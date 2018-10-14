package common.service.util;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.CuserDAO;
import common.domain.Cuser;
import common.util.Toolkit;

@Service("MyCuserService")
public class MyCuserServiceImpl implements MyCuserService{
	@Autowired
	CuserDAO cuserDAO;
	
	@Override
	public List<Cuser> listCuser(String keyword, Integer usertype,
			Integer offset, Integer pS) {
		String hql = "from Cuser cuser where (cuser.isDeleted is null or cuser.isDeleted=false)";
		if(usertype!=null){
			hql += " and cuser.usertype="+usertype;
		}
		if(keyword!=null && !"".equals(keyword)){
			hql += " and (cuser.username like ?1 or cuser.nickname like ?2 or cuser.phone like ?3)";
			hql += " order by cuser.logintime desc";
			return cuserDAO.executeQuery(hql, offset, pS, "%"+keyword+"%", "%"+keyword+"%", "%"+keyword+"%");
		}else{
			hql += " order by cuser.logintime desc";
			return cuserDAO.executeQuery(hql, offset, pS);
		}
	}

	@Override
	public int countCuser(String keyword, Integer usertype) {
		String hql = "select count(*) from Cuser cuser where (cuser.isDeleted is null or cuser.isDeleted=false)";
		if(usertype!=null){
			hql += " and cuser.usertype="+usertype;
		}
		if(keyword!=null && !"".equals(keyword)){
			hql += " and (cuser.username like ?1 or cuser.nickname like ?2 or cuser.phone like ?3)";
			Query createQuerySingleResult = cuserDAO.createQuerySingleResult(hql,"%"+keyword+"%","%"+keyword+"%","%"+keyword+"%");
			return ((Long)createQuerySingleResult.getSingleResult()).intValue();
		}else{
			Query createQuerySingleResult = cuserDAO.createQuerySingleResult(hql);
			return ((Long)createQuerySingleResult.getSingleResult()).intValue();
		}
	}

	@Override
	public Cuser checkLogin(String username, String password) {
		String hql = "from Cuser cuser where (cuser.username=?1 or cuser.email=?2 or cuser.phone=?3)"
				+ " and cuser.password=md5(concat(md5(?4),cuser.salt)) and (cuser.isDeleted is null or cuser.isDeleted=false)";
		
		List<Cuser> executeQuery = cuserDAO.executeQuery(hql, username,username,username,password);
		if(executeQuery==null||executeQuery.size()==0) return null;
		return executeQuery.get(0);
	}

	@Override
	public UserDetails produceAuth(Cuser cuser){
        //加载该用户权限  
        Set<GrantedAuthority> grantedAuths = new HashSet<>();
        boolean enabled = true;  
        boolean accountNonExpired = true;  
        boolean credentialsNonExpired = true;  
        boolean accountNonLocked = true;  
        
        UserDetails userdetails = new User(cuser.getUsername(), cuser.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
        return userdetails;  
	}

	@Override
	public Cuser checkLogintoken(String logintoken) {
		String hql = "from Cuser cuser where cuser.logintoken=?1 and (cuser.isDeleted is null or cuser.isDeleted=false)";
		List<Cuser> executeQuery = cuserDAO.executeQuery(hql, logintoken);
		if(executeQuery==null||executeQuery.size()==0) return null;
		return executeQuery.get(0);
	}

	@Override
	public boolean isExist(String value, String field) {
		String hql = "from Cuser cuser where cuser."+field+"=?1 and (cuser.isDeleted is null or cuser.isDeleted=false)";
		List<Cuser> executeQuery = cuserDAO.executeQuery(hql, value);
		if(executeQuery==null||executeQuery.size()==0) return false;
		return true;
	}

	@Override
	public Cuser findByField(String value, String field) {
		String hql = "from Cuser cuser where cuser."+field+"=?1 and (cuser.isDeleted is null or cuser.isDeleted=false)";
		List<Cuser> executeQuery = cuserDAO.executeQuery(hql, value);
		if(executeQuery==null||executeQuery.size()==0) return null;
		return executeQuery.get(0);
	}

	@Override
	public Cuser createCuser(String username, String nickname, String phone, String email,
			String password, String ip, Integer usertype) {
		Cuser cuser = new Cuser();
		cuser.setUsername(username);
		cuser.setPhone(phone);
		cuser.setEmail(email);
		cuser.setNickname(nickname);
		cuser.setUsertype(usertype);
		cuser.setRegip(ip);
		
		// 密码掩码和密码
		String salt = Toolkit.randString(4);
		cuser.setSalt(salt);
		cuser.setPassword(DigestUtils.md5Hex(DigestUtils.md5Hex(password)+salt) );
		
		cuser.setCreatedtime(Calendar.getInstance());
		cuser.setIsDeleted(false);
		cuser.setCheckStatus(true);// false表示被限制，true表示正常
		cuser = cuserDAO.store(cuser);
		return cuser;
	}

	@Override
	public Cuser saveNewPwd(Integer uid, String salt, String password) {
		Cuser cuser = cuserDAO.findCuserById(uid);
		if(cuser==null) return null;
		
		cuser = cuserDAO.store(createPwd(cuser, salt, password));
		return cuser;
	}

	@Override
	public Cuser createPwd(Cuser cuser, String salt, String password) {
		cuser.setSalt(salt);
		cuser.setPassword(DigestUtils.md5Hex(DigestUtils.md5Hex(password)+salt) );
		cuser.setLogintoken(null);
		return cuser;
	}

	@Override
	public Cuser alterPwd(Cuser cuser, String oldpassword, String newpassword) {
		
		if(!cuser.getPassword().equals(DigestUtils.md5Hex(DigestUtils.md5Hex(oldpassword)+cuser.getSalt()))){
			return null; // 原始密码错误
		}
		
		String salt = Toolkit.randString(4);
		cuser.setSalt(salt);
		cuser.setPassword(DigestUtils.md5Hex(DigestUtils.md5Hex(newpassword)+salt) );
		cuser.setLogintoken(null);
		cuser = cuserDAO.store(cuser);

		return cuser;
	}

}
