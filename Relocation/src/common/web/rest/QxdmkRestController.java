package common.web.rest;

import common.dao.QxdmkDAO;
import common.domain.Qxdmk;
import common.service.QxdmkService;

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
 * Spring Rest controller that handles CRUD requests for Qxdmk entities
 * 
 */

@Controller("QxdmkRestController")
@Transactional
public class QxdmkRestController {

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

	/**
	 * Create a new Qxdmk entity
	 * 
	 */
	@RequestMapping(value = "/Qxdmk", method = RequestMethod.POST)
	@ResponseBody
	public Qxdmk newQxdmk(@RequestBody Qxdmk qxdmk) {
		qxdmkService.saveQxdmk(qxdmk);
		return qxdmkDAO.findQxdmkByPrimaryKey(qxdmk.getQxdm());
	}

	/**
	 * Show all Qxdmk entities
	 * 
	 */
	@RequestMapping(value = "/Qxdmk", method = RequestMethod.GET)
	@ResponseBody
	public List<Qxdmk> listQxdmks() {
		return new java.util.ArrayList<Qxdmk>(qxdmkService.loadQxdmks());
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
	 * Delete an existing Qxdmk entity
	 * 
	 */
	@RequestMapping(value = "/Qxdmk/{qxdmk_qxdm}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteQxdmk(@PathVariable String qxdmk_qxdm) {
		Qxdmk qxdmk = qxdmkDAO.findQxdmkByPrimaryKey(qxdmk_qxdm);
		qxdmkService.deleteQxdmk(qxdmk);
	}

	/**
	 * Save an existing Qxdmk entity
	 * 
	 */
	@RequestMapping(value = "/Qxdmk", method = RequestMethod.PUT)
	@ResponseBody
	public Qxdmk saveQxdmk(@RequestBody Qxdmk qxdmk) {
		qxdmkService.saveQxdmk(qxdmk);
		return qxdmkDAO.findQxdmkByPrimaryKey(qxdmk.getQxdm());
	}

	/**
	 * Select an existing Qxdmk entity
	 * 
	 */
	@RequestMapping(value = "/Qxdmk/{qxdmk_qxdm}", method = RequestMethod.GET)
	@ResponseBody
	public Qxdmk loadQxdmk(@PathVariable String qxdmk_qxdm) {
		return qxdmkDAO.findQxdmkByPrimaryKey(qxdmk_qxdm);
	}
}