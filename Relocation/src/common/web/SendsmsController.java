package common.web;

import common.dao.SendsmsDAO;
import common.domain.Cuser;
import common.domain.Sendsms;
import common.service.CuserService;
import common.service.SendsmsService;
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
 * Spring MVC controller that handles CRUD requests for Sendsms entities
 * 
 */

@Controller("SendsmsController")
public class SendsmsController {

	/**
	 * DAO injected by Spring that manages Sendsms entities
	 * 
	 */
	@Autowired
	private SendsmsDAO sendsmsDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Sendsms entities
	 * 
	 */
	@Autowired
	private SendsmsService sendsmsService;
	
	@Autowired
	private CuserService cuserService;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;
	
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
	 * Entry point to show all Sendsms entities
	 * 
	 */
	public String indexSendsms() {
		return "redirect:/indexSendsms";
	}

	/**
	 * Edit an existing Sendsms entity
	 * 
	 */
	@RequestMapping("/editSendsms")
	public ModelAndView editSendsms(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sendsms", sendsmsDAO.findSendsmsByPrimaryKey(idKey));
		mav.setViewName("sendsms/editSendsms.jsp");

		return mav;
	}

	/**
	 * Show all Sendsms entities
	 * 
	 */
	@RequestMapping("/indexSendsms")
	public ModelAndView listSendsmss() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sendsmss", sendsmsService.loadSendsmss());

		mav.setViewName("sendsms/listSendsmss.jsp");

		return mav;
	}

	/**
	 * Save an existing Sendsms entity
	 * 
	 */
	@RequestMapping("/saveSendsms")
	public String saveSendsms(@ModelAttribute Sendsms sendsms,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存短信信息";
		try {
			sendsmsService.saveSendsms(sendsms);
			return "forward:/indexSendsms";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Select an existing Sendsms entity
	 * 
	 */
	@RequestMapping("/selectSendsms")
	public ModelAndView selectSendsms(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sendsms", sendsmsDAO.findSendsmsByPrimaryKey(idKey));
		mav.setViewName("sendsms/viewSendsms.jsp");

		return mav;
	}

	/**
	 * Create a new Sendsms entity
	 * 
	 */
	@RequestMapping("/newSendsms")
	public ModelAndView newSendsms() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sendsms", new Sendsms());
		mav.addObject("newFlag", true);
		mav.setViewName("sendsms/editSendsms.jsp");

		return mav;
	}

	/**
	 * Delete an existing Sendsms entity
	 * 
	 */
	@RequestMapping("/deleteSendsms")
	public String deleteSendsms(@RequestParam Integer idKey,HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除短信信息";
		try {
			Sendsms sendsms = sendsmsDAO.findSendsmsByPrimaryKey(idKey);
			sendsmsService.deleteSendsms(sendsms);
			return "forward:/indexSendsms";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 */
	@RequestMapping("/sendsmsController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select the Sendsms entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSendsms")
	public ModelAndView confirmDeleteSendsms(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sendsms", sendsmsDAO.findSendsmsByPrimaryKey(idKey));
		mav.setViewName("sendsms/deleteSendsms.jsp");

		return mav;
	}
}