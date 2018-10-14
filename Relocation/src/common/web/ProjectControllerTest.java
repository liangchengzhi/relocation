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
 * Unit test for the <code>ProjectController</code> controller.
 *
 * @see common.web.ProjectController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class ProjectControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editProjectRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectRecords()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectRecords() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectRecords");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>projectControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetprojectControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/projectController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

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