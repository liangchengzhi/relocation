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
 * Unit test for the <code>RecordController</code> controller.
 *
 * @see common.web.RecordController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class RecordControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editRecordCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecordCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecordCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecordCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecordCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecordCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecordCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecordCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecordCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecordCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecordCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecordCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecordCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecordCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecordCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecordCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecordCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecordCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRecordCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRecordCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRecordCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecordProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecordProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecordProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecordProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecordProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecordProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecordProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecordProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecordProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecordProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecordProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecordProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecordProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecordProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecordProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecordProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecordProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecordProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRecordProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRecordProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRecordProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecordRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecordRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecordRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecordRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecordRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecordRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecordRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecordRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecordRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecordRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecordRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecordRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecordRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecordRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecordRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecordRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecordRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecordRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRecordRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRecordRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRecordRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRecord");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>recordControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetrecordControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/recordController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordController controller = (RecordController) context.getBean("RecordController");

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