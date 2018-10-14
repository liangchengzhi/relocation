package common.web;

import common.dao.CuserDAO;
import common.dao.RecordDAO;
import common.dao.RecordTransitionfeeDAO;
import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;
import common.service.CuserService;
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
 * Spring MVC controller that handles CRUD requests for Cuser entities
 * 
 */

@Controller("CuserController")
public class CuserController {

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
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;

	/**
	 * Show all Record entities by Cuser
	 * 
	 */
	@RequestMapping("/listCuserRecords")
	public ModelAndView listCuserRecords(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", cuserDAO.findCuserByPrimaryKey(idKey));
		mav.setViewName("cuser/records/listRecords.jsp");

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
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/deleteCuserRecordTransitionfees")
	public ModelAndView deleteCuserRecordTransitionfees(@RequestParam Integer cuser_id, @RequestParam Integer related_recordtransitionfees_id,HttpServletRequest request, HttpServletResponse response) {
		
		Cuser cuser1 = currentUser.getCuser(request, response);
		String username = (cuser1 == null) ? "" : cuser1.getUsername();
		String tranName = "删除过渡费记录";
		
		try {
			ModelAndView mav = new ModelAndView();

			Cuser cuser = cuserService.deleteCuserRecordTransitionfees(cuser_id, related_recordtransitionfees_id);

			mav.addObject("cuser_id", cuser_id);
			mav.addObject("cuser", cuser);
			mav.setViewName("cuser/viewCuser.jsp");
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Entry point to show all Cuser entities
	 * 
	 */
	public String indexCuser() {
		return "redirect:/indexCuser";
	}

	/**
	 * Select the child Record entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteCuserRecords")
	public ModelAndView confirmDeleteCuserRecords(@RequestParam Integer cuser_id, @RequestParam Integer related_records_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("record", recordDAO.findRecordByPrimaryKey(related_records_id));
		mav.addObject("cuser_id", cuser_id);
		mav.setViewName("cuser/records/deleteRecords.jsp");

		return mav;
	}

	/**
	 * Edit an existing Cuser entity
	 * 
	 */
	@RequestMapping("/editCuser")
	public ModelAndView editCuser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", cuserDAO.findCuserByPrimaryKey(idKey));
		mav.setViewName("cuser/editCuser.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/cuserController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	@RequestMapping("/saveCuserRecords")
	public ModelAndView saveCuserRecords(@RequestParam Integer cuser_id, @ModelAttribute Record records,@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存用户信息";
		try {
			Cuser parent_cuser = cuserService.saveCuserRecords(cuser_id, records);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("cuser_id", cuser_id);
			mav.addObject("cuser", parent_cuser);
			mav.setViewName("cuser/viewCuser.jsp");
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return mav;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}

	}

	/**
	 * Show all Cuser entities
	 * 
	 */
	@RequestMapping("/indexCuser")
	public ModelAndView listCusers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cusers", cuserService.loadCusers());

		mav.setViewName("cuser/listCusers.jsp");

		return mav;
	}

	/**
	 * Create a new Record entity
	 * 
	 */
	@RequestMapping("/newCuserRecords")
	public ModelAndView newCuserRecords(@RequestParam Integer cuser_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("cuser_id", cuser_id);
		mav.addObject("record", new Record());
		mav.addObject("newFlag", true);
		mav.setViewName("cuser/records/editRecords.jsp");

		return mav;
	}

	/**
	 * Create a new RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/newCuserRecordTransitionfees")
	public ModelAndView newCuserRecordTransitionfees(@RequestParam Integer cuser_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("cuser_id", cuser_id);
		mav.addObject("recordtransitionfee", new RecordTransitionfee());
		mav.addObject("newFlag", true);
		mav.setViewName("cuser/recordtransitionfees/editRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Edit an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/editCuserRecordTransitionfees")
	public ModelAndView editCuserRecordTransitionfees(@RequestParam Integer cuser_id, @RequestParam Integer recordtransitionfees_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfees_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("cuser_id", cuser_id);
		mav.addObject("recordtransitionfee", recordtransitionfee);
		mav.setViewName("cuser/recordtransitionfees/editRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Edit an existing Record entity
	 * 
	 */
	@RequestMapping("/editCuserRecords")
	public ModelAndView editCuserRecords(@RequestParam Integer cuser_id, @RequestParam Integer records_id) {
		Record record = recordDAO.findRecordByPrimaryKey(records_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("cuser_id", cuser_id);
		mav.addObject("record", record);
		mav.setViewName("cuser/records/editRecords.jsp");

		return mav;
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	@RequestMapping("/deleteCuserRecords")
	public ModelAndView deleteCuserRecords(@RequestParam Integer cuser_id, @RequestParam Integer related_records_id,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser1 = currentUser.getCuser(request, response);
		String username = (cuser1 == null) ? "" : cuser1.getUsername();
		String tranName = "删除用户";
		
		try {
			ModelAndView mav = new ModelAndView();

			Cuser cuser = cuserService.deleteCuserRecords(cuser_id, related_records_id);

			mav.addObject("cuser_id", cuser_id);
			mav.addObject("cuser", cuser);
			mav.setViewName("cuser/viewCuser.jsp");
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return mav;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}

	/**
	 * View an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/selectCuserRecordTransitionfees")
	public ModelAndView selectCuserRecordTransitionfees(@RequestParam Integer cuser_id, @RequestParam Integer recordtransitionfees_id) {
		RecordTransitionfee recordtransitionfee = recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(recordtransitionfees_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("cuser_id", cuser_id);
		mav.addObject("recordtransitionfee", recordtransitionfee);
		mav.setViewName("cuser/recordtransitionfees/viewRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Delete an existing Cuser entity
	 * 
	 */
	@RequestMapping("/deleteCuser")
	public String deleteCuser(@RequestParam Integer idKey,HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser1 = currentUser.getCuser(request, response);
		String username = (cuser1 == null) ? "" : cuser1.getUsername();
		String tranName = "删除用户";
		
		try {
			Cuser cuser = cuserDAO.findCuserByPrimaryKey(idKey);
			cuserService.deleteCuser(cuser);
			return "forward:/indexCuser";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}

	}

	/**
	 * Select an existing Cuser entity
	 * 
	 */
	@RequestMapping("/selectCuser")
	public ModelAndView selectCuser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", cuserDAO.findCuserByPrimaryKey(idKey));
		mav.setViewName("cuser/viewCuser.jsp");

		return mav;
	}

	/**
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@RequestMapping("/saveCuserRecordTransitionfees")
	public ModelAndView saveCuserRecordTransitionfees(@RequestParam Integer cuser_id, @ModelAttribute RecordTransitionfee recordtransitionfees,
			HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser1 = currentUser.getCuser(request, response);
		String username = (cuser1 == null) ? "" : cuser1.getUsername();
		String tranName = "保存拆迁过渡费";
		
		try {
			Cuser parent_cuser = cuserService.saveCuserRecordTransitionfees(cuser_id, recordtransitionfees);

			ModelAndView mav = new ModelAndView();
			mav.addObject("cuser_id", cuser_id);
			mav.addObject("cuser", parent_cuser);
			mav.setViewName("cuser/viewCuser.jsp");
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");

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
	@RequestMapping("/saveCuser")
	public String saveCuser(@ModelAttribute Cuser cuser,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser1 = currentUser.getCuser(request, response);
		String username = (cuser1 == null) ? "" : cuser1.getUsername();
		String tranName = "保存用户信息";
		
		try {
			cuserService.saveCuser(cuser);
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return "forward:/indexCuser";
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}

	/**
	 * Create a new Cuser entity
	 * 
	 */
	@RequestMapping("/newCuser")
	public ModelAndView newCuser() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", new Cuser());
		mav.addObject("newFlag", true);
		mav.setViewName("cuser/editCuser.jsp");

		return mav;
	}

	/**
	 * Select the Cuser entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteCuser")
	public ModelAndView confirmDeleteCuser(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", cuserDAO.findCuserByPrimaryKey(idKey));
		mav.setViewName("cuser/deleteCuser.jsp");

		return mav;
	}

	/**
	 * View an existing Record entity
	 * 
	 */
	@RequestMapping("/selectCuserRecords")
	public ModelAndView selectCuserRecords(@RequestParam Integer cuser_id, @RequestParam Integer records_id) {
		Record record = recordDAO.findRecordByPrimaryKey(records_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("cuser_id", cuser_id);
		mav.addObject("record", record);
		mav.setViewName("cuser/records/viewRecords.jsp");

		return mav;
	}

	/**
	 * Show all RecordTransitionfee entities by Cuser
	 * 
	 */
	@RequestMapping("/listCuserRecordTransitionfees")
	public ModelAndView listCuserRecordTransitionfees(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("cuser", cuserDAO.findCuserByPrimaryKey(idKey));
		mav.setViewName("cuser/recordtransitionfees/listRecordTransitionfees.jsp");

		return mav;
	}

	/**
	 * Select the child RecordTransitionfee entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteCuserRecordTransitionfees")
	public ModelAndView confirmDeleteCuserRecordTransitionfees(@RequestParam Integer cuser_id, @RequestParam Integer related_recordtransitionfees_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordtransitionfee", recordTransitionfeeDAO.findRecordTransitionfeeByPrimaryKey(related_recordtransitionfees_id));
		mav.addObject("cuser_id", cuser_id);
		mav.setViewName("cuser/recordtransitionfees/deleteRecordTransitionfees.jsp");

		return mav;
	}
}