package common.dao;

import common.domain.Qxdmk;

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
 * DAO to manage Qxdmk entities.
 * 
 */
@Repository("qxdmkDAO")
public class QxdmkDAOImpl extends AbstractJpaDao<Qxdmk> implements QxdmkDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Qxdmk.class }));

	/**
	 * EntityManager injected by Spring for persistence unit relocation
	 *
	 */
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	/**
	 * Instantiates a new QxdmkDAOImpl
	 *
	 */
	public QxdmkDAOImpl() {
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
	 * JPQL Query - findQxdmkByPrimaryKey
	 *
	 */
	public Qxdmk findQxdmkByPrimaryKey(String qxdm) throws DataAccessException {

		return findQxdmkByPrimaryKey(qxdm, -1, -1);
	}

	/**
	 * JPQL Query - findQxdmkByPrimaryKey
	 *
	 */

	public Qxdmk findQxdmkByPrimaryKey(String qxdm, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findQxdmkByPrimaryKey", startResult, maxRows, qxdm);
			return (common.domain.Qxdmk) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllQxdmks
	 *
	 */
	public Set<Qxdmk> findAllQxdmks() throws DataAccessException {

		return findAllQxdmks(-1, -1);
	}

	/**
	 * JPQL Query - findAllQxdmks
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Qxdmk> findAllQxdmks(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllQxdmks", startResult, maxRows);
		return new LinkedHashSet<Qxdmk>(query.getResultList());
	}

	/**
	 * JPQL Query - findQxdmkByQxdmContaining
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxdmContaining(String qxdm) throws DataAccessException {

		return findQxdmkByQxdmContaining(qxdm, -1, -1);
	}

	/**
	 * JPQL Query - findQxdmkByQxdmContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Qxdmk> findQxdmkByQxdmContaining(String qxdm, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findQxdmkByQxdmContaining", startResult, maxRows, qxdm);
		return new LinkedHashSet<Qxdmk>(query.getResultList());
	}

	/**
	 * JPQL Query - findQxdmkByQxmcContaining
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxmcContaining(String qxmc) throws DataAccessException {

		return findQxdmkByQxmcContaining(qxmc, -1, -1);
	}

	/**
	 * JPQL Query - findQxdmkByQxmcContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Qxdmk> findQxdmkByQxmcContaining(String qxmc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findQxdmkByQxmcContaining", startResult, maxRows, qxmc);
		return new LinkedHashSet<Qxdmk>(query.getResultList());
	}

	/**
	 * JPQL Query - findQxdmkByQxmc
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxmc(String qxmc) throws DataAccessException {

		return findQxdmkByQxmc(qxmc, -1, -1);
	}

	/**
	 * JPQL Query - findQxdmkByQxmc
	 *
	 */

	@SuppressWarnings("unchecked")
	public Set<Qxdmk> findQxdmkByQxmc(String qxmc, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findQxdmkByQxmc", startResult, maxRows, qxmc);
		return new LinkedHashSet<Qxdmk>(query.getResultList());
	}

	/**
	 * JPQL Query - findQxdmkByQxdm
	 *
	 */
	public Qxdmk findQxdmkByQxdm(String qxdm) throws DataAccessException {

		return findQxdmkByQxdm(qxdm, -1, -1);
	}

	/**
	 * JPQL Query - findQxdmkByQxdm
	 *
	 */

	public Qxdmk findQxdmkByQxdm(String qxdm, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findQxdmkByQxdm", startResult, maxRows, qxdm);
			return (common.domain.Qxdmk) query.getSingleResult();
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
	public boolean canBeMerged(Qxdmk entity) {
		return true;
	}
}
