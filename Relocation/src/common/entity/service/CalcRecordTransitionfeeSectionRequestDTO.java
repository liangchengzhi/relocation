package common.entity.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import common.domain.Record;
import common.service.TransitionfeeServiceImpl;

/**
 * 过渡费计算分段方法请求DTO
 * @author liangcz
 * @version 2016/10/06
 * @see TransitionfeeServiceImpl
 */
public class CalcRecordTransitionfeeSectionRequestDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private CalcRecordTransitionfeeRequestDTO requestDTO;
	
	/**
	 * 要计算的record列表
	 */
	private List<Record> records;
	
	/**
	 *  当前时间
	 */
	private long nowTime;
	/**
	 *  下一次过渡费计算截止日
	 */
	private Date nextQuarterFeeCalcDueDate;
	/**
	 * 当前时间
	 */
	private Calendar now;
	private int passMonth;
	private double perHouse;
	private double perBusiness;
	private JSONObject config;
	public CalcRecordTransitionfeeRequestDTO getRequestDTO() {
		return requestDTO;
	}
	public void setRequestDTO(CalcRecordTransitionfeeRequestDTO requestDTO) {
		this.requestDTO = requestDTO;
	}
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
	}
	public long getNowTime() {
		return nowTime;
	}
	public void setNowTime(long nowTime) {
		this.nowTime = nowTime;
	}
	public Date getNextQuarterFeeCalcDueDate() {
		return nextQuarterFeeCalcDueDate;
	}
	public void setNextQuarterFeeCalcDueDate(Date nextQuarterFeeCalcDueDate) {
		this.nextQuarterFeeCalcDueDate = nextQuarterFeeCalcDueDate;
	}
	public Calendar getNow() {
		return now;
	}
	public void setNow(Calendar now) {
		this.now = now;
	}
	public int getPassMonth() {
		return passMonth;
	}
	public void setPassMonth(int passMonth) {
		this.passMonth = passMonth;
	}
	public double getPerHouse() {
		return perHouse;
	}
	public void setPerHouse(double perHouse) {
		this.perHouse = perHouse;
	}
	public double getPerBusiness() {
		return perBusiness;
	}
	public void setPerBusiness(double perBusiness) {
		this.perBusiness = perBusiness;
	}
	public JSONObject getConfig() {
		return config;
	}
	public void setConfig(JSONObject config) {
		this.config = config;
	}

	
	
}
