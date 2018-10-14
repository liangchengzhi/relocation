package common.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllProjects", query = "select myProject from Project myProject"),
		@NamedQuery(name = "findProjectById", query = "select myProject from Project myProject where myProject.id = ?1"),
		@NamedQuery(name = "findProjectByIsDeleted", query = "select myProject from Project myProject where myProject.isDeleted = ?1"),
		@NamedQuery(name = "findProjectByName", query = "select myProject from Project myProject where myProject.name = ?1"),
		@NamedQuery(name = "findProjectByNameContaining", query = "select myProject from Project myProject where myProject.name like ?1"),
		@NamedQuery(name = "findProjectByPrimaryKey", query = "select myProject from Project myProject where myProject.id = ?1") })
@Table(catalog = "relocation", name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "Project")
@XmlRootElement(namespace = "Relocation/common/domain")
public class Project implements Serializable {
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
	 * ��Ŀ���
	 * 
	 */

	@Column(name = "name")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
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
	@OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<common.domain.Record> records;

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
	 * ��Ŀ���
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��Ŀ���
	 * 
	 */
	public String getName() {
		return this.name;
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
	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	/**
	 */
	@JsonIgnore
	public Set<Record> getRecords() {
		if (records == null) {
			records = new java.util.LinkedHashSet<common.domain.Record>();
		}
		return records;
	}

	/**
	 */
	public Project() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Project that) {
		setId(that.getId());
		setName(that.getName());
		setIsDeleted(that.getIsDeleted());
		setRecords(new java.util.LinkedHashSet<common.domain.Record>(that.getRecords()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
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
		if (!(obj instanceof Project))
			return false;
		Project equalCheck = (Project) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
