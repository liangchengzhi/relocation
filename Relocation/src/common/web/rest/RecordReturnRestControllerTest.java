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
 * Unit test for the <code>RecordReturnRestController</code> controller.
 *
 * @see common.web.rest.RecordReturnRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class RecordReturnRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>RecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnRestController controller = (RecordReturnRestController) context.getBean("RecordReturnRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordReturnrecordreturn_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordReturnrecordreturn_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordReturn/{recordreturn_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnRestController controller = (RecordReturnRestController) context.getBean("RecordReturnRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnRestController controller = (RecordReturnRestController) context.getBean("RecordReturnRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnRestController controller = (RecordReturnRestController) context.getBean("RecordReturnRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordReturnrecordreturn_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordReturnrecordreturn_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordReturn/{recordreturn_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnRestController controller = (RecordReturnRestController) context.getBean("RecordReturnRestController");

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