package common.web;

import common.dao.ProjectDAO;
import common.dao.RecordDAO;
import common.domain.Cuser;
import common.domain.Project;
import common.domain.Record;
import common.service.CuserService;
import common.service.ProjectService;
import common.service.UserOperateLogService;
import common.web.util.CurrentUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for Project entities
 * 
 */

@Controller("ProjectController")
public class ProjectController {

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
	
	@Autowired
	private CuserService cuserService;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;

	/**
	 * Select the child Record entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectRecords")
	public ModelAndView confirmDeleteProjectRecords(@RequestParam Integer project_id, @RequestParam Integer related_records_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(related_records_id));
		mav.addObject("project_id", project_id);
		mav.setViewName("project/records/deleteRecords.jsp");

		return mav;
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping("/deleteProjectRecords")
	public ModelAndView deleteProjectRecords(@RequestParam Integer project_id, @RequestParam Integer related_records_id,
			HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁项目";
		
		try {
			ModelAndView mav = new ModelAndView();
			
			Project project = projectService.deleteProjectRecords(project_id, related_records_id);

			mav.addObject("project_id", project_id);
			mav.addObject("project", project);
			mav.setViewName("project/viewProject.jsp");

			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return mav;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
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
	 */
	@RequestMapping("/projectController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select an existing Project entity
	 * 
	 */
	@RequestMapping("/selectProject")
	public ModelAndView selectProject(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(idKey));
		mav.setViewName("project/viewProject.jsp");

		return mav;
	}

	/**
	 * View an existing Record entity
	 * 
	 */
	@RequestMapping("/selectProjectRecords")
	public ModelAndView selectProjectRecords(@RequestParam Integer project_id, @RequestParam Integer records_id) {
		Record record = recordDAO.findRecordByPrimaryKey(records_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_id", project_id);
		mav.addObject("record", record);
		mav.setViewName("project/records/viewRecords.jsp");

		return mav;
	}

	/**
	 * Show all Project entities
	 * 
	 */
	@RequestMapping("/indexProject")
	public ModelAndView listProjects() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projects", projectService.loadProjects());

		mav.setViewName("project/listProjects.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveProject")
	public String saveProject(@ModelAttribute Project project,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁项目信息";
		
		try {
		
			projectService.saveProject(project);
			return "forward:/indexProject";
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
	}

	/**
	 * Edit an existing Record entity
	 * 
	 */
	@RequestMapping("/editProjectRecords")
	public ModelAndView editProjectRecords(@RequestParam Integer project_id, @RequestParam Integer records_id
			,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "修改拆迁项目信息";
		
		try {
		
			Record record = recordDAO.findRecordByPrimaryKey(records_id, -1, -1);

			ModelAndView mav = new ModelAndView();
			mav.addObject("project_id", project_id);
			mav.addObject("record", record);
			mav.setViewName("project/records/editRecords.jsp");

			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteProject")
	public String deleteProject(@RequestParam Integer idKey,HttpServletRequest request,HttpServletResponse response) {
		
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁项目信息";
		
		try {
		
			Project project = projectDAO.findProjectByPrimaryKey(idKey);
			projectService.deleteProject(project);
			return "forward:/indexProject";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newProject")
	public ModelAndView newProject() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("project/editProject.jsp");

		return mav;
	}

	/**
	 * Show all Record entities by Project
	 * 
	 */
	@RequestMapping("/listProjectRecords")
	public ModelAndView listProjectRecords(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(idKey));
		mav.setViewName("project/records/listRecords.jsp");

		return mav;
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping("/newProjectRecords")
	public ModelAndView newProjectRecords(@RequestParam Integer project_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_id", project_id);
		mav.addObject("record", new Record());
		mav.addObject("newFlag", true);
		mav.setViewName("project/records/editRecords.jsp");

		return mav;
	}

	/**
	 * Select the Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProject")
	public ModelAndView confirmDeleteProject(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(idKey));
		mav.setViewName("project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Project entities
	 * 
	 */
	public String indexProject() {
		return "redirect:/indexProject";
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping("/saveProjectRecords")
	public ModelAndView saveProjectRecords(@RequestParam Integer project_id, @ModelAttribute Record records
			,HttpServletRequest request,HttpServletResponse response) {
		
		
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁项目信息";
		
		try {
		
			Project parent_project = projectService.saveProjectRecords(project_id, records);

			ModelAndView mav = new ModelAndView();
			mav.addObject("project_id", project_id);
			mav.addObject("project", parent_project);
			mav.setViewName("project/viewProject.jsp");

			return mav;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editProject")
	public ModelAndView editProject(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(idKey));
		mav.setViewName("project/editProject.jsp");

		return mav;
	}
}