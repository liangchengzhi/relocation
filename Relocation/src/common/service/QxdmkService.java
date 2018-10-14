package common.service;

import common.domain.Qxdmk;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Qxdmk entities
 * 
 */
public interface QxdmkService {

	/**
	 * Save an existing Qxdmk entity
	 * 
	 */
	public void saveQxdmk(Qxdmk qxdmk);

	/**
	 * Load an existing Qxdmk entity
	 * 
	 */
	public Set<Qxdmk> loadQxdmks();

	/**
	 * Delete an existing Qxdmk entity
	 * 
	 */
	public void deleteQxdmk(Qxdmk qxdmk_1);

	/**
	 * Return all Qxdmk entity
	 * 
	 */
	public List<Qxdmk> findAllQxdmks(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Qxdmk entity
	 * 
	 */
	public Integer countQxdmks();

	/**
	 */
	public Qxdmk findQxdmkByPrimaryKey(String qxdm);
}