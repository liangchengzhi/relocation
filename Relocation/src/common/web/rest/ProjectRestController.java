package common.web.rest;

import common.dao.ProjectDAO;
import common.dao.RecordDAO;
import common.domain.Project;
import common.domain.Record;
import common.service.ProjectService;

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
 * Spring Rest controller that handles CRUD requests for Project entities
 * 
 */

@Controller("ProjectRestController")
@Transactional
public class ProjectRestController {

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
	 * Service injected by Spring that provides CRUD operations for Project entities
	 * 
	 */
	@Autowired
	private ProjectService projectService;

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping(value = "/Project", method = RequestMethod.POST)
	@ResponseBody
	public Project newProject(@RequestBody Project project) {
		projectService.saveProject(project);
		return projectDAO.findProjectByPrimaryKey(project.getId());
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping(value = "/Project/{project_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProject(@PathVariable Integer project_id) {
		Project project = projectDAO.findProjectByPrimaryKey(project_id);
		projectService.deleteProject(project);
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping(value = "/Project", method = RequestMethod.PUT)
	@ResponseBody
	public Project saveProject(@RequestBody Project project) {
		projectService.saveProject(project);
		return projectDAO.findProjectByPrimaryKey(project.getId());
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
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Project/{project_id}/records", method = RequestMethod.PUT)
	@ResponseBody
	public Record saveProjectRecords(@PathVariable Integer project_id, @RequestBody Record records) {
		projectService.saveProjectRecords(project_id, records);
		return recordDAO.findRecordByPrimaryKey(records.getId());
	}

	/**
	 * Show all Project entities
	 * 
	 */
	@RequestMapping(value = "/Project", method = RequestMethod.GET)
	@ResponseBody
	public List<Project> listProjects() {
		return new java.util.ArrayList<Project>(projectService.loadProjects());
	}

	/**
	 * Show all Record entities by Project
	 * 
	 */
	@RequestMapping(value = "/Project/{project_id}/records", method = RequestMethod.GET)
	@ResponseBody
	public List<Record> getProjectRecords(@PathVariable Integer project_id) {
		return new java.util.ArrayList<Record>(projectDAO.findProjectByPrimaryKey(project_id).getRecords());
	}

	/**
	 * Select an existing Project entity
	 * 
	 */
	@RequestMapping(value = "/Project/{project_id}", method = RequestMethod.GET)
	@ResponseBody
	public Project loadProject(@PathVariable Integer project_id) {
		return projectDAO.findProjectByPrimaryKey(project_id);
	}

	/**
	 * View an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Project/{project_id}/records/{record_id}", method = RequestMethod.GET)
	@ResponseBody
	public Record loadProjectRecords(@PathVariable Integer project_id, @PathVariable Integer related_records_id) {
		Record record = recordDAO.findRecordByPrimaryKey(related_records_id, -1, -1);

		return record;
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping(value = "/Project/{project_id}/records", method = RequestMethod.POST)
	@ResponseBody
	public Record newProjectRecords(@PathVariable Integer project_id, @RequestBody Record record) {
		projectService.saveProjectRecords(project_id, record);
		return recordDAO.findRecordByPrimaryKey(record.getId());
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping(value = "/Project/{project_id}/records/{record_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteProjectRecords(@PathVariable Integer project_id, @PathVariable Integer related_records_id) {
		projectService.deleteProjectRecords(project_id, related_records_id);
	}
}