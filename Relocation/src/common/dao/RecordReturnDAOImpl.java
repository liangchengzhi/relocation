package common.dao;

import common.domain.RecordReturn;
import common.entity.service.RecordReturnSum;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage RecordReturn entities.
 * 
 */
@Repository("recordReturnDAO")
public class RecordReturnDAOImpl extends AbstractJpaDao<RecordReturn> implements
		RecordReturnDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { RecordReturn.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new RecordReturnDAOImpl
	 *
	 */
	public RecordReturnDAOImpl() {
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
	 * JPQL Query - findRecordReturnByCreatedTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByCreatedTime(java.util.Calendar createdTime) throws DataAccessException {

		return findRecordReturnByCreatedTime(createdTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByCreatedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnByCreatedTime(java.util.Calendar createdTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnByCreatedTime", startResult, maxRows, createdTime);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordReturnBySid
	 *
	 */
	public Set<RecordReturn> findRecordReturnBySid(Integer sid) throws DataAccessException {

		return findRecordReturnBySid(sid, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnBySid
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnBySid(Integer sid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnBySid", startResult, maxRows, sid);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordReturnByIsDeleted
	 *
	 */
	public Set<RecordReturn> findRecordReturnByIsDeleted(Boolean isDeleted) throws DataAccessException {

		return findRecordReturnByIsDeleted(isDeleted, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByIsDeleted
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnByIsDeleted", startResult, maxRows, isDeleted);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllRecordReturns
	 *
	 */
	public Set<RecordReturn> findAllRecordReturns() throws DataAccessException {

		return findAllRecordReturns(-1, -1);
	}

	/**
	 * JPQL Query - findAllRecordReturns
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findAllRecordReturns(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllRecordReturns", startResult, maxRows);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordReturnByPrimaryKey
	 *
	 */
	public RecordReturn findRecordReturnByPrimaryKey(Integer id) throws DataAccessException {

		return findRecordReturnByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByPrimaryKey
	 *
	 */

	public RecordReturn findRecordReturnByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecordReturnByPrimaryKey", startResult, maxRows, id);
			return (common.domain.RecordReturn) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRecordReturnByReturnTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByReturnTime(java.util.Calendar returnTime) throws DataAccessException {

		return findRecordReturnByReturnTime(returnTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByReturnTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnByReturnTime(java.util.Calendar returnTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnByReturnTime", startResult, maxRows, returnTime);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordReturnById
	 *
	 */
	public RecordReturn findRecordReturnById(Integer id) throws DataAccessException {

		return findRecordReturnById(id, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnById
	 *
	 */

	public RecordReturn findRecordReturnById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecordReturnById", startResult, maxRows, id);
			return (common.domain.RecordReturn) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRecordReturnByProductionArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByProductionArea(java.math.BigDecimal productionArea) throws DataAccessException {

		return findRecordReturnByProductionArea(productionArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByProductionArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnByProductionArea(java.math.BigDecimal productionArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnByProductionArea", startResult, maxRows, productionArea);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordReturnByHouseArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByHouseArea(java.math.BigDecimal houseArea) throws DataAccessException {

		return findRecordReturnByHouseArea(houseArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByHouseArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnByHouseArea(java.math.BigDecimal houseArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnByHouseArea", startResult, maxRows, houseArea);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordReturnByBusinessArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByBusinessArea(java.math.BigDecimal businessArea) throws DataAccessException {

		return findRecordReturnByBusinessArea(businessArea, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByBusinessArea
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnByBusinessArea(java.math.BigDecimal businessArea, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnByBusinessArea", startResult, maxRows, businessArea);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecordReturnByDeletedTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException {

		return findRecordReturnByDeletedTime(deletedTime, -1, -1);
	}

	/**
	 * JPQL Query - findRecordReturnByDeletedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<RecordReturn> findRecordReturnByDeletedTime(java.util.Calendar deletedTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecordReturnByDeletedTime", startResult, maxRows, deletedTime);
		return new LinkedHashSet<RecordReturn>(query.getResultList());
	}
	
	
	/**
	 * 获取一段时间内发生的还房记录
	 * @param begin 开始时间
	 * @param end 截止时间
	 * @param recordId 拆迁id
	 * @return
	 * @throws DataAccessException
	 */
	public List<RecordReturn> findRecordReturns(java.util.Calendar begin, java.util.Calendar end,int recordId) throws DataAccessException {
		StringBuffer hql = new StringBuffer(" from RecordReturn t where sid = " + recordId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if(begin != null){
			String dateStr = sdf.format(begin.getTime());
			hql.append(" and DATE_FORMAT(t.returnTime,'%Y%m%d') >= " + dateStr);
		}
		
		if(end != null){
			String dateStr = sdf.format(end.getTime());
			hql.append(" and DATE_FORMAT(t.returnTime,'%Y%m%d') < " + dateStr);
		}
		
		hql.append(" order by t.returnTime asc ");
		List<RecordReturn> list = this.executeQuery(hql.toString());
		return list;
	}
	
	/**
	 * 获取指定时间的还房记录
	 * @param recordId
	 * @param time
	 * @return
	 */
	public RecordReturn findRecordReturnByTime(int recordId,java.util.Calendar time){
		StringBuffer hql = new StringBuffer(" from RecordReturn t where sid = " + recordId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if(time != null){
			String dateStr = sdf.format(time.getTime());
			hql.append(" and DATE_FORMAT(t.returnTime,'%Y%m%d') >= " + dateStr);
		}
		
		hql.append(" order by t.returnTime desc ");
		RecordReturn recordReturn = (RecordReturn) this.executeQuerySingleResult(hql.toString());
		return recordReturn;
	}
	
	/**
	 *  查询还房汇总面积
	 *  截止到time时间之前累计还房面积
	 * @param recordId
	 * @param time
	 * @return
	 */
	public RecordReturnSum getReturnSumAreaByTime(int recordId,java.util.Calendar time){
		StringBuffer hql = new StringBuffer(" from RecordReturn t where t.sid = " + recordId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if(time != null){
			String dateStr = sdf.format(time.getTime());
			hql.append(" and DATE_FORMAT(t.returnTime,'%Y%m%d') <= " + dateStr);
		}
		hql.append(" group by t.sid");
		// String countHql = "select count(t.sid) as cn " + hql; 
		// Integer cn = (Integer) this.executeQuerySingleResult(countHql);

		Query query = null;
		String queryHql = "select t.sid as recordId,SUM(t.houseArea) as houseReturn,SUM(t.businessArea) as businessReturn " + hql.toString();
		query = this.createQuery(queryHql,-1,-1);

		List<Object[]> list = query.getResultList();
		if(list.size() == 0){
			return null;
		}else{
			Object[] objs = (Object[]) list.get(0);
			RecordReturnSum recordReturnSum = new RecordReturnSum();
			recordReturnSum.setRecordId((Integer) objs[0]);
			recordReturnSum.setHouseReturn((BigDecimal) objs[1]);
			recordReturnSum.setBusinessReturn((BigDecimal) objs[2]);
			return recordReturnSum;
		}
	}
	
	/**
	 *  查询一段时间内还房汇总面积
	 * @param recordId 拆迁id
	 * @param begin 开始时间
	 * @param end 截止时间
	 * @return
	 */
	@Override
	public RecordReturnSum getReturnSumAreaByTime(int recordId,java.util.Calendar begin,java.util.Calendar end){
		StringBuffer hql = new StringBuffer(" from RecordReturn t where t.sid = " + recordId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if(begin != null){
			String dateStr = sdf.format(begin.getTime());
			hql.append(" and DATE_FORMAT(t.returnTime,'%Y%m%d') >= " + dateStr);
		}
		
		if(end != null){
			String dateStr = sdf.format(end.getTime());
			hql.append(" and DATE_FORMAT(t.returnTime,'%Y%m%d') < " + dateStr);
		}
		
		hql.append(" group by t.sid");
		Query query = null;
		String queryHql = "select t.sid as recordId,SUM(t.houseArea) as houseReturn,SUM(t.businessArea) as businessReturn " + hql.toString();
		query = this.createQuery(queryHql,-1,-1);
		
		List<Object[]> list = query.getResultList();
		if(list.size() == 0){
			return null;
		}else{
			Object[] objs = (Object[]) list.get(0);
			RecordReturnSum recordReturnSum = new RecordReturnSum();
			recordReturnSum.setRecordId((Integer) objs[0]);
			recordReturnSum.setHouseReturn((BigDecimal) objs[1]);
			recordReturnSum.setBusinessReturn((BigDecimal) objs[2]);
			return recordReturnSum;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(RecordReturn entity) {
		return true;
	}
}
