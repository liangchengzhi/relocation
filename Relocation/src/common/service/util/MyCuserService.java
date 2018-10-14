package common.service.util;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import common.domain.Cuser;


public interface MyCuserService {

	/**
	 * 列出 系统用户
	 * @param keyword	用户名称/手机号
	 * @param usertype	用户类型
	 * @param offset
	 * @param pS
	 * @return
	 */
	public List<Cuser> listCuser(String keyword, Integer usertype, Integer offset, Integer pS);
	public int countCuser(String keyword, Integer usertype);
	
	/**
	 * 检测登陆用户
	 * @param username
	 * @param password
	 * @return
	 */
	public Cuser checkLogin(String username, String password);
	
	/**
	 * 家长用户权限
	 * @param cuser
	 * @return
	 */
	public UserDetails produceAuth(Cuser cuser);
	
	/**
	 * 根据登陆令牌检测登陆用户
	 * @param logintoken
	 * @return
	 */
	public Cuser checkLogintoken(String logintoken);
	
	/**
	 * 检测指定字段是否有指定值
	 * @param value
	 * @param field
	 * @return
	 */
	public boolean isExist(String value, String field);

	/**
	 * 通过制定字段获取用户
	 * @param value
	 * @param field	username/phone/email
	 * @return
	 */
	public Cuser findByField(String value, String field);
	
	/**
	 * 创建新用户
	 * @param username	用户名
	 * @param nickname	昵称
	 * @param phone		手机
	 * @param email		邮箱
	 * @param password	密码（明文）
	 * @param ip		注册IP
	 * @param usertype	用户类型
	 * @return
	 */
	public Cuser createCuser(String username, String nickname, String phone, String email,
			String password, String ip, Integer usertype);
	
	/**
	 * 设置新密码
	 * @param uid
	 * @param password
	 * @return
	 */
	public Cuser saveNewPwd(Integer uid, String salt, String password);
	public Cuser createPwd(Cuser cuser, String salt, String password);
	/**
	 * 修改密码
	 * @param cuser
	 * @param oldpassword
	 * @param newpassword
	 * @return
	 */
	public Cuser alterPwd(Cuser cuser, String oldpassword, String newpassword);
	
}
