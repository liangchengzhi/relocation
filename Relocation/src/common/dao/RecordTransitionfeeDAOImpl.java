package common.dao;

import common.domain.RecordTransitionfee;

import java.util.Arrays;
import java.util.Calendar;
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
 * DAO to manage RecordTransitionfee entities.
 * 
 */
@Repository("recordTransitionfeeDAO")
public class RecordTransitionfeeDAOImpl extends AbstractJpaDao<RecordTransitionfee>
		implements RecordTransitionfeeDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { RecordTransitionfee.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new RecordTransitionfeeDAOImpl
	 *
	 */
	public RecordTransitionfeeDAOImpl() {
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
	 * JPQL Query - findRecordTransitionfeeByFee
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFee(java.math.BigDecimal fee) throws DataAccessException {

		return findRecordTransitionfeeByFee(fee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByFee(java.math.BigDecimal fee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByFee", startResult, maxRows, fee);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByYear
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByYear(Integer year) throws DataAccessException {

		return findRecordTransitionfeeByYear(year, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByYear
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByYear(Integer year, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByYear", startResult, maxRows, year);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByCreatedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByCreatedTime(java.util.Calendar createdTime) throws DataAccessException {

		return findRecordTransitionfeeByCreatedTime(createdTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByCreatedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByCreatedTime(java.util.Calendar createdTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByCreatedTime", startResult, maxRows, createdTime);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllRecordTransitionfees
	 *
	 */
	public Set<RecordTransitionfee> findAllRecordTransitionfees() throws DataAccessException {

		return findAllRecordTransitionfees(-1, -1);
	}

	/**
	 * JPQL Query - findAllRecordTransitionfees
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findAllRecordTransitionfees(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllRecordTransitionfees", startResult, maxRows);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstEndTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstEndTime(java.util.Calendar firstEndTime) throws DataAccessException {

		return findRecordTransitionfeeByFirstEndTime(firstEndTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstEndTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstEndTime(java.util.Calendar firstEndTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByFirstEndTime", startResult, maxRows, firstEndTime);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByEndTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByEndTime(java.util.Calendar endTime) throws DataAccessException {

		return findRecordTransitionfeeByEndTime(endTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByEndTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByEndTime(java.util.Calendar endTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByEndTime", startResult, maxRows, endTime);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDealed
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDealed(Boolean isDealed) throws DataAccessException {

		return findRecordTransitionfeeByIsDealed(isDealed, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDealed
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDealed(Boolean isDealed, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByIsDealed", startResult, maxRows, isDealed);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccountContaining
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccountContaining(String bankAccount) throws DataAccessException {

		return findRecordTransitionfeeByBankAccountContaining(bankAccount, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccountContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccountContaining(String bankAccount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByBankAccountContaining", startResult, maxRows, bankAccount);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByTypeContaining
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByTypeContaining(String type) throws DataAccessException {

		return findRecordTransitionfeeByTypeContaining(type, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByTypeContaining(String type, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByTypeContaining", startResult, maxRows, type);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByStartTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByStartTime(java.util.Calendar startTime) throws DataAccessException {

		return findRecordTransitionfeeByStartTime(startTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByStartTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByStartTime(java.util.Calendar startTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByStartTime", startResult, maxRows, startTime);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstFee
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstFee(java.math.BigDecimal firstFee) throws DataAccessException {

		return findRecordTransitionfeeByFirstFee(firstFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstFee(java.math.BigDecimal firstFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByFirstFee", startResult, maxRows, firstFee);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByType
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByType(String type) throws DataAccessException {

		return findRecordTransitionfeeByType(type, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByType
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByType(String type, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByType", startResult, maxRows, type);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDeleted
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDeleted(Boolean isDeleted) throws DataAccessException {

		return findRecordTransitionfeeByIsDeleted(isDeleted, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDeleted
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByIsDeleted", startResult, maxRows, isDeleted);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByPrimaryKey
	 *
	 */
	public RecordTransitionfee findRecordTransitionfeeByPrimaryKey(Integer id) throws DataAccessException {

		return findRecordTransitionfeeByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByPrimaryKey
	 *
	 */

	public RecordTransitionfee findRecordTransitionfeeByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecordTransitionfeeByPrimaryKey", startResult, maxRows, id);
			return (common.domain.RecordTransitionfee) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByDeletedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException {

		return findRecordTransitionfeeByDeletedTime(deletedTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByDeletedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByDeletedTime(java.util.Calendar deletedTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByDeletedTime", startResult, maxRows, deletedTime);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccount
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccount(String bankAccount) throws DataAccessException {

		return findRecordTransitionfeeByBankAccount(bankAccount, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccount
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccount(String bankAccount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByBankAccount", startResult, maxRows, bankAccount);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByDealedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByDealedTime(java.util.Calendar dealedTime) throws DataAccessException {

		return findRecordTransitionfeeByDealedTime(dealedTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByDealedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByDealedTime(java.util.Calendar dealedTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByDealedTime", startResult, maxRows, dealedTime);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstStartTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstStartTime(java.util.Calendar firstStartTime) throws DataAccessException {

		return findRecordTransitionfeeByFirstStartTime(firstStartTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstStartTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstStartTime(java.util.Calendar firstStartTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByFirstStartTime", startResult, maxRows, firstStartTime);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByQuarter
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByQuarter(Integer quarter) throws DataAccessException {

		return findRecordTransitionfeeByQuarter(quarter, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByQuarter
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByQuarter(Integer quarter, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByQuarter", startResult, maxRows, quarter);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordTransitionfeeById
	 *
	 */
	public RecordTransitionfee findRecordTransitionfeeById(Integer id) throws DataAccessException {

		return findRecordTransitionfeeById(id, -1, -1);
	}
	

	/**
	 * JPQL Query - findRecordTransitionfeeById
	 *
	 */

	public RecordTransitionfee findRecordTransitionfeeById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecordTransitionfeeById", startResult, maxRows, id);
			return (common.domain.RecordTransitionfee) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByRemark
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByRemark(String remark) throws DataAccessException {

		return findRecordTransitionfeeByRemark(remark, -1, -1);
	}

	/**
	 * JPQL Query - findRecordTransitionfeeByRemark
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordTransitionfee> findRecordTransitionfeeByRemark(String remark, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordTransitionfeeByRemark", startResult, maxRows, remark);
		return new LinkedHashSet<RecordTransitionfee>(query.getResultList());
	}
	
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(RecordTransitionfee entity) {
		return true;
	}
	
	@Override
	public Calendar inquiryLastRecordFeeTime(Integer recordId){
		String hql = "select max(endTime) from RecordTransitionfee where 1=1 ";
		if(recordId != null){
			hql = hql + " and sid = " + recordId;
		}
		Query query = this.createQuery(hql, -1, -1);
		Calendar endTime = (Calendar) query.getSingleResult();
		return endTime;
	}
}
