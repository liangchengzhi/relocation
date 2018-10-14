package common.web.rest;

import common.dao.CuserDAO;
import common.dao.ProjectDAO;
import common.dao.RecordDAO;
import common.dao.RecordTransitionfeeDAO;
import common.domain.Cuser;
import common.domain.Project;
import common.domain.Record;
import common.domain.RecordTransitionfee;
import common.service.RecordService;

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
 * Spring Rest controller that handles CRUD requests for Record entities
 * 
 */

@Controller("RecordRestController")
@Transactional
public class RecordRestController {

	/**
	 * DAO injected by Spring that manages Cuser entities
	 * 
	 */
	@Autowired
	private CuserDAO cuserDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

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
	 * Service injected by Spring that provides CRUD operations for Record entities
	 * 
	 */
	@Autowired
	private RecordService recordService;

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/project/{project_id}", method = RequestMethod.GET)
	@ResponseBody
	public Project loadRecordProject(@PathVariable Integer record_id, @PathVariable Integer related_project_id) {
		Project project = projectDAO.findProjectByPrimaryKey(related_project_id, -1, -1);

		return project;
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/recordTransitionfees/{recordtransitionfee_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecordRecordTransitionfees(@PathVariable Integer record_id, @PathVariable Integer related_recordtransitionfees_id) {
		recordService.deleteRecordRecordTransitionfees(record_id, related_recordtransitionfees_id);
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/project", method = RequestMethod.PUT)
	@ResponseBody
	public Project saveRecordProject(@PathVariable Integer record_id, @RequestBody Project project) {
		recordService.saveRecordProject(record_id, project);
		return projectDAO.findProjectByPrimaryKey(project.getId());
	}

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/recordTransitionfees", method = RequestMethod.PUT)
	@ResponseBody
	public RecordTransitionfee saveRecordRecordTransitionfees(@PathVariable Integer record_id, @RequestBody RecordTransitionfee recordtransitionfees) {
		recordService.saveRecordRecordTransitionfees(record_id, recordtransitionfees);
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfees.getId());
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/project/{project_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecordProject(@PathVariable Integer record_id, @PathVariable Integer related_project_id) {
		recordService.deleteRecordProject(record_id, related_project_id);
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/cuser", method = RequestMethod.PUT)
	@ResponseBody
	public Cuser saveRecordCuser(@PathVariable Integer record_id, @RequestBody Cuser cuser) {
		recordService.saveRecordCuser(record_id, cuser);
		return cuserDAO.findCuserByPrimaryKey(cuser.getId());
	}

	/**
	 * View an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/recordTransitionfees/{recordtransitionfee_id}", method = RequestMethod.GET)
	@ResponseBody
	public RecordTransitionfee loadRecordRecordTransitionfees(@PathVariable Integer record_id, @PathVariable Integer related_recordtransitionfees_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(related_recordtransitionfees_id, -1, -1);

		return recordtransitionfee;
	}

	/**
	 * Get Project entity by Record
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/project", method = RequestMethod.GET)
	@ResponseBody
	public Project getRecordProject(@PathVariable Integer record_id) {
		return recordDAO.findRecordByPrimaryKey(record_id).getProject();
	}

	/**
	 * View an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/cuser/{cuser_id}", method = RequestMethod.GET)
	@ResponseBody
	public Cuser loadRecordCuser(@PathVariable Integer record_id, @PathVariable Integer related_cuser_id) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(related_cuser_id, -1, -1);

		return cuser;
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/cuser/{cuser_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecordCuser(@PathVariable Integer record_id, @PathVariable Integer related_cuser_id) {
		recordService.deleteRecordCuser(record_id, related_cuser_id);
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
	 * Get Cuser entity by Record
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/cuser", method = RequestMethod.GET)
	@ResponseBody
	public Cuser getRecordCuser(@PathVariable Integer record_id) {
		return recordDAO.findRecordByPrimaryKey(record_id).getCuser();
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecord(@PathVariable Integer record_id) {
		Record record = recordDAO.findRecordByPrimaryKey(record_id);
		recordService.deleteRecord(record);
	}

	/**
	 * Show all RecordTransitionfee entities by Record
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/recordTransitionfees", method = RequestMethod.GET)
	@ResponseBody
	public List<RecordTransitionfee> getRecordRecordTransitionfees(@PathVariable Integer record_id) {
		return new java.util.ArrayList<RecordTransitionfee>(recordDAO.findRecordByPrimaryKey(record_id).getRecordTransitionfees());
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping(value = "/Record", method = RequestMethod.POST)
	@ResponseBody
	public Record newRecord(@RequestBody Record record) {
		recordService.saveRecord(record);
		return recordDAO.findRecordByPrimaryKey(record.getId());
	}

	/**
	 * Select an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}", method = RequestMethod.GET)
	@ResponseBody
	public Record loadRecord(@PathVariable Integer record_id) {
		return recordDAO.findRecordByPrimaryKey(record_id);
	}

	/**
	 * Create a new Cuser entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/cuser", method = RequestMethod.POST)
	@ResponseBody
	public Cuser newRecordCuser(@PathVariable Integer record_id, @RequestBody Cuser cuser) {
		recordService.saveRecordCuser(record_id, cuser);
		return cuserDAO.findCuserByPrimaryKey(cuser.getId());
	}

	/**
	 * Show all Record entities
	 * 
	 */
	@RequestMapping(value = "/Record", method = RequestMethod.GET)
	@ResponseBody
	public List<Record> listRecords() {
		return new java.util.ArrayList<Record>(recordService.loadRecords());
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/project", method = RequestMethod.POST)
	@ResponseBody
	public Project newRecordProject(@PathVariable Integer record_id, @RequestBody Project project) {
		recordService.saveRecordProject(record_id, project);
		return projectDAO.findProjectByPrimaryKey(project.getId());
	}

	/**
	 * Create a new RecordTransitionfee entity
	 * 
	 */
	@RequestMapping(value = "/Record/{record_id}/recordTransitionfees", method = RequestMethod.POST)
	@ResponseBody
	public RecordTransitionfee newRecordRecordTransitionfees(@PathVariable Integer record_id, @RequestBody RecordTransitionfee recordtransitionfee) {
		recordService.saveRecordRecordTransitionfees(record_id, recordtransitionfee);
		return recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfee.getId());
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Record", method = RequestMethod.PUT)
	@ResponseBody
	public Record saveRecord(@RequestBody Record record) {
		recordService.saveRecord(record);
		return recordDAO.findRecordByPrimaryKey(record.getId());
	}
}