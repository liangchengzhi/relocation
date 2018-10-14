package common.dao;

import common.domain.RecordReturn;
import common.entity.service.RecordReturnSum;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage RecordReturn entities.
 * 
 */
public interface RecordReturnDAO extends JpaDao<RecordReturn> {

	/**
	 * JPQL Query - findRecordReturnByCreatedTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByCreatedTime(java.util.Calendar createdTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByCreatedTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByCreatedTime(Calendar createdTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnBySid
	 *
	 */
	public Set<RecordReturn> findRecordReturnBySid(Integer sid) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnBySid
	 *
	 */
	public Set<RecordReturn> findRecordReturnBySid(Integer sid, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByIsDeleted
	 *
	 */
	public Set<RecordReturn> findRecordReturnByIsDeleted(Boolean isDeleted) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByIsDeleted
	 *
	 */
	public Set<RecordReturn> findRecordReturnByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllRecordReturns
	 *
	 */
	public Set<RecordReturn> findAllRecordReturns() throws DataAccessException;

	/**
	 * JPQL Query - findAllRecordReturns
	 *
	 */
	public Set<RecordReturn> findAllRecordReturns(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByPrimaryKey
	 *
	 */
	public RecordReturn findRecordReturnByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByPrimaryKey
	 *
	 */
	public RecordReturn findRecordReturnByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByReturnTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByReturnTime(java.util.Calendar returnTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByReturnTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByReturnTime(Calendar returnTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnById
	 *
	 */
	public RecordReturn findRecordReturnById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnById
	 *
	 */
	public RecordReturn findRecordReturnById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByProductionArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByProductionArea(java.math.BigDecimal productionArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByProductionArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByProductionArea(BigDecimal productionArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByHouseArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByHouseArea(java.math.BigDecimal houseArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByHouseArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByHouseArea(BigDecimal houseArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByBusinessArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByBusinessArea(java.math.BigDecimal businessArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByBusinessArea
	 *
	 */
	public Set<RecordReturn> findRecordReturnByBusinessArea(BigDecimal businessArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByDeletedTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordReturnByDeletedTime
	 *
	 */
	public Set<RecordReturn> findRecordReturnByDeletedTime(Calendar deletedTime, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 *  查询一定时间内的拆迁还房记录
	 * @param begin
	 * @param end
	 * @param recordId
	 * @return
	 * @throws DataAccessException
	 */
	public List<RecordReturn> findRecordReturns(java.util.Calendar begin, java.util.Calendar end,int recordId) throws DataAccessException;

	/**
	 * 获取指定时间的还房记录
	 * @param recordId
	 * @param time
	 * @return
	 */
	public RecordReturn findRecordReturnByTime(int recordId,java.util.Calendar time);
	
	/**
	 * 查询还房汇总面积
	 * @param recordId
	 * @param time
	 * @return
	 */
	public RecordReturnSum getReturnSumAreaByTime(int recordId,java.util.Calendar time);
	
	/**
	 *  查询一段时间内还房汇总面积
	 * @param recordId 拆迁id
	 * @param begin 开始时间
	 * @param end 截止时间
	 * @return
	 */
	public RecordReturnSum getReturnSumAreaByTime(int recordId, Calendar begin,Calendar end);

}