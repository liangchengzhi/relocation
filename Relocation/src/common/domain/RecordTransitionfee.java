package common.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllRecordTransitionfees", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee"),
		@NamedQuery(name = "findRecordTransitionfeeByBankAccount", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.bankAccount = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByBankAccountContaining", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.bankAccount like ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByCreatedTime", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.createdTime = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByDealedTime", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.dealedTime = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByDeletedTime", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.deletedTime = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByEndTime", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.endTime = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByFee", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.fee = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByFirstEndTime", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.firstEndTime = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByFirstFee", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.firstFee = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByFirstStartTime", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.firstStartTime = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeById", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.id = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByIsDealed", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.isDealed = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByIsDeleted", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.isDeleted = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByPrimaryKey", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.id = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByQuarter", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.quarter = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByRemark", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.remark = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByStartTime", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.startTime = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByType", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.type = ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByTypeContaining", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.type like ?1"),
		@NamedQuery(name = "findRecordTransitionfeeByYear", query = "select myRecordTransitionfee from RecordTransitionfee myRecordTransitionfee where myRecordTransitionfee.year = ?1") })
@Table(catalog = "relocation", name = "record_transitionfee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "RecordTransitionfee")
public class RecordTransitionfee implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	/**
	 * ��ɷ�����
	 * 
	 */

	@Column(name = "type")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String type;
	/**
	 * �״ο�ʼʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "first_start_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar firstStartTime;
	/**
	 * �״ν�ֹʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "first_end_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar firstEndTime;
	/**
	 * �״ι�ɷ�
	 * 
	 */

	@Column(name = "first_fee", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal firstFee;
	/**
	 * ���ο�ʼʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar startTime;
	/**
	 * ���ν�ֹʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar endTime;
	/**
	 * ���
	 * 
	 */

	@Column(name = "year")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer year;
	/**
	 * ����
	 * 
	 */

	@Column(name = "quarter")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer quarter;
	/**
	 * ���ι�ȷ�
	 * 
	 */

	@Column(name = "fee", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal fee;
	
	
	@Column(name = "three_month_fee", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal threeMonthFee;
	
	
	@Column(name = "quarter_fee", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal quarterFee;
	
	@Column(name = "overdue_fee", scale = 2, precision = 8)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal overdueFee;
	
	public void setOverdueFee(BigDecimal overdueFee) {
		this.overdueFee = overdueFee;
	}
	public BigDecimal getOverdueFee() {
		return overdueFee;
	}
	
	/**
	 * �����˻�
	 * 
	 */

	@Column(name = "bank_account")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String bankAccount;
	/**
	 * ��ע
	 * 
	 */

	@Column(name = "remark")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String remark;
	/**
	 * �������
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdTime;
	/**
	 * ����ʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dealed_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dealedTime;
	/**
	 * 1��ʾ�Ѵ���
	 * 
	 */

	@Column(name = "is_dealed")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isDealed;
	/**
	 * ɾ��ʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar deletedTime;
	/**
	 * 1��ʾ��ɾ��
	 * 
	 */

	@Column(name = "is_deleted")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isDeleted;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "sid", referencedColumnName = "id") })
	@XmlTransient
	Record record;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "uid", referencedColumnName = "id") })
	@XmlTransient
	Cuser cuser;
	
	/**
	 */
	@OneToMany(mappedBy = "recordTransitionfee", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<common.domain.RecordTransitionfeeDtl> recordTransitionfeeDtls;
	
	public java.util.Set<common.domain.RecordTransitionfeeDtl> getRecordTransitionfeeDtls() {
		if (recordTransitionfeeDtls == null) {
			recordTransitionfeeDtls = new java.util.LinkedHashSet<common.domain.RecordTransitionfeeDtl>();
		}
		return recordTransitionfeeDtls;
	}
	public void setRecordTransitionfeeDtls(
			java.util.Set<common.domain.RecordTransitionfeeDtl> recordTransitionfeeDtls) {
		this.recordTransitionfeeDtls = recordTransitionfeeDtls;
	}
	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * ��ɷ�����
	 * 
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ��ɷ�����
	 * 
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * �״ο�ʼʱ��
	 * 
	 */
	public void setFirstStartTime(Calendar firstStartTime) {
		this.firstStartTime = firstStartTime;
	}

	/**
	 * �״ο�ʼʱ��
	 * 
	 */
	public Calendar getFirstStartTime() {
		return this.firstStartTime;
	}

	/**
	 * �״ν�ֹʱ��
	 * 
	 */
	public void setFirstEndTime(Calendar firstEndTime) {
		this.firstEndTime = firstEndTime;
	}

	/**
	 * �״ν�ֹʱ��
	 * 
	 */
	public Calendar getFirstEndTime() {
		return this.firstEndTime;
	}

	/**
	 * �״ι�ɷ�
	 * 
	 */
	public void setFirstFee(BigDecimal firstFee) {
		this.firstFee = firstFee;
	}

	/**
	 * �״ι�ɷ�
	 * 
	 */
	public BigDecimal getFirstFee() {
		return this.firstFee;
	}

	/**
	 * ���ο�ʼʱ��
	 * 
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 * ���ο�ʼʱ��
	 * 
	 */
	public Calendar getStartTime() {
		return this.startTime;
	}

	/**
	 * ���ν�ֹʱ��
	 * 
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	/**
	 * ���ν�ֹʱ��
	 * 
	 */
	public Calendar getEndTime() {
		return this.endTime;
	}

	/**
	 * ���
	 * 
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * ���
	 * 
	 */
	public Integer getYear() {
		return this.year;
	}

	/**
	 * ����
	 * 
	 */
	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	/**
	 * ����
	 * 
	 */
	public Integer getQuarter() {
		return this.quarter;
	}

	/**
	 * ���ι�ȷ�
	 * 
	 */
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	/**
	 * ���ι�ȷ�
	 * 
	 */
	public BigDecimal getFee() {
		return this.fee;
	}

	public BigDecimal getThreeMonthFee() {
		return threeMonthFee;
	}

	public void setThreeMonthFee(BigDecimal threeMonthFee) {
		this.threeMonthFee = threeMonthFee;
	}

	public BigDecimal getQuarterFee() {
		return quarterFee;
	}

	public void setQuarterFee(BigDecimal quarterFee) {
		this.quarterFee = quarterFee;
	}

	/**
	 * �����˻�
	 * 
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	/**
	 * �����˻�
	 * 
	 */
	public String getBankAccount() {
		return this.bankAccount;
	}

	/**
	 * ��ע
	 * 
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ��ע
	 * 
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * �������
	 * 
	 */
	public void setCreatedTime(Calendar createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * �������
	 * 
	 */
	public Calendar getCreatedTime() {
		return this.createdTime;
	}

	/**
	 * ����ʱ��
	 * 
	 */
	public void setDealedTime(Calendar dealedTime) {
		this.dealedTime = dealedTime;
	}

	/**
	 * ����ʱ��
	 * 
	 */
	public Calendar getDealedTime() {
		return this.dealedTime;
	}

	/**
	 * 1��ʾ�Ѵ���
	 * 
	 */
	public void setIsDealed(Boolean isDealed) {
		this.isDealed = isDealed;
	}

	/**
	 * 1��ʾ�Ѵ���
	 * 
	 */
	public Boolean getIsDealed() {
		return this.isDealed;
	}

	/**
	 * ɾ��ʱ��
	 * 
	 */
	public void setDeletedTime(Calendar deletedTime) {
		this.deletedTime = deletedTime;
	}

	/**
	 * ɾ��ʱ��
	 * 
	 */
	public Calendar getDeletedTime() {
		return this.deletedTime;
	}

	/**
	 * 1��ʾ��ɾ��
	 * 
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * 1��ʾ��ɾ��
	 * 
	 */
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	/**
	 */
	public void setRecord(Record record) {
		this.record = record;
	}

	/**
	 */
	@JsonIgnore
	public Record getRecord() {
		return record;
	}

	/**
	 */
	public void setCuser(Cuser cuser) {
		this.cuser = cuser;
	}

	/**
	 */
	@JsonIgnore
	public Cuser getCuser() {
		return cuser;
	}

	/**
	 */
	public RecordTransitionfee() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(RecordTransitionfee that) {
		setId(that.getId());
		setType(that.getType());
		setFirstStartTime(that.getFirstStartTime());
		setFirstEndTime(that.getFirstEndTime());
		setFirstFee(that.getFirstFee());
		setStartTime(that.getStartTime());
		setEndTime(that.getEndTime());
		setYear(that.getYear());
		setQuarter(that.getQuarter());
		setFee(that.getFee());
		setThreeMonthFee(that.getThreeMonthFee());
		setQuarterFee(that.getQuarterFee());
		setBankAccount(that.getBankAccount());
		setRemark(that.getRemark());
		setCreatedTime(that.getCreatedTime());
		setDealedTime(that.getDealedTime());
		setIsDealed(that.getIsDealed());
		setDeletedTime(that.getDeletedTime());
		setIsDeleted(that.getIsDeleted());
		setRecord(that.getRecord());
		setCuser(that.getCuser());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("type=[").append(type).append("] ");
		buffer.append("firstStartTime=[").append(firstStartTime).append("] ");
		buffer.append("firstEndTime=[").append(firstEndTime).append("] ");
		buffer.append("firstFee=[").append(firstFee).append("] ");
		buffer.append("startTime=[").append(startTime).append("] ");
		buffer.append("endTime=[").append(endTime).append("] ");
		buffer.append("year=[").append(year).append("] ");
		buffer.append("quarter=[").append(quarter).append("] ");
		buffer.append("fee=[").append(fee).append("] ");
		buffer.append("threeMonthFee=[").append(threeMonthFee).append("] ");
		buffer.append("quarterFee=[").append(quarterFee).append("] ");
		buffer.append("bankAccount=[").append(bankAccount).append("] ");
		buffer.append("remark=[").append(remark).append("] ");
		buffer.append("createdTime=[").append(createdTime).append("] ");
		buffer.append("dealedTime=[").append(dealedTime).append("] ");
		buffer.append("isDealed=[").append(isDealed).append("] ");
		buffer.append("deletedTime=[").append(deletedTime).append("] ");
		buffer.append("isDeleted=[").append(isDeleted).append("] ");

		return buffer.toString();
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
		if (!(obj instanceof RecordTransitionfee))
			return false;
		RecordTransitionfee equalCheck = (RecordTransitionfee) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
