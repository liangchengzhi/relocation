package common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * 过渡费计算明细表
 * @date 2017-04-30
 * @author liangcz
 */
@Entity
@Table(catalog = "relocation", name = "record_transitionfee_dtl")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "RecordTransitionfeeDtl")
public class RecordTransitionfeeDtl implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 *  id 编号(主键)
	 */
	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	/**
	 * 过渡费类型(首次过渡费、正常过渡费、逾期过渡费、三个月补偿)
	 */
	@Column(name = "type")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String type;
	/**
	 *  开始时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startTime;
	/**
	 * 结束时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endTime;
	/**
	 * 计算天数
	 */
	@Column(name = "cal_day", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal calDay;
	/**
	 *  月基础天数
	 */
	@Column(name = "base_day")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer baseDay;
	/**
	 * 基础利率(会浮动，逾期此利率会上浮)
	 */
	@Column(name = "base_rate", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal baseRate;
	/**
	 * 住宅房利率
	 */
	@Column(name = "per_house", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal perHouse;
	/**
	 * 营业房利率
	 */
	@Column(name = "per_business", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal perBusiness;
	/**
	 * 住宅房计算面积
	 */
	@Column(name = "cal_house_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal calHouseArea;
	/**
	 * 营业房计算面积
	 */
	@Column(name = "cal_business_area", scale = 2, precision = 11)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal calBusinessArea;
	/**
	 * 费用
	 */
	@Column(name = "fee", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal fee;
	/**
	 * 计算展示
	 */
	@Column(name = "cal_show")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String calShow;
	/**
	 *  创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdTime;
	/**
	 *  更新时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upd_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar updTime;
	/**
	 *  拆迁记录
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "rid", referencedColumnName = "id") })
	@XmlTransient
	Record record;
	/**
	 *  过渡费计算记录
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "tid", referencedColumnName = "id") })
	@XmlTransient
	RecordTransitionfee recordTransitionfee;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public Calendar getEndTime() {
		return endTime;
	}
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getCalDay() {
		return calDay;
	}
	public void setCalDay(BigDecimal calDay) {
		this.calDay = calDay;
	}
	public Integer getBaseDay() {
		return baseDay;
	}
	public void setBaseDay(Integer baseDay) {
		this.baseDay = baseDay;
	}
	public BigDecimal getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(BigDecimal baseRate) {
		this.baseRate = baseRate;
	}
	public BigDecimal getPerHouse() {
		return perHouse;
	}
	public void setPerHouse(BigDecimal perHouse) {
		this.perHouse = perHouse;
	}
	public BigDecimal getPerBusiness() {
		return perBusiness;
	}
	public void setPerBusiness(BigDecimal perBusiness) {
		this.perBusiness = perBusiness;
	}
	public BigDecimal getCalHouseArea() {
		return calHouseArea;
	}
	public void setCalHouseArea(BigDecimal calHouseArea) {
		this.calHouseArea = calHouseArea;
	}
	public BigDecimal getCalBusinessArea() {
		return calBusinessArea;
	}
	public void setCalBusinessArea(BigDecimal calBusinessArea) {
		this.calBusinessArea = calBusinessArea;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public String getCalShow() {
		return calShow;
	}
	public void setCalShow(String calShow) {
		this.calShow = calShow;
	}
	public Calendar getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}
	public Calendar getUpdTime() {
		return updTime;
	}
	public void setUpdTime(Calendar updTime) {
		this.updTime = updTime;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public RecordTransitionfee getRecordTransitionfee() {
		return recordTransitionfee;
	}
	public void setRecordTransitionfee(RecordTransitionfee recordTransitionfee) {
		this.recordTransitionfee = recordTransitionfee;
	}
	@Override
	public String toString() {
		return "RecordTransitionfeeDtl [id=" + id + ",type=" + type + ",  startTime=" + startTime
				+ ", endTime=" + endTime + ", calDay=" + calDay + ", baseDay="
				+ baseDay + ", baseRate=" + baseRate + ", perHouse=" + perHouse
				+ ", perBusiness=" + perBusiness + ", calHouseArea="
				+ calHouseArea + ", calBusinessArea=" + calBusinessArea
				+ ", fee=" + fee + ", calShow=" + calShow + ", createdTime="
				+ createdTime + ", updTime=" + updTime + "]";
	}
	
}
