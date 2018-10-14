package common.service;

import common.domain.Sysconfig;

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
public class SysconfigServiceTest {

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
	protected SysconfigService service;

	/**
	 * Instantiates a new SysconfigServiceTest.
	 *
	 */
	public SysconfigServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing Sysconfig entity
	 * 
	 */
	@Test
	public void loadSysconfigs() {
		Set<Sysconfig> response = null;
		response = service.loadSysconfigs();
		// TODO: JUnit - Add assertions to test outputs of operation: loadSysconfigs
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sysconfig entity
	 * 
	 */
	@Test
	public void saveSysconfig() {
		// TODO: JUnit - Populate test inputs for operation: saveSysconfig 
		Sysconfig sysconfig = new common.domain.Sysconfig();
		service.saveSysconfig(sysconfig);
	}

	/**
	 * Operation Unit Test
	 * Return all Sysconfig entity
	 * 
	 */
	@Test
	public void findAllSysconfigs() {
		// TODO: JUnit - Populate test inputs for operation: findAllSysconfigs 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Sysconfig> response = null;
		response = service.findAllSysconfigs(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllSysconfigs
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Sysconfig entity
	 * 
	 */
	@Test
	public void countSysconfigs() {
		Integer response = null;
		response = service.countSysconfigs();
		// TODO: JUnit - Add assertions to test outputs of operation: countSysconfigs
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sysconfig entity
	 * 
	 */
	@Test
	public void deleteSysconfig() {
		// TODO: JUnit - Populate test inputs for operation: deleteSysconfig 
		Sysconfig sysconfig_1 = new common.domain.Sysconfig();
		service.deleteSysconfig(sysconfig_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSysconfigByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findSysconfigByPrimaryKey 
		String id = null;
		Sysconfig response = null;
		response = service.findSysconfigByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findSysconfigByPrimaryKey
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
