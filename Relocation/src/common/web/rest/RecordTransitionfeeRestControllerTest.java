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
 * Unit test for the <code>RecordTransitionfeeRestController</code> controller.
 *
 * @see common.web.rest.RecordTransitionfeeRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class RecordTransitionfeeRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idrecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordTransitionfeerecordtransitionfee_idrecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/record");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idrecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecordTransitionfeerecordtransitionfee_idrecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/record");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idrecord()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecordTransitionfeerecordtransitionfee_idrecord() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/record");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idrecordrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordTransitionfeerecordtransitionfee_idrecordrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/record/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idrecordrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordTransitionfeerecordtransitionfee_idrecordrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/record/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idcuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordTransitionfeerecordtransitionfee_idcuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idcuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecordTransitionfeerecordtransitionfee_idcuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idcuser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecordTransitionfeerecordtransitionfee_idcuser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/cuser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idcusercuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordTransitionfeerecordtransitionfee_idcusercuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/cuser/{cuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_idcusercuser_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordTransitionfeerecordtransitionfee_idcusercuser_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}/cuser/{cuser_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetRecordTransitionfeerecordtransitionfee_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfee()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostRecordTransitionfee() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>RecordTransitionfeerecordtransitionfee_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteRecordTransitionfeerecordtransitionfee_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/RecordTransitionfee/{recordtransitionfee_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RecordTransitionfeeRestController controller = (RecordTransitionfeeRestController) context.getBean("RecordTransitionfeeRestController");

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