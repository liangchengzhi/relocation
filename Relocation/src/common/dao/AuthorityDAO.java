package common.dao;

import common.domain.Authority;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Authority entities.
 * 
 */
public interface AuthorityDAO extends JpaDao<Authority> {

	/**
	 * JPQL Query - findAuthorityByName
	 *
	 */
	public Set<Authority> findAuthorityByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByName
	 *
	 */
	public Set<Authority> findAuthorityByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	public Authority findAuthorityByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	public Authority findAuthorityByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityById
	 *
	 */
	public Authority findAuthorityById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityById
	 *
	 */
	public Authority findAuthorityById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByNameContaining
	 *
	 */
	public Set<Authority> findAuthorityByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByNameContaining
	 *
	 */
	public Set<Authority> findAuthorityByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDescriptionContaining
	 *
	 */
	public Set<Authority> findAuthorityByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDescriptionContaining
	 *
	 */
	public Set<Authority> findAuthorityByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDeletedTime
	 *
	 */
	public Set<Authority> findAuthorityByDeletedTime(java.util.Calendar deletedTime) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDeletedTime
	 *
	 */
	public Set<Authority> findAuthorityByDeletedTime(Calendar deletedTime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByMethod
	 *
	 */
	public Set<Authority> findAuthorityByMethod(String method) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByMethod
	 *
	 */
	public Set<Authority> findAuthorityByMethod(String method, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDeletedUser
	 *
	 */
	public Set<Authority> findAuthorityByDeletedUser(String deletedUser) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDeletedUser
	 *
	 */
	public Set<Authority> findAuthorityByDeletedUser(String deletedUser, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDeletedUserContaining
	 *
	 */
	public Set<Authority> findAuthorityByDeletedUserContaining(String deletedUser_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDeletedUserContaining
	 *
	 */
	public Set<Authority> findAuthorityByDeletedUserContaining(String deletedUser_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDescription
	 *
	 */
	public Set<Authority> findAuthorityByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByDescription
	 *
	 */
	public Set<Authority> findAuthorityByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByIsDeleted
	 *
	 */
	public Set<Authority> findAuthorityByIsDeleted(Boolean isDeleted) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByIsDeleted
	 *
	 */
	public Set<Authority> findAuthorityByIsDeleted(Boolean isDeleted, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	public Set<Authority> findAllAuthoritys() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException;

}