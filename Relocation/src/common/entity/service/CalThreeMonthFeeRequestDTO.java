package common.entity.service;

import java.util.Calendar;

import common.domain.Cuser;
import common.domain.Record;

/**
 * 计算还房补贴三个月费用请求DTO
 * @author liangcz
 *
 */
public class CalThreeMonthFeeRequestDTO {
	
	/**
	 *  拆迁记录
	 */
	private Record record;
	
	/**
	 *  还房时间
	 */
	private Calendar returnTime;
	
	/**
	 *  住宅房还房面积
	 */
	private Double houseReturnArea;
	
	/**
	 *  营业房还房面积
	 */
	private Double businessReturnArea;
	
	/**
	 *  操作用户
	 */
	private Cuser cuser;

	
	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Calendar getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Calendar returnTime) {
		this.returnTime = returnTime;
	}

	public Double getHouseReturnArea() {
		return houseReturnArea;
	}

	public void setHouseReturnArea(Double houseReturnArea) {
		this.houseReturnArea = houseReturnArea;
	}

	public Double getBusinessReturnArea() {
		return businessReturnArea;
	}

	public void setBusinessReturnArea(Double businessReturnArea) {
		this.businessReturnArea = businessReturnArea;
	}

	public Cuser getCuser() {
		return cuser;
	}

	public void setCuser(Cuser cuser) {
		this.cuser = cuser;
	}

	@Override
	public String toString() {
		return "CalThreeMonthFeeRequestDTO [record=" + record
				+ ", returnTime=" + returnTime + ", houseReturnArea="
				+ houseReturnArea + ", businessReturnArea="
				+ businessReturnArea + ", cuser=" + cuser + "]";
	}
	
}
