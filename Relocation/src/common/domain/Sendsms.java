package common.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSendsmss", query = "select mySendsms from Sendsms mySendsms"),
		@NamedQuery(name = "findSendsmsByContent", query = "select mySendsms from Sendsms mySendsms where mySendsms.content = ?1"),
		@NamedQuery(name = "findSendsmsByContentContaining", query = "select mySendsms from Sendsms mySendsms where mySendsms.content like ?1"),
		@NamedQuery(name = "findSendsmsByCreatedtime", query = "select mySendsms from Sendsms mySendsms where mySendsms.createdtime = ?1"),
		@NamedQuery(name = "findSendsmsById", query = "select mySendsms from Sendsms mySendsms where mySendsms.id = ?1"),
		@NamedQuery(name = "findSendsmsByIp", query = "select mySendsms from Sendsms mySendsms where mySendsms.ip = ?1"),
		@NamedQuery(name = "findSendsmsByIpContaining", query = "select mySendsms from Sendsms mySendsms where mySendsms.ip like ?1"),
		@NamedQuery(name = "findSendsmsByPhone", query = "select mySendsms from Sendsms mySendsms where mySendsms.phone = ?1"),
		@NamedQuery(name = "findSendsmsByPhoneContaining", query = "select mySendsms from Sendsms mySendsms where mySendsms.phone like ?1"),
		@NamedQuery(name = "findSendsmsByPrimaryKey", query = "select mySendsms from Sendsms mySendsms where mySendsms.id = ?1"),
		@NamedQuery(name = "findSendsmsByRandcode", query = "select mySendsms from Sendsms mySendsms where mySendsms.randcode = ?1"),
		@NamedQuery(name = "findSendsmsByRandcodeContaining", query = "select mySendsms from Sendsms mySendsms where mySendsms.randcode like ?1") })
@Table(catalog = "relocation", name = "sendsms")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "Sendsms")
public class Sendsms implements Serializable {
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
	 */

	@Column(name = "phone", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;
	/**
	 */

	@Column(name = "randcode", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String randcode;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdtime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdtime;
	/**
	 */

	@Column(name = "content")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String content;
	/**
	 */

	@Column(name = "ip")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String ip;

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
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 */
	public void setRandcode(String randcode) {
		this.randcode = randcode;
	}

	/**
	 */
	public String getRandcode() {
		return this.randcode;
	}

	/**
	 */
	public void setCreatedtime(Calendar createdtime) {
		this.createdtime = createdtime;
	}

	/**
	 */
	public Calendar getCreatedtime() {
		return this.createdtime;
	}

	/**
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 */
	public Sendsms() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Sendsms that) {
		setId(that.getId());
		setPhone(that.getPhone());
		setRandcode(that.getRandcode());
		setCreatedtime(that.getCreatedtime());
		setContent(that.getContent());
		setIp(that.getIp());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("randcode=[").append(randcode).append("] ");
		buffer.append("createdtime=[").append(createdtime).append("] ");
		buffer.append("content=[").append(content).append("] ");
		buffer.append("ip=[").append(ip).append("] ");

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
		if (!(obj instanceof Sendsms))
			return false;
		Sendsms equalCheck = (Sendsms) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
