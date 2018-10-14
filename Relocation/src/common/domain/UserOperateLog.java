package common.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 用户操作流水表
 * @author liangcz
 * @version 2016/10/03
 * @see UserOperateLogDAOImpl
 */
@Entity
@Table(catalog = "relocation", name = "user_operate_log")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "UserOperateLog")
public class UserOperateLog implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 编号
	 */
	@Column(name = "seq_no", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seqNo;
	
	/**
	 * 操作用户 
	 */
	@Column(name = "username")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	
	/**
	 * 操作
	 */
	@Column(name = "tran_name")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String tranName;
	
	/**
	 * 交易状态
	 */
	@Column(name = "status")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean status;
	
	/**
	 * 交易描述信息
	 */
	@Column(name = "msg")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String msg;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tran_time")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar tranTime;
	
	/**
	 * 备注
	 */
	@Column(name = "remark")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String remark;

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTranName() {
		return tranName;
	}

	public void setTranName(String tranName) {
		this.tranName = tranName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Calendar getTranTime() {
		return tranTime;
	}

	public void setTranTime(Calendar tranTime) {
		this.tranTime = tranTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((seqNo == null) ? 0 : seqNo.hashCode()));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Cuser))
			return false;
		UserOperateLog equalCheck = (UserOperateLog) obj;
		if ((seqNo == null && equalCheck.seqNo != null) || (seqNo != null && equalCheck.seqNo == null))
			return false;
		if (seqNo != null && !seqNo.equals(equalCheck.seqNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserOperateLog [seqNo=" + seqNo + ", username=" + username
				+ ", tranName=" + tranName + ", status=" + status + ", msg="
				+ msg + ", tranTime=" + tranTime + ", remark=" + remark + "]";
	}

}
