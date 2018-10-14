package common.service;

import common.domain.Cuser;
import common.domain.Project;
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
public class RecordServiceTest {

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
	protected RecordService service;

	/**
	 * Instantiates a new RecordServiceTest.
	 *
	 */
	public RecordServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Project entity
	 * 
	 */
	@Test
	public void deleteRecordProject() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecordProject 
		Integer record_id = 0;
		Integer related_project_id = 0;
		Record response = null;
		response = service.deleteRecordProject(record_id, related_project_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteRecordProject
	}

	/**
	 * Operation Unit Test
	 * Save an existing Cuser entity
	 * 
	 */
	@Test
	public void saveRecordCuser() {
		// TODO: JUnit - Populate test inputs for operation: saveRecordCuser 
		Integer id = 0;
		Cuser related_cuser = new common.domain.Cuser();
		Record response = null;
		response = service.saveRecordCuser(id, related_cuser);
		// TODO: JUnit - Add assertions to test outputs of operation: saveRecordCuser
	}

	/**
	 * Operation Unit Test
	 * Save an existing Project entity
	 * 
	 */
	@Test
	public void saveRecordProject() {
		// TODO: JUnit - Populate test inputs for operation: saveRecordProject 
		Integer id_1 = 0;
		Project related_project = new common.domain.Project();
		Record response = null;
		response = service.saveRecordProject(id_1, related_project);
		// TODO: JUnit - Add assertions to test outputs of operation: saveRecordProject
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Record entity
	 * 
	 */
	@Test
	public void countRecords() {
		Integer response = null;
		response = service.countRecords();
		// TODO: JUnit - Add assertions to test outputs of operation: countRecords
	}

	/**
	 * Operation Unit Test
	 * Load an existing Record entity
	 * 
	 */
	@Test
	public void loadRecords() {
		Set<Record> response = null;
		response = service.loadRecords();
		// TODO: JUnit - Add assertions to test outputs of operation: loadRecords
	}

	/**
	 * Operation Unit Test
	 * Save an existing Record entity
	 * 
	 */
	@Test
	public void saveRecord() {
		// TODO: JUnit - Populate test inputs for operation: saveRecord 
		Record record = new common.domain.Record();
		service.saveRecord(record);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@Test
	public void deleteRecordRecordTransitionfees() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecordRecordTransitionfees 
		Integer record_id_2 = 0;
		Integer related_recordtransitionfees_id = 0;
		Record response = null;
		response = service.deleteRecordRecordTransitionfees(record_id_2, related_recordtransitionfees_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteRecordRecordTransitionfees
	}

	/**
	 * Operation Unit Test
	 * Return all Record entity
	 * 
	 */
	@Test
	public void findAllRecords() {
		// TODO: JUnit - Populate test inputs for operation: findAllRecords 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Record> response = null;
		response = service.findAllRecords(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllRecords
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findRecordByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findRecordByPrimaryKey 
		Integer id_2 = 0;
		Record response = null;
		response = service.findRecordByPrimaryKey(id_2);
		// TODO: JUnit - Add assertions to test outputs of operation: findRecordByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Cuser entity
	 * 
	 */
	@Test
	public void deleteRecordCuser() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecordCuser 
		Integer record_id_1 = 0;
		Integer related_cuser_id = 0;
		Record response = null;
		response = service.deleteRecordCuser(record_id_1, related_cuser_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteRecordCuser
	}

	/**
	 * Operation Unit Test
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@Test
	public void saveRecordRecordTransitionfees() {
		// TODO: JUnit - Populate test inputs for operation: saveRecordRecordTransitionfees 
		Integer id_1 = 0;
		RecordTransitionfee related_recordtransitionfees = new common.domain.RecordTransitionfee();
		Record response = null;
		response = service.saveRecordRecordTransitionfees(id_1, related_recordtransitionfees);
		// TODO: JUnit - Add assertions to test outputs of operation: saveRecordRecordTransitionfees
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Record entity
	 * 
	 */
	@Test
	public void deleteRecord() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecord 
		Record record_1 = new common.domain.Record();
		service.deleteRecord(record_1);
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
