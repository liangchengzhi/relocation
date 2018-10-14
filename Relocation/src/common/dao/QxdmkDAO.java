package common.dao;

import common.domain.Qxdmk;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Qxdmk entities.
 * 
 */
public interface QxdmkDAO extends JpaDao<Qxdmk> {

	/**
	 * JPQL Query - findQxdmkByPrimaryKey
	 *
	 */
	public Qxdmk findQxdmkByPrimaryKey(String qxdm) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByPrimaryKey
	 *
	 */
	public Qxdmk findQxdmkByPrimaryKey(String qxdm, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllQxdmks
	 *
	 */
	public Set<Qxdmk> findAllQxdmks() throws DataAccessException;

	/**
	 * JPQL Query - findAllQxdmks
	 *
	 */
	public Set<Qxdmk> findAllQxdmks(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxdmContaining
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxdmContaining(String qxdm_1) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxdmContaining
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxdmContaining(String qxdm_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxmcContaining
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxmcContaining(String qxmc) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxmcContaining
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxmcContaining(String qxmc, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxmc
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxmc(String qxmc_1) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxmc
	 *
	 */
	public Set<Qxdmk> findQxdmkByQxmc(String qxmc_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxdm
	 *
	 */
	public Qxdmk findQxdmkByQxdm(String qxdm_2) throws DataAccessException;

	/**
	 * JPQL Query - findQxdmkByQxdm
	 *
	 */
	public Qxdmk findQxdmkByQxdm(String qxdm_2, int startResult, int maxRows) throws DataAccessException;

}