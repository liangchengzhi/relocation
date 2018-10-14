package common.service;

import common.domain.Sendsms;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Sendsms entities
 * 
 */
public interface SendsmsService {

	/**
	 */
	public Sendsms findSendsmsByPrimaryKey(Integer id);

	/**
	 * Delete an existing Sendsms entity
	 * 
	 */
	public void deleteSendsms(Sendsms sendsms);

	/**
	 * Load an existing Sendsms entity
	 * 
	 */
	public Set<Sendsms> loadSendsmss();

	/**
	 * Return a count of all Sendsms entity
	 * 
	 */
	public Integer countSendsmss();

	/**
	 * Save an existing Sendsms entity
	 * 
	 */
	public void saveSendsms(Sendsms sendsms_1);

	/**
	 * Return all Sendsms entity
	 * 
	 */
	public List<Sendsms> findAllSendsmss(Integer startResult, Integer maxRows);
}