package common.web.rest;

import common.dao.SysconfigDAO;
import common.domain.Sysconfig;
import common.service.SysconfigService;

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
 * Spring Rest controller that handles CRUD requests for Sysconfig entities
 * 
 */

@Controller("SysconfigRestController")
@Transactional
public class SysconfigRestController {

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

	/**
	 * Show all Sysconfig entities
	 * 
	 */
	@RequestMapping(value = "/Sysconfig", method = RequestMethod.GET)
	@ResponseBody
	public List<Sysconfig> listSysconfigs() {
		return new java.util.ArrayList<Sysconfig>(sysconfigService.loadSysconfigs());
	}

	/**
	 * Create a new Sysconfig entity
	 * 
	 */
	@RequestMapping(value = "/Sysconfig", method = RequestMethod.POST)
	@ResponseBody
	public Sysconfig newSysconfig(@RequestBody Sysconfig sysconfig) {
		sysconfigService.saveSysconfig(sysconfig);
		return sysconfigDAO.findSysconfigByPrimaryKey(sysconfig.getId());
	}

	/**
	 * Save an existing Sysconfig entity
	 * 
	 */
	@RequestMapping(value = "/Sysconfig", method = RequestMethod.PUT)
	@ResponseBody
	public Sysconfig saveSysconfig(@RequestBody Sysconfig sysconfig) {
		sysconfigService.saveSysconfig(sysconfig);
		return sysconfigDAO.findSysconfigByPrimaryKey(sysconfig.getId());
	}

	/**
	 * Delete an existing Sysconfig entity
	 * 
	 */
	@RequestMapping(value = "/Sysconfig/{sysconfig_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSysconfig(@PathVariable String sysconfig_id) {
		Sysconfig sysconfig = sysconfigDAO.findSysconfigByPrimaryKey(sysconfig_id);
		sysconfigService.deleteSysconfig(sysconfig);
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
	 * Select an existing Sysconfig entity
	 * 
	 */
	@RequestMapping(value = "/Sysconfig/{sysconfig_id}", method = RequestMethod.GET)
	@ResponseBody
	public Sysconfig loadSysconfig(@PathVariable String sysconfig_id) {
		return sysconfigDAO.findSysconfigByPrimaryKey(sysconfig_id);
	}
}