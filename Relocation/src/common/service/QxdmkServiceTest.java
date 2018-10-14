package common.service;

import common.domain.Qxdmk;

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
public class QxdmkServiceTest {

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
	protected QxdmkService service;

	/**
	 * Instantiates a new QxdmkServiceTest.
	 *
	 */
	public QxdmkServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Qxdmk entity
	 * 
	 */
	@Test
	public void saveQxdmk() {
		// TODO: JUnit - Populate test inputs for operation: saveQxdmk 
		Qxdmk qxdmk = new common.domain.Qxdmk();
		service.saveQxdmk(qxdmk);
	}

	/**
	 * Operation Unit Test
	 * Load an existing Qxdmk entity
	 * 
	 */
	@Test
	public void loadQxdmks() {
		Set<Qxdmk> response = null;
		response = service.loadQxdmks();
		// TODO: JUnit - Add assertions to test outputs of operation: loadQxdmks
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Qxdmk entity
	 * 
	 */
	@Test
	public void deleteQxdmk() {
		// TODO: JUnit - Populate test inputs for operation: deleteQxdmk 
		Qxdmk qxdmk_1 = new common.domain.Qxdmk();
		service.deleteQxdmk(qxdmk_1);
	}

	/**
	 * Operation Unit Test
	 * Return all Qxdmk entity
	 * 
	 */
	@Test
	public void findAllQxdmks() {
		// TODO: JUnit - Populate test inputs for operation: findAllQxdmks 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Qxdmk> response = null;
		response = service.findAllQxdmks(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllQxdmks
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Qxdmk entity
	 * 
	 */
	@Test
	public void countQxdmks() {
		Integer response = null;
		response = service.countQxdmks();
		// TODO: JUnit - Add assertions to test outputs of operation: countQxdmks
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findQxdmkByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findQxdmkByPrimaryKey 
		String qxdm = null;
		Qxdmk response = null;
		response = service.findQxdmkByPrimaryKey(qxdm);
		// TODO: JUnit - Add assertions to test outputs of operation: findQxdmkByPrimaryKey
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
