package common.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vis.service.MyRecordService;

import common.dao.RecordDAO;
import common.dao.RecordReturnDAO;
import common.domain.Cuser;
import common.domain.Project;
import common.domain.Record;
import common.domain.RecordReturn;
import common.domain.RecordTransitionfee;
import common.entity.basic.ErrorCode;
import common.entity.basic.IFSException;
import common.entity.basic.Input;
import common.entity.service.RecordReturnSum;
import common.util.CommonsUtil;
import common.util.FileTools;
import common.util.ImportModelUtil;
import common.util.JsonObj;
import common.util.PropertiesUtil;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private RecordDAO recordDAO;

	@Autowired
	private RecordReturnDAO recordReturnDAO;
	@Autowired
	MyRecordService recordService;
	
	
	@Autowired
	MyRecordService myRecordService;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 *  保存拆迁记录信息
	 * @param entity
	 * @param cuser
	 * @return
	 */
	@Override
	public JsonObj saveRecord(Record entity, Cuser cuser) {
		JsonObj result = new JsonObj();
		Record findById = null;
		if (entity.getId() != null) {
			findById = recordDAO.findRecordById(entity.getId());
		}

		Project project = myRecordService.findOrSaveProjectByName(entity
				.getProjectName());

		if (entity.getStartTime() != null) {
			entity.getStartTime().set(Calendar.HOUR, 0);
			entity.getStartTime().set(Calendar.MINUTE, 0);
			entity.getEndTime().set(Calendar.SECOND, 0);
		}
		if (entity.getEndTime() != null) {
			entity.getEndTime().set(Calendar.HOUR, 0);
			entity.getEndTime().set(Calendar.MINUTE, 0);
			entity.getEndTime().set(Calendar.SECOND, 0);
		}

		if (findById == null) {// 新增
			if (cuser.getUsertype() != 10) {
				result.setStatus(403);
				return result; // 无权限
			}
			//
			findById = entity;
			findById.setCuser(cuser);
			findById.setHouseAreaBackReturn(new BigDecimal(0));
			findById.setBusinessAreaBackReturn(new BigDecimal(0));
			findById.setProductionAreaBackReturn(new BigDecimal(0));
			findById.setPendingState("1");

			findById.setCreatedTime(Calendar.getInstance());
			findById.setBalanceDeal(new BigDecimal(0));
			findById.setIsDeleted(false);
			findById.setIsDealed(false);
			findById = recordDAO.store(findById);
		} else {// 修改
			/*
			 * if (cuser.getUsertype() < 8 && cuser.getId() * 1 !=
			 * findById.getCuser().getId()) { result.setStatus(403); return
			 * result;// 无权限 }
			 */
			findById.setCoveredArea(entity.getCoveredArea());
			findById.setTotal(entity.getTotal());
			findById.setReplaceAreaTotal(entity.getReplaceAreaTotal());
			findById.setProjectName(entity.getProjectName());
			findById.setContractNumber(entity.getContractNumber());
			findById.setRecordNumber(entity.getRecordNumber());
			findById.setStartTime(entity.getStartTime());
			findById.setUsername(entity.getUsername());
			findById.setEndTime(entity.getEndTime());
			findById.setUsercontact(entity.getUsercontact());
			findById.setUseraddress(entity.getUseraddress());
			findById.setFirstStartTime(entity.getFirstStartTime());
			findById.setFirstEndTime(entity.getFirstEndTime());
			findById.setTransitionFee(entity.getTransitionFee());
			findById.setFacilityFee(entity.getFacilityFee());
			findById.setTransportFee(entity.getTransportFee());
			findById.setMovingFee(entity.getMovingFee());
			findById.setAwardFee(entity.getAwardFee());
			findById.setDiscontinuedFee(entity.getDiscontinuedFee());
			findById.setSelfdemolitionFee(entity.getSelfdemolitionFee());
			findById.setOtherFee(entity.getOtherFee());
			findById.setRemark(entity.getRemark());
			findById.setHouseArea(entity.getHouseArea());
			findById.setBusinessArea(entity.getBusinessArea());
			findById.setProductionArea(entity.getProductionArea());
			findById.setOtherArea(entity.getOtherArea());
			findById.setReplaceHouseAreaBefore(entity
					.getReplaceHouseAreaBefore());
			findById.setReplaceBusinessAreaBefore(entity
					.getReplaceBusinessAreaBefore());
			findById.setReplaceFlag(entity.getReplaceFlag());
			findById.setReplaceHouseArea(entity.getReplaceHouseAreaBefore() == null ? new BigDecimal(
					0) : new BigDecimal(entity.getReplaceHouseAreaBefore()
					.doubleValue() / 2));
			findById.setReplaceBusinessArea(entity.getReplaceBusinessArea());
			findById.setHouseAreaBack(entity.getHouseAreaBack());
			findById.setHouseAreaBackRoom(entity.getHouseAreaBackRoom());
			findById.setBusinessAreaBack(entity.getBusinessAreaBack());
			findById.setBusinessAreaBackRoom(entity.getBusinessAreaBackRoom());
			findById.setOverArea(entity.getOverArea());
			findById.setOverAreaBusiness(entity.getOverAreaBusiness());
			findById.setBalance1(entity.getBalance1());
			findById.setBalance2(entity.getBalance2());
			findById.setSelfRemoveArea(entity.getSelfRemoveArea());
			findById.setSelfRemoveAmount(entity.getSelfRemoveAmount());
			findById.setBankAccount(entity.getBankAccount());
			findById.setUseridcard(entity.getUseridcard());
			findById.setActualBackHouseArea(entity.getActualBackHouseArea());
			findById.setActualBackBusinessArea(entity
					.getActualBackBusinessArea());
			findById.setAreaBenefit100(entity.getAreaBenefit100());
			findById.setServiceDepartment(entity.getServiceDepartment());
			findById = recordDAO.store(findById);
		}
		findById.setChannel("0");
		findById.setProject(project);
		findById.setLastEditTime(Calendar.getInstance());
		recordDAO.store(findById);
		result.setData(findById.getId());
		result.setStatus(0);
		return result;
	}
	
	/**
	 * 导入拆迁数据
	 * @param path
	 * @param source
	 * @param cuser
	 */
	@SuppressWarnings("resource")
	@Override
	public JsonObj importRecord(String path,String source,Cuser cuser){
		List<Record> toRollBacks = new ArrayList<Record>();
		JsonObj result = new JsonObj();
		result.setStatus(0);
		result.setMessage("success");
		Workbook wb0 = null;
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(source);
			// 根据指定的文件输入流导入Excel从而产生Workbook对象
			
			if (path.endsWith(".xlsx")) {
				wb0 = new XSSFWorkbook(fileIn);
			} else {
				wb0 = new HSSFWorkbook(fileIn);
			}
		} catch (Exception e) {
			if(wb0 != null){
				try {
					wb0.close();
				} catch (IOException e1) {
				}
			}
			result.setStatus(901);
			result.setMessage("导入失败");
			return result;
		}
		
		try {

			// 获取Excel文档中的第一个表单
			Sheet sht0 = wb0.getSheetAt(0);
			// 对Sheet中的每一行进行迭代

			int successCount = 0;
			
			int rowid = 1;
			
			for (Row r : sht0) {
				if(rowid++ < 2){
					continue;
				}
				
				String index = getExcelFieldValue(r,"recordInputModel","index");
				Record entity = new Record();
				entity.setOldProjectNo(getExcelFieldValue(r,"recordInputModel","oldProjectNo"));
				entity.setInfoId(getExcelFieldValue(r,"recordInputModel","oldProjectNo") + getExcelFieldValue(r,"recordInputModel","recordNumber"));
				entity.setUsername(getExcelFieldValue(r,"recordInputModel","username"));
				entity.setUsercontact(getExcelFieldValue(r,"recordInputModel","usercontact"));
				entity.setUseraddress(getExcelFieldValue(r,"recordInputModel","useraddress"));
				entity.setContractNumber(getExcelFieldValue(r,"recordInputModel","contractNumber"));
				entity.setRecordNumber(getExcelFieldValue(r,"recordInputModel","recordNumber"));
				entity.setProjectName(getExcelFieldValue(r,"recordInputModel","projectName"));
				entity.setStartTime(strTOCalendar(getExcelFieldValue(r,"recordInputModel","startTime"),"yyyy-MM-dd"));
				entity.setEndTime(strTOCalendar(getExcelFieldValue(r,"recordInputModel","endTime"),"yyyy-MM-dd"));
				entity.setStartTime(strTOCalendar(getExcelFieldValue(r,"recordInputModel","startTime"),"yyyy-MM-dd"));
				entity.setFirstStartTime(strTOCalendar(getExcelFieldValue(r,"recordInputModel","firstStartTime"),"yyyy-MM-dd"));
				entity.setFirstEndTime(strTOCalendar(getExcelFieldValue(r,"recordInputModel","firstEndTime"),"yyyy-MM-dd"));
				entity.setTransitionFee(str2BigDecimal(getExcelFieldValue(r,"recordInputModel","firstFee")));
				double houseArea = parseDouble(getExcelFieldValue(r,"recordInputModel","houseArea"));
				double businessArea = parseDouble(getExcelFieldValue(r,"recordInputModel","businessArea"));
				double productionArea = parseDouble(getExcelFieldValue(r,"recordInputModel","productionArea"));
				entity.setHouseArea(new BigDecimal(houseArea));
				entity.setBusinessArea(new BigDecimal(businessArea));
				entity.setCoveredArea(new BigDecimal(houseArea + businessArea + productionArea));
				entity.setProductionArea(getExcelFieldValue(r,"recordInputModel","productionArea"));
				double replaceHouseAreaBefore = parseDouble(getExcelFieldValue(r,"recordInputModel","replaceHouseArea"));
				entity.setReplaceHouseAreaBefore(new BigDecimal(replaceHouseAreaBefore));
				entity.setReplaceHouseArea(new BigDecimal(replaceHouseAreaBefore/2));
				entity.setAreaBenefit100(Boolean.valueOf(getExcelFieldValue(r,"recordInputModel","areaBenefit100")));
				entity.setHouseAreaBack(str2BigDecimal(getExcelFieldValue(r,"recordInputModel","planHouseAreaBack")));
				entity.setBusinessAreaBack(str2BigDecimal(getExcelFieldValue(r,"recordInputModel","planBusinessAreaBack")));
				
				entity.setBalance1(str2BigDecimal(getExcelFieldValue(r,"recordInputModel","balance1")));
				entity.setBalance2(str2BigDecimal(getExcelFieldValue(r,"recordInputModel","balance2")));
				entity.setSelfRemoveAmount(getExcelFieldValue(r,"recordInputModel","selfRemoveAmount"));
				entity.setSelfRemoveArea(getExcelFieldValue(r,"recordInputModel","selfRemoveArea"));
				entity.setBankAccount(getExcelFieldValue(r,"recordInputModel","acctNo"));
				entity.setUseridcard(getExcelFieldValue(r,"recordInputModel","idNo"));
				
				entity.setBankAccount(getExcelFieldValue(r,"recordInputModel","acctNo"));
				entity.setUseridcard(getExcelFieldValue(r,"recordInputModel","idNo"));
				
				entity.setLastComputeTime(strTOCalendar(getExcelFieldValue(r,"recordInputModel","lastComputeTime"),"yyyy-mm-dd"));
				// entity.setIsEnd(Boolean.valueOf(getExcelFieldValue(r,"recordInputModel","isEnd")));
				entity.setIsEnd(false);
				entity.setRemark(getExcelFieldValue(r,"recordInputModel","remark"));
				entity.setPlanReturnHouseInfo(getExcelFieldValue(r,"recordInputModel","planReturnHouseInfo"));
				entity.setPlanReturnBusinessInfo(getExcelFieldValue(r,"recordInputModel","planReturnBusinessInfo"));
				entity.setPauseCalculateFee(Boolean.valueOf(getExcelFieldValue(r,"recordInputModel","pauseCalculateFee")));
				entity.setServiceDepartment(getExcelFieldValue(r,"recordInputModel","serviceDepartment"));
				log.info("第" + index + "数据:" + entity);
				
				Record record = recordDAO.findRecord(entity.getProjectName(), entity.getContractNumber(), entity.getRecordNumber());
				if(record != null){
					throw new IFSException("第" + index + "行合同号为" + entity.getContractNumber() + "的记录已经存在", ErrorCode.BaseErrorCode);
				}
				
				Project project = myRecordService.findOrSaveProjectByName(entity.getProjectName());
				entity.setProject(project);
				entity.setCuser(cuser);
				entity.setHouseAreaBackReturn(new BigDecimal(0));
				entity.setBusinessAreaBackReturn(new BigDecimal(0));
				entity.setProductionAreaBackReturn(new BigDecimal(0));
				entity.setPendingState("1");
				entity.setLastEditTime(Calendar.getInstance());
				entity.setCreatedTime(Calendar.getInstance());
				entity.setBalanceDeal(new BigDecimal(0));
				entity.setIsDeleted(false);
				entity.setIsDealed(false);
				entity.setChannel("1");
				entity.setTotal(entity.getTransitionFee());
				entity = recordDAO.store(entity);
				toRollBacks.add(entity);
				successCount++;
		
				
			}
			
			

			String msg = "导入完成，成功导入 " + successCount + " 条";
			msg += "。";
			result.setMessage(msg);
		} catch (IFSException e) {
			log.error(CommonsUtil.getStackTrace(e));
			log.error("导入失败，将回滚数据!");
			// 回滚删除数据
			recordDAO.deleteRecord(toRollBacks);
			result.setStatus(901);
			result.setMessage(e.getMessage());
		}catch (Exception e) {
			log.error(CommonsUtil.getStackTrace(e));
			log.error("导入失败，将回滚数据!");
			// 回滚删除数据
			recordDAO.deleteRecord(toRollBacks);
			result.setStatus(901);
			result.setMessage("导入失败");
			// throw new IFSException("导入错误","1001");
		}finally{
			try {
				if(wb0 != null){
					wb0.close();
				}
				if(fileIn != null){
					fileIn.close();
				}
			} catch (Throwable e) {
				
			}
			
		}
		return result;
	}
	
	/**
	 *  还房信息导入
	 * @param path
	 * @param source
	 * @param cuser
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	@Override
	public JsonObj importReturnArea(String path,String source,Cuser cuser){
		JsonObj result = new JsonObj();
		result.setStatus(0);
		result.setMessage("success");
		Workbook wb0 = null;
		FileInputStream fileIn;
		List<String> successList = new ArrayList<String>();
		List<String> errorList = new ArrayList<String>();
		File successFile;
		File errorFile;
		try {
			fileIn = new FileInputStream(source);
			// 根据指定的文件输入流导入Excel从而产生Workbook对象
			
			if (path.endsWith(".xlsx")) {
				wb0 = new XSSFWorkbook(fileIn);
			} else {
				wb0 = new HSSFWorkbook(fileIn);
			}
			
			File logDir = new File(PropertiesUtil.getProperty("relocationLogDir",null));
			if(!logDir.exists()) logDir.mkdirs();
		    successFile = new File(logDir.getAbsoluteFile() + File.separator + "success.txt");
		    errorFile = new File(logDir.getAbsoluteFile() + File.separator + "error.txt");
			if(!successFile.exists()) successFile.createNewFile();
			if(!errorFile.exists()) errorFile.createNewFile();
		} catch (Exception e) {
			log.error(CommonsUtil.getStackTrace(e));
			if(wb0 != null){
				try {
					wb0.close();
				} catch (IOException e1) {
				}
			}
			result.setStatus(902);
			result.setMessage("导入还房信息失败");
			return result;
		}
		
		List<Record> recordList = new ArrayList<Record>();
		List<RecordReturn> recordReturnList = new ArrayList<RecordReturn>();
		try {

			// 获取Excel文档中的第一个表单
			Sheet sht0 = wb0.getSheetAt(0);
			// 对Sheet中的每一行进行迭代

			int successCount = 0;
			int ignoreCount = 0;
			int rowid = 1;
			for (Row r : sht0) {
				if(rowid++ < 2){
					continue;
				}
				String errorMsg = "";
				String index = getExcelFieldValue(r,"recordReturnModel","index");
				String projectName = getExcelFieldValue(r,"recordReturnModel","projectName");
				String recordNumber = getExcelFieldValue(r,"recordReturnModel","recordNumber");
				String contractNumber = getExcelFieldValue(r,"recordReturnModel","contractNumber");
				String returnTime = getExcelFieldValue(r,"recordReturnModel","returnTime");
				String houseAreaReturn = getExcelFieldValue(r,"recordReturnModel","houseAreaReturn");
				// String businessAreaReturn = getExcelFieldValue(r,"recordReturnModel","businessAreaReturn");
				String businessAreaReturn = "0";// 营业房暂时写为0
				String houseDtl = getExcelFieldValue(r,"recordReturnModel","houseDtl1") + "  " + getExcelFieldValue(r,"recordReturnModel","houseDtl2") ;
				String phone = getExcelFieldValue(r,"recordReturnModel","phone");
				String oldProjectNo = getExcelFieldValue(r,"recordReturnModel","oldProjectNo");
				String infoId = oldProjectNo + recordNumber;
				
				Record record = recordDAO.findRecord(projectName, contractNumber, recordNumber);
				if(record == null){
					errorMsg = index + "行" + "合同号为" + contractNumber + "找不到拆迁记录";
					errorList.add(errorMsg);
					ignoreCount ++;
					//throw new IFSException(index + "行" + "合同号为" + contractNumber + "找不到拆迁记录", ErrorCode.BaseErrorCode);
					continue; // 数据错误先跳过
				}
				if(!recordList.contains(record)){
					// 备份record
					recordList.add((Record) BeanUtils.cloneBean(record));
				}
				
				RecordReturn entity = new RecordReturn();
				entity.setReturnTime(strTOCalendar(returnTime, "yyyy-MM-dd"));
				entity.setHouseArea(str2BigDecimal(houseAreaReturn));
				entity.setBusinessArea(str2BigDecimal(businessAreaReturn));
				entity.setCreatedTime(Calendar.getInstance());
				entity.setSid(record.getId());
				entity.setHouseDtl(houseDtl);
				entity.setPhone(phone);
				
				entity.setOldProjectNo(oldProjectNo);
				entity.setInfoId(infoId);
				
				/* 
				 * 如果 拟还住宅房面积和拟还营业房面积都没空，提示先设置拟还房，返回错误。
				 * 如果本次还住宅房面积 + 已还住宅房面积 > 拟还住宅房面积，那么提示面积超出。 
				 * 如果本次还营业房面积 + 已还营业面积 > 拟还营业房面积，那么提示面积超出。
				 * 否则，已还房面积=原面积+本次面积。
				 * 如果拟还住宅房+拟还营业房都还完，更新还房记录标识结束为true。
				 * 更新还房记录和原拆迁记录。
				 * 计算未来三个月还房补贴
				 * */
				double thisHouseArea = entity.getHouseArea() == null ? 0 : entity.getHouseArea().doubleValue(); // 本次还住宅房面积 
				double thisBusinessArea = entity.getBusinessArea() == null ? 0 : entity.getBusinessArea().doubleValue(); // 本次还营业房面积 
						
				double houseAreaBack = record.getHouseAreaBack() == null ? 0 : record.getHouseAreaBack().doubleValue(); // 拟已还住宅房总面积
				double businessAreaBack = record.getBusinessAreaBack() == null ? 0 : record.getBusinessAreaBack().doubleValue(); // 拟还商品房总面积
				
				double actualBackHouseArea = record.getActualBackHouseArea() == null ? 0 : record.getActualBackHouseArea().doubleValue(); // 已还住宅房总面积 
				double actualBackBusinessArea = record.getActualBackBusinessArea() == null ? 0 : record.getActualBackBusinessArea().doubleValue(); // 已还商品房总面积
				
				if(houseAreaBack == 0 && businessAreaBack == 0){
					errorMsg = index + "行" +"合同号为" + contractNumber + "请设置拟还房面积";
					errorList.add(errorMsg);
					throw new IFSException(index + "行" +"合同号为" + contractNumber + "请设置拟还房面积", ErrorCode.BaseErrorCode);
				}
				
				if(actualBackHouseArea + thisHouseArea > houseAreaBack){
					// throw new IFSException(index + "行" +"合同号为" + contractNumber + "还住宅房面积超出拟还住宅房面积", ErrorCode.BaseErrorCode);
				}
				
				if(actualBackBusinessArea + thisBusinessArea > businessAreaBack){
					errorMsg = index + "行" +"合同号为" + contractNumber + "请设置拟还房面积";
					errorList.add(errorMsg);
					throw new IFSException(index + "行" +"合同号为" + contractNumber + "请设置拟还房面积", ErrorCode.BaseErrorCode);
				}
				
				if(record.getLastComputeTime() != null && record.getLastComputeTime().compareTo(entity.getReturnTime()) > 0){
					errorMsg = index + "行" +"合同号为" + contractNumber + "还房时间不能小于上一次过渡费计算时间";
					errorList.add(errorMsg);
					throw new IFSException(index + "行" +"合同号为" + contractNumber + "还房时间不能小于上一次过渡费计算时间", ErrorCode.BaseErrorCode);
				}
				
				if(actualBackHouseArea + thisHouseArea == houseAreaBack && actualBackBusinessArea + thisBusinessArea == businessAreaBack){
					result.setData(true);
				}else{
					result.setData(false);
				}
				
				record.setActualBackHouseArea(new BigDecimal(actualBackHouseArea + thisHouseArea));
				record.setActualBackBusinessArea(new BigDecimal(actualBackBusinessArea + thisBusinessArea));
				
				// record.setHouseArea(new BigDecimal(houseAreaBack - (actualBackHouseArea + thisHouseArea)));
				// record.setBusinessArea(new BigDecimal(businessAreaBack - (actualBackBusinessArea + thisBusinessArea)));
				
				entity.setCreatedTime(Calendar.getInstance());
				
				entity.setRemainHouseArea(new BigDecimal(houseAreaBack - (actualBackHouseArea + thisHouseArea)));
				entity.setRemainBusinessArea(new BigDecimal(businessAreaBack - (actualBackBusinessArea + thisBusinessArea)));
				entity.setChannel(1);
				
				recordDAO.store(record);
				entity = recordReturnDAO.store(entity);
				recordReturnList.add(entity);
				successCount++;
				successList.add(index);
			}

			String msg = "导入完成，成功导入 " + successCount + " 条,忽略 " + ignoreCount + " 条";
			msg += "。";
			result.setMessage(msg);
		} catch (IFSException e) {
			log.error(CommonsUtil.getStackTrace(e));
			log.error("导入失败，将回滚数据!");
			// 回滚删除数据
			for (RecordReturn recordReturn : recordReturnList) {
				recordReturnDAO.remove(recordReturn);
			}
			for (Record record : recordList) {
				recordDAO.store(record);
			}
			result.setStatus(902);
			result.setMessage(e.getMessage());
		}catch (Exception e) {
			log.error(CommonsUtil.getStackTrace(e));
			log.error("导入失败，将回滚数据!");
			// 回滚删除数据
			for (RecordReturn recordReturn : recordReturnList) {
				recordReturnDAO.remove(recordReturn);
			}
			for (Record record : recordList) {
				recordDAO.store(record);
			}
			result.setStatus(902);
			result.setMessage("导入失败");
			// throw new IFSException("导入错误","1001");
		}finally{
			try {
				FileTools.writeFile(successList, successFile);
				FileTools.writeFile(errorList, errorFile);
				if(wb0 != null){
					wb0.close();
				}
				if(fileIn != null){
					fileIn.close();
				}
			} catch (Throwable e) {
				
			}
		}
		return result;
	}
	
	public HSSFWorkbook createTransitionfeeExportExcel(List<RecordTransitionfee> list,String source,
			String nickname,Integer year,Integer quarter,String pname,String feetype,Boolean dealed) throws IOException{
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		FileInputStream fileIn = new FileInputStream(source);
		HSSFWorkbook workbook = new HSSFWorkbook(fileIn);

		HSSFSheet sheet = workbook.getSheetAt(0);
		// sheet.createFreezePane(0, 3);

		HSSFRow tpl = sheet.getRow(3);
		sheet.removeRow(tpl);
		int rowIndex = 3;

		for (RecordTransitionfee record : list) {
			RecordTransitionfee first = recordService.findFirstTransitionfee(record.getRecord().getId());
			 RecordReturnSum recordReturnSum = recordReturnDAO.getReturnSumAreaByTime(record.getRecord().getId(), record.getEndTime());
			if (first == null)
				first = record;

			HSSFRow row = sheet.createRow(rowIndex);
			
			row.createCell(0).setCellValue(rowIndex - 2);
			row.createCell(1).setCellValue(record.getRecord().getUsername());
			row.createCell(2).setCellValue(record.getRecord().getProjectName());
			row.createCell(3).setCellValue(record.getRecord().getContractNumber());
			row.createCell(4).setCellValue(record.getRecord().getRecordNumber());
			row.createCell(5).setCellValue(sdf2.format(record.getRecord().getFirstStartTime().getTime()));
			row.createCell(6).setCellValue(sdf2.format(record.getRecord().getFirstEndTime().getTime()));
			row.createCell(7).setCellValue(sdf2.format(record.getStartTime().getTime()));
			row.createCell(8).setCellValue(sdf2.format(record.getEndTime().getTime()));

			row.createCell(9).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(9).setCellValue(getDoubleValue(first.getFirstFee()));
			
			row.createCell(10).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(10).setCellValue(getDoubleValue(record.getFee()));
			
			row.createCell(11).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(11).setCellValue(getDoubleValue(record.getOverdueFee()));
			
			row.createCell(12).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(12).setCellValue(getDoubleValue(record.getThreeMonthFee()));
			
			row.createCell(13).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			if(record.getFirstFee() != null){
				row.getCell(13).setCellValue(getDoubleValue(record.getQuarterFee().subtract(first.getFirstFee())));
			}else{
				row.getCell(13).setCellValue(getDoubleValue(record.getQuarterFee()));
			}

			row.createCell(14).setCellValue(record.getRecord().getBankAccount());
			
			// 原拆住宅房面积
			row.createCell(15).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(15).setCellValue(getDoubleValue(record.getRecord().getHouseArea()));
			// 原拆营业房面积
			row.createCell(16).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(16).setCellValue(getDoubleValue(record.getRecord().getBusinessArea()));	
			
			double returnHouseSum = 0; // 累计还住宅房面积
			double returnBusinessSum = 0; // 累计还营业房面积
			if(recordReturnSum != null){
				returnHouseSum = getDoubleValue(recordReturnSum.getHouseReturn());
				returnBusinessSum = getDoubleValue(recordReturnSum.getBusinessReturn());
			}
			// 累还住宅房面积
			row.createCell(17).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(17).setCellValue(returnHouseSum);	
			// 原拆营业房面积
			row.createCell(18).setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			row.getCell(18).setCellValue(returnBusinessSum);	
			
			// 办事处管理（01-新蒲办、02-新中办、03-指挥部）
			String serviceDepartment =  record.getRecord().getServiceDepartment();
			if(serviceDepartment == null){
				serviceDepartment = "";
			}
			switch (serviceDepartment) {
			case "01":
				serviceDepartment = "新蒲办";
				break;
			case "02":
				serviceDepartment = "新中办";
				break;
			case "03":
				serviceDepartment = "指挥部";
				break;
			default:
				break;
			}
			row.createCell(19).setCellValue(serviceDepartment);
			for (int i = 0; i < 19; i++)
				row.getCell(i).setCellStyle(tpl.getCell(i).getCellStyle());
			if (tpl.getRowStyle() != null)
				row.setRowStyle(tpl.getRowStyle());
			row.setHeight(tpl.getHeight());
			rowIndex++;
		}

		HSSFRow row0 = sheet.createRow(rowIndex);
		row0.createCell(0).setCellValue("合计");
		int num = 9;
		for (int i = 1; i < num; i++)
			row0.createCell(i).setCellValue("");
		String rowmap = "JKLMN";
		for (int i = 0; i < rowmap.length(); i++) {
			row0.createCell(i + num).setCellType(XSSFCell.CELL_TYPE_FORMULA);
			if (rowIndex > 3)
				row0.getCell(i + num)
						.setCellFormula("SUM(" + rowmap.charAt(i) + "4:" + rowmap.charAt(i) + (rowIndex) + ")");
		}
		row0.createCell(14).setCellValue("");
		for (int i = 0; i < 15; i++)
			row0.getCell(i).setCellStyle(tpl.getCell(12).getCellStyle());
		row0.setHeight((short) 550);

		for (int i = 3; i < rowIndex; i++) {
			HSSFRow row = sheet.getRow(i);
			for (int j = 9; j < 14; j++) {
				HSSFCell cell = row.getCell(j);
				if (cell.getNumericCellValue() == 0)
					cell.setCellValue("");
			}
		}

		sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, num));

		Calendar now2 = Calendar.getInstance();
		HSSFRow row2 = sheet.getRow(1);
		row2.getCell(0).setCellValue("填报单位：" + nickname);
		row2.getCell(10).setCellValue("制表时间： " + sdf2.format(now2.getTime()));

		String header = year + "年" + quarter + "季度";
		HSSFRow row = sheet.getRow(0);
		if (pname != null && !pname.equals("")) {
			header += pname;
		} else {
			header += "******";
		}
		header += "房屋征收过渡费领取申请表";
		if (dealed != null) {
			if (dealed == true)
				header += "(已付款)";
			else
				header += "(未付款)";
		}
		if (feetype != null && !feetype.equals("")) {
			header += "(" + feetype + ")";
		}
		row.getCell(0).setCellValue(header);
		return workbook;
	}
	private String getExcelFieldValue(Row r,String modelId,String name){
		return getExcelFieldValue(r,modelId,name,true);
	}
			
	/**
	 * 获取excel
	 * @param modelId
	 * @param name
	 * @return
	 */
	private String getExcelFieldValue(Row r,String modelId,String name,boolean cheack){
		ImportModelUtil importModelUtil = ImportModelUtil.getInstance();
		int idx = importModelUtil.getImportModelKeyIndex(modelId, name);	
		String value = null;
		Cell cell = r.getCell(idx);
		if(cell == null){
			value = null;
		}else{
			
			switch (cell.getCellType()){
		        case HSSFCell.CELL_TYPE_NUMERIC:
		            if(HSSFDateUtil.isCellDateFormatted(cell)){
		                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		                value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
		            }else{
		            	HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
			            value = dataFormatter.formatCellValue(r.getCell(idx));
		            	//value = r.getCell(idx).toString();r.getCell(idx).getCellFormula()
		            }
		            break;
		        case HSSFCell.CELL_TYPE_STRING:
		            value = cell.getStringCellValue();
		            break; 
		        case HSSFCell.CELL_TYPE_FORMULA:
		            value = cell.getCellFormula();
		            break;
		        case HSSFCell.CELL_TYPE_BLANK:
		            value = "";
		            break;
		        default:
		        	value = r.getCell(idx).toString();
		        	break;
			}
		}
		Input input =  importModelUtil.getImportModel(modelId).getInputs().get(idx);
		String type = input.getType();
		boolean required = input.isRequired();
		if(cheack && required && StringUtils.isBlank(value)){
			String celName = input.getDesc();
			throw new IFSException(r.getRowNum() + "行数据" + idx + "列" + celName + "字段不能为空", ErrorCode.BaseErrorCode);
		}
		if(StringUtils.isBlank(value)){
			value = input.getDefaultValue();
		}
		if("boolean".equalsIgnoreCase(type)){
			if("0".equals(value)){
				value = String.valueOf(false);
			}else if("1".equals(value)){
				value =  String.valueOf(true);
			}
		}
		
		if("double".equalsIgnoreCase(type) && value == null){
			value = "0";
		}
		
		if("int".equalsIgnoreCase(type) && value == null){
			value = "0";
		}
		
		log.info(r.getRowNum() + "行" + idx + "列:" + input.getDesc() + "[" +input.getName() + "] = " + value);
		return value;
	}
	
	/**
	 *  将日期字符串转成Calendar
	 * @param datestr
	 * @param format
	 * @return
	 */
	private Calendar strTOCalendar(String datestr,String format){
		if(StringUtils.isBlank(datestr)){
			return null;
		}
		
		DateFormat df = new SimpleDateFormat(format);
		try {
			Date date = df.parse(datestr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		} catch (ParseException e) {
			log.error(CommonsUtil.getStackTrace(e));
			throw new IFSException(e,e.getMessage(),ErrorCode.BaseErrorCode);
		}
	}
	
	/**
	 * 字符串转成BigDecimal
	 * @param str
	 * @return
	 */
	private BigDecimal str2BigDecimal(String str){
		if(StringUtils.isBlank(str)){
			str = "0";
		}
		double d = Double.valueOf(str);
		return new BigDecimal(d);
	}
	/**
	 * 字符串转double
	 * @param str
	 * @return
	 */
	private Double parseDouble(String str){
		if(StringUtils.isBlank(str)){
			return 0.0;
		}
		return Double.valueOf(str);
	}
	/**
	 * BigDecimal 转成double
	 * @param bigDecimal
	 * @return
	 */
	private double getDoubleValue(BigDecimal bigDecimal){
		if(bigDecimal == null){
			return 0;
		}
		return bigDecimal.doubleValue();
	}
	
//	/**
//	 *  获取当前日期
//	 * @return
//	 */
//	private Calendar getNowDate(){
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.HOUR, 0);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.SECOND, 0);
//		return cal;
//	}
	
}
