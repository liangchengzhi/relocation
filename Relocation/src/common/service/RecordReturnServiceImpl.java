package common.service;

import common.dao.RecordReturnDAO;

import common.domain.RecordReturn;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for RecordReturn entities
 * 
 */

@Service("RecordReturnService")
public class RecordReturnServiceImpl implements RecordReturnService {

	/**
	 * DAO injected by Spring that manages RecordReturn entities
	 * 
	 */
	@Autowired
	private RecordReturnDAO recordReturnDAO;

	/**
	 * Instantiates a new RecordReturnServiceImpl.
	 *
	 */
	public RecordReturnServiceImpl() {
	}

	/**
	 * Save an existing RecordReturn entity
	 * 
	 */
	public void saveRecordReturn(RecordReturn recordreturn) {
		RecordReturn existingRecordReturn = recordReturnDAO.findRecordReturnByPrimaryKey(recordreturn.getId());

		if (existingRecordReturn != null) {
			if (existingRecordReturn != recordreturn) {
				existingRecordReturn.setId(recordreturn.getId());
				existingRecordReturn.setSid(recordreturn.getSid());
				existingRecordReturn.setHouseArea(recordreturn.getHouseArea());
				existingRecordReturn.setBusinessArea(recordreturn.getBusinessArea());
				existingRecordReturn.setProductionArea(recordreturn.getProductionArea());
				existingRecordReturn.setReturnTime(recordreturn.getReturnTime());
				existingRecordReturn.setCreatedTime(recordreturn.getCreatedTime());
				existingRecordReturn.setIsDeleted(recordreturn.getIsDeleted());
				existingRecordReturn.setDeletedTime(recordreturn.getDeletedTime());
			}
			recordreturn = recordReturnDAO.store(existingRecordReturn);
		} else {
			recordreturn = recordReturnDAO.store(recordreturn);
		}
		recordReturnDAO.flush();
	}

	/**
	 * Delete an existing RecordReturn entity
	 * 
	 */
	public void deleteRecordReturn(RecordReturn recordreturn) {
		recordReturnDAO.remove(recordreturn);
		recordReturnDAO.flush();
	}

	/**
	 * Return all RecordReturn entity
	 * 
	 */
	public List<RecordReturn> findAllRecordReturns(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<RecordReturn>(recordReturnDAO.findAllRecordReturns(startResult, maxRows));
	}

	/**
	 * Return a count of all RecordReturn entity
	 * 
	 */
	public Integer countRecordReturns() {
		return ((Long) recordReturnDAO.createQuerySingleResult("select count(o) from RecordReturn o").getSingleResult()).intValue();
	}

	/**
	 */
	public RecordReturn findRecordReturnByPrimaryKey(Integer id) {
		return recordReturnDAO.findRecordReturnByPrimaryKey(id);
	}

	/**
	 * Load an existing RecordReturn entity
	 * 
	 */
	public Set<RecordReturn> loadRecordReturns() {
		return recordReturnDAO.findAllRecordReturns();
	}
}
