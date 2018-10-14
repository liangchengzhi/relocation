package common.service;

import common.domain.Cuser;
import common.domain.Record;

import common.domain.RecordTransitionfee;
import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Cuser entities
 * 
 */
public interface CuserService {

	/**
	 * Save an existing Record entity
	 * 
	 */
	public Cuser saveCuserRecords(Integer id, Record related_records);

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	public void saveCuser(Cuser cuser);

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	public Cuser saveCuserRecordTransitionfees(Integer id_1, RecordTransitionfee related_recordtransitionfees);

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public Cuser deleteCuserRecords(Integer cuser_id, Integer related_records_id);

	/**
	 * Load an existing Cuser entity
	 * 
	 */
	public Set<Cuser> loadCusers();

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	public Cuser deleteCuserRecordTransitionfees(Integer cuser_id_1, Integer related_recordtransitionfees_id);

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	public void deleteCuser(Cuser cuser_1);

	/**
	 * Return a count of all Cuser entity
	 * 
	 */
	public Integer countCusers();

	/**
	 * Return all Cuser entity
	 * 
	 */
	public List<Cuser> findAllCusers(Integer startResult, Integer maxRows);

	/**
	 */
	public Cuser findCuserByPrimaryKey(Integer id_1);
}