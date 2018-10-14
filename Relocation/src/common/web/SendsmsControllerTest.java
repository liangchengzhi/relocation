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
 * Unit test for the <code>SendsmsController</code> controller.
 *
 * @see common.web.SendsmsController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class SendsmsControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexSendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>sendsmsControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsendsmsControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/sendsmsController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsController controller = (SendsmsController) context.getBean("SendsmsController");

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