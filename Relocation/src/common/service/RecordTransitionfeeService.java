package common.service;

import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for RecordTransitionfee entities
 * 
 */
public interface RecordTransitionfeeService {

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public RecordTransitionfee deleteRecordTransitionfeeRecord(Integer recordtransitionfee_id, Integer related_record_id);

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	public void deleteRecordTransitionfee(RecordTransitionfee recordtransitionfee);

	/**
	 */
	public RecordTransitionfee findRecordTransitionfeeByPrimaryKey(Integer id);

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	public void saveRecordTransitionfee(RecordTransitionfee recordtransitionfee_1);

	/**
	 * Return a count of all RecordTransitionfee entity
	 * 
	 */
	public Integer countRecordTransitionfees();

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	public RecordTransitionfee deleteRecordTransitionfeeCuser(Integer recordtransitionfee_id_1, Integer related_cuser_id);

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	public RecordTransitionfee saveRecordTransitionfeeCuser(Integer id_1, Cuser related_cuser);

	/**
	 * Return all RecordTransitionfee entity
	 * 
	 */
	public List<RecordTransitionfee> findAllRecordTransitionfees(Integer startResult, Integer maxRows);

	/**
	 * Load an existing RecordTransitionfee entity
	 * 
	 */
	public Set<RecordTransitionfee> loadRecordTransitionfees();

	/**
	 * Save an existing Record entity
	 * 
	 */
	public RecordTransitionfee saveRecordTransitionfeeRecord(Integer id_2, Record related_record);
}