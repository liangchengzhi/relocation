package common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllRecordReturns", query = "select myRecordReturn from RecordReturn myRecordReturn"),
		@NamedQuery(name = "findRecordReturnByBusinessArea", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.businessArea = ?1"),
		@NamedQuery(name = "findRecordReturnByCreatedTime", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.createdTime = ?1"),
		@NamedQuery(name = "findRecordReturnByDeletedTime", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.deletedTime = ?1"),
		@NamedQuery(name = "findRecordReturnByHouseArea", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.houseArea = ?1"),
		@NamedQuery(name = "findRecordReturnById", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.id = ?1"),
		@NamedQuery(name = "findRecordReturnByIsDeleted", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.isDeleted = ?1"),
		@NamedQuery(name = "findRecordReturnByPrimaryKey", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.id = ?1"),
		@NamedQuery(name = "findRecordReturnByProductionArea", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.productionArea = ?1"),
		@NamedQuery(name = "findRecordReturnByReturnTime", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.returnTime = ?1"),
		@NamedQuery(name = "findRecordReturnBySid", query = "select myRecordReturn from RecordReturn myRecordReturn where myRecordReturn.sid = ?1") })
@Table(catalog = "relocation", name = "record_return")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "RecordReturn")
public class RecordReturn implements Serializable {
	private static final long serialVersionUID = 1L;



	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	

	@Column(name = "sid")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer sid;


	@Column(name = "house_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal houseArea;


	@Column(name = "business_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal businessArea;


	@Column(name = "production_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal productionArea;
	
	@Column(name = "remain_house_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal remainHouseArea;


	@Column(name = "remain_business_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal remainBusinessArea;
	
	/**
	 * 住宅房描述信息 
	 */
	@Column(name = "house_dtl")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String houseDtl;
	/**
	 * 营业房描述信息 
	 */
	@Column(name = "business_dtl")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String businessDtl;
	/**
	 * 生产房描述信息 
	 */
	@Column(name = "product_dtl")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String productDtl;
	/**
	 * 联系电话
	 */
	@Column(name = "phone")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar returnTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdTime;


	@Column(name = "is_deleted")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isDeleted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar deletedTime;
	
	/**
	 * 录入渠道 
	 * 0 交易录入 1 导入
	 */
	@Column(name = "channel")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer channel;
	
	/**
	 *  原项目编号(暂用于导入拆迁记录)
	 */
	@Column(name = "old_project_no")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String oldProjectNo;
	
	/**
	 *  信息ID(记录一个人信息的标识，将来补全这条信息用到)
	 */
	@Column(name = "info_id")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String infoId;

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/**
	 */
	public Integer getSid() {
		return this.sid;
	}


	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}


	public BigDecimal getHouseArea() {
		return this.houseArea;
	}


	public void setBusinessArea(BigDecimal businessArea) {
		this.businessArea = businessArea;
	}


	public BigDecimal getBusinessArea() {
		return this.businessArea;
	}


	public void setProductionArea(BigDecimal productionArea) {
		this.productionArea = productionArea;
	}


	public BigDecimal getProductionArea() {
		return this.productionArea;
	}


	public void setReturnTime(Calendar returnTime) {
		this.returnTime = returnTime;
	}


	public Calendar getReturnTime() {
		return this.returnTime;
	}


	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	
	public Calendar getCreatedTime() {
		return this.createdTime;
	}


	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}


	public Boolean getIsDeleted() {
		return this.isDeleted;
	}


	public void setDeletedTime(Calendar deletedTime) {
		this.deletedTime = deletedTime;
	}


	public Calendar getDeletedTime() {
		return this.deletedTime;
	}
	
	
	public BigDecimal getRemainHouseArea() {
		return remainHouseArea;
	}


	public void setRemainHouseArea(BigDecimal remainHouseArea) {
		this.remainHouseArea = remainHouseArea;
	}


	public BigDecimal getRemainBusinessArea() {
		return remainBusinessArea;
	}


	public void setRemainBusinessArea(BigDecimal remainBusinessArea) {
		this.remainBusinessArea = remainBusinessArea;
	}
	
	

	public Integer getChannel() {
		return channel;
	}


	public void setChannel(Integer channel) {
		this.channel = channel;
	}


	public RecordReturn() {
	}
	

	public String getHouseDtl() {
		return houseDtl;
	}


	public void setHouseDtl(String houseDtl) {
		this.houseDtl = houseDtl;
	}


	public String getBusinessDtl() {
		return businessDtl;
	}


	public void setBusinessDtl(String businessDtl) {
		this.businessDtl = businessDtl;
	}


	public String getProductDtl() {
		return productDtl;
	}


	public void setProductDtl(String productDtl) {
		this.productDtl = productDtl;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOldProjectNo() {
		return oldProjectNo;
	}

	public void setOldProjectNo(String oldProjectNo) {
		this.oldProjectNo = oldProjectNo;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	public void copy(RecordReturn that) {
		setId(that.getId());
		setSid(that.getSid());
		setHouseArea(that.getHouseArea());
		setBusinessArea(that.getBusinessArea());
		setProductionArea(that.getProductionArea());
		setReturnTime(that.getReturnTime());
		setCreatedTime(that.getCreatedTime());
		setIsDeleted(that.getIsDeleted());
		setDeletedTime(that.getDeletedTime());
	}
	
	@Override
	public String toString() {
		return "RecordReturn [id=" + id + ", sid=" + sid + ", houseArea="
				+ houseArea + ", businessArea=" + businessArea
				+ ", productionArea=" + productionArea + ", remainHouseArea="
				+ remainHouseArea + ", remainBusinessArea="
				+ remainBusinessArea + ", houseDtl=" + houseDtl
				+ ", businessDtl=" + businessDtl + ", productDtl=" + productDtl
				+ ", phone=" + phone + ", returnTime=" + returnTime
				+ ", createdTime=" + createdTime + ", isDeleted=" + isDeleted
				+ ", deletedTime=" + deletedTime + ", channel=" + channel
				+ ", oldProjectNo=" + oldProjectNo + ", infoId=" + infoId + "]";
	}


	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RecordReturn))
			return false;
		RecordReturn equalCheck = (RecordReturn) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
