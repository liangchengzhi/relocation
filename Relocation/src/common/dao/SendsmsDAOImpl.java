package common.dao;

import common.domain.Sendsms;

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
 * DAO to manage Sendsms entities.
 * 
 */
@Repository("sendsmsDAO")
public class SendsmsDAOImpl extends AbstractJpaDao<Sendsms> implements
		SendsmsDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Sendsms.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SendsmsDAOImpl
	 *
	 */
	public SendsmsDAOImpl() {
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
	 * JPQL Query - findSendsmsByContent
	 *
	 */
	public Set<Sendsms> findSendsmsByContent(String content) throws DataAccessException {

		return findSendsmsByContent(content, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByContent
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByContent(String content, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByContent", startResult, maxRows, content);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByCreatedtime
	 *
	 */
	public Set<Sendsms> findSendsmsByCreatedtime(java.util.Calendar createdtime) throws DataAccessException {

		return findSendsmsByCreatedtime(createdtime, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByCreatedtime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByCreatedtime(java.util.Calendar createdtime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByCreatedtime", startResult, maxRows, createdtime);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByPhoneContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByPhoneContaining(String phone) throws DataAccessException {

		return findSendsmsByPhoneContaining(phone, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByPhoneContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByPhoneContaining", startResult, maxRows, phone);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByRandcodeContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByRandcodeContaining(String randcode) throws DataAccessException {

		return findSendsmsByRandcodeContaining(randcode, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByRandcodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByRandcodeContaining(String randcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByRandcodeContaining", startResult, maxRows, randcode);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByContentContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByContentContaining(String content) throws DataAccessException {

		return findSendsmsByContentContaining(content, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByContentContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByContentContaining(String content, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByContentContaining", startResult, maxRows, content);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByPrimaryKey
	 *
	 */
	public Sendsms findSendsmsByPrimaryKey(Integer id) throws DataAccessException {

		return findSendsmsByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByPrimaryKey
	 *
	 */

	public Sendsms findSendsmsByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSendsmsByPrimaryKey", startResult, maxRows, id);
			return (common.domain.Sendsms) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSendsmsByRandcode
	 *
	 */
	public Set<Sendsms> findSendsmsByRandcode(String randcode) throws DataAccessException {

		return findSendsmsByRandcode(randcode, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByRandcode
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByRandcode(String randcode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByRandcode", startResult, maxRows, randcode);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllSendsmss
	 *
	 */
	public Set<Sendsms> findAllSendsmss() throws DataAccessException {

		return findAllSendsmss(-1, -1);
	}

	/**
	 * JPQL Query - findAllSendsmss
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findAllSendsmss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSendsmss", startResult, maxRows);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByPhone
	 *
	 */
	public Set<Sendsms> findSendsmsByPhone(String phone) throws DataAccessException {

		return findSendsmsByPhone(phone, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByPhone
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByPhone(String phone, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByPhone", startResult, maxRows, phone);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByIp
	 *
	 */
	public Set<Sendsms> findSendsmsByIp(String ip) throws DataAccessException {

		return findSendsmsByIp(ip, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByIp
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByIp(String ip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByIp", startResult, maxRows, ip);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsByIpContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByIpContaining(String ip) throws DataAccessException {

		return findSendsmsByIpContaining(ip, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsByIpContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sendsms> findSendsmsByIpContaining(String ip, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSendsmsByIpContaining", startResult, maxRows, ip);
		return new LinkedHashSet<Sendsms>(query.getResultList());
	}

	/**
	 * JPQL Query - findSendsmsById
	 *
	 */
	public Sendsms findSendsmsById(Integer id) throws DataAccessException {

		return findSendsmsById(id, -1, -1);
	}

	/**
	 * JPQL Query - findSendsmsById
	 *
	 */

	public Sendsms findSendsmsById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSendsmsById", startResult, maxRows, id);
			return (common.domain.Sendsms) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Sendsms entity) {
		return true;
	}
}
