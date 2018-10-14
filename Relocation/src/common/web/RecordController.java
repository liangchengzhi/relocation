package common.web;

import common.dao.CuserDAO;
import common.dao.ProjectDAO;
import common.dao.RecordDAO;
import common.dao.RecordTransitionfeeDAO;
import common.domain.Cuser;
import common.domain.Project;
import common.domain.Record;
import common.domain.RecordTransitionfee;
import common.service.CuserService;
import common.service.RecordService;
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
 * Spring MVC controller that handles CRUD requests for Record entities
 * 
 */

@Controller("RecordController")
public class RecordController {

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
	
	@Autowired
	private CuserService cuserService;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/saveRecordRecordTransitionfees")
	public ModelAndView saveRecordRecordTransitionfees(@RequestParam Integer record_id, @ModelAttribute RecordTransitionfee recordtransitionfees,
			HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁过渡费信息";
		
		try {
			Record parent_record = recordService.saveRecordRecordTransitionfees(record_id, recordtransitionfees);

			ModelAndView mav = new ModelAndView();
			mav.addObject("record_id", record_id);
			mav.addObject("record", parent_record);
			mav.setViewName("record/viewRecord.jsp");

			return mav;
			
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Edit an existing Cuser entity
	 * 
	 */
	@RequestMapping("/editRecordCuser")
	public ModelAndView editRecordCuser(@RequestParam Integer record_id, @RequestParam Integer cuser_id) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(cuser_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("cuser", cuser);
		mav.setViewName("record/cuser/editCuser.jsp");

		return mav;
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping("/deleteRecord")
	public String deleteRecord(@RequestParam Integer idKey,HttpServletRequest request,HttpServletResponse response) {
		
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁记录";
		
		try {
		
			Record record = recordDAO.findRecordByPrimaryKey(idKey);
			recordService.deleteRecord(record);
			return "forward:/indexRecord";
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 */
	@RequestMapping("/recordController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/editRecordRecordTransitionfees")
	public ModelAndView editRecordRecordTransitionfees(@RequestParam Integer record_id, @RequestParam Integer recordtransitionfees_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfees_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("recordtransitionfee", recordtransitionfee);
		mav.setViewName("record/recordtransitionfees/editRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Select an existing Record entity
	 * 
	 */
	@RequestMapping("/selectRecord")
	public ModelAndView selectRecord(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(idKey));
		mav.setViewName("record/viewRecord.jsp");

		return mav;
	}

	/**
	 * Show all Record entities
	 * 
	 */
	@RequestMapping("/indexRecord")
	public ModelAndView listRecords() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("records", recordService.loadRecords());

		mav.setViewName("record/listRecords.jsp");

		return mav;
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	@RequestMapping("/saveRecordCuser")
	public ModelAndView saveRecordCuser(@RequestParam Integer record_id, @ModelAttribute Cuser cuser) {
		Record parent_record = recordService.saveRecordCuser(record_id, cuser);

		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("record", parent_record);
		mav.setViewName("record/viewRecord.jsp");

		return mav;
	}

	/**
	 * Select the child Cuser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecordCuser")
	public ModelAndView confirmDeleteRecordCuser(@RequestParam Integer record_id, @RequestParam Integer related_cuser_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", cuserDAO.findCuserByPrimaryKey(related_cuser_id));
		mav.addObject("record_id", record_id);
		mav.setViewName("record/cuser/deleteCuser.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveRecordProject")
	public ModelAndView saveRecordProject(@RequestParam Integer record_id, @ModelAttribute Project project,
			HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁信息";
		
		try {
		
			Record parent_record = recordService.saveRecordProject(record_id, project);

			ModelAndView mav = new ModelAndView();
			mav.addObject("record_id", record_id);
			mav.addObject("record", parent_record);
			mav.setViewName("record/viewRecord.jsp");

			return mav;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping("/saveRecord")
	public String saveRecord(@ModelAttribute Record record,HttpServletRequest request,HttpServletResponse response) {

		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁信息";
		
		try {
		
			recordService.saveRecord(record);
			return "forward:/indexRecord";
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/deleteRecordRecordTransitionfees")
	public ModelAndView deleteRecordRecordTransitionfees(@RequestParam Integer record_id, @RequestParam Integer related_recordtransitionfees_id,HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁过渡费信息";
		
		try {
			ModelAndView mav = new ModelAndView();

			Record record = recordService.deleteRecordRecordTransitionfees(record_id, related_recordtransitionfees_id);

			mav.addObject("record_id", record_id);
			mav.addObject("record", record);
			mav.setViewName("record/viewRecord.jsp");

			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
	}

	/**
	 * Create a new RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/newRecordRecordTransitionfees")
	public ModelAndView newRecordRecordTransitionfees(@RequestParam Integer record_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("recordtransitionfee", new RecordTransitionfee());
		mav.addObject("newFlag", true);
		mav.setViewName("record/recordtransitionfees/editRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectRecordProject")
	public ModelAndView selectRecordProject(@RequestParam Integer record_id, @RequestParam Integer project_id) {
		Project project = projectDAO.findProjectByPrimaryKey(project_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("project", project);
		mav.setViewName("record/project/viewProject.jsp");

		return mav;
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
	 * View an existing Cuser entity
	 * 
	 */
	@RequestMapping("/selectRecordCuser")
	public ModelAndView selectRecordCuser(@RequestParam Integer record_id, @RequestParam Integer cuser_id) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(cuser_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("cuser", cuser);
		mav.setViewName("record/cuser/viewCuser.jsp");

		return mav;
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping("/newRecord")
	public ModelAndView newRecord() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", new Record());
		mav.addObject("newFlag", true);
		mav.setViewName("record/editRecord.jsp");

		return mav;
	}

	/**
	 * Edit an existing Record entity
	 * 
	 */
	@RequestMapping("/editRecord")
	public ModelAndView editRecord(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(idKey));
		mav.setViewName("record/editRecord.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editRecordProject")
	public ModelAndView editRecordProject(@RequestParam Integer record_id, @RequestParam Integer project_id) {
		Project project = projectDAO.findProjectByPrimaryKey(project_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("project", project);
		mav.setViewName("record/project/editProject.jsp");

		return mav;
	}

	/**
	 * Create a new Cuser entity
	 * 
	 */
	@RequestMapping("/newRecordCuser")
	public ModelAndView newRecordCuser(@RequestParam Integer record_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("cuser", new Cuser());
		mav.addObject("newFlag", true);
		mav.setViewName("record/cuser/editCuser.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecordProject")
	public ModelAndView confirmDeleteRecordProject(@RequestParam Integer record_id, @RequestParam Integer related_project_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_id));
		mav.addObject("record_id", record_id);
		mav.setViewName("record/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newRecordProject")
	public ModelAndView newRecordProject(@RequestParam Integer record_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("record/project/editProject.jsp");

		return mav;
	}

	/**
	 * Select the Record entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecord")
	public ModelAndView confirmDeleteRecord(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(idKey));
		mav.setViewName("record/deleteRecord.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Record entities
	 * 
	 */
	public String indexRecord() {
		return "redirect:/indexRecord";
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteRecordProject")
	public ModelAndView deleteRecordProject(@RequestParam Integer record_id, @RequestParam Integer related_project_id,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁项目";

		try {
			
			ModelAndView mav = new ModelAndView();

			Record record = recordService.deleteRecordProject(record_id, related_project_id);

			mav.addObject("record_id", record_id);
			mav.addObject("record", record);
			mav.setViewName("record/viewRecord.jsp");

			return mav;
			
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Select the child RecordTransitionfee entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecordRecordTransitionfees")
	public ModelAndView confirmDeleteRecordRecordTransitionfees(@RequestParam Integer record_id, @RequestParam Integer related_recordtransitionfees_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(related_recordtransitionfees_id));
		mav.addObject("record_id", record_id);
		mav.setViewName("record/recordtransitionfees/deleteRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Show all Cuser entities by Record
	 * 
	 */
	@RequestMapping("/listRecordCuser")
	public ModelAndView listRecordCuser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(idKey));
		mav.setViewName("record/cuser/listCuser.jsp");

		return mav;
	}

	/**
	 * Show all RecordTransitionfee entities by Record
	 * 
	 */
	@RequestMapping("/listRecordRecordTransitionfees")
	public ModelAndView listRecordRecordTransitionfees(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(idKey));
		mav.setViewName("record/recordtransitionfees/listRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Record
	 * 
	 */
	@RequestMapping("/listRecordProject")
	public ModelAndView listRecordProject(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(idKey));
		mav.setViewName("record/project/listProject.jsp");

		return mav;
	}

	/**
	 * View an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/selectRecordRecordTransitionfees")
	public ModelAndView selectRecordRecordTransitionfees(@RequestParam Integer record_id, @RequestParam Integer recordtransitionfees_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfees_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("record_id", record_id);
		mav.addObject("recordtransitionfee", recordtransitionfee);
		mav.setViewName("record/recordtransitionfees/viewRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	@RequestMapping("/deleteRecordCuser")
	public ModelAndView deleteRecordCuser(@RequestParam Integer record_id, @RequestParam Integer related_cuser_id,HttpServletRequest request,HttpServletResponse response) {
		
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁用户";
		
		try {
		
			ModelAndView mav = new ModelAndView();

			Record record = recordService.deleteRecordCuser(record_id, related_cuser_id);

			mav.addObject("record_id", record_id);
			mav.addObject("record", record);
			mav.setViewName("record/viewRecord.jsp");

			return mav;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}
}