package common.entity.service;

import java.math.BigDecimal;


/**
 * 还房总面积
 * @author liangcz
 *
 */
public class RecordReturnSum {
	/**
	 *  拆迁id
	 */
	private Integer recordId;
	/**
	 * 住宅还房面积
	 */
	private BigDecimal houseReturn;
	/**
	 * 营业还房面积
	 */
	private BigDecimal businessReturn;
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public BigDecimal getHouseReturn() {
		return houseReturn;
	}
	public void setHouseReturn(BigDecimal houseReturn) {
		this.houseReturn = houseReturn;
	}
	public BigDecimal getBusinessReturn() {
		return businessReturn;
	}
	public void setBusinessReturn(BigDecimal businessReturn) {
		this.businessReturn = businessReturn;
	}
	@Override
	public String toString() {
		return "RecordReturnSum [recordId=" + recordId + ", houseReturn="
				+ houseReturn + ", businessReturn=" + businessReturn + "]";
	}
	
}
