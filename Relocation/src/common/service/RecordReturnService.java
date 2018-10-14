package common.service;

import common.domain.RecordReturn;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for RecordReturn entities
 * 
 */
public interface RecordReturnService {

	/**
	 * Save an existing RecordReturn entity
	 * 
	 */
	public void saveRecordReturn(RecordReturn recordreturn);

	/**
	 * Delete an existing RecordReturn entity
	 * 
	 */
	public void deleteRecordReturn(RecordReturn recordreturn_1);

	/**
	 * Return all RecordReturn entity
	 * 
	 */
	public List<RecordReturn> findAllRecordReturns(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all RecordReturn entity
	 * 
	 */
	public Integer countRecordReturns();

	/**
	 */
	public RecordReturn findRecordReturnByPrimaryKey(Integer id);

	/**
	 * Load an existing RecordReturn entity
	 * 
	 */
	public Set<RecordReturn> loadRecordReturns();
}