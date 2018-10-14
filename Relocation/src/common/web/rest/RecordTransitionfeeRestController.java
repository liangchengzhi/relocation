package common.web.rest;

import common.dao.CuserDAO;
import common.dao.RecordDAO;
import common.dao.RecordTransitionfeeDAO;
import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;
import common.service.RecordTransitionfeeService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for RecordTransitionfee entities
 * 
 */

@Controller("RecordTransitionfeeRestController")
@Transactional
public class RecordTransitionfeeRestController {

	/**
	 * DAO injected by Spring that manages Cuser entities
	 * 
	 */
	@Autowired
	private CuserDAO cuserDAO;

	/**
	 * DAO injected by Spring that manages Record entities
	 * 
	 */
	@Autowired
	private RecordDAO recordDAO;

	/**
	 * DAO injected by Spring that manages RecordTransitionfee entities
	 * 
	 */
	@Autowired
	private RecordTransitionfeeDAO recordTransitionfeeDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for RecordTransitionfee entities
	 * 
	 */
	@Autowired
	private RecordTransitionfeeService recordTransitionfeeService;

	/**
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/record/{record_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecordTransitionfeeRecord(@PathVariable Integer recordtransitionfee_id, @PathVariable Integer related_record_id) {
		recordTransitionfeeService.deleteRecordTransitionfeeRecord(recordtransitionfee_id, related_record_id);
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/record", method = RequestMethod.POST)
	@ResponseBody
	public Record newRecordTransitionfeeRecord(@PathVariable Integer recordtransitionfee_id, @RequestBody Record record) {
		recordTransitionfeeService.saveRecordTransitionfeeRecord(recordtransitionfee_id, record);
		return recordDAO.findRecordByPrimaryKey(record.getId());
	}

	/**
	 * View an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/cuser/{cuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public Cuser loadRecordTransitionfeeCuser(@PathVariable Integer recordtransitionfee_id, @PathVariable Integer related_cuser_id) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(related_cuser_id, -1, -1);

		return cuser;
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecordTransitionfee(@PathVariable Integer recordtransitionfee_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee_id);
		recordTransitionfeeService.deleteRecordTransitionfee(recordtransitionfee);
	}

	/**
	 * Create a new RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee", method = RequestMethod.POST)
	@ResponseBody
	public RecordTransitionfee newRecordTransitionfee(@RequestBody RecordTransitionfee recordtransitionfee) {
		recordTransitionfeeService.saveRecordTransitionfee(recordtransitionfee);
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee.getId());
	}

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee", method = RequestMethod.PUT)
	@ResponseBody
	public RecordTransitionfee saveRecordTransitionfee(@RequestBody RecordTransitionfee recordtransitionfee) {
		recordTransitionfeeService.saveRecordTransitionfee(recordtransitionfee);
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee.getId());
	}

	/**
	 * Show all RecordTransitionfee entities
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee", method = RequestMethod.GET)
	@ResponseBody
	public List<RecordTransitionfee> listRecordTransitionfees() {
		return new java.util.ArrayList<RecordTransitionfee>(recordTransitionfeeService.loadRecordTransitionfees());
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/cuser", method = RequestMethod.PUT)
	@ResponseBody
	public Cuser saveRecordTransitionfeeCuser(@PathVariable Integer recordtransitionfee_id, @RequestBody Cuser cuser) {
		recordTransitionfeeService.saveRecordTransitionfeeCuser(recordtransitionfee_id, cuser);
		return cuserDAO.findCuserByPrimaryKey(cuser.getId());
	}

	/**
	 * Get Record entity by RecordTransitionfee
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/record", method = RequestMethod.GET)
	@ResponseBody
	public Record getRecordTransitionfeeRecord(@PathVariable Integer recordtransitionfee_id) {
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee_id).getRecord();
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/record", method = RequestMethod.PUT)
	@ResponseBody
	public Record saveRecordTransitionfeeRecord(@PathVariable Integer recordtransitionfee_id, @RequestBody Record record) {
		recordTransitionfeeService.saveRecordTransitionfeeRecord(recordtransitionfee_id, record);
		return recordDAO.findRecordByPrimaryKey(record.getId());
	}

	/**
	 * Select an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}", method = RequestMethod.GET)
	@ResponseBody
	public RecordTransitionfee loadRecordTransitionfee(@PathVariable Integer recordtransitionfee_id) {
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee_id);
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Get Cuser entity by RecordTransitionfee
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/cuser", method = RequestMethod.GET)
	@ResponseBody
	public Cuser getRecordTransitionfeeCuser(@PathVariable Integer recordtransitionfee_id) {
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee_id).getCuser();
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/cuser/{cuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecordTransitionfeeCuser(@PathVariable Integer recordtransitionfee_id, @PathVariable Integer related_cuser_id) {
		recordTransitionfeeService.deleteRecordTransitionfeeCuser(recordtransitionfee_id, related_cuser_id);
	}

	/**
	 * Create a new Cuser entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/cuser", method = RequestMethod.POST)
	@ResponseBody
	public Cuser newRecordTransitionfeeCuser(@PathVariable Integer recordtransitionfee_id, @RequestBody Cuser cuser) {
		recordTransitionfeeService.saveRecordTransitionfeeCuser(recordtransitionfee_id, cuser);
		return cuserDAO.findCuserByPrimaryKey(cuser.getId());
	}

	/**
	 * View an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/RecordTransitionfee/{recordtransitionfee_id}/record/{record_id}", method = RequestMethod.GET)
	@ResponseBody
	public Record loadRecordTransitionfeeRecord(@PathVariable Integer recordtransitionfee_id, @PathVariable Integer related_record_id) {
		Record record = recordDAO.findRecordByPrimaryKey(related_record_id, -1, -1);

		return record;
	}
}