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
 * Unit test for the <code>CuserRestController</code> controller.
 *
 * @see common.web.rest.CuserRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class CuserRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Cusercuser_idrecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetCusercuser_idrecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/recordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostCusercuser_idrecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/recordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutCusercuser_idrecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/recordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecordTransitionfeesrecordtransitionfee_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteCusercuser_idrecordTransitionfeesrecordtransitionfee_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/recordTransitionfees/{recordtransitionfee_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecordTransitionfeesrecordtransitionfee_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetCusercuser_idrecordTransitionfeesrecordtransitionfee_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/recordTransitionfees/{recordtransitionfee_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetCusercuser_idrecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/records");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostCusercuser_idrecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/records");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutCusercuser_idrecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/records");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecordsrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteCusercuser_idrecordsrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/records/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_idrecordsrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetCusercuser_idrecordsrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}/records/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetCusercuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Cusercuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteCusercuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Cuser/{cuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserRestController controller = (CuserRestController) context.getBean("CuserRestController");

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