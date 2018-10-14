package common.web.util;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import common.dao.CuserDAO;
import common.domain.Cuser;

/**
 * 获取当前用户，统一获取多种用户信息，进行关联
 */
@Component("CurrentUser")
public class CurrentUser{
	
	@Autowired
	CuserDAO cuserDAO;
	private SessionRegistry sessionRegistry;
	
	private String username;
	private Cuser cuser;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCuser(Cuser cuser) {
		this.cuser = cuser;
	}
	

	public CurrentUser() {
	}

	public CurrentUser(String username) {
	}

	/**
	 * 初始化，获取当前用户名
	 */
	public void init(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(true);
			if(session==null) return ;
			Cuser attribute = (Cuser)session.getServletContext().getAttribute(session.getId());
			if (attribute==null) {
				String logintoken = request.getParameter("logintoken");
				Cuser checkLogin = null;
				boolean aviable = true;
				if(logintoken==null){
					Cookie[] cookies = request.getCookies();
					if(cookies!=null)
					for(int i=0; i<cookies.length; i++){
						if(cookies[i].getName().equals("logintoken")){
							logintoken = cookies[i].getValue();
						}
					}
				}
				if(logintoken!=null){
					checkLogin = null;//cuserService.checkLogintoken(logintoken);
				}
				
				if(checkLogin!=null){
					if(checkLogin.getCheckStatus()!=null&&checkLogin.getCheckStatus()==false){ //被管理员限制登录
						aviable = false;
					}
				}else{
					aviable = false;
				}
				
				if(aviable){
					
					session.setAttribute("username", checkLogin.getUsername());
					session.setAttribute("uid", checkLogin.getId());
					session.getServletContext().setAttribute(session.getId(), checkLogin);
					String tmp = null;
					String ip = ((tmp=request.getHeader("x-forwarded-for")) == null) ? request.getRemoteAddr(): tmp;
					checkLogin.setLoginip(ip);
					checkLogin.setLogintime(Calendar.getInstance());
					cuserDAO.store(checkLogin);
					this.cuser = checkLogin;
				}else{
					session.removeAttribute("username");
					session.removeAttribute("uid");
					if(logintoken!=null){
						Cookie cookie = new Cookie("logintoken", null);
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
					setUsername("");
					setCuser(null);
					return;
				}
			}else{
				this.cuser = cuserDAO.findCuserById(attribute.getId());
			}
			this.setUsername(this.cuser==null?null:this.cuser.getUsername());
		} catch (Exception e) {
			setUsername("");
			e.printStackTrace();
		}

	}

	/**
	 * 构造
	 * @param cuser
	 * @param username
	 * @param users
	 */
	public CurrentUser(Cuser cuser, String username) {
		super();
		this.cuser = cuser;
		this.username = username;
	}

	public Cuser getCuser() {
		return cuser;
	}
	public Cuser getCuser(HttpServletRequest request, HttpServletResponse response) {
		init(request,response);
		//TODO 默认是登陆状态，超级管理员
		//cuser = cuserDAO.findCuserById(1);
		return cuser;
	}

}
