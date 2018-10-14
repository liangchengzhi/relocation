package common.service;

import common.dao.CuserDAO;
import common.dao.RecordDAO;
import common.dao.RecordTransitionfeeDAO;

import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for RecordTransitionfee entities
 * 
 */

@Service("RecordTransitionfeeService")
public class RecordTransitionfeeServiceImpl implements
		RecordTransitionfeeService {

	/**
	 * DAO injected by Spring that manages Cuser entities
	 * 
	 */
	@Autowired
	private CuserDAO cuserDAO;

	/**
	 * DAO injected by Spring that manages Record entities
	 * 
	 */
	@Autowired
	private RecordDAO recordDAO;

	/**
	 * DAO injected by Spring that manages RecordTransitionfee entities
	 * 
	 */
	@Autowired
	private RecordTransitionfeeDAO recordTransitionfeeDAO;

	/**
	 * Instantiates a new RecordTransitionfeeServiceImpl.
	 *
	 */
	public RecordTransitionfeeServiceImpl() {
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public RecordTransitionfee deleteRecordTransitionfeeRecord(Integer recordtransitionfee_id, Integer related_record_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee_id, -1, -1);
		Record related_record = recordDAO.findRecordByPrimaryKey(related_record_id, -1, -1);

		recordtransitionfee.setRecord(null);
		related_record.getRecordTransitionfees().remove(recordtransitionfee);
		recordtransitionfee = recordTransitionfeeDAO.store(recordtransitionfee);
		recordTransitionfeeDAO.flush();

		related_record = recordDAO.store(related_record);
		recordDAO.flush();

		recordDAO.remove(related_record);
		recordDAO.flush();

		return recordtransitionfee;
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	public void deleteRecordTransitionfee(RecordTransitionfee recordtransitionfee) {
		recordTransitionfeeDAO.remove(recordtransitionfee);
		recordTransitionfeeDAO.flush();
	}

	/**
	 */
	public RecordTransitionfee findRecordTransitionfeeByPrimaryKey(Integer id) {
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(id);
	}

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	public void saveRecordTransitionfee(RecordTransitionfee recordtransitionfee) {
		RecordTransitionfee existingRecordTransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee.getId());

		if (existingRecordTransitionfee != null) {
			if (existingRecordTransitionfee != recordtransitionfee) {
				existingRecordTransitionfee.setId(recordtransitionfee.getId());
				existingRecordTransitionfee.setType(recordtransitionfee.getType());
				existingRecordTransitionfee.setFirstStartTime(recordtransitionfee.getFirstStartTime());
				existingRecordTransitionfee.setFirstEndTime(recordtransitionfee.getFirstEndTime());
				existingRecordTransitionfee.setFirstFee(recordtransitionfee.getFirstFee());
				existingRecordTransitionfee.setStartTime(recordtransitionfee.getStartTime());
				existingRecordTransitionfee.setEndTime(recordtransitionfee.getEndTime());
				existingRecordTransitionfee.setYear(recordtransitionfee.getYear());
				existingRecordTransitionfee.setQuarter(recordtransitionfee.getQuarter());
				existingRecordTransitionfee.setFee(recordtransitionfee.getFee());
				existingRecordTransitionfee.setBankAccount(recordtransitionfee.getBankAccount());
				existingRecordTransitionfee.setRemark(recordtransitionfee.getRemark());
				existingRecordTransitionfee.setCreatedTime(recordtransitionfee.getCreatedTime());
				existingRecordTransitionfee.setDealedTime(recordtransitionfee.getDealedTime());
				existingRecordTransitionfee.setIsDealed(recordtransitionfee.getIsDealed());
				existingRecordTransitionfee.setDeletedTime(recordtransitionfee.getDeletedTime());
				existingRecordTransitionfee.setIsDeleted(recordtransitionfee.getIsDeleted());
			}
			recordtransitionfee = recordTransitionfeeDAO.store(existingRecordTransitionfee);
		} else {
			recordtransitionfee = recordTransitionfeeDAO.store(recordtransitionfee);
		}
		recordTransitionfeeDAO.flush();
	}

	/**
	 * Return a count of all RecordTransitionfee entity
	 * 
	 */
	public Integer countRecordTransitionfees() {
		return ((Long) recordTransitionfeeDAO.createQuerySingleResult("select count(o) from RecordTransitionfee o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	public RecordTransitionfee deleteRecordTransitionfeeCuser(Integer recordtransitionfee_id, Integer related_cuser_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee_id, -1, -1);
		Cuser related_cuser = cuserDAO.findCuserByPrimaryKey(related_cuser_id, -1, -1);

		recordtransitionfee.setCuser(null);
		related_cuser.getRecordTransitionfees().remove(recordtransitionfee);
		recordtransitionfee = recordTransitionfeeDAO.store(recordtransitionfee);
		recordTransitionfeeDAO.flush();

		related_cuser = cuserDAO.store(related_cuser);
		cuserDAO.flush();

		cuserDAO.remove(related_cuser);
		cuserDAO.flush();

		return recordtransitionfee;
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	public RecordTransitionfee saveRecordTransitionfeeCuser(Integer id, Cuser related_cuser) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(id, -1, -1);
		Cuser existingcuser = cuserDAO.findCuserByPrimaryKey(related_cuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingcuser != null) {
			existingcuser.setId(related_cuser.getId());
			existingcuser.setUsername(related_cuser.getUsername());
			existingcuser.setPassword(related_cuser.getPassword());
			existingcuser.setSalt(related_cuser.getSalt());
			existingcuser.setPhone(related_cuser.getPhone());
			existingcuser.setEmail(related_cuser.getEmail());
			existingcuser.setUsertype(related_cuser.getUsertype());
			existingcuser.setGender(related_cuser.getGender());
			existingcuser.setNickname(related_cuser.getNickname());
			existingcuser.setAddress(related_cuser.getAddress());
			existingcuser.setPhoto(related_cuser.getPhoto());
			existingcuser.setQxdm(related_cuser.getQxdm());
			existingcuser.setQxmc(related_cuser.getQxmc());
			existingcuser.setDepartment(related_cuser.getDepartment());
			existingcuser.setLogintime(related_cuser.getLogintime());
			existingcuser.setLoginip(related_cuser.getLoginip());
			existingcuser.setLogintoken(related_cuser.getLogintoken());
			existingcuser.setCheckStatus(related_cuser.getCheckStatus());
			existingcuser.setRegip(related_cuser.getRegip());
			existingcuser.setCreatedtime(related_cuser.getCreatedtime());
			existingcuser.setIsDeleted(related_cuser.getIsDeleted());
			related_cuser = existingcuser;
		} else {
			related_cuser = cuserDAO.store(related_cuser);
			cuserDAO.flush();
		}

		recordtransitionfee.setCuser(related_cuser);
		related_cuser.getRecordTransitionfees().add(recordtransitionfee);
		recordtransitionfee = recordTransitionfeeDAO.store(recordtransitionfee);
		recordTransitionfeeDAO.flush();

		related_cuser = cuserDAO.store(related_cuser);
		cuserDAO.flush();

		return recordtransitionfee;
	}

	/**
	 * Return all RecordTransitionfee entity
	 * 
	 */
	public List<RecordTransitionfee> findAllRecordTransitionfees(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<RecordTransitionfee>(recordTransitionfeeDAO.findAllRecordTransitionfees(startResult, maxRows));
	}

	/**
	 * Load an existing RecordTransitionfee entity
	 * 
	 */
	public Set<RecordTransitionfee> loadRecordTransitionfees() {
		return recordTransitionfeeDAO.findAllRecordTransitionfees();
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	public RecordTransitionfee saveRecordTransitionfeeRecord(Integer id, Record related_record) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(id, -1, -1);
		Record existingrecord = recordDAO.findRecordByPrimaryKey(related_record.getId());

		// copy into the existing record to preserve existing relationships
		if (existingrecord != null) {
			existingrecord.setId(related_record.getId());
			existingrecord.setProjectName(related_record.getProjectName());
			existingrecord.setUsername(related_record.getUsername());
			existingrecord.setUsercontact(related_record.getUsercontact());
			existingrecord.setUseraddress(related_record.getUseraddress());
			existingrecord.setUseridcard(related_record.getUseridcard());
			existingrecord.setContractNumber(related_record.getContractNumber());
			existingrecord.setRecordNumber(related_record.getRecordNumber());
			existingrecord.setCoveredArea(related_record.getCoveredArea());
			existingrecord.setCoveredAreaBack(related_record.getCoveredAreaBack());
			existingrecord.setHouseArea(related_record.getHouseArea());
			existingrecord.setHouseAreaBack(related_record.getHouseAreaBack());
			existingrecord.setHouseAreaBackReturn(related_record.getHouseAreaBackReturn());
			existingrecord.setHouseAreaBackRoom(related_record.getHouseAreaBackRoom());
			existingrecord.setBusinessArea(related_record.getBusinessArea());
			existingrecord.setBusinessAreaBack(related_record.getBusinessAreaBack());
			existingrecord.setBusinessAreaBackReturn(related_record.getBusinessAreaBackReturn());
			existingrecord.setBusinessAreaBackRoom(related_record.getBusinessAreaBackRoom());
			existingrecord.setProductionArea(related_record.getProductionArea());
			existingrecord.setProductionAreaBack(related_record.getProductionAreaBack());
			existingrecord.setProductionAreaBackReturn(related_record.getProductionAreaBackReturn());
			existingrecord.setProductionAreaBackRoom(related_record.getProductionAreaBackRoom());
			existingrecord.setBalance1(related_record.getBalance1());
			existingrecord.setBalance2(related_record.getBalance2());
			existingrecord.setBalanceDeal(related_record.getBalanceDeal());
			existingrecord.setBankAccount(related_record.getBankAccount());
			existingrecord.setSelfRemoveArea(related_record.getSelfRemoveArea());
			existingrecord.setSelfSimplyArea(related_record.getSelfSimplyArea());
			existingrecord.setSelfRemoveAmount(related_record.getSelfRemoveAmount());
			existingrecord.setStartDealTime(related_record.getStartDealTime());
			existingrecord.setLastDealTime(related_record.getLastDealTime());
			existingrecord.setIsDealed(related_record.getIsDealed());
			existingrecord.setRemark(related_record.getRemark());
			existingrecord.setStartTime(related_record.getStartTime());
			existingrecord.setEndTime(related_record.getEndTime());
			existingrecord.setIsStart(related_record.getIsStart());
			existingrecord.setIsEnd(related_record.getIsEnd());
			existingrecord.setCreatedTime(related_record.getCreatedTime());
			existingrecord.setLastEditTime(related_record.getLastEditTime());
			existingrecord.setDeletedTime(related_record.getDeletedTime());
			existingrecord.setIsDeleted(related_record.getIsDeleted());
			existingrecord.setFacilityFee(related_record.getFacilityFee());
			existingrecord.setTransportFee(related_record.getTransportFee());
			existingrecord.setTransitionFee(related_record.getTransitionFee());
			existingrecord.setMovingFee(related_record.getMovingFee());
			existingrecord.setAwardFee(related_record.getAwardFee());
			existingrecord.setDiscontinuedFee(related_record.getDiscontinuedFee());
			existingrecord.setSelfdemolitionFee(related_record.getSelfdemolitionFee());
			existingrecord.setOtherFee(related_record.getOtherFee());
			existingrecord.setTotal(related_record.getTotal());
			existingrecord.setPerFee(related_record.getPerFee());
			existingrecord.setLastComputeTime(related_record.getLastComputeTime());
			related_record = existingrecord;
		} else {
			related_record = recordDAO.store(related_record);
			recordDAO.flush();
		}

		recordtransitionfee.setRecord(related_record);
		related_record.getRecordTransitionfees().add(recordtransitionfee);
		recordtransitionfee = recordTransitionfeeDAO.store(recordtransitionfee);
		recordTransitionfeeDAO.flush();

		related_record = recordDAO.store(related_record);
		recordDAO.flush();

		return recordtransitionfee;
	}
}
