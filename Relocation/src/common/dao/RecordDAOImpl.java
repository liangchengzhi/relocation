package common.dao;

import common.domain.Record;
import common.entity.basic.ErrorCode;
import common.entity.basic.IFSException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Record entities.
 * 
 */
@Repository("recordDAO")
public class RecordDAOImpl extends AbstractJpaDao<Record> implements RecordDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Record.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new RecordDAOImpl
	 *
	 */
	public RecordDAOImpl() {
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
	 * JPQL Query - findRecordByContractNumber
	 *
	 */
	public Set<Record> findRecordByContractNumber(String contractNumber) throws DataAccessException {

		return findRecordByContractNumber(contractNumber, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByContractNumber
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByContractNumber(String contractNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByContractNumber", startResult, maxRows, contractNumber);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByIsEnd
	 *
	 */
	public Set<Record> findRecordByIsEnd(Boolean isEnd) throws DataAccessException {

		return findRecordByIsEnd(isEnd, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByIsEnd
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByIsEnd(Boolean isEnd, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByIsEnd", startResult, maxRows, isEnd);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBalance1
	 *
	 */
	public Set<Record> findRecordByBalance1(java.math.BigDecimal balance1) throws DataAccessException {

		return findRecordByBalance1(balance1, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBalance1
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBalance1(java.math.BigDecimal balance1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBalance1", startResult, maxRows, balance1);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByRemark
	 *
	 */
	public Set<Record> findRecordByRemark(String remark) throws DataAccessException {

		return findRecordByRemark(remark, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByRemark
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByRemark(String remark, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByRemark", startResult, maxRows, remark);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBusinessArea
	 *
	 */
	public Set<Record> findRecordByBusinessArea(java.math.BigDecimal businessArea) throws DataAccessException {

		return findRecordByBusinessArea(businessArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBusinessArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBusinessArea(java.math.BigDecimal businessArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBusinessArea", startResult, maxRows, businessArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUseridcard
	 *
	 */
	public Set<Record> findRecordByUseridcard(String useridcard) throws DataAccessException {

		return findRecordByUseridcard(useridcard, -1, -1);
	}
	
	/**
	 * JPQL Query - findRecordByUseridcard
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUseridcard(String useridcard, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUseridcard", startResult, maxRows, useridcard);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByRecordNumber
	 *
	 */
	public Set<Record> findRecordByRecordNumber(String recordNumber) throws DataAccessException {

		return findRecordByRecordNumber(recordNumber, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByRecordNumber
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByRecordNumber(String recordNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByRecordNumber", startResult, maxRows, recordNumber);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveAmountContaining
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAmountContaining(String selfRemoveAmount) throws DataAccessException {

		return findRecordBySelfRemoveAmountContaining(selfRemoveAmount, -1, -1);
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveAmountContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordBySelfRemoveAmountContaining(String selfRemoveAmount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordBySelfRemoveAmountContaining", startResult, maxRows, selfRemoveAmount);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackRoomContaining(String productionAreaBackRoom) throws DataAccessException {

		return findRecordByProductionAreaBackRoomContaining(productionAreaBackRoom, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoomContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProductionAreaBackRoomContaining(String productionAreaBackRoom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProductionAreaBackRoomContaining", startResult, maxRows, productionAreaBackRoom);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByLastEditTime
	 *
	 */
	public Set<Record> findRecordByLastEditTime(java.util.Calendar lastEditTime) throws DataAccessException {

		return findRecordByLastEditTime(lastEditTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByLastEditTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByLastEditTime(java.util.Calendar lastEditTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByLastEditTime", startResult, maxRows, lastEditTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByPrimaryKey
	 *
	 */
	public Record findRecordByPrimaryKey(Integer id) throws DataAccessException {

		return findRecordByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByPrimaryKey
	 *
	 */

	public Record findRecordByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecordByPrimaryKey", startResult, maxRows, id);
			return (common.domain.Record) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRecordByEndTime
	 *
	 */
	public Set<Record> findRecordByEndTime(java.util.Calendar endTime) throws DataAccessException {

		return findRecordByEndTime(endTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByEndTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByEndTime(java.util.Calendar endTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByEndTime", startResult, maxRows, endTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByTransitionFee
	 *
	 */
	public Set<Record> findRecordByTransitionFee(java.math.BigDecimal transitionFee) throws DataAccessException {

		return findRecordByTransitionFee(transitionFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByTransitionFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByTransitionFee(java.math.BigDecimal transitionFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByTransitionFee", startResult, maxRows, transitionFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackRoomContaining(String houseAreaBackRoom) throws DataAccessException {

		return findRecordByHouseAreaBackRoomContaining(houseAreaBackRoom, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoomContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByHouseAreaBackRoomContaining(String houseAreaBackRoom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByHouseAreaBackRoomContaining", startResult, maxRows, houseAreaBackRoom);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByCoveredAreaBack
	 *
	 */
	public Set<Record> findRecordByCoveredAreaBack(java.math.BigDecimal coveredAreaBack) throws DataAccessException {

		return findRecordByCoveredAreaBack(coveredAreaBack, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByCoveredAreaBack
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByCoveredAreaBack(java.math.BigDecimal coveredAreaBack, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByCoveredAreaBack", startResult, maxRows, coveredAreaBack);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackReturn(java.math.BigDecimal productionAreaBackReturn) throws DataAccessException {

		return findRecordByProductionAreaBackReturn(productionAreaBackReturn, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBackReturn
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProductionAreaBackReturn(java.math.BigDecimal productionAreaBackReturn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProductionAreaBackReturn", startResult, maxRows, productionAreaBackReturn);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProjectName
	 *
	 */
	public Set<Record> findRecordByProjectName(String projectName) throws DataAccessException {

		return findRecordByProjectName(projectName, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProjectName
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProjectName(String projectName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProjectName", startResult, maxRows, projectName);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByLastComputeTime
	 *
	 */
	public Set<Record> findRecordByLastComputeTime(java.util.Calendar lastComputeTime) throws DataAccessException {

		return findRecordByLastComputeTime(lastComputeTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByLastComputeTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByLastComputeTime(java.util.Calendar lastComputeTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByLastComputeTime", startResult, maxRows, lastComputeTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUsernameContaining
	 *
	 */
	public Set<Record> findRecordByUsernameContaining(String username) throws DataAccessException {

		return findRecordByUsernameContaining(username, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByUsernameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUsernameContaining", startResult, maxRows, username);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordById
	 *
	 */
	public Record findRecordById(Integer id) throws DataAccessException {

		return findRecordById(id, -1, -1);
	}

	/**
	 * JPQL Query - findRecordById
	 *
	 */

	public Record findRecordById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecordById", startResult, maxRows, id);
			return (common.domain.Record) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRecordBySelfSimplyArea
	 *
	 */
	public Set<Record> findRecordBySelfSimplyArea(String selfSimplyArea) throws DataAccessException {

		return findRecordBySelfSimplyArea(selfSimplyArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordBySelfSimplyArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordBySelfSimplyArea(String selfSimplyArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordBySelfSimplyArea", startResult, maxRows, selfSimplyArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUsername
	 *
	 */
	public Set<Record> findRecordByUsername(String username) throws DataAccessException {

		return findRecordByUsername(username, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByUsername
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUsername(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUsername", startResult, maxRows, username);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProjectNameContaining
	 *
	 */
	public Set<Record> findRecordByProjectNameContaining(String projectName) throws DataAccessException {

		return findRecordByProjectNameContaining(projectName, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProjectNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProjectNameContaining(String projectName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProjectNameContaining", startResult, maxRows, projectName);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByOtherFee
	 *
	 */
	public Set<Record> findRecordByOtherFee(java.math.BigDecimal otherFee) throws DataAccessException {

		return findRecordByOtherFee(otherFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByOtherFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByOtherFee(java.math.BigDecimal otherFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByOtherFee", startResult, maxRows, otherFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUseraddress
	 *
	 */
	public Set<Record> findRecordByUseraddress(String useraddress) throws DataAccessException {

		return findRecordByUseraddress(useraddress, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByUseraddress
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUseraddress(String useraddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUseraddress", startResult, maxRows, useraddress);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByHouseArea
	 *
	 */
	public Set<Record> findRecordByHouseArea(java.math.BigDecimal houseArea) throws DataAccessException {

		return findRecordByHouseArea(houseArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByHouseArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByHouseArea(java.math.BigDecimal houseArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByHouseArea", startResult, maxRows, houseArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackRoomContaining(String businessAreaBackRoom) throws DataAccessException {

		return findRecordByBusinessAreaBackRoomContaining(businessAreaBackRoom, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoomContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBusinessAreaBackRoomContaining(String businessAreaBackRoom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBusinessAreaBackRoomContaining", startResult, maxRows, businessAreaBackRoom);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordBySelfSimplyAreaContaining
	 *
	 */
	public Set<Record> findRecordBySelfSimplyAreaContaining(String selfSimplyArea) throws DataAccessException {

		return findRecordBySelfSimplyAreaContaining(selfSimplyArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordBySelfSimplyAreaContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordBySelfSimplyAreaContaining(String selfSimplyArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordBySelfSimplyAreaContaining", startResult, maxRows, selfSimplyArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByDiscontinuedFee
	 *
	 */
	public Set<Record> findRecordByDiscontinuedFee(java.math.BigDecimal discontinuedFee) throws DataAccessException {

		return findRecordByDiscontinuedFee(discontinuedFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByDiscontinuedFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByDiscontinuedFee(java.math.BigDecimal discontinuedFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByDiscontinuedFee", startResult, maxRows, discontinuedFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUseraddressContaining
	 *
	 */
	public Set<Record> findRecordByUseraddressContaining(String useraddress) throws DataAccessException {

		return findRecordByUseraddressContaining(useraddress, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByUseraddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUseraddressContaining(String useraddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUseraddressContaining", startResult, maxRows, useraddress);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackReturn(java.math.BigDecimal houseAreaBackReturn) throws DataAccessException {

		return findRecordByHouseAreaBackReturn(houseAreaBackReturn, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBackReturn
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByHouseAreaBackReturn(java.math.BigDecimal houseAreaBackReturn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByHouseAreaBackReturn", startResult, maxRows, houseAreaBackReturn);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveAmount
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAmount(String selfRemoveAmount) throws DataAccessException {

		return findRecordBySelfRemoveAmount(selfRemoveAmount, -1, -1);
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveAmount
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordBySelfRemoveAmount(String selfRemoveAmount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordBySelfRemoveAmount", startResult, maxRows, selfRemoveAmount);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByStartTime
	 *
	 */
	public Set<Record> findRecordByStartTime(java.util.Calendar startTime) throws DataAccessException {

		return findRecordByStartTime(startTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByStartTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByStartTime(java.util.Calendar startTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByStartTime", startResult, maxRows, startTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByTotal
	 *
	 */
	public Set<Record> findRecordByTotal(java.math.BigDecimal total) throws DataAccessException {

		return findRecordByTotal(total, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByTotal
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByTotal(java.math.BigDecimal total, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByTotal", startResult, maxRows, total);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByContractNumberContaining
	 *
	 */
	public Set<Record> findRecordByContractNumberContaining(String contractNumber) throws DataAccessException {

		return findRecordByContractNumberContaining(contractNumber, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByContractNumberContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByContractNumberContaining(String contractNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByContractNumberContaining", startResult, maxRows, contractNumber);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByRecordNumberContaining
	 *
	 */
	public Set<Record> findRecordByRecordNumberContaining(String recordNumber) throws DataAccessException {

		return findRecordByRecordNumberContaining(recordNumber, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByRecordNumberContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByRecordNumberContaining(String recordNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByRecordNumberContaining", startResult, maxRows, recordNumber);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBack
	 *
	 */
	public Set<Record> findRecordByProductionAreaBack(java.math.BigDecimal productionAreaBack) throws DataAccessException {

		return findRecordByProductionAreaBack(productionAreaBack, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBack
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProductionAreaBack(java.math.BigDecimal productionAreaBack, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProductionAreaBack", startResult, maxRows, productionAreaBack);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordBySelfdemolitionFee
	 *
	 */
	public Set<Record> findRecordBySelfdemolitionFee(java.math.BigDecimal selfdemolitionFee) throws DataAccessException {

		return findRecordBySelfdemolitionFee(selfdemolitionFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordBySelfdemolitionFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordBySelfdemolitionFee(java.math.BigDecimal selfdemolitionFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordBySelfdemolitionFee", startResult, maxRows, selfdemolitionFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUsercontact
	 *
	 */
	public Set<Record> findRecordByUsercontact(String usercontact) throws DataAccessException {

		return findRecordByUsercontact(usercontact, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByUsercontact
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUsercontact(String usercontact, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUsercontact", startResult, maxRows, usercontact);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBack
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBack(java.math.BigDecimal businessAreaBack) throws DataAccessException {

		return findRecordByBusinessAreaBack(businessAreaBack, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBack
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBusinessAreaBack(java.math.BigDecimal businessAreaBack, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBusinessAreaBack", startResult, maxRows, businessAreaBack);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByFacilityFee
	 *
	 */
	public Set<Record> findRecordByFacilityFee(java.math.BigDecimal facilityFee) throws DataAccessException {

		return findRecordByFacilityFee(facilityFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByFacilityFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByFacilityFee(java.math.BigDecimal facilityFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByFacilityFee", startResult, maxRows, facilityFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBalanceDeal
	 *
	 */
	public Set<Record> findRecordByBalanceDeal(java.math.BigDecimal balanceDeal) throws DataAccessException {

		return findRecordByBalanceDeal(balanceDeal, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBalanceDeal
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBalanceDeal(java.math.BigDecimal balanceDeal, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBalanceDeal", startResult, maxRows, balanceDeal);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBankAccountContaining
	 *
	 */
	public Set<Record> findRecordByBankAccountContaining(String bankAccount) throws DataAccessException {

		return findRecordByBankAccountContaining(bankAccount, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBankAccountContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBankAccountContaining(String bankAccount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBankAccountContaining", startResult, maxRows, bankAccount);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByAwardFee
	 *
	 */
	public Set<Record> findRecordByAwardFee(java.math.BigDecimal awardFee) throws DataAccessException {

		return findRecordByAwardFee(awardFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByAwardFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByAwardFee(java.math.BigDecimal awardFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByAwardFee", startResult, maxRows, awardFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByTransportFee
	 *
	 */
	public Set<Record> findRecordByTransportFee(java.math.BigDecimal transportFee) throws DataAccessException {

		return findRecordByTransportFee(transportFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByTransportFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByTransportFee(java.math.BigDecimal transportFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByTransportFee", startResult, maxRows, transportFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByLastDealTime
	 *
	 */
	public Set<Record> findRecordByLastDealTime(java.util.Calendar lastDealTime) throws DataAccessException {

		return findRecordByLastDealTime(lastDealTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByLastDealTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByLastDealTime(java.util.Calendar lastDealTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByLastDealTime", startResult, maxRows, lastDealTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBalance2
	 *
	 */
	public Set<Record> findRecordByBalance2(java.math.BigDecimal balance2) throws DataAccessException {

		return findRecordByBalance2(balance2, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBalance2
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBalance2(java.math.BigDecimal balance2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBalance2", startResult, maxRows, balance2);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackRoom(String houseAreaBackRoom) throws DataAccessException {

		return findRecordByHouseAreaBackRoom(houseAreaBackRoom, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoom
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByHouseAreaBackRoom(String houseAreaBackRoom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByHouseAreaBackRoom", startResult, maxRows, houseAreaBackRoom);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackRoom(String businessAreaBackRoom) throws DataAccessException {

		return findRecordByBusinessAreaBackRoom(businessAreaBackRoom, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoom
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBusinessAreaBackRoom(String businessAreaBackRoom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBusinessAreaBackRoom", startResult, maxRows, businessAreaBackRoom);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackReturn(java.math.BigDecimal businessAreaBackReturn) throws DataAccessException {

		return findRecordByBusinessAreaBackReturn(businessAreaBackReturn, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBusinessAreaBackReturn
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBusinessAreaBackReturn(java.math.BigDecimal businessAreaBackReturn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBusinessAreaBackReturn", startResult, maxRows, businessAreaBackReturn);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUsercontactContaining
	 *
	 */
	public Set<Record> findRecordByUsercontactContaining(String usercontact) throws DataAccessException {

		return findRecordByUsercontactContaining(usercontact, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByUsercontactContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUsercontactContaining(String usercontact, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUsercontactContaining", startResult, maxRows, usercontact);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByBankAccount
	 *
	 */
	public Set<Record> findRecordByBankAccount(String bankAccount) throws DataAccessException {

		return findRecordByBankAccount(bankAccount, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByBankAccount
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByBankAccount(String bankAccount, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByBankAccount", startResult, maxRows, bankAccount);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByCreatedTime
	 *
	 */
	public Set<Record> findRecordByCreatedTime(java.util.Calendar createdTime) throws DataAccessException {

		return findRecordByCreatedTime(createdTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByCreatedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByCreatedTime(java.util.Calendar createdTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByCreatedTime", startResult, maxRows, createdTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBack
	 *
	 */
	public Set<Record> findRecordByHouseAreaBack(java.math.BigDecimal houseAreaBack) throws DataAccessException {

		return findRecordByHouseAreaBack(houseAreaBack, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByHouseAreaBack
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByHouseAreaBack(java.math.BigDecimal houseAreaBack, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByHouseAreaBack", startResult, maxRows, houseAreaBack);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByCoveredArea
	 *
	 */
	public Set<Record> findRecordByCoveredArea(java.math.BigDecimal coveredArea) throws DataAccessException {

		return findRecordByCoveredArea(coveredArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByCoveredArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByCoveredArea(java.math.BigDecimal coveredArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByCoveredArea", startResult, maxRows, coveredArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByUseridcardContaining
	 *
	 */
	public Set<Record> findRecordByUseridcardContaining(String useridcard) throws DataAccessException {

		return findRecordByUseridcardContaining(useridcard, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByUseridcardContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByUseridcardContaining(String useridcard, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByUseridcardContaining", startResult, maxRows, useridcard);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllRecords
	 *
	 */
	public Set<Record> findAllRecords() throws DataAccessException {

		return findAllRecords(-1, -1);
	}

	/**
	 * JPQL Query - findAllRecords
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findAllRecords(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllRecords", startResult, maxRows);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProductionAreaContaining
	 *
	 */
	public Set<Record> findRecordByProductionAreaContaining(String productionArea) throws DataAccessException {

		return findRecordByProductionAreaContaining(productionArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProductionAreaContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProductionAreaContaining(String productionArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProductionAreaContaining", startResult, maxRows, productionArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveAreaContaining
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAreaContaining(String selfRemoveArea) throws DataAccessException {

		return findRecordBySelfRemoveAreaContaining(selfRemoveArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveAreaContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordBySelfRemoveAreaContaining(String selfRemoveArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordBySelfRemoveAreaContaining", startResult, maxRows, selfRemoveArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByIsDealed
	 *
	 */
	public Set<Record> findRecordByIsDealed(Boolean isDealed) throws DataAccessException {

		return findRecordByIsDealed(isDealed, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByIsDealed
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByIsDealed(Boolean isDealed, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByIsDealed", startResult, maxRows, isDealed);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByIsDeleted
	 *
	 */
	public Set<Record> findRecordByIsDeleted(Boolean isDeleted) throws DataAccessException {

		return findRecordByIsDeleted(isDeleted, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByIsDeleted
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByIsDeleted", startResult, maxRows, isDeleted);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByIsStart
	 *
	 */
	public Set<Record> findRecordByIsStart(Boolean isStart) throws DataAccessException {

		return findRecordByIsStart(isStart, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByIsStart
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByIsStart(Boolean isStart, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByIsStart", startResult, maxRows, isStart);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackRoom(String productionAreaBackRoom) throws DataAccessException {

		return findRecordByProductionAreaBackRoom(productionAreaBackRoom, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoom
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProductionAreaBackRoom(String productionAreaBackRoom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProductionAreaBackRoom", startResult, maxRows, productionAreaBackRoom);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByDeletedTime
	 *
	 */
	public Set<Record> findRecordByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException {

		return findRecordByDeletedTime(deletedTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByDeletedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByDeletedTime(java.util.Calendar deletedTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByDeletedTime", startResult, maxRows, deletedTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByStartDealTime
	 *
	 */
	public Set<Record> findRecordByStartDealTime(java.util.Calendar startDealTime) throws DataAccessException {

		return findRecordByStartDealTime(startDealTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByStartDealTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByStartDealTime(java.util.Calendar startDealTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByStartDealTime", startResult, maxRows, startDealTime);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByMovingFee
	 *
	 */
	public Set<Record> findRecordByMovingFee(java.math.BigDecimal movingFee) throws DataAccessException {

		return findRecordByMovingFee(movingFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByMovingFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByMovingFee(java.math.BigDecimal movingFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByMovingFee", startResult, maxRows, movingFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByProductionArea
	 *
	 */
	public Set<Record> findRecordByProductionArea(String productionArea) throws DataAccessException {

		return findRecordByProductionArea(productionArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByProductionArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByProductionArea(String productionArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByProductionArea", startResult, maxRows, productionArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveArea
	 *
	 */
	public Set<Record> findRecordBySelfRemoveArea(String selfRemoveArea) throws DataAccessException {

		return findRecordBySelfRemoveArea(selfRemoveArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordBySelfRemoveArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordBySelfRemoveArea(String selfRemoveArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordBySelfRemoveArea", startResult, maxRows, selfRemoveArea);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByPerFee
	 *
	 */
	public Set<Record> findRecordByPerFee(java.math.BigDecimal perFee) throws DataAccessException {

		return findRecordByPerFee(perFee, -1, -1);
	}

	/**
	 * JPQL Query - findRecordByPerFee
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByPerFee(java.math.BigDecimal perFee, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByPerFee", startResult, maxRows, perFee);
		return new LinkedHashSet<Record>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordByReplaceFlag
	 *
	 */
	public Set<Record> findRecordByReplaceFlag(Integer replaceFlag) throws DataAccessException {

		return findRecordByReplaceFlag(replaceFlag, -1, -1);
	}
	
	public Set<Record> findDealRecordByUseridcard(String useridcard) throws DataAccessException {

		return findRecordByUseridcard(useridcard, -1, -1);
	}
	
	
	/**
	 * JPQL Query - findRecordByReplaceFlag
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Record> findRecordByReplaceFlag(Integer replaceFlag, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordByReplaceFlag", startResult, maxRows, replaceFlag);
		return new LinkedHashSet<Record>(query.getResultList());
	}
	
	/**
	 * 查询该户是否已经有一百平米优惠享受的拆迁记录
	 * @param useridcard
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public Set<Record> checkIfHadAreaBenefit100(String useridcard) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		// sb.append("from Record t WHERE (sum(case when t.houseArea is null then 0 else t.houseArea end) + sum(case when t.businessArea is null then 0 else t.businessArea end)) < 100 and t.useridcard = " + useridcard);
		
		sb.append("from Record t WHERE coalesce(t.houseArea,0)+coalesce(t.businessArea, 0)<100 and t.useridcard = '" + useridcard + "'");
	   //  + COALESCE(t.businessArea,0)) 
		
		Query query = this.createQuery(sb.toString(), -1, -1);
		return new LinkedHashSet<Record>(query.getResultList());
	}			
	
	
	/**
	 *  查询拆迁记录
	 * @param projectName
	 * @param contractNumber
	 * @param recordNumber
	 * @return
	 */
	@Override
	public Record findRecord(String projectName,String contractNumber,String recordNumber){
		String hql = "from Record t where t.projectName = " + "'" + projectName + "'" + " and t.recordNumber = " + "'" + recordNumber + "'";
		Query query = this.createQuery(hql, -1, -1);
		Set<Record> set = new LinkedHashSet<Record>(query.getResultList());
		if(set.size() == 0){
			return null;
		}
		if(set.size() > 1){
			throw new IFSException("查询失败", ErrorCode.BaseErrorCode);
		}
		return set.iterator().next();
	}
	@Override
	public Calendar inquiryLastCalTime(Integer recordId){
		String hql = "select max(endTime) from RecordTransitionfee where 1=1 ";
		if(recordId != null){
			hql = hql + " and sid = " + recordId;
		}
		Query query = this.createQuery(hql, -1, -1);
		Calendar endTime = (Calendar) query.getSingleResult();
		return endTime;
	}
	
	
//	public void deleteRecord(List<String> records){
//		
//		String recordids = StringUtils.join(records.toArray(), ",");
//		String hql = " delete from Record t where t.id in (" + recordids +")";
//		this.remove(toRemove);
//		
//	}
	
	/**
	 * 删除record
	 * @param records
	 */
	@Override
	public void deleteRecord(List<Record> records){
		for (Record record : records) {
			this.remove(record);
		}
	}
	
	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Record entity) {
		return true;
	}
}
