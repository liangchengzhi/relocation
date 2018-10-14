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
public class CuserServiceTest {

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
	protected CuserService service;

	/**
	 * Instantiates a new CuserServiceTest.
	 *
	 */
	public CuserServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Record entity
	 * 
	 */
	@Test
	public void saveCuserRecords() {
		// TODO: JUnit - Populate test inputs for operation: saveCuserRecords 
		Integer id = 0;
		Record related_records = new common.domain.Record();
		Cuser response = null;
		response = service.saveCuserRecords(id, related_records);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCuserRecords
	}

	/**
	 * Operation Unit Test
	 * Save an existing Cuser entity
	 * 
	 */
	@Test
	public void saveCuser() {
		// TODO: JUnit - Populate test inputs for operation: saveCuser 
		Cuser cuser = new common.domain.Cuser();
		service.saveCuser(cuser);
	}

	/**
	 * Operation Unit Test
	 * Save an existing RecordTransitionfee entity
	 * 
	 */
	@Test
	public void saveCuserRecordTransitionfees() {
		// TODO: JUnit - Populate test inputs for operation: saveCuserRecordTransitionfees 
		Integer id_1 = 0;
		RecordTransitionfee related_recordtransitionfees = new common.domain.RecordTransitionfee();
		Cuser response = null;
		response = service.saveCuserRecordTransitionfees(id_1, related_recordtransitionfees);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCuserRecordTransitionfees
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Record entity
	 * 
	 */
	@Test
	public void deleteCuserRecords() {
		// TODO: JUnit - Populate test inputs for operation: deleteCuserRecords 
		Integer cuser_id = 0;
		Integer related_records_id = 0;
		Cuser response = null;
		response = service.deleteCuserRecords(cuser_id, related_records_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCuserRecords
	}

	/**
	 * Operation Unit Test
	 * Load an existing Cuser entity
	 * 
	 */
	@Test
	public void loadCusers() {
		Set<Cuser> response = null;
		response = service.loadCusers();
		// TODO: JUnit - Add assertions to test outputs of operation: loadCusers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing RecordTransitionfee entity
	 * 
	 */
	@Test
	public void deleteCuserRecordTransitionfees() {
		// TODO: JUnit - Populate test inputs for operation: deleteCuserRecordTransitionfees 
		Integer cuser_id_1 = 0;
		Integer related_recordtransitionfees_id = 0;
		Cuser response = null;
		response = service.deleteCuserRecordTransitionfees(cuser_id_1, related_recordtransitionfees_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCuserRecordTransitionfees
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Cuser entity
	 * 
	 */
	@Test
	public void deleteCuser() {
		// TODO: JUnit - Populate test inputs for operation: deleteCuser 
		Cuser cuser_1 = new common.domain.Cuser();
		service.deleteCuser(cuser_1);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Cuser entity
	 * 
	 */
	@Test
	public void countCusers() {
		Integer response = null;
		response = service.countCusers();
		// TODO: JUnit - Add assertions to test outputs of operation: countCusers
	}

	/**
	 * Operation Unit Test
	 * Return all Cuser entity
	 * 
	 */
	@Test
	public void findAllCusers() {
		// TODO: JUnit - Populate test inputs for operation: findAllCusers 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Cuser> response = null;
		response = service.findAllCusers(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllCusers
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findCuserByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findCuserByPrimaryKey 
		Integer id_1 = 0;
		Cuser response = null;
		response = service.findCuserByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findCuserByPrimaryKey
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
