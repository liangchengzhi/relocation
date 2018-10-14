package common.service;

import common.domain.Sendsms;

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
public class SendsmsServiceTest {

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
	protected SendsmsService service;

	/**
	 * Instantiates a new SendsmsServiceTest.
	 *
	 */
	public SendsmsServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSendsmsByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findSendsmsByPrimaryKey 
		Integer id = 0;
		Sendsms response = null;
		response = service.findSendsmsByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findSendsmsByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sendsms entity
	 * 
	 */
	@Test
	public void deleteSendsms() {
		// TODO: JUnit - Populate test inputs for operation: deleteSendsms 
		Sendsms sendsms = new common.domain.Sendsms();
		service.deleteSendsms(sendsms);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Sendsms entity
	 * 
	 */
	@Test
	public void loadSendsmss() {
		Set<Sendsms> response = null;
		response = service.loadSendsmss();
		// TODO: JUnit - Add assertions to test outputs of operation: loadSendsmss
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Sendsms entity
	 * 
	 */
	@Test
	public void countSendsmss() {
		Integer response = null;
		response = service.countSendsmss();
		// TODO: JUnit - Add assertions to test outputs of operation: countSendsmss
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sendsms entity
	 * 
	 */
	@Test
	public void saveSendsms() {
		// TODO: JUnit - Populate test inputs for operation: saveSendsms 
		Sendsms sendsms_1 = new common.domain.Sendsms();
		service.saveSendsms(sendsms_1);
	}

	/**
	 * Operation Unit Test
	 * Return all Sendsms entity
	 * 
	 */
	@Test
	public void findAllSendsmss() {
		// TODO: JUnit - Populate test inputs for operation: findAllSendsmss 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Sendsms> response = null;
		response = service.findAllSendsmss(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllSendsmss
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
