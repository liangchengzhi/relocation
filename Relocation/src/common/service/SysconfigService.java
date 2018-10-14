package common.service;

import common.domain.Sysconfig;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Sysconfig entities
 * 
 */
public interface SysconfigService {

	/**
	 * Load an existing Sysconfig entity
	 * 
	 */
	public Set<Sysconfig> loadSysconfigs();

	/**
	 * Save an existing Sysconfig entity
	 * 
	 */
	public void saveSysconfig(Sysconfig sysconfig);

	/**
	 * Return all Sysconfig entity
	 * 
	 */
	public List<Sysconfig> findAllSysconfigs(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Sysconfig entity
	 * 
	 */
	public Integer countSysconfigs();

	/**
	 * Delete an existing Sysconfig entity
	 * 
	 */
	public void deleteSysconfig(Sysconfig sysconfig_1);

	/**
	 */
	public Sysconfig findSysconfigByPrimaryKey(String id);
}