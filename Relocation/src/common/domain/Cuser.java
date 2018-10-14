package common.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
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
		@NamedQuery(name = "findAllCusers", query = "select myCuser from Cuser myCuser"),
		@NamedQuery(name = "findCuserByAddress", query = "select myCuser from Cuser myCuser where myCuser.address = ?1"),
		@NamedQuery(name = "findCuserByAddressContaining", query = "select myCuser from Cuser myCuser where myCuser.address like ?1"),
		@NamedQuery(name = "findCuserByCheckStatus", query = "select myCuser from Cuser myCuser where myCuser.checkStatus = ?1"),
		@NamedQuery(name = "findCuserByCreatedtime", query = "select myCuser from Cuser myCuser where myCuser.createdtime = ?1"),
		@NamedQuery(name = "findCuserByDepartment", query = "select myCuser from Cuser myCuser where myCuser.department = ?1"),
		@NamedQuery(name = "findCuserByDepartmentContaining", query = "select myCuser from Cuser myCuser where myCuser.department like ?1"),
		@NamedQuery(name = "findCuserByEmail", query = "select myCuser from Cuser myCuser where myCuser.email = ?1"),
		@NamedQuery(name = "findCuserByEmailContaining", query = "select myCuser from Cuser myCuser where myCuser.email like ?1"),
		@NamedQuery(name = "findCuserByGender", query = "select myCuser from Cuser myCuser where myCuser.gender = ?1"),
		@NamedQuery(name = "findCuserById", query = "select myCuser from Cuser myCuser where myCuser.id = ?1"),
		@NamedQuery(name = "findCuserByIsDeleted", query = "select myCuser from Cuser myCuser where myCuser.isDeleted = ?1"),
		@NamedQuery(name = "findCuserByLoginip", query = "select myCuser from Cuser myCuser where myCuser.loginip = ?1"),
		@NamedQuery(name = "findCuserByLoginipContaining", query = "select myCuser from Cuser myCuser where myCuser.loginip like ?1"),
		@NamedQuery(name = "findCuserByLogintime", query = "select myCuser from Cuser myCuser where myCuser.logintime = ?1"),
		@NamedQuery(name = "findCuserByLogintoken", query = "select myCuser from Cuser myCuser where myCuser.logintoken = ?1"),
		@NamedQuery(name = "findCuserByLogintokenContaining", query = "select myCuser from Cuser myCuser where myCuser.logintoken like ?1"),
		@NamedQuery(name = "findCuserByNickname", query = "select myCuser from Cuser myCuser where myCuser.nickname = ?1"),
		@NamedQuery(name = "findCuserByNicknameContaining", query = "select myCuser from Cuser myCuser where myCuser.nickname like ?1"),
		@NamedQuery(name = "findCuserByPassword", query = "select myCuser from Cuser myCuser where myCuser.password = ?1"),
		@NamedQuery(name = "findCuserByPasswordContaining", query = "select myCuser from Cuser myCuser where myCuser.password like ?1"),
		@NamedQuery(name = "findCuserByPhone", query = "select myCuser from Cuser myCuser where myCuser.phone = ?1"),
		@NamedQuery(name = "findCuserByPhoneContaining", query = "select myCuser from Cuser myCuser where myCuser.phone like ?1"),
		@NamedQuery(name = "findCuserByPhoto", query = "select myCuser from Cuser myCuser where myCuser.photo = ?1"),
		@NamedQuery(name = "findCuserByPhotoContaining", query = "select myCuser from Cuser myCuser where myCuser.photo like ?1"),
		@NamedQuery(name = "findCuserByPrimaryKey", query = "select myCuser from Cuser myCuser where myCuser.id = ?1"),
		@NamedQuery(name = "findCuserByQxdm", query = "select myCuser from Cuser myCuser where myCuser.qxdm = ?1"),
		@NamedQuery(name = "findCuserByQxdmContaining", query = "select myCuser from Cuser myCuser where myCuser.qxdm like ?1"),
		@NamedQuery(name = "findCuserByQxmc", query = "select myCuser from Cuser myCuser where myCuser.qxmc = ?1"),
		@NamedQuery(name = "findCuserByQxmcContaining", query = "select myCuser from Cuser myCuser where myCuser.qxmc like ?1"),
		@NamedQuery(name = "findCuserByRegip", query = "select myCuser from Cuser myCuser where myCuser.regip = ?1"),
		@NamedQuery(name = "findCuserByRegipContaining", query = "select myCuser from Cuser myCuser where myCuser.regip like ?1"),
		@NamedQuery(name = "findCuserBySalt", query = "select myCuser from Cuser myCuser where myCuser.salt = ?1"),
		@NamedQuery(name = "findCuserBySaltContaining", query = "select myCuser from Cuser myCuser where myCuser.salt like ?1"),
		@NamedQuery(name = "findCuserByUsername", query = "select myCuser from Cuser myCuser where myCuser.username = ?1"),
		@NamedQuery(name = "findCuserByUsernameContaining", query = "select myCuser from Cuser myCuser where myCuser.username like ?1"),
		@NamedQuery(name = "findCuserByUsertype", query = "select myCuser from Cuser myCuser where myCuser.usertype = ?1") })
@Table(catalog = "relocation", name = "cuser")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Relocation/common/domain", name = "Cuser")
@XmlRootElement(namespace = "Relocation/common/domain")
public class Cuser implements Serializable {
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
	 * �û���
	 * 
	 */

	@Column(name = "username")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	
	@Column(name = "authority")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authority;
	@Column(name = "authority_group")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String authorityGroup;
	/**
	 * ����
	 * 
	 */

	@Column(name = "password")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 * ��������(saltΪinit��ʾ��ʼ����)
	 * 
	 */

	@Column(name = "salt")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String salt;
	/**
	 * �ֻ��
	 * 
	 */

	@Column(name = "phone")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;
	/**
	 * �����ַ
	 * 
	 */

	@Column(name = "email")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 * �û����ͣ�10���ܡ�9ƽ̨����Ա��8Ǩ��λ��0��ͨ�û���
	 * 
	 */

	@Column(name = "usertype")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer usertype;
	/**
	 * �Ա�1�У�0Ů��null���ܣ�
	 * 
	 */

	@Column(name = "gender")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean gender;
	/**
	 * �ǳƣ���ͨ�û��ǳƣ��̼ҵ���������Աְ��
	 * 
	 */

	@Column(name = "nickname")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String nickname;
	/**
	 * ��ַ
	 * 
	 */

	@Column(name = "address")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String address;
	/**
	 * ��Ƭ��ͷ��Logo��
	 * 
	 */

	@Column(name = "photo")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String photo;
	/**
	 * �������
	 * 
	 */

	@Column(name = "qxdm")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String qxdm;
	/**
	 * �������
	 * 
	 */

	@Column(name = "qxmc")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String qxmc;
	/**
	 * ������λ������
	 * 
	 */

	@Column(name = "department")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String department;
	/**
	 * ����¼ʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "logintime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar logintime;
	/**
	 * ����¼IP
	 * 
	 */

	@Column(name = "loginip")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginip;
	/**
	 * ��¼����
	 * 
	 */

	@Column(name = "logintoken")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String logintoken;
	/**
	 * ��Ч״̬λ
	 * 
	 */

	@Column(name = "check_status")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean checkStatus;
	/**
	 * ע��IP
	 * 
	 */

	@Column(name = "regip")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String regip;
	/**
	 * ����ʱ��
	 * 
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdtime")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdtime;
	/**
	 * �Ƿ�ɾ��1��ɾ��
	 * 
	 */

	@Column(name = "is_deleted")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isDeleted;

	/**
	 */
	@OneToMany(mappedBy = "cuser", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<common.domain.RecordTransitionfee> recordTransitionfees;
	/**
	 */
	@OneToMany(mappedBy = "cuser", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
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
	 * �û���
	 * 
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * �û���
	 * 
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * ����
	 * 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ����
	 * 
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * ��������(saltΪinit��ʾ��ʼ����)
	 * 
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * ��������(saltΪinit��ʾ��ʼ����)
	 * 
	 */
	public String getSalt() {
		return this.salt;
	}

	/**
	 * �ֻ��
	 * 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * �ֻ��
	 * 
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * �����ַ
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * �����ַ
	 * 
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * �û����ͣ�10���ܡ�9ƽ̨����Ա��8Ǩ��λ��0��ͨ�û���
	 * 
	 */
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	/**
	 * �û����ͣ�10���ܡ�9ƽ̨����Ա��8Ǩ��λ��0��ͨ�û���
	 * 
	 */
	public Integer getUsertype() {
		return this.usertype;
	}

	/**
	 * �Ա�1�У�0Ů��null���ܣ�
	 * 
	 */
	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	/**
	 * �Ա�1�У�0Ů��null���ܣ�
	 * 
	 */
	public Boolean getGender() {
		return this.gender;
	}

	/**
	 * �ǳƣ���ͨ�û��ǳƣ��̼ҵ���������Աְ��
	 * 
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * �ǳƣ���ͨ�û��ǳƣ��̼ҵ���������Աְ��
	 * 
	 */
	public String getNickname() {
		return this.nickname;
	}

	/**
	 * ��ַ
	 * 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * ��ַ
	 * 
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * ��Ƭ��ͷ��Logo��
	 * 
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * ��Ƭ��ͷ��Logo��
	 * 
	 */
	public String getPhoto() {
		return this.photo;
	}

	/**
	 * �������
	 * 
	 */
	public void setQxdm(String qxdm) {
		this.qxdm = qxdm;
	}

	/**
	 * �������
	 * 
	 */
	public String getQxdm() {
		return this.qxdm;
	}

	/**
	 * �������
	 * 
	 */
	public void setQxmc(String qxmc) {
		this.qxmc = qxmc;
	}

	/**
	 * �������
	 * 
	 */
	public String getQxmc() {
		return this.qxmc;
	}

	/**
	 * ������λ������
	 * 
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * ������λ������
	 * 
	 */
	public String getDepartment() {
		return this.department;
	}

	/**
	 * ����¼ʱ��
	 * 
	 */
	public void setLogintime(Calendar logintime) {
		this.logintime = logintime;
	}

	/**
	 * ����¼ʱ��
	 * 
	 */
	public Calendar getLogintime() {
		return this.logintime;
	}

	/**
	 * ����¼IP
	 * 
	 */
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	/**
	 * ����¼IP
	 * 
	 */
	public String getLoginip() {
		return this.loginip;
	}

	/**
	 * ��¼����
	 * 
	 */
	public void setLogintoken(String logintoken) {
		this.logintoken = logintoken;
	}

	/**
	 * ��¼����
	 * 
	 */
	public String getLogintoken() {
		return this.logintoken;
	}

	/**
	 * ��Ч״̬λ
	 * 
	 */
	public void setCheckStatus(Boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	/**
	 * ��Ч״̬λ
	 * 
	 */
	public Boolean getCheckStatus() {
		return this.checkStatus;
	}

	/**
	 * ע��IP
	 * 
	 */
	public void setRegip(String regip) {
		this.regip = regip;
	}

	/**
	 * ע��IP
	 * 
	 */
	public String getRegip() {
		return this.regip;
	}

	/**
	 * ����ʱ��
	 * 
	 */
	public void setCreatedtime(Calendar createdtime) {
		this.createdtime = createdtime;
	}

	/**
	 * ����ʱ��
	 * 
	 */
	public Calendar getCreatedtime() {
		return this.createdtime;
	}

	/**
	 * �Ƿ�ɾ��1��ɾ��
	 * 
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * �Ƿ�ɾ��1��ɾ��
	 * 
	 */
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setAuthorityGroup(String authorityGroup) {
		this.authorityGroup = authorityGroup;
	}
	public String getAuthorityGroup() {
		return authorityGroup;
	}

	/**
	 */
	public void setRecordTransitionfees(Set<RecordTransitionfee> recordTransitionfees) {
		this.recordTransitionfees = recordTransitionfees;
	}

	/**
	 */
	@JsonIgnore
	public Set<RecordTransitionfee> getRecordTransitionfees() {
		if (recordTransitionfees == null) {
			recordTransitionfees = new java.util.LinkedHashSet<common.domain.RecordTransitionfee>();
		}
		return recordTransitionfees;
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
	public Cuser() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Cuser that) {
		setId(that.getId());
		setUsername(that.getUsername());
		setPassword(that.getPassword());
		setSalt(that.getSalt());
		setPhone(that.getPhone());
		setEmail(that.getEmail());
		setUsertype(that.getUsertype());
		setGender(that.getGender());
		setNickname(that.getNickname());
		setAddress(that.getAddress());
		setPhoto(that.getPhoto());
		setQxdm(that.getQxdm());
		setQxmc(that.getQxmc());
		setDepartment(that.getDepartment());
		setLogintime(that.getLogintime());
		setLoginip(that.getLoginip());
		setLogintoken(that.getLogintoken());
		setCheckStatus(that.getCheckStatus());
		setRegip(that.getRegip());
		setCreatedtime(that.getCreatedtime());
		setIsDeleted(that.getIsDeleted());
		setRecordTransitionfees(new java.util.LinkedHashSet<common.domain.RecordTransitionfee>(that.getRecordTransitionfees()));
		setRecords(new java.util.LinkedHashSet<common.domain.Record>(that.getRecords()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("username=[").append(username).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("salt=[").append(salt).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("usertype=[").append(usertype).append("] ");
		buffer.append("gender=[").append(gender).append("] ");
		buffer.append("nickname=[").append(nickname).append("] ");
		buffer.append("address=[").append(address).append("] ");
		buffer.append("photo=[").append(photo).append("] ");
		buffer.append("qxdm=[").append(qxdm).append("] ");
		buffer.append("qxmc=[").append(qxmc).append("] ");
		buffer.append("department=[").append(department).append("] ");
		buffer.append("logintime=[").append(logintime).append("] ");
		buffer.append("loginip=[").append(loginip).append("] ");
		buffer.append("logintoken=[").append(logintoken).append("] ");
		buffer.append("checkStatus=[").append(checkStatus).append("] ");
		buffer.append("regip=[").append(regip).append("] ");
		buffer.append("createdtime=[").append(createdtime).append("] ");
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
		if (!(obj instanceof Cuser))
			return false;
		Cuser equalCheck = (Cuser) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
