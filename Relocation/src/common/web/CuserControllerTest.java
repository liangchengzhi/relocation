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
 * Unit test for the <code>CuserController</code> controller.
 *
 * @see common.web.CuserController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class CuserControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editCuserRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditCuserRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editCuserRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newCuserRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewCuserRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newCuserRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveCuserRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveCuserRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveCuserRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteCuserRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteCuserRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteCuserRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteCuserRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteCuserRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteCuserRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectCuserRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectCuserRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectCuserRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listCuserRecordTransitionfees()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistCuserRecordTransitionfees() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listCuserRecordTransitionfees");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editCuserRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditCuserRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editCuserRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newCuserRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewCuserRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newCuserRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveCuserRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveCuserRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveCuserRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteCuserRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteCuserRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteCuserRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteCuserRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteCuserRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteCuserRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectCuserRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectCuserRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectCuserRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listCuserRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistCuserRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listCuserRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteCuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteCuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteCuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>cuserControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetcuserControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/cuserController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		CuserController controller = (CuserController) context.getBean("CuserController");

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