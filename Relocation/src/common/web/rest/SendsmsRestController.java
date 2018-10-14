package common.web.rest;

import common.dao.SendsmsDAO;
import common.domain.Sendsms;
import common.service.SendsmsService;

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
 * Spring Rest controller that handles CRUD requests for Sendsms entities
 * 
 */

@Controller("SendsmsRestController")
@Transactional
public class SendsmsRestController {

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

	/**
	 * Show all Sendsms entities
	 * 
	 */
	@RequestMapping(value = "/Sendsms", method = RequestMethod.GET)
	@ResponseBody
	public List<Sendsms> listSendsmss() {
		return new java.util.ArrayList<Sendsms>(sendsmsService.loadSendsmss());
	}

	/**
	 * Save an existing Sendsms entity
	 * 
	 */
	@RequestMapping(value = "/Sendsms", method = RequestMethod.PUT)
	@ResponseBody
	public Sendsms saveSendsms(@RequestBody Sendsms sendsms) {
		sendsmsService.saveSendsms(sendsms);
		return sendsmsDAO.findSendsmsByPrimaryKey(sendsms.getId());
	}

	/**
	 * Select an existing Sendsms entity
	 * 
	 */
	@RequestMapping(value = "/Sendsms/{sendsms_id}", method = RequestMethod.GET)
	@ResponseBody
	public Sendsms loadSendsms(@PathVariable Integer sendsms_id) {
		return sendsmsDAO.findSendsmsByPrimaryKey(sendsms_id);
	}

	/**
	 * Create a new Sendsms entity
	 * 
	 */
	@RequestMapping(value = "/Sendsms", method = RequestMethod.POST)
	@ResponseBody
	public Sendsms newSendsms(@RequestBody Sendsms sendsms) {
		sendsmsService.saveSendsms(sendsms);
		return sendsmsDAO.findSendsmsByPrimaryKey(sendsms.getId());
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
	 * Delete an existing Sendsms entity
	 * 
	 */
	@RequestMapping(value = "/Sendsms/{sendsms_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSendsms(@PathVariable Integer sendsms_id) {
		Sendsms sendsms = sendsmsDAO.findSendsmsByPrimaryKey(sendsms_id);
		sendsmsService.deleteSendsms(sendsms);
	}
}