package common.dao;

import common.domain.Sysconfig;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Sysconfig entities.
 * 
 */
public interface SysconfigDAO extends JpaDao<Sysconfig> {

	/**
	 * JPQL Query - findAllSysconfigs
	 *
	 */
	public Set<Sysconfig> findAllSysconfigs() throws DataAccessException;

	/**
	 * JPQL Query - findAllSysconfigs
	 *
	 */
	public Set<Sysconfig> findAllSysconfigs(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByDescriptionContaining
	 *
	 */
	public Set<Sysconfig> findSysconfigByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByDescriptionContaining
	 *
	 */
	public Set<Sysconfig> findSysconfigByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByPrimaryKey
	 *
	 */
	public Sysconfig findSysconfigByPrimaryKey(String id) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByPrimaryKey
	 *
	 */
	public Sysconfig findSysconfigByPrimaryKey(String id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByDescription
	 *
	 */
	public Set<Sysconfig> findSysconfigByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByDescription
	 *
	 */
	public Set<Sysconfig> findSysconfigByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByIdContaining
	 *
	 */
	public Set<Sysconfig> findSysconfigByIdContaining(String id_1) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByIdContaining
	 *
	 */
	public Set<Sysconfig> findSysconfigByIdContaining(String id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByValue
	 *
	 */
	public Set<Sysconfig> findSysconfigByValue(String value) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigByValue
	 *
	 */
	public Set<Sysconfig> findSysconfigByValue(String value, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigById
	 *
	 */
	public Sysconfig findSysconfigById(String id_2) throws DataAccessException;

	/**
	 * JPQL Query - findSysconfigById
	 *
	 */
	public Sysconfig findSysconfigById(String id_2, int startResult, int maxRows) throws DataAccessException;

}