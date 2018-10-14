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
 * Unit test for the <code>RecordRestController</code> controller.
 *
 * @see common.web.rest.RecordRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class RecordRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Recordrecord_idcuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordrecord_idcuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idcuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecordrecord_idcuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idcuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecordrecord_idcuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idcusercuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordrecord_idcusercuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/cuser/{cuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idcusercuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordrecord_idcusercuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/cuser/{cuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idproject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordrecord_idproject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/project");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idproject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecordrecord_idproject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/project");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idproject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecordrecord_idproject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/project");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idprojectproject_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordrecord_idprojectproject_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/project/{project_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idprojectproject_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordrecord_idprojectproject_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/project/{project_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idrecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordrecord_idrecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/recordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idrecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecordrecord_idrecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/recordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idrecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecordrecord_idrecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/recordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idrecordTransitionfeesrecordtransitionfee_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordrecord_idrecordTransitionfeesrecordtransitionfee_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/recordTransitionfees/{recordtransitionfee_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_idrecordTransitionfeesrecordtransitionfee_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordrecord_idrecordTransitionfeesrecordtransitionfee_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}/recordTransitionfees/{recordtransitionfee_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Record()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Record()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Record()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Recordrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Record/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordRestController controller = (RecordRestController) context.getBean("RecordRestController");

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