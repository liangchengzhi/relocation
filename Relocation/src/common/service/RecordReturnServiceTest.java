package common.service;

import common.domain.RecordReturn;

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
public class RecordReturnServiceTest {

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
	protected RecordReturnService service;

	/**
	 * Instantiates a new RecordReturnServiceTest.
	 *
	 */
	public RecordReturnServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing RecordReturn entity
	 * 
	 */
	@Test
	public void saveRecordReturn() {
		// TODO: JUnit - Populate test inputs for operation: saveRecordReturn 
		RecordReturn recordreturn = new common.domain.RecordReturn();
		service.saveRecordReturn(recordreturn);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing RecordReturn entity
	 * 
	 */
	@Test
	public void deleteRecordReturn() {
		// TODO: JUnit - Populate test inputs for operation: deleteRecordReturn 
		RecordReturn recordreturn_1 = new common.domain.RecordReturn();
		service.deleteRecordReturn(recordreturn_1);
	}

	/**
	 * Operation Unit Test
	 * Return all RecordReturn entity
	 * 
	 */
	@Test
	public void findAllRecordReturns() {
		// TODO: JUnit - Populate test inputs for operation: findAllRecordReturns 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<RecordReturn> response = null;
		response = service.findAllRecordReturns(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllRecordReturns
	}

	/**
	 * Operation Unit Test
	 * Return a count of all RecordReturn entity
	 * 
	 */
	@Test
	public void countRecordReturns() {
		Integer response = null;
		response = service.countRecordReturns();
		// TODO: JUnit - Add assertions to test outputs of operation: countRecordReturns
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findRecordReturnByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findRecordReturnByPrimaryKey 
		Integer id = 0;
		RecordReturn response = null;
		response = service.findRecordReturnByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findRecordReturnByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Load an existing RecordReturn entity
	 * 
	 */
	@Test
	public void loadRecordReturns() {
		Set<RecordReturn> response = null;
		response = service.loadRecordReturns();
		// TODO: JUnit - Add assertions to test outputs of operation: loadRecordReturns
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
