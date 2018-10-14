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
 * Unit test for the <code>QxdmkController</code> controller.
 *
 * @see common.web.QxdmkController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class QxdmkControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexQxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexQxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectQxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectQxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editQxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editQxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveQxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveQxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newQxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newQxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteQxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteQxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteQxdmk()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteQxdmk() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteQxdmk");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>qxdmkControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetqxdmkControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/qxdmkController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		QxdmkController controller = (QxdmkController) context.getBean("QxdmkController");

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