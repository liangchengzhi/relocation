package common.service;

import common.domain.Project;
import common.domain.Record;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/Relocation-security-context.xml",
		"file:./src/Relocation-service-context.xml",
		"file:./src/Relocation-dao-context.xml",
		"file:./src/Relocation-web-context.xml" })
public class ProjectServiceTest {

	/**
	 * The Spring application context.
	 *
	 */
	@SuppressWarnings("unused")
	private ApplicationContext context;

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected ProjectService service;

	/**
	 * Instantiates a new ProjectServiceTest.
	 *
	 */
	public ProjectServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Project entity
	 * 
	 */
	@Test
	public void countProjects() {
		Integer response = null;
		response = service.countProjects();
		// TODO: JUnit - Add assertions to test outputs of operation: countProjects
	}

	/**
	 * Operation Unit Test
	 * Save an existing Record entity
	 * 
	 */
	@Test
	public void saveProjectRecords() {
		// TODO: JUnit - Populate test inputs for operation: saveProjectRecords 
		Integer id = 0;
		Record related_records = new common.domain.Record();
		Project response = null;
		response = service.saveProjectRecords(id, related_records);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProjectRecords
	}

	/**
	 * Operation Unit Test
	 * Save an existing Project entity
	 * 
	 */
	@Test
	public void saveProject() {
		// TODO: JUnit - Populate test inputs for operation: saveProject 
		Project project = new common.domain.Project();
		service.saveProject(project);
	}

	/**
	 * Operation Unit Test
	 * Return all Project entity
	 * 
	 */
	@Test
	public void findAllProjects() {
		// TODO: JUnit - Populate test inputs for operation: findAllProjects 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Project> response = null;
		response = service.findAllProjects(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllProjects
	}

	/**
	 * Operation Unit Test
	 * Load an existing Project entity
	 * 
	 */
	@Test
	public void loadProjects() {
		Set<Project> response = null;
		response = service.loadProjects();
		// TODO: JUnit - Add assertions to test outputs of operation: loadProjects
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Project entity
	 * 
	 */
	@Test
	public void deleteProject() {
		// TODO: JUnit - Populate test inputs for operation: deleteProject 
		Project project_1 = new common.domain.Project();
		service.deleteProject(project_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findProjectByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findProjectByPrimaryKey 
		Integer id_1 = 0;
		Project response = null;
		response = service.findProjectByPrimaryKey(id_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findProjectByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Record entity
	 * 
	 */
	@Test
	public void deleteProjectRecords() {
		// TODO: JUnit - Populate test inputs for operation: deleteProjectRecords 
		Integer project_id = 0;
		Integer related_records_id = 0;
		Project response = null;
		response = service.deleteProjectRecords(project_id, related_records_id);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProjectRecords
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
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
