package common.web.rest;

import common.dao.CuserDAO;
import common.dao.RecordDAO;
import common.dao.RecordTransitionfeeDAO;
import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;
import common.service.CuserService;

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
 * Spring Rest controller that handles CRUD requests for Cuser entities
 * 
 */

@Controller("CuserRestController")
@Transactional
public class CuserRestController {

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
	 * Service injected by Spring that provides CRUD operations for Cuser entities
	 * 
	 */
	@Autowired
	private CuserService cuserService;

	/**
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/records/{record_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCuserRecords(@PathVariable Integer cuser_id, @PathVariable Integer related_records_id) {
		cuserService.deleteCuserRecords(cuser_id, related_records_id);
	}

	/**
	 * Create a new RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/recordTransitionfees", method = RequestMethod.POST)
	@ResponseBody
	public RecordTransitionfee newCuserRecordTransitionfees(@PathVariable Integer cuser_id, @RequestBody RecordTransitionfee recordtransitionfee) {
		cuserService.saveCuserRecordTransitionfees(cuser_id, recordtransitionfee);
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee.getId());
	}

	/**
	 * Show all Record entities by Cuser
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/records", method = RequestMethod.GET)
	@ResponseBody
	public List<Record> getCuserRecords(@PathVariable Integer cuser_id) {
		return new java.util.ArrayList<Record>(cuserDAO.findCuserByPrimaryKey(cuser_id).getRecords());
	}

	/**
	 * View an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/recordTransitionfees/{recordtransitionfee_id}", method = RequestMethod.GET)
	@ResponseBody
	public RecordTransitionfee loadCuserRecordTransitionfees(@PathVariable Integer cuser_id, @PathVariable Integer related_recordtransitionfees_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(related_recordtransitionfees_id, -1, -1);

		return recordtransitionfee;
	}

	/**
	 * Show all RecordTransitionfee entities by Cuser
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/recordTransitionfees", method = RequestMethod.GET)
	@ResponseBody
	public List<RecordTransitionfee> getCuserRecordTransitionfees(@PathVariable Integer cuser_id) {
		return new java.util.ArrayList<RecordTransitionfee>(cuserDAO.findCuserByPrimaryKey(cuser_id).getRecordTransitionfees());
	}

	/**
	 * Select an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public Cuser loadCuser(@PathVariable Integer cuser_id) {
		return cuserDAO.findCuserByPrimaryKey(cuser_id);
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/recordTransitionfees/{recordtransitionfee_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCuserRecordTransitionfees(@PathVariable Integer cuser_id, @PathVariable Integer related_recordtransitionfees_id) {
		cuserService.deleteCuserRecordTransitionfees(cuser_id, related_recordtransitionfees_id);
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
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/recordTransitionfees", method = RequestMethod.PUT)
	@ResponseBody
	public RecordTransitionfee saveCuserRecordTransitionfees(@PathVariable Integer cuser_id, @RequestBody RecordTransitionfee recordtransitionfees) {
		cuserService.saveCuserRecordTransitionfees(cuser_id, recordtransitionfees);
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfees.getId());
	}

	/**
	 * Show all Cuser entities
	 * 
	 */
	@RequestMapping(value = "/Cuser", method = RequestMethod.GET)
	@ResponseBody
	public List<Cuser> listCusers() {
		return new java.util.ArrayList<Cuser>(cuserService.loadCusers());
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/records", method = RequestMethod.POST)
	@ResponseBody
	public Record newCuserRecords(@PathVariable Integer cuser_id, @RequestBody Record record) {
		cuserService.saveCuserRecords(cuser_id, record);
		return recordDAO.findRecordByPrimaryKey(record.getId());
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCuser(@PathVariable Integer cuser_id) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(cuser_id);
		cuserService.deleteCuser(cuser);
	}

	/**
	 * View an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/records/{record_id}", method = RequestMethod.GET)
	@ResponseBody
	public Record loadCuserRecords(@PathVariable Integer cuser_id, @PathVariable Integer related_records_id) {
		Record record = recordDAO.findRecordByPrimaryKey(related_records_id, -1, -1);

		return record;
	}

	/**
	 * Create a new Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Cuser", method = RequestMethod.POST)
	@ResponseBody
	public Cuser newCuser(@RequestBody Cuser cuser) {
		cuserService.saveCuser(cuser);
		return cuserDAO.findCuserByPrimaryKey(cuser.getId());
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Cuser/{cuser_id}/records", method = RequestMethod.PUT)
	@ResponseBody
	public Record saveCuserRecords(@PathVariable Integer cuser_id, @RequestBody Record records) {
		cuserService.saveCuserRecords(cuser_id, records);
		return recordDAO.findRecordByPrimaryKey(records.getId());
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Cuser", method = RequestMethod.PUT)
	@ResponseBody
	public Cuser saveCuser(@RequestBody Cuser cuser) {
		cuserService.saveCuser(cuser);
		return cuserDAO.findCuserByPrimaryKey(cuser.getId());
	}
}