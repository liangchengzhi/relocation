package common.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSysconfigs", query = "select mySysconfig from Sysconfig mySysconfig"),
		@NamedQuery(name = "findSysconfigByDescription", query = "select mySysconfig from Sysconfig mySysconfig where mySysconfig.description = ?1"),
		@NamedQuery(name = "findSysconfigByDescriptionContaining", query = "select mySysconfig from Sysconfig mySysconfig where mySysconfig.description like ?1"),
		@NamedQuery(name = "findSysconfigById", query = "select mySysconfig from Sysconfig mySysconfig where mySysconfig.id = ?1"),
		@NamedQuery(name = "findSysconfigByIdContaining", query = "select mySysconfig from Sysconfig mySysconfig where mySysconfig.id like ?1"),
		@NamedQuery(name = "findSysconfigByPrimaryKey", query = "select mySysconfig from Sysconfig mySysconfig where mySysconfig.id = ?1"),
		@NamedQuery(name = "findSysconfigByValue", query = "select mySysconfig from Sysconfig mySysconfig where mySysconfig.value = ?1") })
@Table(catalog = "relocation", name = "sysconfig")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "Sysconfig")
public class Sysconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 键
	 * 
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String id;
	/**
	 * 值
	 * 
	 */

	@Column(name = "value")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String value;
	/**
	 * 配置说明
	 * 
	 */

	@Column(name = "description")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;

	/**
	 * 键
	 * 
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 键
	 * 
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 值
	 * 
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 值
	 * 
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * 配置说明
	 * 
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 配置说明
	 * 
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 */
	public Sysconfig() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Sysconfig that) {
		setId(that.getId());
		setValue(that.getValue());
		setDescription(that.getDescription());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("value=[").append(value).append("] ");
		buffer.append("description=[").append(description).append("] ");

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
		if (!(obj instanceof Sysconfig))
			return false;
		Sysconfig equalCheck = (Sysconfig) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
