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
		@NamedQuery(name = "findAllQxdmks", query = "select myQxdmk from Qxdmk myQxdmk"),
		@NamedQuery(name = "findQxdmkByPrimaryKey", query = "select myQxdmk from Qxdmk myQxdmk where myQxdmk.qxdm = ?1"),
		@NamedQuery(name = "findQxdmkByQxdm", query = "select myQxdmk from Qxdmk myQxdmk where myQxdmk.qxdm = ?1"),
		@NamedQuery(name = "findQxdmkByQxdmContaining", query = "select myQxdmk from Qxdmk myQxdmk where myQxdmk.qxdm like ?1"),
		@NamedQuery(name = "findQxdmkByQxmc", query = "select myQxdmk from Qxdmk myQxdmk where myQxdmk.qxmc = ?1"),
		@NamedQuery(name = "findQxdmkByQxmcContaining", query = "select myQxdmk from Qxdmk myQxdmk where myQxdmk.qxmc like ?1") })
@Table(catalog = "relocation", name = "qxdmk")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "Qxdmk")
public class Qxdmk implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "qxdm", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	String qxdm;
	/**
	 */

	@Column(name = "qxmc")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String qxmc;

	/**
	 */
	public void setQxdm(String qxdm) {
		this.qxdm = qxdm;
	}

	/**
	 */
	public String getQxdm() {
		return this.qxdm;
	}

	/**
	 */
	public void setQxmc(String qxmc) {
		this.qxmc = qxmc;
	}

	/**
	 */
	public String getQxmc() {
		return this.qxmc;
	}

	/**
	 */
	public Qxdmk() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Qxdmk that) {
		setQxdm(that.getQxdm());
		setQxmc(that.getQxmc());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("qxdm=[").append(qxdm).append("] ");
		buffer.append("qxmc=[").append(qxmc).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((qxdm == null) ? 0 : qxdm.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Qxdmk))
			return false;
		Qxdmk equalCheck = (Qxdmk) obj;
		if ((qxdm == null && equalCheck.qxdm != null) || (qxdm != null && equalCheck.qxdm == null))
			return false;
		if (qxdm != null && !qxdm.equals(equalCheck.qxdm))
			return false;
		return true;
	}
}
