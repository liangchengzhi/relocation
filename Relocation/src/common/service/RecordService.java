package common.service;

import common.domain.Cuser;
import common.domain.Project;
import common.domain.Record;

import common.domain.RecordTransitionfee;
import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Record entities
 * 
 */
public interface RecordService {

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Record deleteRecordProject(Integer record_id, Integer related_project_id);

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	public Record saveRecordCuser(Integer id, Cuser related_cuser);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Record saveRecordProject(Integer id_1, Project related_project);

	/**
	 * Return a count of all Record entity
	 * 
	 */
	public Integer countRecords();

	/**
	 * Load an existing Record entity
	 * 
	 */
	public Set<Record> loadRecords();

	/**
	 * Save an existing Record entity
	 * 
	 */
	public void saveRecord(Record record);

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	public Record deleteRecordRecordTransitionfees(Integer record_id_2, Integer related_recordtransitionfees_id);

	/**
	 * Return all Record entity
	 * 
	 */
	public List<Record> findAllRecords(Integer startResult, Integer maxRows);

	/**
	 */
	public Record findRecordByPrimaryKey(Integer id_2);

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	public Record deleteRecordCuser(Integer record_id_1, Integer related_cuser_id);

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	public Record saveRecordRecordTransitionfees(Integer id_1, RecordTransitionfee related_recordtransitionfees);

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public void deleteRecord(Record record_1);
}