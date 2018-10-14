package common.dao;

import common.domain.Project;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Project entities.
 * 
 */
public interface ProjectDAO extends JpaDao<Project> {

	/**
	 * JPQL Query - findProjectByNameContaining
	 *
	 */
	public Set<Project> findProjectByNameContaining(String name) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByNameContaining
	 *
	 */
	public Set<Project> findProjectByNameContaining(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllProjects
	 *
	 */
	public Set<Project> findAllProjects() throws DataAccessException;

	/**
	 * JPQL Query - findAllProjects
	 *
	 */
	public Set<Project> findAllProjects(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */
	public Project findProjectByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */
	public Project findProjectByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByIsDeleted
	 *
	 */
	public Set<Project> findProjectByIsDeleted(Boolean isDeleted) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByIsDeleted
	 *
	 */
	public Set<Project> findProjectByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByName
	 *
	 */
	public Set<Project> findProjectByName(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectByName
	 *
	 */
	public Set<Project> findProjectByName(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjectById
	 *
	 */
	public Project findProjectById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjectById
	 *
	 */
	public Project findProjectById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}