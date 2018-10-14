package common.web;

import common.dao.RecordReturnDAO;
import common.domain.Cuser;
import common.domain.RecordReturn;
import common.service.CuserService;
import common.service.RecordReturnService;
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
 * Spring MVC controller that handles CRUD requests for RecordReturn entities
 * 
 */

@Controller("RecordReturnController")
public class RecordReturnController {

	/**
	 * DAO injected by Spring that manages RecordReturn entities
	 * 
	 */
	@Autowired
	private RecordReturnDAO recordReturnDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for RecordReturn entities
	 * 
	 */
	@Autowired
	private RecordReturnService recordReturnService;
	
	@Autowired
	private CuserService cuserService;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;
	
	/**
	 * Delete an existing RecordReturn entity
	 * 
	 */
	@RequestMapping("/deleteRecordReturn")
	public String deleteRecordReturn(@RequestParam Integer idKey,HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除还房信息";
		
		try {
			RecordReturn recordreturn = recordReturnDAO.findRecordReturnByPrimaryKey(idKey);
			recordReturnService.deleteRecordReturn(recordreturn);
			return "forward:/indexRecordReturn";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 */
	@RequestMapping("/recordreturnController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
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
	 * Save an existing RecordReturn entity
	 * 
	 */
	@RequestMapping("/saveRecordReturn")
	public String saveRecordReturn(@ModelAttribute RecordReturn recordreturn,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存还房信息";
		
		try {
			recordReturnService.saveRecordReturn(recordreturn);
			return "forward:/indexRecordReturn";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}

	/**
	 * Edit an existing RecordReturn entity
	 * 
	 */
	@RequestMapping("/editRecordReturn")
	public ModelAndView editRecordReturn(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordreturn", recordReturnDAO.findRecordReturnByPrimaryKey(idKey));
		mav.setViewName("recordreturn/editRecordReturn.jsp");

		return mav;
	}

	/**
	 * Entry point to show all RecordReturn entities
	 * 
	 */
	public String indexRecordReturn() {
		return "redirect:/indexRecordReturn";
	}

	/**
	 * Select the RecordReturn entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecordReturn")
	public ModelAndView confirmDeleteRecordReturn(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordreturn", recordReturnDAO.findRecordReturnByPrimaryKey(idKey));
		mav.setViewName("recordreturn/deleteRecordReturn.jsp");

		return mav;
	}

	/**
	 * Show all RecordReturn entities
	 * 
	 */
	@RequestMapping("/indexRecordReturn")
	public ModelAndView listRecordReturns() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordreturns", recordReturnService.loadRecordReturns());

		mav.setViewName("recordreturn/listRecordReturns.jsp");

		return mav;
	}

	/**
	 * Create a new RecordReturn entity
	 * 
	 */
	@RequestMapping("/newRecordReturn")
	public ModelAndView newRecordReturn() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordreturn", new RecordReturn());
		mav.addObject("newFlag", true);
		mav.setViewName("recordreturn/editRecordReturn.jsp");

		return mav;
	}

	/**
	 * Select an existing RecordReturn entity
	 * 
	 */
	@RequestMapping("/selectRecordReturn")
	public ModelAndView selectRecordReturn(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recordreturn", recordReturnDAO.findRecordReturnByPrimaryKey(idKey));
		mav.setViewName("recordreturn/viewRecordReturn.jsp");

		return mav;
	}
}