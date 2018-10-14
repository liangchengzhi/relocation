package common.web.rest;

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
 * Unit test for the <code>SendsmsRestController</code> controller.
 *
 * @see common.web.rest.SendsmsRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class SendsmsRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Sendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Sendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsRestController controller = (SendsmsRestController) context.getBean("SendsmsRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Sendsmssendsms_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetSendsmssendsms_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Sendsms/{sendsms_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsRestController controller = (SendsmsRestController) context.getBean("SendsmsRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Sendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Sendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsRestController controller = (SendsmsRestController) context.getBean("SendsmsRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Sendsms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostSendsms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Sendsms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsRestController controller = (SendsmsRestController) context.getBean("SendsmsRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Sendsmssendsms_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteSendsmssendsms_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Sendsms/{sendsms_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SendsmsRestController controller = (SendsmsRestController) context.getBean("SendsmsRestController");

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