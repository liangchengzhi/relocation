package common.web.rest;

import common.dao.RecordReturnDAO;
import common.domain.RecordReturn;
import common.service.RecordReturnService;

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
 * Spring Rest controller that handles CRUD requests for RecordReturn entities
 * 
 */

@Controller("RecordReturnRestController")
@Transactional
public class RecordReturnRestController {

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

	/**
	 * Create a new RecordReturn entity
	 * 
	 */
	@RequestMapping(value = "/RecordReturn", method = RequestMethod.POST)
	@ResponseBody
	public RecordReturn newRecordReturn(@RequestBody RecordReturn recordreturn) {
		recordReturnService.saveRecordReturn(recordreturn);
		return recordReturnDAO.findRecordReturnByPrimaryKey(recordreturn.getId());
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
	 * Show all RecordReturn entities
	 * 
	 */
	@RequestMapping(value = "/RecordReturn", method = RequestMethod.GET)
	@ResponseBody
	public List<RecordReturn> listRecordReturns() {
		return new java.util.ArrayList<RecordReturn>(recordReturnService.loadRecordReturns());
	}

	/**
	 * Delete an existing RecordReturn entity
	 * 
	 */
	@RequestMapping(value = "/RecordReturn/{recordreturn_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRecordReturn(@PathVariable Integer recordreturn_id) {
		RecordReturn recordreturn = recordReturnDAO.findRecordReturnByPrimaryKey(recordreturn_id);
		recordReturnService.deleteRecordReturn(recordreturn);
	}

	/**
	 * Select an existing RecordReturn entity
	 * 
	 */
	@RequestMapping(value = "/RecordReturn/{recordreturn_id}", method = RequestMethod.GET)
	@ResponseBody
	public RecordReturn loadRecordReturn(@PathVariable Integer recordreturn_id) {
		return recordReturnDAO.findRecordReturnByPrimaryKey(recordreturn_id);
	}

	/**
	 * Save an existing RecordReturn entity
	 * 
	 */
	@RequestMapping(value = "/RecordReturn", method = RequestMethod.PUT)
	@ResponseBody
	public RecordReturn saveRecordReturn(@RequestBody RecordReturn recordreturn) {
		recordReturnService.saveRecordReturn(recordreturn);
		return recordReturnDAO.findRecordReturnByPrimaryKey(recordreturn.getId());
	}
}