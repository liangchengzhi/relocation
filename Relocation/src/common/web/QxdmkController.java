package common.web;

import common.dao.QxdmkDAO;
import common.domain.Cuser;
import common.domain.Qxdmk;
import common.service.CuserService;
import common.service.QxdmkService;
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
 * Spring MVC controller that handles CRUD requests for Qxdmk entities
 * 
 */

@Controller("QxdmkController")
public class QxdmkController {

	/**
	 * DAO injected by Spring that manages Qxdmk entities
	 * 
	 */
	@Autowired
	private QxdmkDAO qxdmkDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Qxdmk entities
	 * 
	 */
	@Autowired
	private QxdmkService qxdmkService;
	
	@Autowired
	private CuserService cuserService;
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;

	/**
	 */
	@RequestMapping("/qxdmkController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Qxdmk entity
	 * 
	 */
	@RequestMapping("/deleteQxdmk")
	public String deleteQxdmk(@RequestParam String qxdmKey,HttpServletRequest request,HttpServletResponse response) {
		
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除区域信息";
		
		try {
			Qxdmk qxdmk = qxdmkDAO.findQxdmkByPrimaryKey(qxdmKey);
			qxdmkService.deleteQxdmk(qxdmk);
			return "forward:/indexQxdmk";
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Create a new Qxdmk entity
	 * 
	 */
	@RequestMapping("/newQxdmk")
	public ModelAndView newQxdmk() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("qxdmk", new Qxdmk());
		mav.addObject("newFlag", true);
		mav.setViewName("qxdmk/editQxdmk.jsp");

		return mav;
	}

	/**
	 * Select an existing Qxdmk entity
	 * 
	 */
	@RequestMapping("/selectQxdmk")
	public ModelAndView selectQxdmk(@RequestParam String qxdmKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("qxdmk", qxdmkDAO.findQxdmkByPrimaryKey(qxdmKey));
		mav.setViewName("qxdmk/viewQxdmk.jsp");

		return mav;
	}

	/**
	 * Show all Qxdmk entities
	 * 
	 */
	@RequestMapping("/indexQxdmk")
	public ModelAndView listQxdmks() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("qxdmks", qxdmkService.loadQxdmks());

		mav.setViewName("qxdmk/listQxdmks.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Qxdmk entities
	 * 
	 */
	public String indexQxdmk() {
		return "redirect:/indexQxdmk";
	}

	/**
	 * Save an existing Qxdmk entity
	 * 
	 */
	@RequestMapping("/saveQxdmk")
	public String saveQxdmk(@ModelAttribute Qxdmk qxdmk,HttpServletRequest request,HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "更";
		
		try {
		
			qxdmkService.saveQxdmk(qxdmk);
			return "forward:/indexQxdmk";
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	}

	/**
	 * Select the Qxdmk entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteQxdmk")
	public ModelAndView confirmDeleteQxdmk(@RequestParam String qxdmKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("qxdmk", qxdmkDAO.findQxdmkByPrimaryKey(qxdmKey));
		mav.setViewName("qxdmk/deleteQxdmk.jsp");

		return mav;
	}

	/**
	 * Edit an existing Qxdmk entity
	 * 
	 */
	@RequestMapping("/editQxdmk")
	public ModelAndView editQxdmk(@RequestParam String qxdmKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("qxdmk", qxdmkDAO.findQxdmkByPrimaryKey(qxdmKey));
		mav.setViewName("qxdmk/editQxdmk.jsp");

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
}