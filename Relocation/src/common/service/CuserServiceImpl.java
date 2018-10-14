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
 * Spring service that handles CRUD requests for Cuser entities
 * 
 */

@Service("CuserService")
public class CuserServiceImpl implements CuserService {

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
	 * Instantiates a new CuserServiceImpl.
	 *
	 */
	public CuserServiceImpl() {
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	public Cuser saveCuserRecords(Integer id, Record related_records) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(id, -1, -1);
		Record existingrecords = recordDAO.findRecordByPrimaryKey(related_records.getId());

		// copy into the existing record to preserve existing relationships
		if (existingrecords != null) {
			existingrecords.setId(related_records.getId());
			existingrecords.setProjectName(related_records.getProjectName());
			existingrecords.setUsername(related_records.getUsername());
			existingrecords.setUsercontact(related_records.getUsercontact());
			existingrecords.setUseraddress(related_records.getUseraddress());
			existingrecords.setUseridcard(related_records.getUseridcard());
			existingrecords.setContractNumber(related_records.getContractNumber());
			existingrecords.setRecordNumber(related_records.getRecordNumber());
			existingrecords.setCoveredArea(related_records.getCoveredArea());
			existingrecords.setCoveredAreaBack(related_records.getCoveredAreaBack());
			existingrecords.setHouseArea(related_records.getHouseArea());
			existingrecords.setHouseAreaBack(related_records.getHouseAreaBack());
			existingrecords.setHouseAreaBackRoom(related_records.getHouseAreaBackRoom());
			existingrecords.setBusinessArea(related_records.getBusinessArea());
			existingrecords.setBusinessAreaBack(related_records.getBusinessAreaBack());
			existingrecords.setBusinessAreaBackRoom(related_records.getBusinessAreaBackRoom());
			existingrecords.setProductionArea(related_records.getProductionArea());
			existingrecords.setProductionAreaBack(related_records.getProductionAreaBack());
			existingrecords.setProductionAreaBackRoom(related_records.getProductionAreaBackRoom());
			existingrecords.setBalance1(related_records.getBalance1());
			existingrecords.setBalance2(related_records.getBalance2());
			existingrecords.setSelfRemoveArea(related_records.getSelfRemoveArea());
			existingrecords.setSelfSimplyArea(related_records.getSelfSimplyArea());
			existingrecords.setSelfRemoveAmount(related_records.getSelfRemoveAmount());
			existingrecords.setRemark(related_records.getRemark());
			existingrecords.setCreatedTime(related_records.getCreatedTime());
			existingrecords.setLastEditTime(related_records.getLastEditTime());
			existingrecords.setDeletedTime(related_records.getDeletedTime());
			existingrecords.setIsDeleted(related_records.getIsDeleted());
			related_records = existingrecords;
		} else {
			related_records = recordDAO.store(related_records);
			recordDAO.flush();
		}

		related_records.setCuser(cuser);
		cuser.getRecords().add(related_records);
		related_records = recordDAO.store(related_records);
		recordDAO.flush();

		cuser = cuserDAO.store(cuser);
		cuserDAO.flush();

		return cuser;
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	public void saveCuser(Cuser cuser) {
		Cuser existingCuser = cuserDAO.findCuserByPrimaryKey(cuser.getId());

		if (existingCuser != null) {
			if (existingCuser != cuser) {
				existingCuser.setId(cuser.getId());
				existingCuser.setUsername(cuser.getUsername());
				existingCuser.setPassword(cuser.getPassword());
				existingCuser.setSalt(cuser.getSalt());
				existingCuser.setPhone(cuser.getPhone());
				existingCuser.setEmail(cuser.getEmail());
				existingCuser.setUsertype(cuser.getUsertype());
				existingCuser.setGender(cuser.getGender());
				existingCuser.setNickname(cuser.getNickname());
				existingCuser.setAddress(cuser.getAddress());
				existingCuser.setPhoto(cuser.getPhoto());
				existingCuser.setQxdm(cuser.getQxdm());
				existingCuser.setQxmc(cuser.getQxmc());
				existingCuser.setDepartment(cuser.getDepartment());
				existingCuser.setLogintime(cuser.getLogintime());
				existingCuser.setLoginip(cuser.getLoginip());
				existingCuser.setLogintoken(cuser.getLogintoken());
				existingCuser.setCheckStatus(cuser.getCheckStatus());
				existingCuser.setRegip(cuser.getRegip());
				existingCuser.setCreatedtime(cuser.getCreatedtime());
				existingCuser.setIsDeleted(cuser.getIsDeleted());
			}
			cuser = cuserDAO.store(existingCuser);
		} else {
			cuser = cuserDAO.store(cuser);
		}
		cuserDAO.flush();
	}

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	public Cuser saveCuserRecordTransitionfees(Integer id, RecordTransitionfee related_recordtransitionfees) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(id, -1, -1);
		RecordTransitionfee existingrecordTransitionfees = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(related_recordtransitionfees.getId());

		// copy into the existing record to preserve existing relationships
		if (existingrecordTransitionfees != null) {
			existingrecordTransitionfees.setId(related_recordtransitionfees.getId());
			existingrecordTransitionfees.setType(related_recordtransitionfees.getType());
			existingrecordTransitionfees.setFirstStartTime(related_recordtransitionfees.getFirstStartTime());
			existingrecordTransitionfees.setFirstEndTime(related_recordtransitionfees.getFirstEndTime());
			existingrecordTransitionfees.setFirstFee(related_recordtransitionfees.getFirstFee());
			existingrecordTransitionfees.setStartTime(related_recordtransitionfees.getStartTime());
			existingrecordTransitionfees.setEndTime(related_recordtransitionfees.getEndTime());
			existingrecordTransitionfees.setYear(related_recordtransitionfees.getYear());
			existingrecordTransitionfees.setQuarter(related_recordtransitionfees.getQuarter());
			existingrecordTransitionfees.setFee(related_recordtransitionfees.getFee());
			existingrecordTransitionfees.setBankAccount(related_recordtransitionfees.getBankAccount());
			existingrecordTransitionfees.setRemark(related_recordtransitionfees.getRemark());
			existingrecordTransitionfees.setCreatedTime(related_recordtransitionfees.getCreatedTime());
			existingrecordTransitionfees.setDealedTime(related_recordtransitionfees.getDealedTime());
			existingrecordTransitionfees.setIsDealed(related_recordtransitionfees.getIsDealed());
			existingrecordTransitionfees.setDeletedTime(related_recordtransitionfees.getDeletedTime());
			existingrecordTransitionfees.setIsDeleted(related_recordtransitionfees.getIsDeleted());
			related_recordtransitionfees = existingrecordTransitionfees;
		} else {
			related_recordtransitionfees = recordTransitionfeeDAO.store(related_recordtransitionfees);
			recordTransitionfeeDAO.flush();
		}

		related_recordtransitionfees.setCuser(cuser);
		cuser.getRecordTransitionfees().add(related_recordtransitionfees);
		related_recordtransitionfees = recordTransitionfeeDAO.store(related_recordtransitionfees);
		recordTransitionfeeDAO.flush();

		cuser = cuserDAO.store(cuser);
		cuserDAO.flush();

		return cuser;
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public Cuser deleteCuserRecords(Integer cuser_id, Integer related_records_id) {
		Record related_records = recordDAO.findRecordByPrimaryKey(related_records_id, -1, -1);

		Cuser cuser = cuserDAO.findCuserByPrimaryKey(cuser_id, -1, -1);

		related_records.setCuser(null);
		cuser.getRecords().remove(related_records);

		recordDAO.remove(related_records);
		recordDAO.flush();

		return cuser;
	}

	/**
	 * Load an existing Cuser entity
	 * 
	 */
	public Set<Cuser> loadCusers() {
		return cuserDAO.findAllCusers();
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	public Cuser deleteCuserRecordTransitionfees(Integer cuser_id, Integer related_recordtransitionfees_id) {
		RecordTransitionfee related_recordtransitionfees = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(related_recordtransitionfees_id, -1, -1);

		Cuser cuser = cuserDAO.findCuserByPrimaryKey(cuser_id, -1, -1);

		related_recordtransitionfees.setCuser(null);
		cuser.getRecordTransitionfees().remove(related_recordtransitionfees);

		recordTransitionfeeDAO.remove(related_recordtransitionfees);
		recordTransitionfeeDAO.flush();

		return cuser;
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	public void deleteCuser(Cuser cuser) {
		cuserDAO.remove(cuser);
		cuserDAO.flush();
	}

	/**
	 * Return a count of all Cuser entity
	 * 
	 */
	public Integer countCusers() {
		return ((Long) cuserDAO.createQuerySingleResult("select count(o) from Cuser o").getSingleResult()).intValue();
	}

	/**
	 * Return all Cuser entity
	 * 
	 */
	public List<Cuser> findAllCusers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Cuser>(cuserDAO.findAllCusers(startResult, maxRows));
	}

	/**
	 */
	public Cuser findCuserByPrimaryKey(Integer id) {
		return cuserDAO.findCuserByPrimaryKey(id);
	}
}
