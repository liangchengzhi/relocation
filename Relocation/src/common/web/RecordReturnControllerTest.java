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
 * Unit test for the <code>RecordReturnController</code> controller.
 *
 * @see common.web.RecordReturnController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class RecordReturnControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexRecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexRecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecordReturn()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecordReturn() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecordReturn");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>recordreturnControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetrecordreturnControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/recordreturnController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordReturnController controller = (RecordReturnController) context.getBean("RecordReturnController");

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