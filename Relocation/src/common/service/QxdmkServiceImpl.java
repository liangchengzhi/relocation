package common.service;

import common.dao.QxdmkDAO;

import common.domain.Qxdmk;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Qxdmk entities
 * 
 */

@Service("QxdmkService")
public class QxdmkServiceImpl implements QxdmkService {

	/**
	 * DAO injected by Spring that manages Qxdmk entities
	 * 
	 */
	@Autowired
	private QxdmkDAO qxdmkDAO;

	/**
	 * Instantiates a new QxdmkServiceImpl.
	 *
	 */
	public QxdmkServiceImpl() {
	}

	/**
	 * Save an existing Qxdmk entity
	 * 
	 */
	public void saveQxdmk(Qxdmk qxdmk) {
		Qxdmk existingQxdmk = qxdmkDAO.findQxdmkByPrimaryKey(qxdmk.getQxdm());

		if (existingQxdmk != null) {
			if (existingQxdmk != qxdmk) {
				existingQxdmk.setQxdm(qxdmk.getQxdm());
				existingQxdmk.setQxmc(qxdmk.getQxmc());
			}
			qxdmk = qxdmkDAO.store(existingQxdmk);
		} else {
			qxdmk = qxdmkDAO.store(qxdmk);
		}
		qxdmkDAO.flush();
	}

	/**
	 * Load an existing Qxdmk entity
	 * 
	 */
	public Set<Qxdmk> loadQxdmks() {
		return qxdmkDAO.findAllQxdmks();
	}

	/**
	 * Delete an existing Qxdmk entity
	 * 
	 */
	public void deleteQxdmk(Qxdmk qxdmk) {
		qxdmkDAO.remove(qxdmk);
		qxdmkDAO.flush();
	}

	/**
	 * Return all Qxdmk entity
	 * 
	 */
	public List<Qxdmk> findAllQxdmks(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Qxdmk>(qxdmkDAO.findAllQxdmks(startResult, maxRows));
	}

	/**
	 * Return a count of all Qxdmk entity
	 * 
	 */
	public Integer countQxdmks() {
		return ((Long) qxdmkDAO.createQuerySingleResult("select count(o) from Qxdmk o").getSingleResult()).intValue();
	}

	/**
	 */
	public Qxdmk findQxdmkByPrimaryKey(String qxdm) {
		return qxdmkDAO.findQxdmkByPrimaryKey(qxdm);
	}
}
