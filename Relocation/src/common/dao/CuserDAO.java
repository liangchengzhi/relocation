package common.dao;

import common.domain.Cuser;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Cuser entities.
 * 
 */
public interface CuserDAO extends JpaDao<Cuser> {

	/**
	 * JPQL Query - findCuserByQxdmContaining
	 *
	 */
	public Set<Cuser> findCuserByQxdmContaining(String qxdm) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByQxdmContaining
	 *
	 */
	public Set<Cuser> findCuserByQxdmContaining(String qxdm, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPrimaryKey
	 *
	 */
	public Cuser findCuserByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPrimaryKey
	 *
	 */
	public Cuser findCuserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhotoContaining
	 *
	 */
	public Set<Cuser> findCuserByPhotoContaining(String photo) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhotoContaining
	 *
	 */
	public Set<Cuser> findCuserByPhotoContaining(String photo, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByUsertype
	 *
	 */
	public Set<Cuser> findCuserByUsertype(Integer usertype) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByUsertype
	 *
	 */
	public Set<Cuser> findCuserByUsertype(Integer usertype, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByQxmcContaining
	 *
	 */
	public Set<Cuser> findCuserByQxmcContaining(String qxmc) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByQxmcContaining
	 *
	 */
	public Set<Cuser> findCuserByQxmcContaining(String qxmc, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByCheckStatus
	 *
	 */
	public Set<Cuser> findCuserByCheckStatus(Boolean checkStatus) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByCheckStatus
	 *
	 */
	public Set<Cuser> findCuserByCheckStatus(Boolean checkStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByRegipContaining
	 *
	 */
	public Set<Cuser> findCuserByRegipContaining(String regip) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByRegipContaining
	 *
	 */
	public Set<Cuser> findCuserByRegipContaining(String regip, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByCreatedtime
	 *
	 */
	public Set<Cuser> findCuserByCreatedtime(java.util.Calendar createdtime) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByCreatedtime
	 *
	 */
	public Set<Cuser> findCuserByCreatedtime(Calendar createdtime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserBySalt
	 *
	 */
	public Set<Cuser> findCuserBySalt(String salt) throws DataAccessException;

	/**
	 * JPQL Query - findCuserBySalt
	 *
	 */
	public Set<Cuser> findCuserBySalt(String salt, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserBySaltContaining
	 *
	 */
	public Set<Cuser> findCuserBySaltContaining(String salt_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserBySaltContaining
	 *
	 */
	public Set<Cuser> findCuserBySaltContaining(String salt_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByQxdm
	 *
	 */
	public Set<Cuser> findCuserByQxdm(String qxdm_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByQxdm
	 *
	 */
	public Set<Cuser> findCuserByQxdm(String qxdm_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLoginipContaining
	 *
	 */
	public Set<Cuser> findCuserByLoginipContaining(String loginip) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLoginipContaining
	 *
	 */
	public Set<Cuser> findCuserByLoginipContaining(String loginip, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByIsDeleted
	 *
	 */
	public Set<Cuser> findCuserByIsDeleted(Boolean isDeleted) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByIsDeleted
	 *
	 */
	public Set<Cuser> findCuserByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhoneContaining
	 *
	 */
	public Set<Cuser> findCuserByPhoneContaining(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhoneContaining
	 *
	 */
	public Set<Cuser> findCuserByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByNicknameContaining
	 *
	 */
	public Set<Cuser> findCuserByNicknameContaining(String nickname) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByNicknameContaining
	 *
	 */
	public Set<Cuser> findCuserByNicknameContaining(String nickname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLogintokenContaining
	 *
	 */
	public Set<Cuser> findCuserByLogintokenContaining(String logintoken) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLogintokenContaining
	 *
	 */
	public Set<Cuser> findCuserByLogintokenContaining(String logintoken, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhoto
	 *
	 */
	public Set<Cuser> findCuserByPhoto(String photo_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhoto
	 *
	 */
	public Set<Cuser> findCuserByPhoto(String photo_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLogintime
	 *
	 */
	public Set<Cuser> findCuserByLogintime(java.util.Calendar logintime) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLogintime
	 *
	 */
	public Set<Cuser> findCuserByLogintime(Calendar logintime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLoginip
	 *
	 */
	public Set<Cuser> findCuserByLoginip(String loginip_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLoginip
	 *
	 */
	public Set<Cuser> findCuserByLoginip(String loginip_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByNickname
	 *
	 */
	public Set<Cuser> findCuserByNickname(String nickname_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByNickname
	 *
	 */
	public Set<Cuser> findCuserByNickname(String nickname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByUsernameContaining
	 *
	 */
	public Set<Cuser> findCuserByUsernameContaining(String username) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByUsernameContaining
	 *
	 */
	public Set<Cuser> findCuserByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllCusers
	 *
	 */
	public Set<Cuser> findAllCusers() throws DataAccessException;

	/**
	 * JPQL Query - findAllCusers
	 *
	 */
	public Set<Cuser> findAllCusers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByEmailContaining
	 *
	 */
	public Set<Cuser> findCuserByEmailContaining(String email) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByEmailContaining
	 *
	 */
	public Set<Cuser> findCuserByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPassword
	 *
	 */
	public Set<Cuser> findCuserByPassword(String password) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPassword
	 *
	 */
	public Set<Cuser> findCuserByPassword(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByAddress
	 *
	 */
	public Set<Cuser> findCuserByAddress(String address) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByAddress
	 *
	 */
	public Set<Cuser> findCuserByAddress(String address, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByEmail
	 *
	 */
	public Set<Cuser> findCuserByEmail(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByEmail
	 *
	 */
	public Set<Cuser> findCuserByEmail(String email_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByAddressContaining
	 *
	 */
	public Set<Cuser> findCuserByAddressContaining(String address_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByAddressContaining
	 *
	 */
	public Set<Cuser> findCuserByAddressContaining(String address_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByDepartmentContaining
	 *
	 */
	public Set<Cuser> findCuserByDepartmentContaining(String department) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByDepartmentContaining
	 *
	 */
	public Set<Cuser> findCuserByDepartmentContaining(String department, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhone
	 *
	 */
	public Set<Cuser> findCuserByPhone(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPhone
	 *
	 */
	public Set<Cuser> findCuserByPhone(String phone_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLogintoken
	 *
	 */
	public Set<Cuser> findCuserByLogintoken(String logintoken_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByLogintoken
	 *
	 */
	public Set<Cuser> findCuserByLogintoken(String logintoken_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByRegip
	 *
	 */
	public Set<Cuser> findCuserByRegip(String regip_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByRegip
	 *
	 */
	public Set<Cuser> findCuserByRegip(String regip_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByDepartment
	 *
	 */
	public Set<Cuser> findCuserByDepartment(String department_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByDepartment
	 *
	 */
	public Set<Cuser> findCuserByDepartment(String department_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserById
	 *
	 */
	public Cuser findCuserById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserById
	 *
	 */
	public Cuser findCuserById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByUsername
	 *
	 */
	public Set<Cuser> findCuserByUsername(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByUsername
	 *
	 */
	public Set<Cuser> findCuserByUsername(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByGender
	 *
	 */
	public Set<Cuser> findCuserByGender(Boolean gender) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByGender
	 *
	 */
	public Set<Cuser> findCuserByGender(Boolean gender, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByQxmc
	 *
	 */
	public Set<Cuser> findCuserByQxmc(String qxmc_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByQxmc
	 *
	 */
	public Set<Cuser> findCuserByQxmc(String qxmc_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPasswordContaining
	 *
	 */
	public Set<Cuser> findCuserByPasswordContaining(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findCuserByPasswordContaining
	 *
	 */
	public Set<Cuser> findCuserByPasswordContaining(String password_1, int startResult, int maxRows) throws DataAccessException;

}