package common.service;

import common.domain.Project;
import common.domain.Record;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Project entities
 * 
 */
public interface ProjectService {

	/**
	 * Return a count of all Project entity
	 * 
	 */
	public Integer countProjects();

	/**
	 * Save an existing Record entity
	 * 
	 */
	public Project saveProjectRecords(Integer id, Record related_records);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public void saveProject(Project project);

	/**
	 * Return all Project entity
	 * 
	 */
	public List<Project> findAllProjects(Integer startResult, Integer maxRows);

	/**
	 * Load an existing Project entity
	 * 
	 */
	public Set<Project> loadProjects();

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public void deleteProject(Project project_1);

	/**
	 */
	public Project findProjectByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public Project deleteProjectRecords(Integer project_id, Integer related_records_id);
}