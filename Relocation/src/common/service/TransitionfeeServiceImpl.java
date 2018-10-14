package common.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vis.service.MyRecordService;
import com.vis.web.AdminController;

import common.dao.RecordDAO;
import common.dao.RecordReturnDAO;
import common.dao.RecordTransitionfeeDAO;
import common.dao.RecordTransitionfeeDtlDAO;
import common.dao.SysconfigDAO;
import common.domain.Record;
import common.domain.RecordReturn;
import common.domain.RecordTransitionfee;
import common.domain.RecordTransitionfeeDtl;
import common.domain.Sysconfig;
import common.entity.basic.ErrorCode;
import common.entity.basic.IFSException;
import common.entity.service.CalcRecordTransitionfeeRequestDTO;
import common.entity.service.CalcRecordTransitionfeeSectionRequestDTO;
import common.entity.service.RecordReturnSum;
import common.util.CommonsUtil;
import common.util.FileTools;
import common.util.JsonObj;
import common.util.PropertiesUtil;

/**
 * 过渡费计算service
 * @author liangcz
 * @version 2016/10/04
 * @see AdminController
 * @see TransitionfeeService
 */
@Service("TransitionfeeService")
public class TransitionfeeServiceImpl implements TransitionfeeService{
	@Autowired
	private MyRecordService recordService;
	@Autowired
	private RecordDAO recordDAO;
	@Autowired
	private RecordReturnDAO recordReturnDAO;
	@Autowired
	private RecordTransitionfeeDAO transitionfeeDAO;
	@Autowired
	private SysconfigDAO sysconfigDAO;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private RecordTransitionfeeDtlDAO recordTransitionfeeDtlDAO;
	
	private Logger log = Logger.getLogger(TransitionfeeServiceImpl.class);
	/**
	 *  过渡费计算线程名前缀
	 */
	private static String THREAD_PREFIX = "calRecordThread-";
	/**
	 * 计算过渡费
	 * @param CalcRecordTransitionfeeRequestDTO 请求DTO
	 */
	public JsonObj calcRecordTransitionfee(CalcRecordTransitionfeeRequestDTO requestDTO){
		List<Record> recordList = new ArrayList<Record>();
		List<RecordTransitionfee> recordTransitionfeeList = new ArrayList<RecordTransitionfee>();
		try {
			JsonObj result = new JsonObj();
			/* 判断过渡费是否正在计算，如果正在计算，返回 */
			if(isThreadBusyNow(THREAD_PREFIX)){
				result.setStatus(-1);
				result.setMessage("过渡费正在计算，请等待");
				return result;
			}
			
			JSONObject config = new JSONObject(requestDTO.getSysconfig().getValue());
			Sysconfig config2 = sysconfigDAO.findSysconfigById("admin_compute_transitionfee_time");
			Date nextQuarterFeeCalcDueDate = null;
			String nextQuarterFeeCalcDueDateStr = null;
			if(config.has("next_quarter_fee_calc_due_date")){
				nextQuarterFeeCalcDueDateStr = (String) config.get("next_quarter_fee_calc_due_date");
				if(StringUtils.isNotBlank(nextQuarterFeeCalcDueDateStr)){
					String lastComputerTimeStr = config2.getValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					nextQuarterFeeCalcDueDate = sdf.parse(nextQuarterFeeCalcDueDateStr);
					if(StringUtils.isNotBlank(lastComputerTimeStr)){
						Date lastComputerTime = sdf.parse(lastComputerTimeStr);
						if(nextQuarterFeeCalcDueDate.compareTo(lastComputerTime) <= 0){
							nextQuarterFeeCalcDueDate = null;
						}
					}
				}
			}
			Calendar now = Calendar.getInstance();
			int passMonth = Integer.parseInt((String) config.get("after_month_num"));
			double per_house = Double.parseDouble((String) config.get("per_house"));
			double per_business = Double.parseDouble((String) config.get("per_business"));
			
			int successCount = 0;
			List<Record> list = null;
			int offset = 0;
			int maxSize = 100000;// 一次处理最大数
			

			long nowTime = now.getTime().getTime();
			
			list = recordService.listUnDealedRecord(null, null, null, null, null, null, null, offset, maxSize);
			if(list.size() == 0){
				result.setStatus(-1);
				result.setMessage("当前没有要计算的过渡费记录");
				return result;
			}
			CalcRecordTransitionfeeSectionRequestDTO calcRecordTransitionfeeSectionRequestDTO = new CalcRecordTransitionfeeSectionRequestDTO();
			calcRecordTransitionfeeSectionRequestDTO.setRequestDTO(requestDTO);
			calcRecordTransitionfeeSectionRequestDTO.setNowTime(nowTime);
			calcRecordTransitionfeeSectionRequestDTO.setNextQuarterFeeCalcDueDate(nextQuarterFeeCalcDueDate);
			calcRecordTransitionfeeSectionRequestDTO.setNow(now);
			calcRecordTransitionfeeSectionRequestDTO.setPassMonth(passMonth);
			calcRecordTransitionfeeSectionRequestDTO.setPerHouse(per_house);
			calcRecordTransitionfeeSectionRequestDTO.setPerBusiness(per_business);
			calcRecordTransitionfeeSectionRequestDTO.setConfig(config);
			//  过渡费计算最大线程数
			// int maxThread = Integer.parseInt(PropertiesUtil.getProperty("transitionfee.maxThread"));
			// 过渡费一个线程计算过渡费记录数
			int calRecordPerThread = Integer.parseInt(PropertiesUtil.getProperty("transitionfee.calRecordPerThread"));
			// 线程间隔时间
			int calIntervalTime = Integer.parseInt(PropertiesUtil.getProperty("transitionfee.calIntervalTime"));
			int threadCount = 0; // 线程启动数
			int calRecordCount = 0; // 已经计算的record数量
			int calCountInThisThread = 0; // 当前线程计算拆迁户数
			while(calRecordCount < list.size()){
				if(calRecordCount + calRecordPerThread > list.size()){
					calCountInThisThread = list.size() - calRecordCount;
				}else{
					calCountInThisThread = calRecordPerThread;
				}
				List<Record> calRecordList = new ArrayList<Record>();
				for (int i = calRecordCount; i < calRecordCount + calCountInThisThread; i++) {
					calRecordList.add(list.get(i));
				}
				if(calRecordList.size() == 0){
					break;
				}
				calcRecordTransitionfeeSectionRequestDTO.setRecords(calRecordList);
				TransitionfeeCalThread transitionfeeCalThread = new TransitionfeeCalThread();
				transitionfeeCalThread.setCalcRecordTransitionfeeSectionRequestDTO(calcRecordTransitionfeeSectionRequestDTO);
				Thread t = new Thread(transitionfeeCalThread,THREAD_PREFIX + threadCount);
				t.start();
				Thread.sleep(calIntervalTime);
				calRecordCount += calCountInThisThread;
				threadCount++;
			}
			result.setMessage("提交过渡费计算申请完成，请稍后留意计算结果");
			return result;
		} catch (IFSException e) {
			throw e;
		}catch (Throwable e) {
			throw new IFSException(e,ErrorCode.BaseErrorCode,"计算过渡费发生错误");
		} 
		
	}
	/**
	 *  计算单个record的过渡费
	 */
	@Override
	public void calcRecordTransitionfee(CalcRecordTransitionfeeSectionRequestDTO calcRecordTransitionfeeSectionRequestDTO){
		CalcRecordTransitionfeeRequestDTO requestDTO = calcRecordTransitionfeeSectionRequestDTO.getRequestDTO();
		List<Record> records = calcRecordTransitionfeeSectionRequestDTO.getRecords();
		long nowTime = calcRecordTransitionfeeSectionRequestDTO.getNowTime();
		Date nextQuarterFeeCalcDueDate = calcRecordTransitionfeeSectionRequestDTO.getNextQuarterFeeCalcDueDate();
		Calendar now = calcRecordTransitionfeeSectionRequestDTO.getNow();
		int passMonth = calcRecordTransitionfeeSectionRequestDTO.getPassMonth();
		double per_house = calcRecordTransitionfeeSectionRequestDTO.getPerHouse();
		double per_business = calcRecordTransitionfeeSectionRequestDTO.getPerBusiness();
		JSONObject config = calcRecordTransitionfeeSectionRequestDTO.getConfig();
		File logDir = new File(PropertiesUtil.getProperty("relocationLogDir",null));
		if(!logDir.exists()) logDir.mkdirs();
	    File errorFile = new File(logDir.getAbsoluteFile() + File.separator + Thread.currentThread().getName() + "_error.txt");
	    List<String> errorList = new ArrayList<String>();
		for (Record r : records) {
			if(r.getIsEnd() == null){
				r.setIsEnd(false);
			}
			List<RecordTransitionfee> recordTransitionfeeList = new ArrayList<RecordTransitionfee>();
			// 过渡费分段计算明细备份，出错用于回滚
			List<RecordTransitionfeeDtl> backupRecordTransitionfeeDtlList = new ArrayList<RecordTransitionfeeDtl>();
			Record backupRecord = null;
			try {
				backupRecord = (Record) BeanUtils.cloneBean(r);
				// 是否是首次计算过渡费
				boolean isFirstCalcRecordTransitionfee = false;
				if (r.getLastComputeTime() == null) {
					isFirstCalcRecordTransitionfee = true;
				}

				if (r.getTotal() == null || r.getEndTime() == null
						|| r.getStartTime() == null
						|| r.getStartTime().getTime().getTime() > nowTime)
					continue;// 未录入一次性过渡费 或 未设置起止时间 或 尚未开始

				if (r.getIsEnd() != null
						&& r.getIsEnd() == true
						&& !isFirstCalcRecordTransitionfee
						&& r.getLastComputeTime().getTime().getTime() >= r
								.getEndTime().getTime().getTime()) {
					continue;// 已还房 并且 已计算最后的补发三月
				}

				boolean toSave = false;
				boolean hadGetBenefit100 = false; // 是否已经享受了100平米优惠
				double houseArea = bigDecimalTODouble(r.getHouseArea()); // 原住宅房面积
				double businessArea = bigDecimalTODouble(r.getBusinessArea()); // 原营业房面积
				double replaceHouseAreaBefore = bigDecimalTODouble(r
						.getReplaceHouseAreaBefore()); // 住宅置换面积
				double replaceHouseArea = bigDecimalTODouble(r
						.getReplaceHouseArea()); // 置换成营业房面积
				double actualBackHouseArea = bigDecimalTODouble(r
						.getActualBackHouseArea()); // 实际已还住宅房
				double actualBackBusinessArea = bigDecimalTODouble(r
						.getActualBackBusinessArea()); // 实际已还营业房
				/* 分段日切割点，用于日期的分段
				 * 比如 2012-07-31 拆迁，那么取分割日为31日
				 * 以后分段以此天作为日分割。
				 * 如果下个月有31号，则取31，否则取月最后一天。
				 *依次类推：  0731~0831,0831~0930，0930-10-31 
				 *如果2012-07-20，则日切割点为20日
				 * 分段为： 0720~0820,0820~0920,0920~1020
				 * */
				int splitDay = r.getStartTime().get(Calendar.DAY_OF_MONTH);

				/*
				 * 100 平米优惠政策: 同一户首次拆迁，且原住宅面积 < 100，住宅房按100算，否则按实际面积算。
				 * 拆迁户在还房一次之后，自动取消100平米优惠，按剩余面积(原拆迁面积-还房面积)来计算过渡费
				 * 
				 * 住宅房： 符合100平米优惠，如果符合按优惠来算，否则住宅房按实际面积算。 营业房： 营业房按实际面积计算。
				 */
				double baseRemainHouse = houseArea; // 过渡费计算住宅面积
				if (houseArea > 0
						&& (r.getAreaBenefit100() == null || r
								.getAreaBenefit100() == true)) {
					if (houseArea < 100) {
						baseRemainHouse = 100;
						hadGetBenefit100 = true;
					}
					// 减去还房
					// baseRemainHouse = baseRemainHouse - actualBackHouseArea;
					if (baseRemainHouse < 0) {
						baseRemainHouse = 0;
					}
				}

				/*
				 * 如果原营业房面积为0，则计算面积为0 否则过渡费营业房面积 = 原营业房面积 - 再减去还房面积
				 */
				double baseRemainBusiness = businessArea; // 过渡费计算住宅面积
				/*
				 * if(businessArea > 0 && (r.getAreaBenefit100() == null ||
				 * r.getAreaBenefit100() == true)){ baseRemainBusiness =
				 * businessArea;
				 * 
				 * // 减去还房 // remainBusiness = remainBusiness -
				 * actualBackBusinessArea; if(baseRemainBusiness < 0){
				 * baseRemainBusiness = 0; } }
				 */
				log.info("住宅房基础计算面积：" + baseRemainHouse + "\n" + "营业房基础计算面积:"
						+ baseRemainBusiness);

				// 计算起始日期
				Date dateBgin = null;
				/* 首次过渡费计算，起始日期取首次过渡费结束日 */
				if (isFirstCalcRecordTransitionfee) {
					if (r.getFirstEndTime() != null) {
						dateBgin = r.getFirstEndTime().getTime();
					} else {
						dateBgin = r.getStartTime().getTime();
					}
				} else {
					Calendar lastCalTime = recordDAO.inquiryLastCalTime(r.getId());
					dateBgin = this.getNoneTimeDate(lastCalTime.getTime());
				}

				/* 如果设了截止日，则优先算到截止日期 */
				/* 如果已经还房完成，那么算到当前日期，否则算到上季度截止日 */
				Calendar calCutTimeCal;
				if (r.getIsEnd() != null && r.getIsEnd()) {
					calCutTimeCal = this.dateTOCalendar(this
							.getNoneTimeDate(new Date()));
				} else {
					calCutTimeCal = this.getLastQuarter(
							this.dateTOCalendar(this.getNoneTimeDate(now
									.getTime())), splitDay);
				}

				if (nextQuarterFeeCalcDueDate != null
						&& nextQuarterFeeCalcDueDate.compareTo(calCutTimeCal
								.getTime()) < 0) {
					calCutTimeCal = dateTOCalendar(nextQuarterFeeCalcDueDate);
				}

				// 计算结束日期
				// Date toDayNoneTime = this.getNoneTimeDate(new Date());
				Date dateEnd = this.getNextQuarter(dateBgin, splitDay);
				Calendar calBegin = this.dateTOCalendar(dateBgin);
				Calendar calEnd = this.dateTOCalendar(dateEnd);
				Calendar overBeginCal = this.dateTOCalendar(this
						.getNoneTimeDate(r.getEndTime().getTime()));
				if (calEnd.compareTo(calCutTimeCal) > 0 && isFirstCalcRecordTransitionfee == false) {
					calEnd = this.coloneCalendar(calCutTimeCal);
				}

				dateEnd = calEnd.getTime();
				boolean hadComputeOverFee = false; // 是否已经算完所有的逾期过渡费，如果算完，那么就该退出
				boolean breakFlag = false; // 跳出循环标识
				boolean scope = false; // 分段计算标识，计算日期包含正常过渡费和逾期过渡费
				// 过渡费明细列表,每一个过渡费计算的区间具体怎么分段的数据记录下来，方便以后追查
				List<RecordTransitionfeeDtl> recordTransitionfeeDtlList = new ArrayList<RecordTransitionfeeDtl>();
				/* 循环计算每个季度的过渡费。并插入过渡费明细表。 */
				/* 如果没计算过，首次起始日期，首次过渡费起日。否则取上次计算的日期计起。 结束日，取下一季度月份+合同到期日。 */
				while (calEnd.compareTo(calCutTimeCal) <= 0
						&&  (r.getIsEnd() == null || r.getIsEnd() == false)) {
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					System.out.println(sdf.format(dateBgin) + "~"
							+ sdf.format(dateEnd));

					int year = calEnd.get(Calendar.YEAR);
					int month = calEnd.get(Calendar.MONTH) + 1;

					RecordTransitionfee t = new RecordTransitionfee();
					t.setRecord(r);
					t.setCuser(requestDTO.getCuser());
					t.setType("正常过渡");
					t.setEndTime(calEnd);
					t.setYear(year);
					t.setQuarter((int) ((month - 1) / 3) + 1);
					t.setRemark("");
					t.setCreatedTime(now);
					t.setIsDealed(false);
					t.setIsDeleted(false);

					double totalFee = 0;
					double fee = 0;
					// 首次过渡费
					long start = calBegin.getTime().getTime();
					long end = calEnd.getTime().getTime();
					t.setStartTime(calBegin);

					/* 第一次计算，首次过渡费，加 一次性过渡费 */
					if (isFirstCalcRecordTransitionfee) {
						t.setStartTime(calBegin);
						toSave = true;
						t.setFirstStartTime(r.getFirstStartTime());
						t.setFirstEndTime(r.getFirstEndTime());
						t.setFirstFee(r.getTotal());
						totalFee += r.getTotal().doubleValue();
						isFirstCalcRecordTransitionfee = false;
						RecordTransitionfeeDtl recordTransitionfeeDtl = new RecordTransitionfeeDtl();
						recordTransitionfeeDtl.setType("首次过渡费");
						recordTransitionfeeDtl.setRecord(r);
						recordTransitionfeeDtl.setStartTime(r.getFirstStartTime());
						recordTransitionfeeDtl.setEndTime(r.getFirstEndTime());
						recordTransitionfeeDtl.setFee(r.getTotal());
						recordTransitionfeeDtl.setCreatedTime(now);
						recordTransitionfeeDtlList.add(recordTransitionfeeDtl);
					}

					if (calBegin.getTime().getTime() < r.getEndTime().getTime()
							.getTime()
							+ passMonth * 30 * 3600 * 24 * 1000) {

						/* 正常过渡计算 */
						/* 是分段逾期，那么end取截止日 */
						Calendar calEndTmp = calEnd;
						if (calEnd.compareTo(r.getEndTime()) > 0) {
							calEnd = this.dateTOCalendar(r.getEndTime()
									.getTime());
							dateEnd = calEnd.getTime();
							end = dateEnd.getTime();
							scope = true;
						}

						/* 计算相差天数。满月算30天，不规则天数按实际天数 */
						// int overDay = (int) ((end - start) * 1.0 / 3600 / 24
						// / 1000) -1;
						// int overDay = this.calBtwDays(calEnd, calBegin);
						//
						// if (overDay < 1) overDay = 0;
						// System.out.println("天数:" + overDay);
						// fee = overDay * 1.0 / 30 * (per_house *
						// baseRemainHouse + per_business * baseRemainBusiness);

						// 分段计算过渡费
						fee = calAreaSectionFee(calBegin, calEnd, r.getId(),
								baseRemainHouse, baseRemainBusiness, per_house,
								per_business, 1, houseArea,
								bigDecimalTODouble(r.getHouseAreaBack()),
								hadGetBenefit100,splitDay,"正常过渡费",recordTransitionfeeDtlList);

						totalFee += fee;
						t.setFee(new BigDecimal(fee));
						if (fee > 0)
							toSave = true;

						/* 分段计算完恢复原值 */
						if (scope) {
							calEnd = calEndTmp;
							dateEnd = calEnd.getTime();
							end = dateEnd.getTime();
						}
					}

					if (calEnd.getTime().getTime() > overBeginCal.getTime()
							.getTime() + passMonth * 30 * 3600 * 24 * 1000) {
						if (r.getIsEnd() == null || r.getIsEnd() == false) {
							/* 逾期过渡费 计算(>两年) */
							// Calendar nowCal = this.dateTOCalendar(new
							// Date());

							double overFee = 0.0; // 分段逾期过渡费
							/* 计算起始日小于过渡费合同到期日，则是跨正常过渡费计算和逾期过渡费计算 */
							if (calBegin.compareTo(overBeginCal) < 0) {
								calBegin = this.dateTOCalendar(overBeginCal
										.getTime());
								breakFlag = false;
							} else {
								// calEnd = this.getNextCalDate(r.getEndTime(),
								// calBegin, nowCal, passMonth);
								calEnd = this.dateTOCalendar(this
										.getNextQuarter(calBegin.getTime(),
												splitDay));
								breakFlag = true;
							}

							/* 逾期过渡费分段计算 */
							while (calEnd.compareTo(calCutTimeCal) <= 0
									&& calBegin.compareTo(calEnd) != 0
									&& r.getIsEnd() != true) {

								overFee = 0.0;
								Calendar calBeginTmp = this
										.coloneCalendar(calBegin);
								Calendar calEndTmp;
								List<Calendar> pointList = this
										.getOverFeeCalcPoints(calBegin, calEnd,
												overBeginCal);
								for (Calendar point : pointList) {
									if (point.compareTo(calBegin) == 0) {
										continue;
									}
									calEndTmp = this.coloneCalendar(point);
									if (calBeginTmp.compareTo(calEndTmp) == 0) {
										continue;
									}
									dateEnd = calEndTmp.getTime();
									end = calEndTmp.getTime().getTime();
									start = calBeginTmp.getTime().getTime();

									double f = 1;
									// 超期半年数
									// int overHalfyear = (int) (((end -
									// calBegin.getTime().getTime()) * 1.0 /
									// 3600 / 24
									// / 1000 - passMonth * 30) / 365 * 2);
									int overHalfyear = this.calMonthBetween(
											calBeginTmp, overBeginCal) / 6;

									if (overHalfyear < 0)
										f = 1;
									else if (overHalfyear >= 6)
										f = Double.parseDouble((String) config
												.get("max_increment")) / 100 + 1;
									else
										f = Double.parseDouble((String) config
												.get("increment"
														+ (overHalfyear + 1))) / 100 + 1;

									/* 算头不算尾，天数要减一 */
									// int overDay = (int) ((end - start) * 1.0
									// / 3600 / 24 / 1000);
									int overDay = this.calBtwDays(calEndTmp,
											calBeginTmp);
									if (overDay < 1)
										overDay = 0;

									// overFee += f * overDay * 1.0 / 30 *
									// (per_house * baseRemainHouse +
									// per_business * baseRemainBusiness);
									overFee += calAreaSectionFee(calBeginTmp,
											calEndTmp, r.getId(),
											baseRemainHouse,
											baseRemainBusiness, per_house,
											per_business, f, houseArea,
											bigDecimalTODouble(r.getHouseAreaBack()),
											hadGetBenefit100,splitDay,"逾期过渡费",recordTransitionfeeDtlList);
									if (overFee > 0)
										toSave = true;

									log.info("********逾期："
											+ sdf.format(calBeginTmp.getTime()
													.getTime())
											+ "~"
											+ sdf.format(calEndTmp.getTime()
													.getTime()) + "天数:"
											+ overDay + "，利率:" + f + "，过渡费："
											+ overFee);

									calBeginTmp = this
											.coloneCalendar(calEndTmp);

								}

								/* 如果是跨正常和逾期，则先退出 ;否则插入逾期过渡费记录 */
								if (scope) {
									scope = false;
									break;
								} else {
									double threeMonthFee = calThreeMonthFee(
											r.getId(), calBegin, calEnd,
											per_house, per_business, houseArea,
											businessArea,recordTransitionfeeDtlList);
									if (threeMonthFee > 0) {
										toSave = true;
										totalFee += threeMonthFee;
										t.setThreeMonthFee(new BigDecimal(
												threeMonthFee));
									}
									// 判断是否还房完成，如果完成则设标识位end为true，计算到此截止
									RecordReturnSum recordReturnSum = recordReturnDAO
											.getReturnSumAreaByTime(r.getId(),
													null, calEnd);
									if (recordReturnSum != null) {
										double houseReturn = bigDecimalTODouble(recordReturnSum
												.getHouseReturn());
										double businessReturn = bigDecimalTODouble(recordReturnSum
												.getBusinessReturn());
										// 如果房子还完，设标识位为true，计算截止
										if (houseReturn >= houseArea
												&& businessReturn >= businessArea) {
											r.setIsEnd(true);
										}
									}
									/* 如果逾期和还房都算出来为0，则退出循环计算 */
									if (overFee <= 0 && threeMonthFee <= 0) {
										break;
									}
									/* 插入逾期过渡费记录 */
									RecordTransitionfee transitionfeeOver = new RecordTransitionfee();
									transitionfeeOver.setRecord(r);
									transitionfeeOver.setCuser(requestDTO
											.getCuser());
									transitionfeeOver.setType("逾期还房补偿");
									transitionfeeOver.setStartTime(calBegin);
									transitionfeeOver.setEndTime(calEnd);
									transitionfeeOver.setYear(calEnd
											.get(Calendar.YEAR));
									transitionfeeOver.setQuarter((int) ((calEnd
											.get(Calendar.MONTH) - 1) / 3) + 1);
									transitionfeeOver.setRemark("逾期过渡费记录");
									transitionfeeOver.setCreatedTime(now);
									transitionfeeOver.setIsDealed(false);
									transitionfeeOver.setIsDeleted(false);
									transitionfeeOver
											.setOverdueFee(new BigDecimal(
													overFee));
									transitionfeeOver.setFee(new BigDecimal(0));
									transitionfeeOver
											.setQuarterFee(new BigDecimal(
													overFee + threeMonthFee));
									transitionfeeOver
											.setThreeMonthFee(new BigDecimal(
													threeMonthFee));
									transitionfeeOver = transitionfeeDAO.store(transitionfeeOver);
									recordTransitionfeeList
											.add(transitionfeeOver);
									for (RecordTransitionfeeDtl recordTransitionfeeDtl : recordTransitionfeeDtlList) {
										recordTransitionfeeDtl.setRecord(r);
										recordTransitionfeeDtl.setRecordTransitionfee(transitionfeeOver);
										recordTransitionfeeDtl = recordTransitionfeeDtlDAO.store(recordTransitionfeeDtl);
										backupRecordTransitionfeeDtlList.add(recordTransitionfeeDtl);
										recordTransitionfeeDtlList = new ArrayList<RecordTransitionfeeDtl>();
									}
									// successCount++;
									hadComputeOverFee = true; // 已经算过逾期过渡费
								}

								calBegin = this
										.dateTOCalendar(calEnd.getTime());
								// calEnd = this.getNextCalDate(overBeginCal,
								// calBegin, nowCal, passMonth);
								calEnd = this.dateTOCalendar(this
										.getNextQuarter(calBegin.getTime(),
												splitDay));
							}

							if (overFee > 0) {
								t.setOverdueFee(new BigDecimal(overFee));
								totalFee += overFee;
								toSave = true;
								t.setEndTime(calEnd);
								t.setType("逾期还房补偿");
								t.setRemark("");
							}

						}
					}
					if(toSave){
						r.setLastComputeTime(calEnd);
						recordDAO.store(r);
					}

					/* 如果已经算完逾期过渡费，那么表示计算已经完成，退出循环 */
					if (hadComputeOverFee) {
						break;
					}

					// 考虑到这里有还房造成的分段计算。所以起始日期不取calBegin,calEnd，取t.startTime
					// t.endTime，因为这两个日期在之前设置，比较准确
					double threeMonthFee = calThreeMonthFee(r.getId(),
							t.getStartTime(), t.getEndTime(), per_house,
							per_business, houseArea, businessArea,recordTransitionfeeDtlList);
					if (threeMonthFee > 0) {
						toSave = true;
						totalFee += threeMonthFee;
						t.setThreeMonthFee(new BigDecimal(threeMonthFee));

					}
					// 判断是否还房完成，如果完成则设标识位end为true，计算到此截止
					RecordReturnSum recordReturnSum = recordReturnDAO
							.getReturnSumAreaByTime(r.getId(), null, calEnd);
					if (recordReturnSum != null) {
						double houseReturn = bigDecimalTODouble(recordReturnSum
								.getHouseReturn());
						double businessReturn = bigDecimalTODouble(recordReturnSum
								.getBusinessReturn());
						// 如果房子还完，设标识位为true，计算截止
						if (houseReturn >= houseArea
								&& businessReturn >= businessArea) {
							r.setIsEnd(true);
						}
					}
					if (toSave) {
						System.out.println("总费用：" + new BigDecimal(totalFee));
						t.setQuarterFee(new BigDecimal(totalFee));
						t = transitionfeeDAO.store(t);
						recordTransitionfeeList.add(t);
						toSave = false;
						
						for (RecordTransitionfeeDtl recordTransitionfeeDtl : recordTransitionfeeDtlList) {
							recordTransitionfeeDtl.setRecord(r);
							recordTransitionfeeDtl.setRecordTransitionfee(t);
							recordTransitionfeeDtl = recordTransitionfeeDtlDAO.store(recordTransitionfeeDtl);
							backupRecordTransitionfeeDtlList.add(recordTransitionfeeDtl);
							recordTransitionfeeDtlList = new ArrayList<RecordTransitionfeeDtl>();
						}
						// successCount++;
					}

					if (isSameDate(calEnd, calCutTimeCal) || breakFlag) {
						break; // 跳出循环
					}

					/* 重新赋值循环 */
					totalFee = 0;
					fee = 0;
					calBegin = this.dateTOCalendar(calEnd.getTime());
					calEnd = this.dateTOCalendar(this.getNextQuarter(
							calEnd.getTime(), splitDay));
					if (calEnd.compareTo(calCutTimeCal) > 0) {
						calEnd = this.coloneCalendar(calCutTimeCal);
					}

					dateBgin = calBegin.getTime();
					dateEnd = calEnd.getTime();
				}
			} catch (IFSException e) {
				for (RecordTransitionfee recordTransitionfee : recordTransitionfeeList) {
					transitionfeeDAO.remove(recordTransitionfee);
				}
				for (RecordTransitionfeeDtl recordTransitionfeeDtl : backupRecordTransitionfeeDtlList) {
					recordTransitionfeeDtlDAO.remove(recordTransitionfeeDtl);
				}
				recordDAO.store(backupRecord);
				log.error(r.getId() + " 过渡计算失败：" + CommonsUtil.getStackTrace(e));
				errorList.add(r.getId() + " 过渡计算失败：" + e.getMessage() + ",数据已经回滚");
				try {
					FileTools.writeFile(errorList, errorFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				continue;
			} catch (Throwable e) {
				for (RecordTransitionfee recordTransitionfee : recordTransitionfeeList) {
					transitionfeeDAO.remove(recordTransitionfee);
				}
				for (RecordTransitionfeeDtl recordTransitionfeeDtl : backupRecordTransitionfeeDtlList) {
					recordTransitionfeeDtlDAO.remove(recordTransitionfeeDtl);
				}
				
				recordDAO.store(backupRecord);
				log.error(r.getId() + " 过渡计算失败：" + CommonsUtil.getStackTrace(e));
				errorList.add(r.getId() + " 过渡计算失败：" + e.getMessage() + ",数据已经回滚");
				try {
					FileTools.writeFile(errorList, errorFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				continue;
			}
		}
	}
	
	/**
	 * 计算还房补发三个月的总费用
	 * @param recordId 拆迁id
	 * @param begin 计算开始时间
	 * @param end 计算截止时间
	 * @param perHouse 住宅房利率
	 * @param perBusiness 商品房利率
	 * @param houseArea 拆迁住宅房面积
	 * @param businessArea 拆迁商品房面积
	 * @param recordTransitionfeeDtlList 过渡费计算明细
	 * @return
	 */
	private double calThreeMonthFee(int recordId,Calendar begin,Calendar end,double perHouse,double perBusiness,
			double houseArea,double businessArea,List<RecordTransitionfeeDtl> recordTransitionfeeDtlList){
		RecordReturnSum recordReturnSum = recordReturnDAO.getReturnSumAreaByTime(recordId,begin,end);
		if(recordReturnSum == null){
			return 0;
		}
		// 累计还房总面积
		RecordReturnSum recordReturnSumAll = recordReturnDAO.getReturnSumAreaByTime(recordId,null,end);
				
		// 在时间区域内还住宅房面积
		double houseReturnArea  = bigDecimalTODouble(recordReturnSum.getHouseReturn());
		// 在时间区域内还商品房面积
		double businessReturnArea = bigDecimalTODouble(recordReturnSum.getBusinessReturn());
		
		if(houseReturnArea == 0 && businessReturnArea == 0){
			return 0;
		}
		// 累计还住宅房面积
		double houseReturnAreaAll = bigDecimalTODouble(recordReturnSumAll.getHouseReturn());
		// 累计还商品房面积
		double businessReturnAreaAll = bigDecimalTODouble(recordReturnSumAll.getBusinessReturn());
		
		// 如果总还房面积大于住宅房面积，按原拆房面积算
		if(houseReturnAreaAll > houseArea){
			houseReturnArea = houseReturnArea - (houseReturnAreaAll - houseArea);
		}
		if(businessReturnAreaAll > businessReturnArea){
			businessReturnArea = businessReturnArea - (businessReturnAreaAll - businessArea);
		}
		
		double threeMonthFee = 90 * 1.0 / 30 * (perHouse * houseReturnArea + perBusiness * businessReturnArea);
		if(threeMonthFee > 0){
			RecordTransitionfeeDtl recordTransitionfeeDtl = new RecordTransitionfeeDtl();
			recordTransitionfeeDtl.setType("三个月补偿");
			recordTransitionfeeDtl.setStartTime(begin);
			recordTransitionfeeDtl.setEndTime(end);
			recordTransitionfeeDtl.setBaseDay(30);
			recordTransitionfeeDtl.setCalDay(new BigDecimal(90));
			recordTransitionfeeDtl.setBaseRate(new BigDecimal(1));
			recordTransitionfeeDtl.setCalHouseArea(new BigDecimal(houseReturnArea));
			recordTransitionfeeDtl.setCalBusinessArea(new BigDecimal(businessReturnArea));
			recordTransitionfeeDtl.setPerHouse(new BigDecimal(perHouse));
			recordTransitionfeeDtl.setPerBusiness(new BigDecimal(perBusiness));
			String calShow = 90 + " * " + 1.0 + " / " + 30 + " * " + "(" + perHouse + " * " + houseReturnArea + " + " + perBusiness + " * " + businessReturnArea + ")" + " = " + threeMonthFee;
			recordTransitionfeeDtl.setCalShow(calShow);
			recordTransitionfeeDtl.setFee(new BigDecimal(threeMonthFee));
			recordTransitionfeeDtl.setCreatedTime(Calendar.getInstance());
			recordTransitionfeeDtlList.add(recordTransitionfeeDtl);
		}
		return threeMonthFee;
	}
	
//	/**
//	 * 计算还房补贴三个月费
//	 * @param requestDTO
//	 * @return
//	 */
//	public JsonObj calThreeMonthFee(CalThreeMonthFeeRequestDTO requestDTO){
//		JsonObj result = new JsonObj();
//		Sysconfig config = sysconfigDAO.findSysconfigById("admin_record_config");
//		if (config == null) {
//			throw new IFSException(new Exception(),ErrorCode.BaseErrorCode,"请先设置相关参数");
//		}
//		JSONObject jsonObject = new JSONObject(config.getValue());
//		Calendar now = Calendar.getInstance();
//		double perHouse = Double.parseDouble((String) jsonObject.get("per_house"));
//		double perBusiness = Double.parseDouble((String) jsonObject.get("per_business"));
//		
//		
//		Calendar calBegin = this.coloneCalendar(requestDTO.getReturnTime());
//		Calendar calEnd = this.coloneCalendar(requestDTO.getReturnTime());
//		calEnd.add(Calendar.MONTH, 3);
//		
//		double houseReturnArea = requestDTO.getHouseReturnArea() == null ? 0 : requestDTO.getHouseReturnArea();
//		double businessReturnArea = requestDTO.getBusinessReturnArea() == null ? 0 : requestDTO.getBusinessReturnArea();
//		
//		double threeMonthFee = 90 * 1.0 / 30 * (perHouse * houseReturnArea + perBusiness * businessReturnArea);
//		RecordTransitionfee transitionfee = new RecordTransitionfee();
//		transitionfee.setRecord(requestDTO.getRecord());
//		transitionfee.setCuser(requestDTO.getCuser());
//		transitionfee.setType("还房三个月补贴");
//		transitionfee.setStartTime(calBegin);
//		transitionfee.setEndTime(calEnd);
//		transitionfee.setYear(calEnd.get(Calendar.YEAR));
//		transitionfee.setQuarter((int) ((calEnd.get(Calendar.MONTH) - 1) / 3) + 1);
//		transitionfee.setRemark("逾期过渡费记录");
//		transitionfee.setCreatedTime(now);
//		transitionfee.setIsDealed(false);
//		transitionfee.setIsDeleted(false);
//		transitionfee.setOverdueFee(new BigDecimal(0));
//		transitionfee.setFee(new BigDecimal(0));
//		transitionfee.setThreeMonthFee(new BigDecimal(threeMonthFee));
//		transitionfee.setQuarterFee(new BigDecimal(threeMonthFee));
//		transitionfeeDAO.store(transitionfee);
//		result.setStatus(0);
//		return result;
//	}
	
	
	/**
	 * date 转换成 Calendar
	 * @param date
	 * @return
	 */
	private Calendar dateTOCalendar(Date date){
		Calendar c = Calendar.getInstance();
		//c.setTime(date);
		c.setTimeInMillis(date.getTime());
		return c;
	}
	
	
	/**
	 * 获取年月日日期
	 * @param date
	 * @return
	 */
	private Date getNoneTimeDate(Date date){
		Calendar calendar = Calendar.getInstance();
		//calendar.setTime(date);
		calendar.setTimeInMillis(date.getTime());
		// 忽略时间，日期计算只计算日期
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取下一个季度
	 * @param date 起始日
	 *  @param splitDay 切割日
	 * @return
	 */
	private Date getNextQuarter(Date date,int splitDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getNoneTimeDate(date));
		int maxDayOfMonth;
		// 第一季度
		Calendar quartz1 = Calendar.getInstance();
		quartz1.setTime(calendar.getTime());
		quartz1.set(Calendar.MONTH, 2);
		quartz1.set(Calendar.DAY_OF_MONTH, 1);
		quartz1.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz1.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz1.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		// 第二季度
		Calendar quartz2 = Calendar.getInstance();
		quartz2.setTime(calendar.getTime());
		quartz2.set(Calendar.MONTH, 5);
		quartz2.set(Calendar.DAY_OF_MONTH, 1);
		quartz2.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz2.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz2.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		// 第三季度
		Calendar quartz3 = Calendar.getInstance();
		quartz3.setTime(calendar.getTime());
		quartz3.set(Calendar.MONTH, 8);
		quartz3.set(Calendar.DAY_OF_MONTH, 1);
		quartz3.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz3.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz3.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		// 第四季度
		Calendar quartz4 = Calendar.getInstance();
		quartz4.setTime(calendar.getTime());
		quartz4.set(Calendar.MONTH, 11);
		quartz4.set(Calendar.DAY_OF_MONTH, 1);
		quartz4.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz4.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz4.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		
		Date ndate = null;
		if(calendar.compareTo(quartz1) < 0){
			ndate = quartz1.getTime();
		}else if(calendar.compareTo(quartz1) >= 0 && calendar.compareTo(quartz2) <0 ){
			ndate = quartz2.getTime();
		}else if(calendar.compareTo(quartz2) >= 0 && calendar.compareTo(quartz3) <0 ){
			ndate = quartz3.getTime();
		}else if(calendar.compareTo(quartz3) >= 0 && calendar.compareTo(quartz4) <0 ){
			ndate = quartz4.getTime();
		}else{
			calendar.add(Calendar.YEAR, 1);
			calendar.set(Calendar.MONTH, 2);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
			ndate = calendar.getTime();
		}
		return ndate;
	}
	/**
	 * 查询是否包含线程名的线程存在
	 * @return bolean
	 */
	private boolean isThreadBusyNow(String ThreadNameKey){
		ThreadGroup group = Thread.currentThread().getThreadGroup();
        while(group != null) {
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++) {
                if(threads[i].getName().contains(ThreadNameKey)) {
                    return true;
                }
            }
            group = group.getParent();
        }
		return false;
	}
	/**
	 * 判断两个日期是否相等，忽略时间
	 * @param c1
	 * @param c2
	 * @return
	 */
	private boolean isSameDate(Calendar c1,Calendar c2){
		if(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)){
			return true;
		}
		return false;
	}
	
	/**
	 * 将bigDecimal 转换成double
	 * @return
	 */
	private double bigDecimalTODouble(BigDecimal b){
		return b == null ? 0 : b.doubleValue();
	}
	
	
	/**
	 *  获取逾期过渡费下一个计算的时间点
	 *  @param beginDate 过渡费逾期开始日
	 *  @param calDate 计算日期起点
	 *  @param nowDate 当前时间
	 *  @param passMonth 
	 * @return
	 */
	private Calendar getNextCalDate(Calendar beginDate,Calendar calDate,Calendar nowDate,int passMonth){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// System.out.println("calDate：" + sdf.format(calDate.getTime().getTime()));
		// System.out.println("beginDate：" + sdf.format(beginDate.getTime().getTime()));
		/* 计算超出半年数 */
		// int overHalfyear = (int) (((calDate.getTime().getTime() - beginDate.getTime().getTime()) * 1.0 / 3600 / 24 / 1000 - passMonth * 30) / 365 * 2);
		int overHalfyear = this.calMonthBetween(calDate, beginDate) / 6;		
		// System.out.println("overHalfyear:" + overHalfyear);
		
		/* 逾期超过6个半年，那么下个计算日期直接返回当前日 ，利率取最高标准 */
		if(overHalfyear >= 6){
			return nowDate;
		}
		
		Calendar nextCalDate = Calendar.getInstance();
		//nextCalDate.setTime(beginDate.getTime());
		nextCalDate.setTimeInMillis(beginDate.getTime().getTime());
		nextCalDate.add(Calendar.MONTH, (overHalfyear + 1) * 6);
		
		/* 如果下一个计算的日期大于当前日期，那么返回当前日期 */
		if(nextCalDate.compareTo(nowDate) > 0){
			return nowDate;
		}
		System.out.println("nextCalDate：" + sdf.format(nextCalDate.getTime().getTime()));
		return nextCalDate;
	}
	
	
	/**
	 * 计算日期相差几个月
	 * @param c1
	 * @param c2
	 * @return
	 */
	private int calMonthBetween(Calendar c1,Calendar c2){
		int result = 0;
		int year1 = c1.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH);
		
		int year2 = c2.get(Calendar.YEAR);
		int month2 = c2.get(Calendar.MONTH);
		
		result = Math.abs((year2 - year1) * 12 + (month2 - month1));
		
		if(c1.compareTo(c2) < 0){
			Calendar c3 = Calendar.getInstance();
			c3.setTimeInMillis(c1.getTimeInMillis());
			c3.add(Calendar.MONTH, result);
			if(c3.compareTo(c2) > 0) result++;
		}else if(c1.compareTo(c2) > 0){
			Calendar c3 = Calendar.getInstance();
			c3.setTimeInMillis(c2.getTimeInMillis());
			c3.add(Calendar.MONTH, result);
			if(c3.compareTo(c1) > 0) result++;
		}
		return result;
	}
	
	/**
	 *  计算相差天数。一个月按 30 天算
	 * @param c1
	 * @param c2
	 * @return
	 */
	private int calBtwDays(Calendar c1,Calendar c2){
		Calendar max,min;
		if(c1.compareTo(c2) > 0){
			max = c1;
			min = c2;
		}else if(c1.compareTo(c2) < 0){
			max = c2;
			min = c1;
		}else{
			return 0;
		}
		int betDays = 0;
		int betMonths = (max.get(Calendar.YEAR) - min.get(Calendar.YEAR)) * 12 + (max.get(Calendar.MONTH) - min.get(Calendar.MONTH));
		log.info("betMonths:" + betMonths);
		
		int dayOfMonthOfMaxDay = max.get(Calendar.DAY_OF_MONTH);
		int dayOfMonthOfMinDay = min.get(Calendar.DAY_OF_MONTH);
		
		if(dayOfMonthOfMaxDay > dayOfMonthOfMinDay){
			betDays = betMonths * 30 + (max.get(Calendar.DAY_OF_MONTH) - min.get(Calendar.DAY_OF_MONTH));
		}else if(dayOfMonthOfMaxDay == dayOfMonthOfMinDay){
			betDays = betMonths * 30;
		}else{
			/*
			Calendar c3 = Calendar.getInstance();
			c3.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH) - 1, dayOfMonthOfMinDay,0,0,0);
			betDays = (int) ((max.getTime().getTime() - c3.getTime().getTime()) / 3600 / 24 / 1000) + 1;
			*/
			/* 不足一个月也按30天算 */
			betDays = 30 - dayOfMonthOfMinDay + dayOfMonthOfMaxDay;
			betDays += 30 * (betMonths - 1);
		}
				
		log.info("betDays:" + betDays);
		return betDays;
	}
	
	/**
	 * 计算两个日期实际相差的天数
	 * @param c1
	 * @param c2
	 * @return
	 */
	private int calRealBtwDays(Calendar c1,Calendar c2){
		int betDays = (int) ((c1.getTime().getTime() - c2.getTime().getTime()) / 3600 / 24 / 1000);
		return Math.abs(betDays);
	}
	
	/**
	 * 将一段时间切分成多个时间点，以半年为阀值
	 * @param begin
	 * @param end
	 * @param contractEndCld
	 * @return
	 */
	private List<Calendar> getOverFeeCalcPoints(Calendar begin,Calendar end,Calendar contractEndCld){
		Calendar c1 = this.coloneCalendar(begin);
		Calendar c2 = this.coloneCalendar(end);
		Calendar c3 = this.coloneCalendar(contractEndCld);

		List<Calendar> list = new ArrayList<Calendar>();
		// list.add(this.coloneCalendar(c1));
		while(true){
			int overHalfyear = this.calMonthBetween(c1, contractEndCld) / 6;
			c3.add(Calendar.MONTH, (overHalfyear + 1) * 6);
			if(c3.compareTo(c2) > 0){
				list.add(this.coloneCalendar(this.coloneCalendar(c2)));
				break;
			}
			list.add(this.coloneCalendar(c3));
		}
		return list;
	}
	
	/**
	 * 克隆，生成新想calendar
	 * @param c1
	 * @return
	 */
	private Calendar coloneCalendar(Calendar c1){
		Calendar c2 = Calendar.getInstance();
		c2.setTimeInMillis(c1.getTimeInMillis());
		return c2;
	}
	
	/**
	 * 获取上一个季度截止日
	 * @param now
	 * @param contractEndCld
	 * @return
	 */
	private Calendar getLastQuarter(Calendar now,int splitDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getNoneTimeDate(now.getTime()));
		int maxDayOfMonth;
		// 第一季度
		Calendar quartz1 = Calendar.getInstance();
		quartz1.setTime(calendar.getTime());
		quartz1.set(Calendar.MONTH, 2);
		quartz1.set(Calendar.DAY_OF_MONTH, 1);
		quartz1.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz1.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz1.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		// 第二季度
		Calendar quartz2 = Calendar.getInstance();
		quartz2.setTime(calendar.getTime());
		quartz2.set(Calendar.MONTH, 5);
		quartz2.set(Calendar.DAY_OF_MONTH, 1);
		quartz2.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz2.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz2.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		// 第三季度
		Calendar quartz3 = Calendar.getInstance();
		quartz3.setTime(calendar.getTime());
		quartz3.set(Calendar.MONTH, 8);
		quartz3.set(Calendar.DAY_OF_MONTH, 1);
		quartz3.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz3.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz3.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		// 第四季度
		Calendar quartz4 = Calendar.getInstance();
		quartz4.setTime(calendar.getTime());
		quartz4.set(Calendar.MONTH, 11);
		quartz4.set(Calendar.DAY_OF_MONTH, 1);
		quartz4.getActualMaximum(Calendar.DAY_OF_MONTH);
		maxDayOfMonth = quartz4.getActualMaximum(Calendar.DAY_OF_MONTH);
		quartz4.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
		
		
		Calendar lastQuartTer; // 上一季度 截止日
		
		if(calendar.compareTo(quartz4) >= 0){
			lastQuartTer = this.coloneCalendar(quartz4);
		}else if(calendar.compareTo(quartz3) >= 0){
			lastQuartTer = this.coloneCalendar(quartz3);
		}else if(calendar.compareTo(quartz2) >= 0){
			lastQuartTer = this.coloneCalendar(quartz2);
		}else if(calendar.compareTo(quartz1) >= 0){
			lastQuartTer = this.coloneCalendar(quartz1);
		}else{
			calendar.add(Calendar.YEAR, -1);
			calendar.set(Calendar.MONTH, 11);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.DAY_OF_MONTH, splitDay > maxDayOfMonth ? maxDayOfMonth : splitDay);
			lastQuartTer = this.coloneCalendar(calendar);
		}
		
		return lastQuartTer;
	}
	
	/**
	 * 获取在指定时间剩余的拆迁剩余面积
	 * @param recordId
	 * @param time
	 */
	private RecordReturn calRemainArea(int recordId,Calendar time){
		RecordReturn recordReturn = this.recordReturnDAO.findRecordReturnByTime(recordId,time);
		return recordReturn;
	}
	
	/**
	 * 拷贝一份calendar
	 * @param c
	 * @return
	 */
	private Calendar copyCalendar(Calendar c){
		Calendar nc = Calendar.getInstance();
		nc.setTimeInMillis(c.getTimeInMillis());
		return nc;
	}
	
	/**
	 * 根据日期切割点取下一个月的计算日期
	 * 如果下个月有31号，则取31，否则取月最后一天。
	 * 依次类推：  0731~0831,0831~0930，0930-10-31 
	 * 如果2012-07-20，则日切割点为20日
	 * 分段为： 0720~0820,0820~0920,0920~1020
	 * @param c1  起始日
	 * @param splitDay 日期分段切割点
	 * @return Calendar 下一个计算节点
	 * */
	private Calendar getNextCalDay(Calendar c1,int splitDay){
		/* 先取取下一个月的1号，如果下个的最后一天比splitDay小，则取当月最后一天 */
		Calendar c2 = copyCalendar(c1);
		c2.set(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.MONTH, 1);
		int nextMonthsMaxDay = c2.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(nextMonthsMaxDay > splitDay){
			c2.set(Calendar.DAY_OF_MONTH, splitDay);
		}else{
			c2.set(Calendar.DAY_OF_MONTH, nextMonthsMaxDay);
		}
		return c2;
	}
	/**
	 * 计算分段过渡费
	 * 如果合同签署日期为*-31，则按老算法来算，baseday为30，日期间隔调用calBtwDays
	 * 如果合同签署日期不为*-31，则calBegin ~ calEnd，日期按月进行分割。baseday取月实际天数
	 * 具体为：
	 * 把过渡费区间按月再分段计算。如 06-30 ~ 09-30，则分成06-30 ~ 07-30,07-30 ~ 08-30,08-30 ~ 09-30。
	 * 每个月的baseday按月实际天数，如06-30 ~ 07-30，baseday 为30天 ; 07-30 ~ 08-30 baseday 为31天; 08-30 ~ 09-30 baseday 为31天，
	 * @param calBegin 计算开始时间
	 * @param calEnd  计算结束时间
	 * @param recordId 拆件面积
	 * @param baseRemainHouse 开始过渡费住宅房计算面积
	 * @param baseRemainBusiness 开始过渡费商品房计算面积
	 * @param perHouse 住宅房利率
	 * @param perBusiness 商品房利率
	 * @param houseArea 住宅房原拆迁面积
	 * @param houseAreaBack 拟还住宅房面积
	 * @param hadGetBenefit100 是否已经享受了100平米优惠
	 * @param splitDay 日期分段切割点
	 * @param type 过渡费类型
	 * @param recordTransitionfeeDtlList 过渡费计算明细
	 * @return
	 */
	private Double calAreaSectionFee(Calendar calBegin,Calendar calEnd,Integer recordId,double baseRemainHouse,
			double baseRemainBusiness,double perHouse,double perBusiness,double rate,double houseArea,
			double houseAreaBack,boolean hadGetBenefit100,int splitDay,String type,List<RecordTransitionfeeDtl> recordTransitionfeeDtlList){
		double fee = 0;
		Calendar calBeginTmp = copyCalendar(calBegin);
		Calendar calEndTmp = getNextCalDay(calBeginTmp,splitDay);
		int baseDay = calRealBtwDays(calEndTmp, calBeginTmp);
		if(calEndTmp.getTimeInMillis() > calEnd.getTimeInMillis()){
			calEndTmp = copyCalendar(calEnd);
		}
		while(true){
			fee += calAreaSectionFee(calBeginTmp,calEndTmp,recordId,baseRemainHouse,
					baseRemainBusiness,perHouse,perBusiness,rate,houseArea,houseAreaBack,hadGetBenefit100,splitDay,type,recordTransitionfeeDtlList,baseDay);
			calBeginTmp = copyCalendar(calEndTmp);
			calEndTmp = getNextCalDay(calBeginTmp,splitDay);
			baseDay = calRealBtwDays(calEndTmp, calBeginTmp);
			if(calEndTmp.getTimeInMillis() > calEnd.getTimeInMillis()){
				calEndTmp = copyCalendar(calEnd);
			}
			if(calBeginTmp.getTimeInMillis() == calEnd.getTimeInMillis()){
				break;
			}
		}
		return fee;
	}
	/**
	 * 
	 * @param calBegin 计算开始时间
	 * @param calEnd  计算结束时间
	 * @param recordId 拆件面积
	 * @param baseRemainHouse 开始过渡费住宅房计算面积
	 * @param baseRemainBusiness 开始过渡费商品房计算面积
	 * @param perHouse 住宅房利率
	 * @param perBusiness 商品房利率
	 * @param houseArea 住宅房原拆迁面积
	 * @param houseAreaBack 拟还住宅房面积
	 * @param hadGetBenefit100 是否已经享受了100平米优惠
	 * @param splitDay 日期分段切割点
	 * @param type 过渡费类型
	 * @param recordTransitionfeeDtlList 过渡费计算明细
	 * @param baseDay 月基础天数,随月不一样
	 * @return
	 */
	private Double calAreaSectionFee(Calendar calBegin,Calendar calEnd,Integer recordId,double baseRemainHouse,
			double baseRemainBusiness,double perHouse,double perBusiness,double rate,double houseArea,
			double houseAreaBack,boolean hadGetBenefit100,int splitDay,String type,
			List<RecordTransitionfeeDtl> recordTransitionfeeDtlList,int baseDay){
		double fee = 0.0;
		List<RecordReturn> recordReturnList = recordReturnDAO.findRecordReturns(calBegin,calEnd,recordId);
		//RecordReturn firstRecordReturn = this.recordReturnDAO.findRecordReturnByTime(r.getId(),calBegin);
		double remainHouse = 0.0; // 剩余住宅房面积
		double remainBusiness = 0.0; // 剩余住宅房面积
		remainHouse = baseRemainHouse;
		remainBusiness = baseRemainBusiness;
		if(recordReturnList.size() == 0){
			/* 计算相差天数。满月算30天，不规则天数按实际天数 */
			// int overDay = (int) ((end - start) * 1.0 / 3600 / 24 / 1000) -1;
			int overDay = 0;
			overDay = this.calRealBtwDays(calEnd, calBegin);
			
			if (overDay < 1) overDay = 0;
			System.out.println("天数:" + overDay);
			 RecordReturnSum recordReturnSum = recordReturnDAO.getReturnSumAreaByTime(recordId,calBegin);
			 if(recordReturnSum != null){
				 /* 对于住宅房，如果享受了还房优惠
				  * 1) 如果还房面积大于等于原拆迁面积，那么算还完，不再享受100平米优惠
				  * 2) 如果还房面积小于原拆迁面积，则按剩余面积来算
				  * 3) 如果没发生还房，则按过渡费费面积按100平米计算
				  * */
				 if(hadGetBenefit100){
					 /* 对于享受100 平米优惠的
					  * 如果住宅还房面积大于拟还住宅房面积，则表示住宅还房结束，则剩余住宅房子过渡费计算面积为0
					  * 如果住宅还房面积小于拟还住宅房面积，则用实际拆迁住宅房面积-住宅还房总面积当作过渡费计算面积 */
					 if(houseAreaBack - bigDecimalTODouble(recordReturnSum.getHouseReturn()) <= 0){
						 remainHouse = 0;
					 }else{
						 remainHouse = houseArea - bigDecimalTODouble(recordReturnSum.getHouseReturn());
					 }
				 }else{
					 remainHouse = baseRemainHouse - bigDecimalTODouble(recordReturnSum.getHouseReturn());
				 }
				 remainBusiness = baseRemainBusiness - bigDecimalTODouble(recordReturnSum.getBusinessReturn());
				 if(remainHouse < 0) remainHouse = 0;
				 if(remainBusiness < 0) remainBusiness = 0;
			 }
			fee = overDay * rate / baseDay * (perHouse * remainHouse + perBusiness * remainBusiness);
			/* 记录过渡费基三明细场景 */
			RecordTransitionfeeDtl recordTransitionfeeDtl = new RecordTransitionfeeDtl();
			recordTransitionfeeDtl.setType(type);
			recordTransitionfeeDtl.setStartTime(calBegin);
			recordTransitionfeeDtl.setEndTime(calEnd);
			recordTransitionfeeDtl.setBaseDay(baseDay);
			recordTransitionfeeDtl.setCalDay(new BigDecimal(overDay));
			recordTransitionfeeDtl.setBaseRate(new BigDecimal(rate));
			recordTransitionfeeDtl.setCalHouseArea(new BigDecimal(remainHouse));
			recordTransitionfeeDtl.setCalBusinessArea(new BigDecimal(remainBusiness));
			recordTransitionfeeDtl.setPerHouse(new BigDecimal(perHouse));
			recordTransitionfeeDtl.setPerBusiness(new BigDecimal(perBusiness));
			recordTransitionfeeDtl.setFee(new BigDecimal(fee));
			recordTransitionfeeDtl.setCreatedTime(Calendar.getInstance());
			String calShow = overDay + " * " + rate + " / " + baseDay + " * " + "(" + perHouse + " * " + remainHouse + " + " + perBusiness + " * " + remainBusiness + ")" + " = " + fee;
			recordTransitionfeeDtl.setCalShow(calShow);
			recordTransitionfeeDtlList.add(recordTransitionfeeDtl);
		}else{
			Calendar calBeginPatch = this.coloneCalendar(calBegin);
			Calendar calEndPatch = this.coloneCalendar(recordReturnList.get(0).getReturnTime());
			
			for (RecordReturn recordReturn : recordReturnList) {
				calEndPatch = this.coloneCalendar(recordReturn.getReturnTime());
				int overDay = this.calRealBtwDays(calEndPatch, calBeginPatch);
				RecordReturnSum recordReturnSum = recordReturnDAO.getReturnSumAreaByTime(recordId,calBeginPatch);
				if(recordReturnSum != null){
					 if(hadGetBenefit100){
						 /* 对于享受100 平米优惠的
						  * 如果住宅还房面积大于拟还住宅房面积，则表示住宅还房结束，则剩余住宅房子过渡费计算面积为0
						  * 如果住宅还房面积小于拟还住宅房面积，则用实际拆迁住宅房面积-住宅还房总面积当作过渡费计算面积 */
						 if(houseAreaBack - bigDecimalTODouble(recordReturnSum.getHouseReturn()) <= 0){
							 remainHouse = 0;
						 }else{
							 remainHouse = houseArea - bigDecimalTODouble(recordReturnSum.getHouseReturn());
						 }
					 }else{
						 remainHouse = baseRemainHouse - bigDecimalTODouble(recordReturnSum.getHouseReturn());
					 }
					 remainBusiness = baseRemainBusiness - bigDecimalTODouble(recordReturnSum.getBusinessReturn());
				 }
				if (overDay < 1) overDay = 0;
				if(remainHouse < 0) remainHouse = 0;
			    if(remainBusiness < 0) remainBusiness = 0;
				double calFee = overDay * rate / baseDay * (perHouse * remainHouse + perBusiness * remainBusiness);
				fee += calFee;
				/* 记录过渡费基三明细场景 */
				RecordTransitionfeeDtl recordTransitionfeeDtl = new RecordTransitionfeeDtl();
				recordTransitionfeeDtl.setType(type);
				recordTransitionfeeDtl.setStartTime(calBeginPatch);
				recordTransitionfeeDtl.setEndTime(calEndPatch);
				recordTransitionfeeDtl.setBaseDay(baseDay);
				recordTransitionfeeDtl.setCalDay(new BigDecimal(overDay));
				recordTransitionfeeDtl.setBaseRate(new BigDecimal(rate));
				recordTransitionfeeDtl.setCalHouseArea(new BigDecimal(remainHouse));
				recordTransitionfeeDtl.setCalBusinessArea(new BigDecimal(remainBusiness));
				recordTransitionfeeDtl.setPerHouse(new BigDecimal(perHouse));
				recordTransitionfeeDtl.setPerBusiness(new BigDecimal(perBusiness));
				recordTransitionfeeDtl.setFee(new BigDecimal(calFee));
				recordTransitionfeeDtl.setCreatedTime(Calendar.getInstance());
				String calShow = overDay + " * " + rate + " / " + baseDay + " * " + "(" + perHouse + " * " + remainHouse + " + " + perBusiness + " * " + remainBusiness + ")" + " = " + calFee;
				recordTransitionfeeDtl.setCalShow(calShow);
				recordTransitionfeeDtlList.add(recordTransitionfeeDtl);
				calBeginPatch = this.coloneCalendar(calEndPatch);
			}
			
			if(calEndPatch.compareTo(calEnd) < 0){
				calBeginPatch = this.coloneCalendar(calEndPatch);
				calEndPatch = this.coloneCalendar(calEnd);
				int overDay = this.calRealBtwDays(calEndPatch, calBeginPatch);
				RecordReturnSum recordReturnSum = recordReturnDAO.getReturnSumAreaByTime(recordId,calBeginPatch);
				 if(recordReturnSum != null){
					 if(hadGetBenefit100){
						 /* 对于享受100 平米优惠的
						  * 如果住宅还房面积大于拟还住宅房面积，则表示住宅还房结束，则剩余住宅房子过渡费计算面积为0
						  * 如果住宅还房面积小于拟还住宅房面积，则用实际拆迁住宅房面积-住宅还房总面积当作过渡费计算面积 */
						 if(houseAreaBack - bigDecimalTODouble(recordReturnSum.getHouseReturn()) <= 0){
							 remainHouse = 0;
						 }else{
							 remainHouse = houseArea - bigDecimalTODouble(recordReturnSum.getHouseReturn());
						 }
					 }else{
						 remainHouse = baseRemainHouse - bigDecimalTODouble(recordReturnSum.getHouseReturn());
					 }
					 remainBusiness = baseRemainBusiness - bigDecimalTODouble(recordReturnSum.getBusinessReturn());
					 if(remainHouse < 0) remainHouse = 0;
					 if(remainBusiness < 0) remainBusiness = 0;
				 }
				if (overDay < 1) overDay = 0;
				double calFee = overDay * rate / baseDay * (perHouse * remainHouse + perBusiness * remainBusiness);
				fee += calFee;
				/* 记录过渡费基三明细场景 */
				RecordTransitionfeeDtl recordTransitionfeeDtl = new RecordTransitionfeeDtl();
				recordTransitionfeeDtl.setType(type);
				recordTransitionfeeDtl.setStartTime(calBeginPatch);
				recordTransitionfeeDtl.setEndTime(calEndPatch);
				recordTransitionfeeDtl.setBaseDay(baseDay);
				recordTransitionfeeDtl.setCalDay(new BigDecimal(overDay));
				recordTransitionfeeDtl.setBaseRate(new BigDecimal(rate));
				recordTransitionfeeDtl.setCalHouseArea(new BigDecimal(remainHouse));
				recordTransitionfeeDtl.setCalBusinessArea(new BigDecimal(remainBusiness));
				recordTransitionfeeDtl.setPerHouse(new BigDecimal(perHouse));
				recordTransitionfeeDtl.setPerBusiness(new BigDecimal(perBusiness));
				recordTransitionfeeDtl.setFee(new BigDecimal(calFee));
				recordTransitionfeeDtl.setCreatedTime(Calendar.getInstance());
				String calShow = overDay + " * " + rate + " / " + baseDay + " * " + "(" + perHouse + " * " + remainHouse + " + " + perBusiness + " * " + remainBusiness + ")" + " = " + calFee;
				recordTransitionfeeDtl.setCalShow(calShow);
				recordTransitionfeeDtlList.add(recordTransitionfeeDtl);
			}
		}
		if(fee < 0) fee = 0;
		return fee;
	}
	
	
}
