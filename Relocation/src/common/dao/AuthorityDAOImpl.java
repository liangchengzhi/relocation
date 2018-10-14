package common.dao;

import common.domain.Authority;

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
 * DAO to manage Authority entities.
 * 
 */
@Repository("authorityDAO")
public class AuthorityDAOImpl extends AbstractJpaDao<Authority> implements
		AuthorityDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Authority.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AuthorityDAOImpl
	 *
	 */
	public AuthorityDAOImpl() {
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
	 * JPQL Query - findAuthorityByName
	 *
	 */
	public Set<Authority> findAuthorityByName(String name) throws DataAccessException {

		return findAuthorityByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByName
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByName", startResult, maxRows, name);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	public Authority findAuthorityByPrimaryKey(Integer id) throws DataAccessException {

		return findAuthorityByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */

	public Authority findAuthorityByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthorityByPrimaryKey", startResult, maxRows, id);
			return (common.domain.Authority) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuthorityById
	 *
	 */
	public Authority findAuthorityById(Integer id) throws DataAccessException {

		return findAuthorityById(id, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityById
	 *
	 */

	public Authority findAuthorityById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuthorityById", startResult, maxRows, id);
			return (common.domain.Authority) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuthorityByNameContaining
	 *
	 */
	public Set<Authority> findAuthorityByNameContaining(String name) throws DataAccessException {

		return findAuthorityByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByDescriptionContaining
	 *
	 */
	public Set<Authority> findAuthorityByDescriptionContaining(String description) throws DataAccessException {

		return findAuthorityByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByDeletedTime
	 *
	 */
	public Set<Authority> findAuthorityByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException {

		return findAuthorityByDeletedTime(deletedTime, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByDeletedTime
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByDeletedTime(java.util.Calendar deletedTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByDeletedTime", startResult, maxRows, deletedTime);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByMethod
	 *
	 */
	public Set<Authority> findAuthorityByMethod(String method) throws DataAccessException {

		return findAuthorityByMethod(method, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByMethod
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByMethod(String method, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByMethod", startResult, maxRows, method);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByDeletedUser
	 *
	 */
	public Set<Authority> findAuthorityByDeletedUser(String deletedUser) throws DataAccessException {

		return findAuthorityByDeletedUser(deletedUser, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByDeletedUser
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByDeletedUser(String deletedUser, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByDeletedUser", startResult, maxRows, deletedUser);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByDeletedUserContaining
	 *
	 */
	public Set<Authority> findAuthorityByDeletedUserContaining(String deletedUser) throws DataAccessException {

		return findAuthorityByDeletedUserContaining(deletedUser, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByDeletedUserContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByDeletedUserContaining(String deletedUser, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByDeletedUserContaining", startResult, maxRows, deletedUser);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByDescription
	 *
	 */
	public Set<Authority> findAuthorityByDescription(String description) throws DataAccessException {

		return findAuthorityByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuthorityByIsDeleted
	 *
	 */
	public Set<Authority> findAuthorityByIsDeleted(Boolean isDeleted) throws DataAccessException {

		return findAuthorityByIsDeleted(isDeleted, -1, -1);
	}

	/**
	 * JPQL Query - findAuthorityByIsDeleted
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAuthorityByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuthorityByIsDeleted", startResult, maxRows, isDeleted);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	public Set<Authority> findAllAuthoritys() throws DataAccessException {

		return findAllAuthoritys(-1, -1);
	}

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAuthoritys", startResult, maxRows);
		return new LinkedHashSet<Authority>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Authority entity) {
		return true;
	}
}
