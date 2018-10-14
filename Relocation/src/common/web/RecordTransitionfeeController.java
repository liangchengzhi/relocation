package common.web;

import common.dao.CuserDAO;
import common.dao.RecordDAO;
import common.dao.RecordTransitionfeeDAO;
import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;
import common.service.CuserService;
import common.service.RecordTransitionfeeService;
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
 * Spring MVC controller that handles CRUD requests for RecordTransitionfee entities
 * 
 */

@Controller("RecordTransitionfeeController")
public class RecordTransitionfeeController {

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
	
	@Autowired
	private CuserService cuserService;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;
	
	/**
	 * Create a new Cuser entity
	 * 
	 */
	@RequestMapping("/newRecordTransitionfeeCuser")
	public ModelAndView newRecordTransitionfeeCuser(@RequestParam Integer recordtransitionfee_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.addObject("cuser", new Cuser());
		mav.addObject("newFlag", true);
		mav.setViewName("recordtransitionfee/cuser/editCuser.jsp");

		return mav;
	}

	/**
	 * View an existing Cuser entity
	 * 
	 */
	@RequestMapping("/selectRecordTransitionfeeCuser")
	public ModelAndView selectRecordTransitionfeeCuser(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer cuser_id) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(cuser_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.addObject("cuser", cuser);
		mav.setViewName("recordtransitionfee/cuser/viewCuser.jsp");

		return mav;
	}

	/**
	 * Show all RecordTransitionfee entities
	 * 
	 */
	@RequestMapping("/indexRecordTransitionfee")
	public ModelAndView listRecordTransitionfees() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfees", recordTransitionfeeService.loadRecordTransitionfees());

		mav.setViewName("recordtransitionfee/listRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping("/newRecordTransitionfeeRecord")
	public ModelAndView newRecordTransitionfeeRecord(@RequestParam Integer recordtransitionfee_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.addObject("record", new Record());
		mav.addObject("newFlag", true);
		mav.setViewName("recordtransitionfee/record/editRecord.jsp");

		return mav;
	}

	/**
	 * Create a new RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/newRecordTransitionfee")
	public ModelAndView newRecordTransitionfee() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", new RecordTransitionfee());
		mav.addObject("newFlag", true);
		mav.setViewName("recordtransitionfee/editRecordTransitionfee.jsp");

		return mav;
	}

	/**
	 * Show all Cuser entities by RecordTransitionfee
	 * 
	 */
	@RequestMapping("/listRecordTransitionfeeCuser")
	public ModelAndView listRecordTransitionfeeCuser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(idKey));
		mav.setViewName("recordtransitionfee/cuser/listCuser.jsp");

		return mav;
	}

	/**
	 * Select the child Cuser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecordTransitionfeeCuser")
	public ModelAndView confirmDeleteRecordTransitionfeeCuser(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer related_cuser_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", cuserDAO.findCuserByPrimaryKey(related_cuser_id));
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.setViewName("recordtransitionfee/cuser/deleteCuser.jsp");

		return mav;
	}

	/**
	 * Show all Record entities by RecordTransitionfee
	 * 
	 */
	@RequestMapping("/listRecordTransitionfeeRecord")
	public ModelAndView listRecordTransitionfeeRecord(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(idKey));
		mav.setViewName("recordtransitionfee/record/listRecord.jsp");

		return mav;
	}

	/**
	 * Select the RecordTransitionfee entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecordTransitionfee")
	public ModelAndView confirmDeleteRecordTransitionfee(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(idKey));
		mav.setViewName("recordtransitionfee/deleteRecordTransitionfee.jsp");

		return mav;
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	@RequestMapping("/deleteRecordTransitionfeeCuser")
	public ModelAndView deleteRecordTransitionfeeCuser(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer related_cuser_id,
			HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁过渡费用户";
		
		try {
		
			ModelAndView mav = new ModelAndView();

			RecordTransitionfee recordtransitionfee = recordTransitionfeeService.deleteRecordTransitionfeeCuser(recordtransitionfee_id, related_cuser_id);

			mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
			mav.addObject("recordtransitionfee", recordtransitionfee);
			mav.setViewName("recordtransitionfee/viewRecordTransitionfee.jsp");

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
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping("/deleteRecordTransitionfeeRecord")
	public ModelAndView deleteRecordTransitionfeeRecord(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer related_record_id,
			HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁过渡费用户";
		
		try {
		
			ModelAndView mav = new ModelAndView();
			RecordTransitionfee recordtransitionfee = recordTransitionfeeService.deleteRecordTransitionfeeRecord(recordtransitionfee_id, related_record_id);

			mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
			mav.addObject("recordtransitionfee", recordtransitionfee);
			mav.setViewName("recordtransitionfee/viewRecordTransitionfee.jsp");
			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 */
	@RequestMapping("/recordtransitionfeeController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/editRecordTransitionfee")
	public ModelAndView editRecordTransitionfee(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(idKey));
		mav.setViewName("recordtransitionfee/editRecordTransitionfee.jsp");

		return mav;
	}

	/**
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/deleteRecordTransitionfee")
	public String deleteRecordTransitionfee(@RequestParam Integer idKey,HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除拆迁过渡费用户";
		
		try {
		
			RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(idKey);
			recordTransitionfeeService.deleteRecordTransitionfee(recordtransitionfee);
			return "forward:/indexRecordTransitionfee";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Entry point to show all RecordTransitionfee entities
	 * 
	 */
	public String indexRecordTransitionfee() {
		return "redirect:/indexRecordTransitionfee";
	}

	/**
	 * Edit an existing Record entity
	 * 
	 */
	@RequestMapping("/editRecordTransitionfeeRecord")
	public ModelAndView editRecordTransitionfeeRecord(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer record_id) {
		Record record = recordDAO.findRecordByPrimaryKey(record_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.addObject("record", record);
		mav.setViewName("recordtransitionfee/record/editRecord.jsp");

		return mav;
	}

	/**
	 * View an existing Record entity
	 * 
	 */
	@RequestMapping("/selectRecordTransitionfeeRecord")
	public ModelAndView selectRecordTransitionfeeRecord(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer record_id) {
		Record record = recordDAO.findRecordByPrimaryKey(record_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.addObject("record", record);
		mav.setViewName("recordtransitionfee/record/viewRecord.jsp");

		return mav;
	}

	/**
	 * Select the child Record entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecordTransitionfeeRecord")
	public ModelAndView confirmDeleteRecordTransitionfeeRecord(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer related_record_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(related_record_id));
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.setViewName("recordtransitionfee/record/deleteRecord.jsp");

		return mav;
	}

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/saveRecordTransitionfee")
	public String saveRecordTransitionfee(@ModelAttribute RecordTransitionfee recordtransitionfee,HttpServletRequest request,HttpServletResponse response) {
		
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁过渡费信息";
		
		try {
			recordTransitionfeeService.saveRecordTransitionfee(recordtransitionfee);
			return "forward:/indexRecordTransitionfee";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Select an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/selectRecordTransitionfee")
	public ModelAndView selectRecordTransitionfee(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(idKey));
		mav.setViewName("recordtransitionfee/viewRecordTransitionfee.jsp");

		return mav;
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping("/saveRecordTransitionfeeRecord")
	public ModelAndView saveRecordTransitionfeeRecord(@RequestParam Integer recordtransitionfee_id, @ModelAttribute Record record,HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存拆迁过渡费信息";
		
		try {
			RecordTransitionfee parent_recordtransitionfee = recordTransitionfeeService.saveRecordTransitionfeeRecord(recordtransitionfee_id, record);

			ModelAndView mav = new ModelAndView();
			mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
			mav.addObject("recordtransitionfee", parent_recordtransitionfee);
			mav.setViewName("recordtransitionfee/viewRecordTransitionfee.jsp");

			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Save an existing Cuser entity
	 * 
	 */
	@RequestMapping("/saveRecordTransitionfeeCuser")
	public ModelAndView saveRecordTransitionfeeCuser(@RequestParam Integer recordtransitionfee_id, @ModelAttribute Cuser cuser,HttpServletRequest request,HttpServletResponse response) {
		
		
		Cuser cuser1 = currentUser.getCuser(request, response);
		String username = (cuser1 == null) ? "" : cuser1.getUsername();
		String tranName = "保存拆迁过渡费用户信息";
		
		try {
			RecordTransitionfee parent_recordtransitionfee = recordTransitionfeeService.saveRecordTransitionfeeCuser(recordtransitionfee_id, cuser);

			ModelAndView mav = new ModelAndView();
			mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
			mav.addObject("recordtransitionfee", parent_recordtransitionfee);
			mav.setViewName("recordtransitionfee/viewRecordTransitionfee.jsp");

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
	@RequestMapping("/editRecordTransitionfeeCuser")
	public ModelAndView editRecordTransitionfeeCuser(@RequestParam Integer recordtransitionfee_id, @RequestParam Integer cuser_id) {
		Cuser cuser = cuserDAO.findCuserByPrimaryKey(cuser_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recordtransitionfee_id", recordtransitionfee_id);
		mav.addObject("cuser", cuser);
		mav.setViewName("recordtransitionfee/cuser/editCuser.jsp");

		return mav;
	}
}