package common.dao;

import common.domain.Sendsms;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Sendsms entities.
 * 
 */
public interface SendsmsDAO extends JpaDao<Sendsms> {

	/**
	 * JPQL Query - findSendsmsByContent
	 *
	 */
	public Set<Sendsms> findSendsmsByContent(String content) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByContent
	 *
	 */
	public Set<Sendsms> findSendsmsByContent(String content, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByCreatedtime
	 *
	 */
	public Set<Sendsms> findSendsmsByCreatedtime(java.util.Calendar createdtime) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByCreatedtime
	 *
	 */
	public Set<Sendsms> findSendsmsByCreatedtime(Calendar createdtime, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByPhoneContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByPhoneContaining(String phone) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByPhoneContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByPhoneContaining(String phone, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByRandcodeContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByRandcodeContaining(String randcode) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByRandcodeContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByRandcodeContaining(String randcode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByContentContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByContentContaining(String content_1) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByContentContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByContentContaining(String content_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByPrimaryKey
	 *
	 */
	public Sendsms findSendsmsByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByPrimaryKey
	 *
	 */
	public Sendsms findSendsmsByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByRandcode
	 *
	 */
	public Set<Sendsms> findSendsmsByRandcode(String randcode_1) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByRandcode
	 *
	 */
	public Set<Sendsms> findSendsmsByRandcode(String randcode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSendsmss
	 *
	 */
	public Set<Sendsms> findAllSendsmss() throws DataAccessException;

	/**
	 * JPQL Query - findAllSendsmss
	 *
	 */
	public Set<Sendsms> findAllSendsmss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByPhone
	 *
	 */
	public Set<Sendsms> findSendsmsByPhone(String phone_1) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByPhone
	 *
	 */
	public Set<Sendsms> findSendsmsByPhone(String phone_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByIp
	 *
	 */
	public Set<Sendsms> findSendsmsByIp(String ip) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByIp
	 *
	 */
	public Set<Sendsms> findSendsmsByIp(String ip, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByIpContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByIpContaining(String ip_1) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsByIpContaining
	 *
	 */
	public Set<Sendsms> findSendsmsByIpContaining(String ip_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsById
	 *
	 */
	public Sendsms findSendsmsById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findSendsmsById
	 *
	 */
	public Sendsms findSendsmsById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}