package common.dao;

import common.domain.Sysconfig;

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
 * DAO to manage Sysconfig entities.
 * 
 */
@Repository("sysconfigDAO")
public class SysconfigDAOImpl extends AbstractJpaDao<Sysconfig> implements
		SysconfigDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Sysconfig.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SysconfigDAOImpl
	 *
	 */
	public SysconfigDAOImpl() {
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
	 * JPQL Query - findAllSysconfigs
	 *
	 */
	public Set<Sysconfig> findAllSysconfigs() throws DataAccessException {

		return findAllSysconfigs(-1, -1);
	}

	/**
	 * JPQL Query - findAllSysconfigs
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sysconfig> findAllSysconfigs(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSysconfigs", startResult, maxRows);
		return new LinkedHashSet<Sysconfig>(query.getResultList());
	}

	/**
	 * JPQL Query - findSysconfigByDescriptionContaining
	 *
	 */
	public Set<Sysconfig> findSysconfigByDescriptionContaining(String description) throws DataAccessException {

		return findSysconfigByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findSysconfigByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sysconfig> findSysconfigByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSysconfigByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Sysconfig>(query.getResultList());
	}

	/**
	 * JPQL Query - findSysconfigByPrimaryKey
	 *
	 */
	public Sysconfig findSysconfigByPrimaryKey(String id) throws DataAccessException {

		return findSysconfigByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findSysconfigByPrimaryKey
	 *
	 */

	public Sysconfig findSysconfigByPrimaryKey(String id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSysconfigByPrimaryKey", startResult, maxRows, id);
			return (common.domain.Sysconfig) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSysconfigByDescription
	 *
	 */
	public Set<Sysconfig> findSysconfigByDescription(String description) throws DataAccessException {

		return findSysconfigByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findSysconfigByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sysconfig> findSysconfigByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSysconfigByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Sysconfig>(query.getResultList());
	}

	/**
	 * JPQL Query - findSysconfigByIdContaining
	 *
	 */
	public Set<Sysconfig> findSysconfigByIdContaining(String id) throws DataAccessException {

		return findSysconfigByIdContaining(id, -1, -1);
	}

	/**
	 * JPQL Query - findSysconfigByIdContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sysconfig> findSysconfigByIdContaining(String id, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSysconfigByIdContaining", startResult, maxRows, id);
		return new LinkedHashSet<Sysconfig>(query.getResultList());
	}

	/**
	 * JPQL Query - findSysconfigByValue
	 *
	 */
	public Set<Sysconfig> findSysconfigByValue(String value) throws DataAccessException {

		return findSysconfigByValue(value, -1, -1);
	}

	/**
	 * JPQL Query - findSysconfigByValue
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Sysconfig> findSysconfigByValue(String value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSysconfigByValue", startResult, maxRows, value);
		return new LinkedHashSet<Sysconfig>(query.getResultList());
	}

	/**
	 * JPQL Query - findSysconfigById
	 *
	 */
	public Sysconfig findSysconfigById(String id) throws DataAccessException {

		return findSysconfigById(id, -1, -1);
	}

	/**
	 * JPQL Query - findSysconfigById
	 *
	 */

	public Sysconfig findSysconfigById(String id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSysconfigById", startResult, maxRows, id);
			return (common.domain.Sysconfig) query.getSingleResult();
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
	public boolean canBeMerged(Sysconfig entity) {
		return true;
	}
}
