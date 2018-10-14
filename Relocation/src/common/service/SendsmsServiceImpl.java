package common.service;

import common.dao.SendsmsDAO;

import common.domain.Sendsms;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Sendsms entities
 * 
 */

@Service("SendsmsService")
public class SendsmsServiceImpl implements SendsmsService {

	/**
	 * DAO injected by Spring that manages Sendsms entities
	 * 
	 */
	@Autowired
	private SendsmsDAO sendsmsDAO;

	/**
	 * Instantiates a new SendsmsServiceImpl.
	 *
	 */
	public SendsmsServiceImpl() {
	}

	/**
	 */
	public Sendsms findSendsmsByPrimaryKey(Integer id) {
		return sendsmsDAO.findSendsmsByPrimaryKey(id);
	}

	/**
	 * Delete an existing Sendsms entity
	 * 
	 */
	public void deleteSendsms(Sendsms sendsms) {
		sendsmsDAO.remove(sendsms);
		sendsmsDAO.flush();
	}

	/**
	 * Load an existing Sendsms entity
	 * 
	 */
	public Set<Sendsms> loadSendsmss() {
		return sendsmsDAO.findAllSendsmss();
	}

	/**
	 * Return a count of all Sendsms entity
	 * 
	 */
	public Integer countSendsmss() {
		return ((Long) sendsmsDAO.createQuerySingleResult("select count(o) from Sendsms o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Sendsms entity
	 * 
	 */
	public void saveSendsms(Sendsms sendsms) {
		Sendsms existingSendsms = sendsmsDAO.findSendsmsByPrimaryKey(sendsms.getId());

		if (existingSendsms != null) {
			if (existingSendsms != sendsms) {
				existingSendsms.setId(sendsms.getId());
				existingSendsms.setPhone(sendsms.getPhone());
				existingSendsms.setRandcode(sendsms.getRandcode());
				existingSendsms.setCreatedtime(sendsms.getCreatedtime());
				existingSendsms.setContent(sendsms.getContent());
				existingSendsms.setIp(sendsms.getIp());
			}
			sendsms = sendsmsDAO.store(existingSendsms);
		} else {
			sendsms = sendsmsDAO.store(sendsms);
		}
		sendsmsDAO.flush();
	}

	/**
	 * Return all Sendsms entity
	 * 
	 */
	public List<Sendsms> findAllSendsmss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Sendsms>(sendsmsDAO.findAllSendsmss(startResult, maxRows));
	}
}
