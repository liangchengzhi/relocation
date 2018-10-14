package common.service;

import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class RecordTransitionfeeServiceTest {

	/**
	 * The Spring application context.
	 *
	 */
	@SuppressWarnings("unused")
	private ApplicationContext context;

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected RecordTransitionfeeService service;

	/**
	 * Instantiates a new RecordTransitionfeeServiceTest.
	 *
	 */
	public RecordTransitionfeeServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Record entity
	 * 
	 */
	@Test
	public void deleteRecordTransitionfeeRecord() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecordTransitionfeeRecord 
		Integer recordtransitionfee_id = 0;
		Integer related_record_id = 0;
		RecordTransitionfee response = null;
		response = service.deleteRecordTransitionfeeRecord(recordtransitionfee_id, related_record_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteRecordTransitionfeeRecord
	}

	/**
	 * Operation Unit Test
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@Test
	public void deleteRecordTransitionfee() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecordTransitionfee 
		RecordTransitionfee recordtransitionfee = new common.domain.RecordTransitionfee();
		service.deleteRecordTransitionfee(recordtransitionfee);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findRecordTransitionfeeByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findRecordTransitionfeeByPrimaryKey 
		Integer id = 0;
		RecordTransitionfee response = null;
		response = service.findRecordTransitionfeeByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findRecordTransitionfeeByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@Test
	public void saveRecordTransitionfee() {
		// TODO: JUnit - Populate test inputs for operation: saveRecordTransitionfee 
		RecordTransitionfee recordtransitionfee_1 = new common.domain.RecordTransitionfee();
		service.saveRecordTransitionfee(recordtransitionfee_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all RecordTransitionfee entity
	 * 
	 */
	@Test
	public void countRecordTransitionfees() {
		Integer response = null;
		response = service.countRecordTransitionfees();
		// TODO: JUnit - Add assertions to test outputs of operation: countRecordTransitionfees
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Cuser entity
	 * 
	 */
	@Test
	public void deleteRecordTransitionfeeCuser() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecordTransitionfeeCuser 
		Integer recordtransitionfee_id_1 = 0;
		Integer related_cuser_id = 0;
		RecordTransitionfee response = null;
		response = service.deleteRecordTransitionfeeCuser(recordtransitionfee_id_1, related_cuser_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteRecordTransitionfeeCuser
	}

	/**
	 * Operation Unit Test
	 * Save an existing Cuser entity
	 * 
	 */
	@Test
	public void saveRecordTransitionfeeCuser() {
		// TODO: JUnit - Populate test inputs for operation: saveRecordTransitionfeeCuser 
		Integer id_1 = 0;
		Cuser related_cuser = new common.domain.Cuser();
		RecordTransitionfee response = null;
		response = service.saveRecordTransitionfeeCuser(id_1, related_cuser);
		// TODO: JUnit - Add assertions to test outputs of operation: saveRecordTransitionfeeCuser
	}

	/**
	 * Operation Unit Test
	 * Return all RecordTransitionfee entity
	 * 
	 */
	@Test
	public void findAllRecordTransitionfees() {
		// TODO: JUnit - Populate test inputs for operation: findAllRecordTransitionfees 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<RecordTransitionfee> response = null;
		response = service.findAllRecordTransitionfees(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllRecordTransitionfees
	}

	/**
	 * Operation Unit Test
	 * Load an existing RecordTransitionfee entity
	 * 
	 */
	@Test
	public void loadRecordTransitionfees() {
		Set<RecordTransitionfee> response = null;
		response = service.loadRecordTransitionfees();
		// TODO: JUnit - Add assertions to test outputs of operation: loadRecordTransitionfees
	}

	/**
	 * Operation Unit Test
	 * Save an existing Record entity
	 * 
	 */
	@Test
	public void saveRecordTransitionfeeRecord() {
		// TODO: JUnit - Populate test inputs for operation: saveRecordTransitionfeeRecord 
		Integer id_2 = 0;
		Record related_record = new common.domain.Record();
		RecordTransitionfee response = null;
		response = service.saveRecordTransitionfeeRecord(id_2, related_record);
		// TODO: JUnit - Add assertions to test outputs of operation: saveRecordTransitionfeeRecord
	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		this.context = context;
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
