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
 * Unit test for the <code>ProjectRestController</code> controller.
 *
 * @see common.web.rest.ProjectRestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class ProjectRestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>Projectproject_idrecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetProjectproject_idrecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project/{project_id}/records");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Projectproject_idrecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostProjectproject_idrecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project/{project_id}/records");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Projectproject_idrecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutProjectproject_idrecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project/{project_id}/records");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Projectproject_idrecordsrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteProjectproject_idrecordsrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project/{project_id}/records/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Projectproject_idrecordsrecord_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetProjectproject_idrecordsrecord_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project/{project_id}/records/{record_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Project()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Projectproject_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetProjectproject_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project/{project_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Project()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PutProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Project()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void PostProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>Projectproject_id()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void DeleteProjectproject_id() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/Project/{project_id}");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectRestController controller = (ProjectRestController) context.getBean("ProjectRestController");

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