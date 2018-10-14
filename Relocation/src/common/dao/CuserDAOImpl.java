package common.dao;

import common.domain.Cuser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Cuser entities.
 * 
 */
@Repository("cuserDAO")
public class CuserDAOImpl extends AbstractJpaDao<Cuser> implements CuserDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Cuser.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new CuserDAOImpl
	 *
	 */
	public CuserDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findCuserByQxdmContaining
	 *
	 */
	public Set<Cuser> findCuserByQxdmContaining(String qxdm) throws DataAccessException {

		return findCuserByQxdmContaining(qxdm, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByQxdmContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByQxdmContaining(String qxdm, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByQxdmContaining", startResult, maxRows, qxdm);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByPrimaryKey
	 *
	 */
	public Cuser findCuserByPrimaryKey(Integer id) throws DataAccessException {

		return findCuserByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByPrimaryKey
	 *
	 */

	public Cuser findCuserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCuserByPrimaryKey", startResult, maxRows, id);
			return (common.domain.Cuser) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCuserByPhotoContaining
	 *
	 */
	public Set<Cuser> findCuserByPhotoContaining(String photo) throws DataAccessException {

		return findCuserByPhotoContaining(photo, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByPhotoContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByPhotoContaining(String photo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByPhotoContaining", startResult, maxRows, photo);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByUsertype
	 *
	 */
	public Set<Cuser> findCuserByUsertype(Integer usertype) throws DataAccessException {

		return findCuserByUsertype(usertype, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByUsertype
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByUsertype(Integer usertype, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByUsertype", startResult, maxRows, usertype);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByQxmcContaining
	 *
	 */
	public Set<Cuser> findCuserByQxmcContaining(String qxmc) throws DataAccessException {

		return findCuserByQxmcContaining(qxmc, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByQxmcContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByQxmcContaining(String qxmc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByQxmcContaining", startResult, maxRows, qxmc);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByCheckStatus
	 *
	 */
	public Set<Cuser> findCuserByCheckStatus(Boolean checkStatus) throws DataAccessException {

		return findCuserByCheckStatus(checkStatus, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByCheckStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByCheckStatus(Boolean checkStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByCheckStatus", startResult, maxRows, checkStatus);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByRegipContaining
	 *
	 */
	public Set<Cuser> findCuserByRegipContaining(String regip) throws DataAccessException {

		return findCuserByRegipContaining(regip, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByRegipContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByRegipContaining(String regip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByRegipContaining", startResult, maxRows, regip);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByCreatedtime
	 *
	 */
	public Set<Cuser> findCuserByCreatedtime(java.util.Calendar createdtime) throws DataAccessException {

		return findCuserByCreatedtime(createdtime, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByCreatedtime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByCreatedtime(java.util.Calendar createdtime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByCreatedtime", startResult, maxRows, createdtime);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserBySalt
	 *
	 */
	public Set<Cuser> findCuserBySalt(String salt) throws DataAccessException {

		return findCuserBySalt(salt, -1, -1);
	}

	/**
	 * JPQL Query - findCuserBySalt
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserBySalt(String salt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserBySalt", startResult, maxRows, salt);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserBySaltContaining
	 *
	 */
	public Set<Cuser> findCuserBySaltContaining(String salt) throws DataAccessException {

		return findCuserBySaltContaining(salt, -1, -1);
	}

	/**
	 * JPQL Query - findCuserBySaltContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserBySaltContaining(String salt, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserBySaltContaining", startResult, maxRows, salt);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByQxdm
	 *
	 */
	public Set<Cuser> findCuserByQxdm(String qxdm) throws DataAccessException {

		return findCuserByQxdm(qxdm, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByQxdm
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByQxdm(String qxdm, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByQxdm", startResult, maxRows, qxdm);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByLoginipContaining
	 *
	 */
	public Set<Cuser> findCuserByLoginipContaining(String loginip) throws DataAccessException {

		return findCuserByLoginipContaining(loginip, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByLoginipContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByLoginipContaining(String loginip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByLoginipContaining", startResult, maxRows, loginip);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByIsDeleted
	 *
	 */
	public Set<Cuser> findCuserByIsDeleted(Boolean isDeleted) throws DataAccessException {

		return findCuserByIsDeleted(isDeleted, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByIsDeleted
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByIsDeleted", startResult, maxRows, isDeleted);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByPhoneContaining
	 *
	 */
	public Set<Cuser> findCuserByPhoneContaining(String phone) throws DataAccessException {

		return findCuserByPhoneContaining(phone, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByNicknameContaining
	 *
	 */
	public Set<Cuser> findCuserByNicknameContaining(String nickname) throws DataAccessException {

		return findCuserByNicknameContaining(nickname, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByNicknameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByNicknameContaining(String nickname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByNicknameContaining", startResult, maxRows, nickname);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByLogintokenContaining
	 *
	 */
	public Set<Cuser> findCuserByLogintokenContaining(String logintoken) throws DataAccessException {

		return findCuserByLogintokenContaining(logintoken, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByLogintokenContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByLogintokenContaining(String logintoken, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByLogintokenContaining", startResult, maxRows, logintoken);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByPhoto
	 *
	 */
	public Set<Cuser> findCuserByPhoto(String photo) throws DataAccessException {

		return findCuserByPhoto(photo, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByPhoto
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByPhoto(String photo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByPhoto", startResult, maxRows, photo);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByLogintime
	 *
	 */
	public Set<Cuser> findCuserByLogintime(java.util.Calendar logintime) throws DataAccessException {

		return findCuserByLogintime(logintime, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByLogintime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByLogintime(java.util.Calendar logintime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByLogintime", startResult, maxRows, logintime);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByLoginip
	 *
	 */
	public Set<Cuser> findCuserByLoginip(String loginip) throws DataAccessException {

		return findCuserByLoginip(loginip, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByLoginip
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByLoginip(String loginip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByLoginip", startResult, maxRows, loginip);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByNickname
	 *
	 */
	public Set<Cuser> findCuserByNickname(String nickname) throws DataAccessException {

		return findCuserByNickname(nickname, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByNickname
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByNickname(String nickname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByNickname", startResult, maxRows, nickname);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByUsernameContaining
	 *
	 */
	public Set<Cuser> findCuserByUsernameContaining(String username) throws DataAccessException {

		return findCuserByUsernameContaining(username, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByUsernameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByUsernameContaining", startResult, maxRows, username);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllCusers
	 *
	 */
	public Set<Cuser> findAllCusers() throws DataAccessException {

		return findAllCusers(-1, -1);
	}

	/**
	 * JPQL Query - findAllCusers
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findAllCusers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllCusers", startResult, maxRows);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByEmailContaining
	 *
	 */
	public Set<Cuser> findCuserByEmailContaining(String email) throws DataAccessException {

		return findCuserByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByPassword
	 *
	 */
	public Set<Cuser> findCuserByPassword(String password) throws DataAccessException {

		return findCuserByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByPassword", startResult, maxRows, password);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByAddress
	 *
	 */
	public Set<Cuser> findCuserByAddress(String address) throws DataAccessException {

		return findCuserByAddress(address, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByAddress(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByAddress", startResult, maxRows, address);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByEmail
	 *
	 */
	public Set<Cuser> findCuserByEmail(String email) throws DataAccessException {

		return findCuserByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByEmail", startResult, maxRows, email);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByAddressContaining
	 *
	 */
	public Set<Cuser> findCuserByAddressContaining(String address) throws DataAccessException {

		return findCuserByAddressContaining(address, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByAddressContaining(String address, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByAddressContaining", startResult, maxRows, address);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByDepartmentContaining
	 *
	 */
	public Set<Cuser> findCuserByDepartmentContaining(String department) throws DataAccessException {

		return findCuserByDepartmentContaining(department, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByDepartmentContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByDepartmentContaining(String department, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByDepartmentContaining", startResult, maxRows, department);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByPhone
	 *
	 */
	public Set<Cuser> findCuserByPhone(String phone) throws DataAccessException {

		return findCuserByPhone(phone, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByLogintoken
	 *
	 */
	public Set<Cuser> findCuserByLogintoken(String logintoken) throws DataAccessException {

		return findCuserByLogintoken(logintoken, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByLogintoken
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByLogintoken(String logintoken, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByLogintoken", startResult, maxRows, logintoken);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByRegip
	 *
	 */
	public Set<Cuser> findCuserByRegip(String regip) throws DataAccessException {

		return findCuserByRegip(regip, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByRegip
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByRegip(String regip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByRegip", startResult, maxRows, regip);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByDepartment
	 *
	 */
	public Set<Cuser> findCuserByDepartment(String department) throws DataAccessException {

		return findCuserByDepartment(department, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByDepartment
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByDepartment(String department, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByDepartment", startResult, maxRows, department);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserById
	 *
	 */
	public Cuser findCuserById(Integer id) throws DataAccessException {

		return findCuserById(id, -1, -1);
	}

	/**
	 * JPQL Query - findCuserById
	 *
	 */

	public Cuser findCuserById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findCuserById", startResult, maxRows, id);
			return (common.domain.Cuser) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findCuserByUsername
	 *
	 */
	public Set<Cuser> findCuserByUsername(String username) throws DataAccessException {

		return findCuserByUsername(username, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByUsername
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByUsername(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByUsername", startResult, maxRows, username);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByGender
	 *
	 */
	public Set<Cuser> findCuserByGender(Boolean gender) throws DataAccessException {

		return findCuserByGender(gender, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByGender
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByGender(Boolean gender, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByGender", startResult, maxRows, gender);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByQxmc
	 *
	 */
	public Set<Cuser> findCuserByQxmc(String qxmc) throws DataAccessException {

		return findCuserByQxmc(qxmc, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByQxmc
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByQxmc(String qxmc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByQxmc", startResult, maxRows, qxmc);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * JPQL Query - findCuserByPasswordContaining
	 *
	 */
	public Set<Cuser> findCuserByPasswordContaining(String password) throws DataAccessException {

		return findCuserByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findCuserByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Cuser> findCuserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findCuserByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<Cuser>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Cuser entity) {
		return true;
	}
}
