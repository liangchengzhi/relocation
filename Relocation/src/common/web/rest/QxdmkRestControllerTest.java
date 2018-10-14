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
 * Unit test for the <code>QxdmkRestController</code> controller.
 *
 * @see common.web.rest.QxdmkRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class QxdmkRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Qxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Qxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkRestController controller = (QxdmkRestController) context.getBean("QxdmkRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Qxdmkqxdmk_qxdm()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetQxdmkqxdmk_qxdm() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Qxdmk/{qxdmk_qxdm}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkRestController controller = (QxdmkRestController) context.getBean("QxdmkRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Qxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Qxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkRestController controller = (QxdmkRestController) context.getBean("QxdmkRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Qxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Qxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkRestController controller = (QxdmkRestController) context.getBean("QxdmkRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Qxdmkqxdmk_qxdm()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteQxdmkqxdmk_qxdm() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Qxdmk/{qxdmk_qxdm}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkRestController controller = (QxdmkRestController) context.getBean("QxdmkRestController");

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