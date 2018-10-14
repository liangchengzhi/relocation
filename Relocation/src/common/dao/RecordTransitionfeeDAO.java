package common.dao;

import common.domain.RecordTransitionfee;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage RecordTransitionfee entities.
 * 
 */
public interface RecordTransitionfeeDAO extends JpaDao<RecordTransitionfee> {

	/**
	 * JPQL Query - findRecordTransitionfeeByFee
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFee(java.math.BigDecimal fee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByFee
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFee(BigDecimal fee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByYear
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByYear(Integer year) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByYear
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByYear(Integer year, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByCreatedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByCreatedTime(java.util.Calendar createdTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByCreatedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByCreatedTime(Calendar createdTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllRecordTransitionfees
	 *
	 */
	public Set<RecordTransitionfee> findAllRecordTransitionfees() throws DataAccessException;

	/**
	 * JPQL Query - findAllRecordTransitionfees
	 *
	 */
	public Set<RecordTransitionfee> findAllRecordTransitionfees(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstEndTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstEndTime(java.util.Calendar firstEndTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstEndTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstEndTime(Calendar firstEndTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByEndTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByEndTime(java.util.Calendar endTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByEndTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByEndTime(Calendar endTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDealed
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDealed(Boolean isDealed) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDealed
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDealed(Boolean isDealed, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccountContaining
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccountContaining(String bankAccount) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccountContaining
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccountContaining(String bankAccount, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByTypeContaining
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByTypeContaining(String type) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByTypeContaining
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByTypeContaining(String type, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByStartTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByStartTime(java.util.Calendar startTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByStartTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByStartTime(Calendar startTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstFee
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstFee(java.math.BigDecimal firstFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstFee
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstFee(BigDecimal firstFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByType
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByType(String type_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByType
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByType(String type_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDeleted
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDeleted(Boolean isDeleted) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByIsDeleted
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByPrimaryKey
	 *
	 */
	public RecordTransitionfee findRecordTransitionfeeByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByPrimaryKey
	 *
	 */
	public RecordTransitionfee findRecordTransitionfeeByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByDeletedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByDeletedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByDeletedTime(Calendar deletedTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccount
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccount(String bankAccount_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByBankAccount
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByBankAccount(String bankAccount_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByDealedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByDealedTime(java.util.Calendar dealedTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByDealedTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByDealedTime(Calendar dealedTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstStartTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstStartTime(java.util.Calendar firstStartTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByFirstStartTime
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByFirstStartTime(Calendar firstStartTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByQuarter
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByQuarter(Integer quarter) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByQuarter
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByQuarter(Integer quarter, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeById
	 *
	 */
	public RecordTransitionfee findRecordTransitionfeeById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeById
	 *
	 */
	public RecordTransitionfee findRecordTransitionfeeById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByRemark
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByRemark(String remark) throws DataAccessException;

	/**
	 * JPQL Query - findRecordTransitionfeeByRemark
	 *
	 */
	public Set<RecordTransitionfee> findRecordTransitionfeeByRemark(String remark, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 * 查询
	 * @author liangcz
	 * @date   2018年3月9日 下午3:53:06
	 * @return void
	 */
	Calendar inquiryLastRecordFeeTime(Integer recordId);

}