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
 * Unit test for the <code>RecordTransitionfeeController</code> controller.
 *
 * @see common.web.RecordTransitionfeeController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class RecordTransitionfeeControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editRecordTransitionfeeRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecordTransitionfeeRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecordTransitionfeeRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecordTransitionfeeRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecordTransitionfeeRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecordTransitionfeeRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecordTransitionfeeRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecordTransitionfeeRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecordTransitionfeeRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecordTransitionfeeRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecordTransitionfeeRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecordTransitionfeeRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecordTransitionfeeRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecordTransitionfeeRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecordTransitionfeeRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecordTransitionfeeRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecordTransitionfeeRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecordTransitionfeeRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRecordTransitionfeeRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRecordTransitionfeeRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRecordTransitionfeeRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecordTransitionfeeCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecordTransitionfeeCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecordTransitionfeeCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecordTransitionfeeCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecordTransitionfeeCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecordTransitionfeeCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecordTransitionfeeCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecordTransitionfeeCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecordTransitionfeeCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecordTransitionfeeCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecordTransitionfeeCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecordTransitionfeeCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecordTransitionfeeCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecordTransitionfeeCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecordTransitionfeeCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecordTransitionfeeCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecordTransitionfeeCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecordTransitionfeeCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRecordTransitionfeeCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRecordTransitionfeeCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRecordTransitionfeeCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexRecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexRecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>recordtransitionfeeControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetrecordtransitionfeeControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/recordtransitionfeeController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeController controller = (RecordTransitionfeeController) context.getBean("RecordTransitionfeeController");

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