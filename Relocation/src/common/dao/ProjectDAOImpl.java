package common.dao;

import common.domain.Project;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Project entities.
 * 
 */
@Repository("projectDAO")
public class ProjectDAOImpl extends AbstractJpaDao<Project> implements
		ProjectDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Project.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ProjectDAOImpl
	 *
	 */
	public ProjectDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findProjectByNameContaining
	 *
	 */
	public Set<Project> findProjectByNameContaining(String name) throws DataAccessException {

		return findProjectByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Project> findProjectByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllProjects
	 *
	 */
	public Set<Project> findAllProjects() throws DataAccessException {

		return findAllProjects(-1, -1);
	}

	/**
	 * JPQL Query - findAllProjects
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Project> findAllProjects(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllProjects", startResult, maxRows);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */
	public Project findProjectByPrimaryKey(Integer id) throws DataAccessException {

		return findProjectByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByPrimaryKey
	 *
	 */

	public Project findProjectByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjectByPrimaryKey", startResult, maxRows, id);
			return (common.domain.Project) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findProjectByIsDeleted
	 *
	 */
	public Set<Project> findProjectByIsDeleted(Boolean isDeleted) throws DataAccessException {

		return findProjectByIsDeleted(isDeleted, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByIsDeleted
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Project> findProjectByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByIsDeleted", startResult, maxRows, isDeleted);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectByName
	 *
	 */
	public Set<Project> findProjectByName(String name) throws DataAccessException {

		return findProjectByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findProjectByName
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Project> findProjectByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findProjectByName", startResult, maxRows, name);
		return new LinkedHashSet<Project>(query.getResultList());
	}

	/**
	 * JPQL Query - findProjectById
	 *
	 */
	public Project findProjectById(Integer id) throws DataAccessException {

		return findProjectById(id, -1, -1);
	}

	/**
	 * JPQL Query - findProjectById
	 *
	 */

	public Project findProjectById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findProjectById", startResult, maxRows, id);
			return (common.domain.Project) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Project entity) {
		return true;
	}
}
