package common.service;

import common.dao.CuserDAO;
import common.dao.ProjectDAO;
import common.dao.RecordDAO;

import common.dao.RecordTransitionfeeDAO;
import common.domain.Cuser;
import common.domain.Project;
import common.domain.Record;

import common.domain.RecordTransitionfee;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Record entities
 * 
 */

@Service("RecordService")
public class RecordServiceImpl implements RecordService {

	/**
	 * DAO injected by Spring that manages Cuser entities
	 * 
	 */
	@Autowired
	private CuserDAO cuserDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

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
	 * Instantiates a new RecordServiceImpl.
	 *
	 */
	public RecordServiceImpl() {
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Record deleteRecordProject(Integer record_id, Integer related_project_id) {
		Record record = recordDAO.findRecordByPrimaryKey(record_id, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_id, -1, -1);

		record.setProject(null);
		related_project.getRecords().remove(record);
		record = recordDAO.store(record);
		recordDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return record;
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	public Record saveRecordCuser(Integer id, Cuser related_cuser) {
		Record record = recordDAO.findRecordByPrimaryKey(id, -1, -1);
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

		record.setCuser(related_cuser);
		related_cuser.getRecords().add(record);
		record = recordDAO.store(record);
		recordDAO.flush();

		related_cuser = cuserDAO.store(related_cuser);
		cuserDAO.flush();

		return record;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Record saveRecordProject(Integer id, Project related_project) {
		Record record = recordDAO.findRecordByPrimaryKey(id, -1, -1);
		Project existingproject = projectDAO.findProjectByPrimaryKey(related_project.getId());

		// copy into the existing record to preserve existing relationships
		if (existingproject != null) {
			existingproject.setId(related_project.getId());
			existingproject.setName(related_project.getName());
			existingproject.setIsDeleted(related_project.getIsDeleted());
			related_project = existingproject;
		} else {
			related_project = projectDAO.store(related_project);
			projectDAO.flush();
		}

		record.setProject(related_project);
		related_project.getRecords().add(record);
		record = recordDAO.store(record);
		recordDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return record;
	}

	/**
	 * Return a count of all Record entity
	 * 
	 */
	public Integer countRecords() {
		return ((Long) recordDAO.createQuerySingleResult("select count(o) from Record o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Record entity
	 * 
	 */
	public Set<Record> loadRecords() {
		return recordDAO.findAllRecords();
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	public void saveRecord(Record record) {
		Record existingRecord = recordDAO.findRecordByPrimaryKey(record.getId());

		if (existingRecord != null) {
			if (existingRecord != record) {
				existingRecord.setId(record.getId());
				existingRecord.setProjectName(record.getProjectName());
				existingRecord.setUsername(record.getUsername());
				existingRecord.setUsercontact(record.getUsercontact());
				existingRecord.setUseraddress(record.getUseraddress());
				existingRecord.setUseridcard(record.getUseridcard());
				existingRecord.setContractNumber(record.getContractNumber());
				existingRecord.setRecordNumber(record.getRecordNumber());
				existingRecord.setCoveredArea(record.getCoveredArea());
				existingRecord.setCoveredAreaBack(record.getCoveredAreaBack());
				existingRecord.setHouseArea(record.getHouseArea());
				existingRecord.setHouseAreaBack(record.getHouseAreaBack());
				existingRecord.setHouseAreaBackRoom(record.getHouseAreaBackRoom());
				existingRecord.setBusinessArea(record.getBusinessArea());
				existingRecord.setBusinessAreaBack(record.getBusinessAreaBack());
				existingRecord.setBusinessAreaBackRoom(record.getBusinessAreaBackRoom());
				existingRecord.setProductionArea(record.getProductionArea());
				existingRecord.setProductionAreaBack(record.getProductionAreaBack());
				existingRecord.setProductionAreaBackRoom(record.getProductionAreaBackRoom());
				existingRecord.setBalance1(record.getBalance1());
				existingRecord.setBalance2(record.getBalance2());
				existingRecord.setSelfRemoveArea(record.getSelfRemoveArea());
				existingRecord.setSelfSimplyArea(record.getSelfSimplyArea());
				existingRecord.setSelfRemoveAmount(record.getSelfRemoveAmount());
				existingRecord.setRemark(record.getRemark());
				existingRecord.setCreatedTime(record.getCreatedTime());
				existingRecord.setLastEditTime(record.getLastEditTime());
				existingRecord.setDeletedTime(record.getDeletedTime());
				existingRecord.setIsDeleted(record.getIsDeleted());
			}
			record = recordDAO.store(existingRecord);
		} else {
			record = recordDAO.store(record);
		}
		recordDAO.flush();
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	public Record deleteRecordRecordTransitionfees(Integer record_id, Integer related_recordtransitionfees_id) {
		RecordTransitionfee related_recordtransitionfees = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(related_recordtransitionfees_id, -1, -1);

		Record record = recordDAO.findRecordByPrimaryKey(record_id, -1, -1);

		related_recordtransitionfees.setRecord(null);
		record.getRecordTransitionfees().remove(related_recordtransitionfees);

		recordTransitionfeeDAO.remove(related_recordtransitionfees);
		recordTransitionfeeDAO.flush();

		return record;
	}

	/**
	 * Return all Record entity
	 * 
	 */
	public List<Record> findAllRecords(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Record>(recordDAO.findAllRecords(startResult, maxRows));
	}

	/**
	 */
	public Record findRecordByPrimaryKey(Integer id) {
		return recordDAO.findRecordByPrimaryKey(id);
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	public Record deleteRecordCuser(Integer record_id, Integer related_cuser_id) {
		Record record = recordDAO.findRecordByPrimaryKey(record_id, -1, -1);
		Cuser related_cuser = cuserDAO.findCuserByPrimaryKey(related_cuser_id, -1, -1);

		record.setCuser(null);
		related_cuser.getRecords().remove(record);
		record = recordDAO.store(record);
		recordDAO.flush();

		related_cuser = cuserDAO.store(related_cuser);
		cuserDAO.flush();

		cuserDAO.remove(related_cuser);
		cuserDAO.flush();

		return record;
	}

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	public Record saveRecordRecordTransitionfees(Integer id, RecordTransitionfee related_recordtransitionfees) {
		Record record = recordDAO.findRecordByPrimaryKey(id, -1, -1);
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

		related_recordtransitionfees.setRecord(record);
		record.getRecordTransitionfees().add(related_recordtransitionfees);
		related_recordtransitionfees = recordTransitionfeeDAO.store(related_recordtransitionfees);
		recordTransitionfeeDAO.flush();

		record = recordDAO.store(record);
		recordDAO.flush();

		return record;
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public void deleteRecord(Record record) {
		recordDAO.remove(record);
		recordDAO.flush();
	}
}
