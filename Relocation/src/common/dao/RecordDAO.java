package common.dao;

import common.domain.Record;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Record entities.
 * 
 */
public interface RecordDAO extends JpaDao<Record> {

	/**
	 * JPQL Query - findRecordByContractNumber
	 *
	 */
	public Set<Record> findRecordByContractNumber(String contractNumber) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByContractNumber
	 *
	 */
	public Set<Record> findRecordByContractNumber(String contractNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsEnd
	 *
	 */
	public Set<Record> findRecordByIsEnd(Boolean isEnd) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsEnd
	 *
	 */
	public Set<Record> findRecordByIsEnd(Boolean isEnd, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBalance1
	 *
	 */
	public Set<Record> findRecordByBalance1(java.math.BigDecimal balance1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBalance1
	 *
	 */
	public Set<Record> findRecordByBalance1(BigDecimal balance1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByRemark
	 *
	 */
	public Set<Record> findRecordByRemark(String remark) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByRemark
	 *
	 */
	public Set<Record> findRecordByRemark(String remark, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessArea
	 *
	 */
	public Set<Record> findRecordByBusinessArea(java.math.BigDecimal businessArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessArea
	 *
	 */
	public Set<Record> findRecordByBusinessArea(BigDecimal businessArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseridcard
	 *
	 */
	public Set<Record> findRecordByUseridcard(String useridcard) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseridcard
	 *
	 */
	public Set<Record> findRecordByUseridcard(String useridcard, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByRecordNumber
	 *
	 */
	public Set<Record> findRecordByRecordNumber(String recordNumber) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByRecordNumber
	 *
	 */
	public Set<Record> findRecordByRecordNumber(String recordNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveAmountContaining
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAmountContaining(String selfRemoveAmount) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveAmountContaining
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAmountContaining(String selfRemoveAmount, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackRoomContaining(String productionAreaBackRoom) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackRoomContaining(String productionAreaBackRoom, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByLastEditTime
	 *
	 */
	public Set<Record> findRecordByLastEditTime(java.util.Calendar lastEditTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByLastEditTime
	 *
	 */
	public Set<Record> findRecordByLastEditTime(Calendar lastEditTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByPrimaryKey
	 *
	 */
	public Record findRecordByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByPrimaryKey
	 *
	 */
	public Record findRecordByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByEndTime
	 *
	 */
	public Set<Record> findRecordByEndTime(java.util.Calendar endTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByEndTime
	 *
	 */
	public Set<Record> findRecordByEndTime(Calendar endTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByTransitionFee
	 *
	 */
	public Set<Record> findRecordByTransitionFee(java.math.BigDecimal transitionFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByTransitionFee
	 *
	 */
	public Set<Record> findRecordByTransitionFee(BigDecimal transitionFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackRoomContaining(String houseAreaBackRoom) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackRoomContaining(String houseAreaBackRoom, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByCoveredAreaBack
	 *
	 */
	public Set<Record> findRecordByCoveredAreaBack(java.math.BigDecimal coveredAreaBack) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByCoveredAreaBack
	 *
	 */
	public Set<Record> findRecordByCoveredAreaBack(BigDecimal coveredAreaBack, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackReturn(java.math.BigDecimal productionAreaBackReturn) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackReturn(BigDecimal productionAreaBackReturn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProjectName
	 *
	 */
	public Set<Record> findRecordByProjectName(String projectName) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProjectName
	 *
	 */
	public Set<Record> findRecordByProjectName(String projectName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByLastComputeTime
	 *
	 */
	public Set<Record> findRecordByLastComputeTime(java.util.Calendar lastComputeTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByLastComputeTime
	 *
	 */
	public Set<Record> findRecordByLastComputeTime(Calendar lastComputeTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsernameContaining
	 *
	 */
	public Set<Record> findRecordByUsernameContaining(String username) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsernameContaining
	 *
	 */
	public Set<Record> findRecordByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordById
	 *
	 */
	public Record findRecordById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordById
	 *
	 */
	public Record findRecordById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfSimplyArea
	 *
	 */
	public Set<Record> findRecordBySelfSimplyArea(String selfSimplyArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfSimplyArea
	 *
	 */
	public Set<Record> findRecordBySelfSimplyArea(String selfSimplyArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsername
	 *
	 */
	public Set<Record> findRecordByUsername(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsername
	 *
	 */
	public Set<Record> findRecordByUsername(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProjectNameContaining
	 *
	 */
	public Set<Record> findRecordByProjectNameContaining(String projectName_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProjectNameContaining
	 *
	 */
	public Set<Record> findRecordByProjectNameContaining(String projectName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByOtherFee
	 *
	 */
	public Set<Record> findRecordByOtherFee(java.math.BigDecimal otherFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByOtherFee
	 *
	 */
	public Set<Record> findRecordByOtherFee(BigDecimal otherFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseraddress
	 *
	 */
	public Set<Record> findRecordByUseraddress(String useraddress) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseraddress
	 *
	 */
	public Set<Record> findRecordByUseraddress(String useraddress, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseArea
	 *
	 */
	public Set<Record> findRecordByHouseArea(java.math.BigDecimal houseArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseArea
	 *
	 */
	public Set<Record> findRecordByHouseArea(BigDecimal houseArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackRoomContaining(String businessAreaBackRoom) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoomContaining
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackRoomContaining(String businessAreaBackRoom, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfSimplyAreaContaining
	 *
	 */
	public Set<Record> findRecordBySelfSimplyAreaContaining(String selfSimplyArea_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfSimplyAreaContaining
	 *
	 */
	public Set<Record> findRecordBySelfSimplyAreaContaining(String selfSimplyArea_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByDiscontinuedFee
	 *
	 */
	public Set<Record> findRecordByDiscontinuedFee(java.math.BigDecimal discontinuedFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByDiscontinuedFee
	 *
	 */
	public Set<Record> findRecordByDiscontinuedFee(BigDecimal discontinuedFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseraddressContaining
	 *
	 */
	public Set<Record> findRecordByUseraddressContaining(String useraddress_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseraddressContaining
	 *
	 */
	public Set<Record> findRecordByUseraddressContaining(String useraddress_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackReturn(java.math.BigDecimal houseAreaBackReturn) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackReturn(BigDecimal houseAreaBackReturn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveAmount
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAmount(String selfRemoveAmount_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveAmount
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAmount(String selfRemoveAmount_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByStartTime
	 *
	 */
	public Set<Record> findRecordByStartTime(java.util.Calendar startTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByStartTime
	 *
	 */
	public Set<Record> findRecordByStartTime(Calendar startTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByTotal
	 *
	 */
	public Set<Record> findRecordByTotal(java.math.BigDecimal total) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByTotal
	 *
	 */
	public Set<Record> findRecordByTotal(BigDecimal total, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByContractNumberContaining
	 *
	 */
	public Set<Record> findRecordByContractNumberContaining(String contractNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByContractNumberContaining
	 *
	 */
	public Set<Record> findRecordByContractNumberContaining(String contractNumber_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByRecordNumberContaining
	 *
	 */
	public Set<Record> findRecordByRecordNumberContaining(String recordNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByRecordNumberContaining
	 *
	 */
	public Set<Record> findRecordByRecordNumberContaining(String recordNumber_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBack
	 *
	 */
	public Set<Record> findRecordByProductionAreaBack(java.math.BigDecimal productionAreaBack) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBack
	 *
	 */
	public Set<Record> findRecordByProductionAreaBack(BigDecimal productionAreaBack, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfdemolitionFee
	 *
	 */
	public Set<Record> findRecordBySelfdemolitionFee(java.math.BigDecimal selfdemolitionFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfdemolitionFee
	 *
	 */
	public Set<Record> findRecordBySelfdemolitionFee(BigDecimal selfdemolitionFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsercontact
	 *
	 */
	public Set<Record> findRecordByUsercontact(String usercontact) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsercontact
	 *
	 */
	public Set<Record> findRecordByUsercontact(String usercontact, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBack
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBack(java.math.BigDecimal businessAreaBack) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBack
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBack(BigDecimal businessAreaBack, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByFacilityFee
	 *
	 */
	public Set<Record> findRecordByFacilityFee(java.math.BigDecimal facilityFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByFacilityFee
	 *
	 */
	public Set<Record> findRecordByFacilityFee(BigDecimal facilityFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBalanceDeal
	 *
	 */
	public Set<Record> findRecordByBalanceDeal(java.math.BigDecimal balanceDeal) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBalanceDeal
	 *
	 */
	public Set<Record> findRecordByBalanceDeal(BigDecimal balanceDeal, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBankAccountContaining
	 *
	 */
	public Set<Record> findRecordByBankAccountContaining(String bankAccount) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBankAccountContaining
	 *
	 */
	public Set<Record> findRecordByBankAccountContaining(String bankAccount, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByAwardFee
	 *
	 */
	public Set<Record> findRecordByAwardFee(java.math.BigDecimal awardFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByAwardFee
	 *
	 */
	public Set<Record> findRecordByAwardFee(BigDecimal awardFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByTransportFee
	 *
	 */
	public Set<Record> findRecordByTransportFee(java.math.BigDecimal transportFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByTransportFee
	 *
	 */
	public Set<Record> findRecordByTransportFee(BigDecimal transportFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByLastDealTime
	 *
	 */
	public Set<Record> findRecordByLastDealTime(java.util.Calendar lastDealTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByLastDealTime
	 *
	 */
	public Set<Record> findRecordByLastDealTime(Calendar lastDealTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBalance2
	 *
	 */
	public Set<Record> findRecordByBalance2(java.math.BigDecimal balance2) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBalance2
	 *
	 */
	public Set<Record> findRecordByBalance2(BigDecimal balance2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackRoom(String houseAreaBackRoom_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByHouseAreaBackRoom(String houseAreaBackRoom_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackRoom(String businessAreaBackRoom_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackRoom(String businessAreaBackRoom_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackReturn(java.math.BigDecimal businessAreaBackReturn) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBusinessAreaBackReturn
	 *
	 */
	public Set<Record> findRecordByBusinessAreaBackReturn(BigDecimal businessAreaBackReturn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsercontactContaining
	 *
	 */
	public Set<Record> findRecordByUsercontactContaining(String usercontact_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUsercontactContaining
	 *
	 */
	public Set<Record> findRecordByUsercontactContaining(String usercontact_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBankAccount
	 *
	 */
	public Set<Record> findRecordByBankAccount(String bankAccount_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByBankAccount
	 *
	 */
	public Set<Record> findRecordByBankAccount(String bankAccount_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByCreatedTime
	 *
	 */
	public Set<Record> findRecordByCreatedTime(java.util.Calendar createdTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByCreatedTime
	 *
	 */
	public Set<Record> findRecordByCreatedTime(Calendar createdTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBack
	 *
	 */
	public Set<Record> findRecordByHouseAreaBack(java.math.BigDecimal houseAreaBack) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByHouseAreaBack
	 *
	 */
	public Set<Record> findRecordByHouseAreaBack(BigDecimal houseAreaBack, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByCoveredArea
	 *
	 */
	public Set<Record> findRecordByCoveredArea(java.math.BigDecimal coveredArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByCoveredArea
	 *
	 */
	public Set<Record> findRecordByCoveredArea(BigDecimal coveredArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseridcardContaining
	 *
	 */
	public Set<Record> findRecordByUseridcardContaining(String useridcard_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByUseridcardContaining
	 *
	 */
	public Set<Record> findRecordByUseridcardContaining(String useridcard_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllRecords
	 *
	 */
	public Set<Record> findAllRecords() throws DataAccessException;

	/**
	 * JPQL Query - findAllRecords
	 *
	 */
	public Set<Record> findAllRecords(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaContaining
	 *
	 */
	public Set<Record> findRecordByProductionAreaContaining(String productionArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaContaining
	 *
	 */
	public Set<Record> findRecordByProductionAreaContaining(String productionArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveAreaContaining
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAreaContaining(String selfRemoveArea) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveAreaContaining
	 *
	 */
	public Set<Record> findRecordBySelfRemoveAreaContaining(String selfRemoveArea, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsDealed
	 *
	 */
	public Set<Record> findRecordByIsDealed(Boolean isDealed) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsDealed
	 *
	 */
	public Set<Record> findRecordByIsDealed(Boolean isDealed, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsDeleted
	 *
	 */
	public Set<Record> findRecordByIsDeleted(Boolean isDeleted) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsDeleted
	 *
	 */
	public Set<Record> findRecordByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsStart
	 *
	 */
	public Set<Record> findRecordByIsStart(Boolean isStart) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByIsStart
	 *
	 */
	public Set<Record> findRecordByIsStart(Boolean isStart, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackRoom(String productionAreaBackRoom_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionAreaBackRoom
	 *
	 */
	public Set<Record> findRecordByProductionAreaBackRoom(String productionAreaBackRoom_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByDeletedTime
	 *
	 */
	public Set<Record> findRecordByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByDeletedTime
	 *
	 */
	public Set<Record> findRecordByDeletedTime(Calendar deletedTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByStartDealTime
	 *
	 */
	public Set<Record> findRecordByStartDealTime(java.util.Calendar startDealTime) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByStartDealTime
	 *
	 */
	public Set<Record> findRecordByStartDealTime(Calendar startDealTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByMovingFee
	 *
	 */
	public Set<Record> findRecordByMovingFee(java.math.BigDecimal movingFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByMovingFee
	 *
	 */
	public Set<Record> findRecordByMovingFee(BigDecimal movingFee, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionArea
	 *
	 */
	public Set<Record> findRecordByProductionArea(String productionArea_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByProductionArea
	 *
	 */
	public Set<Record> findRecordByProductionArea(String productionArea_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveArea
	 *
	 */
	public Set<Record> findRecordBySelfRemoveArea(String selfRemoveArea_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecordBySelfRemoveArea
	 *
	 */
	public Set<Record> findRecordBySelfRemoveArea(String selfRemoveArea_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByPerFee
	 *
	 */
	public Set<Record> findRecordByPerFee(java.math.BigDecimal perFee) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByPerFee
	 *
	 */
	public Set<Record> findRecordByPerFee(BigDecimal perFee, int startResult, int maxRows) throws DataAccessException;
	/**
	 * JPQL Query - findRecordByReplaceFlag
	 *
	 */
	public Set<Record> findRecordByReplaceFlag(Integer replaceFlag) throws DataAccessException;

	/**
	 * JPQL Query - findRecordByReplaceFlag
	 *
	 */
	public Set<Record> findRecordByReplaceFlag(Integer replaceFlag, int startResult, int maxRows) throws DataAccessException;
	
	/**
	 *  查询该户是否已经有一百平米优惠享受的拆迁记录
	 * @param useridcard
	 * @return
	 * @throws DataAccessException
	 */
	public Set<Record> checkIfHadAreaBenefit100(String useridcard) throws DataAccessException;

	/**
	 * 查询拆迁记录
	 * @param projectName
	 * @param contractNumber
	 * @param recordNumber
	 * @return
	 */
	Record findRecord(String projectName, String contractNumber,
			String recordNumber);

	/**
	 *  删除record
	 * @param records
	 */
	void deleteRecord(List<Record> records);
	/**
	 * 查询最后计算过渡费的时间
	 * @author liangcz
	 * @date   2018年3月9日 下午3:49:20
	 * @return void
	 */
	Calendar inquiryLastCalTime(Integer recordId);
}