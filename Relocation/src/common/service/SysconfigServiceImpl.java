package common.service;

import common.dao.SysconfigDAO;

import common.domain.Sysconfig;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Sysconfig entities
 * 
 */

@Service("SysconfigService")
public class SysconfigServiceImpl implements SysconfigService {

	/**
	 * DAO injected by Spring that manages Sysconfig entities
	 * 
	 */
	@Autowired
	private SysconfigDAO sysconfigDAO;

	/**
	 * Instantiates a new SysconfigServiceImpl.
	 *
	 */
	public SysconfigServiceImpl() {
	}

	/**
	 * Load an existing Sysconfig entity
	 * 
	 */
	public Set<Sysconfig> loadSysconfigs() {
		return sysconfigDAO.findAllSysconfigs();
	}

	/**
	 * Save an existing Sysconfig entity
	 * 
	 */
	public void saveSysconfig(Sysconfig sysconfig) {
		Sysconfig existingSysconfig = sysconfigDAO.findSysconfigByPrimaryKey(sysconfig.getId());

		if (existingSysconfig != null) {
			if (existingSysconfig != sysconfig) {
				existingSysconfig.setId(sysconfig.getId());
				existingSysconfig.setValue(sysconfig.getValue());
				existingSysconfig.setDescription(sysconfig.getDescription());
			}
			sysconfig = sysconfigDAO.store(existingSysconfig);
		} else {
			sysconfig = sysconfigDAO.store(sysconfig);
		}
		sysconfigDAO.flush();
	}

	/**
	 * Return all Sysconfig entity
	 * 
	 */
	public List<Sysconfig> findAllSysconfigs(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Sysconfig>(sysconfigDAO.findAllSysconfigs(startResult, maxRows));
	}

	/**
	 * Return a count of all Sysconfig entity
	 * 
	 */
	public Integer countSysconfigs() {
		return ((Long) sysconfigDAO.createQuerySingleResult("select count(o) from Sysconfig o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Sysconfig entity
	 * 
	 */
	public void deleteSysconfig(Sysconfig sysconfig) {
		sysconfigDAO.remove(sysconfig);
		sysconfigDAO.flush();
	}

	/**
	 */
	public Sysconfig findSysconfigByPrimaryKey(String id) {
		return sysconfigDAO.findSysconfigByPrimaryKey(id);
	}
}
