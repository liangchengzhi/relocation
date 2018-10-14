package common.domain;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllAuthoritys", query = "select myAuthority from Authority myAuthority"),
		@NamedQuery(name = "findAuthorityByDeletedTime", query = "select myAuthority from Authority myAuthority where myAuthority.deletedTime = ?1"),
		@NamedQuery(name = "findAuthorityByDeletedUser", query = "select myAuthority from Authority myAuthority where myAuthority.deletedUser = ?1"),
		@NamedQuery(name = "findAuthorityByDeletedUserContaining", query = "select myAuthority from Authority myAuthority where myAuthority.deletedUser like ?1"),
		@NamedQuery(name = "findAuthorityByDescription", query = "select myAuthority from Authority myAuthority where myAuthority.description = ?1"),
		@NamedQuery(name = "findAuthorityByDescriptionContaining", query = "select myAuthority from Authority myAuthority where myAuthority.description like ?1"),
		@NamedQuery(name = "findAuthorityById", query = "select myAuthority from Authority myAuthority where myAuthority.id = ?1"),
		@NamedQuery(name = "findAuthorityByIsDeleted", query = "select myAuthority from Authority myAuthority where myAuthority.isDeleted = ?1"),
		@NamedQuery(name = "findAuthorityByMethod", query = "select myAuthority from Authority myAuthority where myAuthority.method = ?1"),
		@NamedQuery(name = "findAuthorityByName", query = "select myAuthority from Authority myAuthority where myAuthority.name = ?1"),
		@NamedQuery(name = "findAuthorityByNameContaining", query = "select myAuthority from Authority myAuthority where myAuthority.name like ?1"),
		@NamedQuery(name = "findAuthorityByPrimaryKey", query = "select myAuthority from Authority myAuthority where myAuthority.id = ?1") })
@Table(catalog = "relocation", name = "authority")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "Authority")
public class Authority implements Serializable {
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
	 * Ȩ�����
	 * 
	 */

	@Column(name = "name", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 * ���󷽷�
	 * 
	 */

	@Column(name = "method")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String method;
	/**
	 * ����
	 * 
	 */

	@Column(name = "description")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 * �Ƿ�ɾ��
	 * 
	 */

	@Column(name = "is_deleted")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isDeleted;
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
	 * ɾ���û�
	 * 
	 */

	@Column(name = "deleted_user")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String deletedUser;

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
	 * Ȩ�����
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Ȩ�����
	 * 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * ���󷽷�
	 * 
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * ���󷽷�
	 * 
	 */
	public String getMethod() {
		return this.method;
	}

	/**
	 * ����
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ����
	 * 
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * �Ƿ�ɾ��
	 * 
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * �Ƿ�ɾ��
	 * 
	 */
	public Boolean getIsDeleted() {
		return this.isDeleted;
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
	 * ɾ���û�
	 * 
	 */
	public void setDeletedUser(String deletedUser) {
		this.deletedUser = deletedUser;
	}

	/**
	 * ɾ���û�
	 * 
	 */
	public String getDeletedUser() {
		return this.deletedUser;
	}

	/**
	 */
	public Authority() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Authority that) {
		setId(that.getId());
		setName(that.getName());
		setMethod(that.getMethod());
		setDescription(that.getDescription());
		setIsDeleted(that.getIsDeleted());
		setDeletedTime(that.getDeletedTime());
		setDeletedUser(that.getDeletedUser());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("method=[").append(method).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("isDeleted=[").append(isDeleted).append("] ");
		buffer.append("deletedTime=[").append(deletedTime).append("] ");
		buffer.append("deletedUser=[").append(deletedUser).append("] ");

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
		if (!(obj instanceof Authority))
			return false;
		Authority equalCheck = (Authority) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
