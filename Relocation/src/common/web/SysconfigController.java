package common.web;

import common.dao.SysconfigDAO;
import common.domain.Cuser;
import common.domain.Sysconfig;
import common.service.CuserService;
import common.service.SysconfigService;
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
 * Spring MVC controller that handles CRUD requests for Sysconfig entities
 * 
 */

@Controller("SysconfigController")
public class SysconfigController {

	/**
	 * DAO injected by Spring that manages Sysconfig entities
	 * 
	 */
	@Autowired
	private SysconfigDAO sysconfigDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Sysconfig entities
	 * 
	 */
	@Autowired
	private SysconfigService sysconfigService;
	
	@Autowired
	private CuserService cuserService;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;

	/**
	 * Create a new Sysconfig entity
	 * 
	 */
	@RequestMapping("/newSysconfig")
	public ModelAndView newSysconfig() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sysconfig", new Sysconfig());
		mav.addObject("newFlag", true);
		mav.setViewName("sysconfig/editSysconfig.jsp");

		return mav;
	}

	/**
	 * Delete an existing Sysconfig entity
	 * 
	 */
	@RequestMapping("/deleteSysconfig")
	public String deleteSysconfig(@RequestParam String idKey,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除系统参数配置信息";
		try {
			Sysconfig sysconfig = sysconfigDAO.findSysconfigByPrimaryKey(idKey);
			sysconfigService.deleteSysconfig(sysconfig);
			return "forward:/indexSysconfig";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Select an existing Sysconfig entity
	 * 
	 */
	@RequestMapping("/selectSysconfig")
	public ModelAndView selectSysconfig(@RequestParam String idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sysconfig", sysconfigDAO.findSysconfigByPrimaryKey(idKey));
		mav.setViewName("sysconfig/viewSysconfig.jsp");

		return mav;
	}

	/**
	 * Save an existing Sysconfig entity
	 * 
	 */
	@RequestMapping("/saveSysconfig")
	public String saveSysconfig(@ModelAttribute Sysconfig sysconfig,HttpServletRequest request,HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "保存系统参数配置信息";
		try {
			sysconfigService.saveSysconfig(sysconfig);
			return "forward:/indexSysconfig";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Show all Sysconfig entities
	 * 
	 */
	@RequestMapping("/indexSysconfig")
	public ModelAndView listSysconfigs() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sysconfigs", sysconfigService.loadSysconfigs());

		mav.setViewName("sysconfig/listSysconfigs.jsp");

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
	 * Entry point to show all Sysconfig entities
	 * 
	 */
	public String indexSysconfig() {
		return "redirect:/indexSysconfig";
	}

	/**
	 * Edit an existing Sysconfig entity
	 * 
	 */
	@RequestMapping("/editSysconfig")
	public ModelAndView editSysconfig(@RequestParam String idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sysconfig", sysconfigDAO.findSysconfigByPrimaryKey(idKey));
		mav.setViewName("sysconfig/editSysconfig.jsp");

		return mav;
	}

	/**
	 * Select the Sysconfig entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteSysconfig")
	public ModelAndView confirmDeleteSysconfig(@RequestParam String idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sysconfig", sysconfigDAO.findSysconfigByPrimaryKey(idKey));
		mav.setViewName("sysconfig/deleteSysconfig.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/sysconfigController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
}