package common.web;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Unit test for the <code>SysconfigController</code> controller.
 *
 * @see common.web.SysconfigController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class SysconfigControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexSysconfig()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSysconfig() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSysconfig");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSysconfig()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSysconfig() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSysconfig");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSysconfig()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSysconfig() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSysconfig");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSysconfig()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSysconfig() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSysconfig");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSysconfig()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSysconfig() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSysconfig");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSysconfig()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSysconfig() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSysconfig");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSysconfig()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSysconfig() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSysconfig");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>sysconfigControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsysconfigControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/sysconfigController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SysconfigController controller = (SysconfigController) context.getBean("SysconfigController");

		// TODO Invoke method and Assert return values

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
	 * Returns a mock HttpServletRequest object.
	 *
	 */
	private MockHttpServletRequest getMockHttpServletRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
		return request;
	}

	/**
	 * Returns a mock HttpServletResponse object.
	 *
	 */
	private MockHttpServletResponse getMockHttpServletResponse() {
		return new MockHttpServletResponse();
	}
}