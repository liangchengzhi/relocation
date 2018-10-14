package common.web.util;


import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import common.dao.CuserDAO;
import common.domain.Cuser;
import common.service.UserOperateLogService;
import common.service.util.CommonService;
import common.service.util.MyCuserService;
import common.util.Constant;
import common.util.JsonObj;
import common.util.JsonObjHelper;
import common.util.Toolkit;

@Controller("SecurityController")
public class SecurityController {
	@Autowired
	CuserDAO cuserDAO;
	@Autowired
	CurrentUser currentUser;
	@Autowired
	MyCuserService cuserService;
	@Autowired
	CommonService commonService;
	@Autowired
	UserOperateLogService userOperateLogService;
	
	/**
	 * 注销操作 前清除login cookie
	 * @return
	 */
	@RequestMapping("/Logout")
	@Transactional
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "注销";
		
		try {
			ModelAndView mav = new ModelAndView();
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for (int i = 0; i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if(cookie.getName().equals("logintoken")){
						cookie.setMaxAge(0);
						cookie.setValue(null);
						response.addCookie(cookie);
						break;
					}
				}
			}
			if(cuser!=null){
				Cuser findById = cuserDAO.findCuserById(cuser.getId());
				findById.setLogintoken(null);
				cuserDAO.store(findById);
			}
			HttpSession session = request.getSession();
			session.getServletContext().removeAttribute(session.getId());
			session.removeAttribute("username");
			session.removeAttribute("uid");
			session.invalidate(); 
			mav.setViewName("redirect:./");
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return mav;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
		
	}
	
	/**
	 * 平台登陆页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/Login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		Cuser cuser = currentUser.getCuser(request, response);
		String referer = request.getParameter("referer");
		if(referer==null) referer = request.getHeader("Referer");
		if(referer==null||referer.indexOf("/Login")!=-1){
			referer = "./";
		}
		if(cuser!=null){
			mav.setViewName("redirect:"+referer);
		}else{
			mav.addObject("register", request.getParameter("register"));
			mav.addObject("referer", referer);
			mav.setViewName("_index/login.jsp");
		}
		return mav;
	}
	
	/**
	 * 登录认证，没有使用访问权限控制。
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/checkLogin")
	@ResponseBody
	public JsonObj loginProcessing(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response)
	{	
		
		String tranName = "登录认证";
		
		try {
			String tmp = null;
			JsonObj result = new JsonObj();
			Cuser checkLogin = cuserService.checkLogin(username, password);
			if(checkLogin==null) {
				checkLogin = currentUser.getCuser(request, response);
			}
			
			if(checkLogin==null){// 用户名或密码错误
				userOperateLogService.saveUserOperateLog(username, tranName, false, "用户名或密码错误");
				result.setStatus(110);
				return result;
			}else if(checkLogin.getCheckStatus()!=null&&checkLogin.getCheckStatus()==false){ //被管理员限制登录
				userOperateLogService.saveUserOperateLog(username, tranName, false, "被管理员限制登录");
				result.setStatus(120);
				return result;
			}
			
			HttpSession session = request.getSession(true); 
			session.setAttribute("username", checkLogin.getUsername());
			session.setAttribute("uid", checkLogin.getId());
			session.getServletContext().setAttribute(session.getId(), checkLogin);
			
			String remenberMe = request.getParameter("remenberMe");
			if(remenberMe!=null&&!remenberMe.equals("yes")){
				Cookie cookie = new Cookie("logintoken", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}else{
				String randomUUID = UUID.randomUUID().toString();
				Cookie cookie1 = new Cookie("logintoken", randomUUID);
				cookie1.setMaxAge(30*24*60*60);//30天有效
				response.addCookie(cookie1);
				checkLogin.setLogintoken(randomUUID);
				try {
					String u = java.net.URLEncoder.encode(checkLogin.getUsername(),"utf-8");
					Cookie cookie2 = new Cookie("loginusername", u);
					cookie2.setMaxAge(30*24*60*60);
					response.addCookie(cookie2);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			String ip = ((tmp=request.getHeader("x-forwarded-for")) == null) ? request.getRemoteAddr(): tmp;
			checkLogin.setLoginip(ip);
			checkLogin.setLogintime(Calendar.getInstance());
			cuserDAO.store(checkLogin);
			
			result.setData(JsonObjHelper.cuser(checkLogin, checkLogin));
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
	}
	
	/**
	 * 获取验证码:{phone/type}:{code}
	 * @param phone
	 * @param type	类型：register/rebind/findpwd
	 * @return
	 */
	@RequestMapping("phoneRandcode")
	@ResponseBody
	public JsonObj getPhoneRandcode(@RequestParam String phone, @RequestParam String type, HttpServletRequest request, HttpServletResponse response){
		String tmp = null;
		JsonObj result = new JsonObj();
		
		Cuser findByField = cuserService.findByField(phone, "phone");
		if(type.equals("register")){ // 注册
			if(findByField!=null){
				result.setStatus(1);return result;
			}
		}else if(type.equals("rebind")){ // 重新绑定
			Cuser cuser = currentUser.getCuser(request, response);
			if(cuser==null){
				result.setStatus(401);return result;
			}
			if(findByField!=null && cuser.getId()*1==findByField.getId()*1){
				result.setStatus(405);return result;
			}
			if(findByField!=null){
				result.setStatus(1);return result;
			}
		}else if(type.equals("findpwd")){ // 找回密码
			if(findByField==null){
				result.setStatus(2);
			}
		}else{
			result.setStatus(-1);
		}
		
		if(result.getStatus()!=0){
			return result;
		}
		
		String ip = ((tmp=request.getHeader("x-forwarded-for")) == null) ? request.getRemoteAddr(): tmp;
		String res = commonService.sendPhoneRandcode(phone, ip, findByField==null?null:findByField.getUsername());
		result.setData(res);
		return result;
	}
	
	/**
	 * 注册新用户
	 * @param username	用户名
	 * @param phone		手机号
	 * @param email		邮箱地址[可选]
	 * @param password	密码
	 * @param code		手机验证码
	 * @param request
	 * @return
	 */
	@RequestMapping("register")
	@ResponseBody
	public JsonObj register(@RequestParam String username,@RequestParam String phone, @RequestParam(value="email",required=false) String email, @RequestParam String password, @RequestParam String code, HttpServletRequest request){
		String tmp = null;
		JsonObj result = new JsonObj();
		if(email!=null && cuserService.isExist(email, "email")){
			result.setStatus(3);//邮箱已存在
		}else if(cuserService.isExist(username, "username")){
			result.setStatus(5);//用户名已存在
		}else if(cuserService.isExist(phone, "phone")){
			result.setStatus(1);//手机号已被绑定
		}else {
			HttpSession session = request.getSession(true);
			String randcode = (String)session.getAttribute("randcode");
			if(randcode!=null){
				String[] split = randcode.split(":");
				if(split[0].equals(phone)&&split[1].equals(code)){
					String ip = (tmp=request.getHeader("x-forwarded-for")) == null ? request.getRemoteAddr(): tmp;
					Cuser registerUser = cuserService.createCuser(username, username, phone, email, password, ip, 0);
					session.removeAttribute("randcode");
					result.setData(JsonObjHelper.cuser(null, registerUser));
				}else{
					result.setStatus(7);//手机验证码错误
				}
			}else{
				result.setStatus(8);//未发送手机验证码
			}
		}
		return result;
	}
	
	/**
	 * 通过手机重置密码前验证手机验证码
	 * @param phone		手机号
	 * @param code		20分钟内最后收到的手机验证码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("findPwdByMobileStep1")
	@ResponseBody
	public JsonObj resetPwdByMobileStep1(@RequestParam String phone, @RequestParam String code, HttpServletRequest request, HttpServletResponse response){
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "通过手机重置密码前验证手机验证码-1";
		
		try {
			JsonObj result = new JsonObj();
			String errorMsg = "";
			HttpSession session = request.getSession(true);
			String randcode = (String)session.getAttribute("randcode");
			if(randcode!=null){
				String[] split = randcode.split(":");
				if(split[0].equals(phone)&&split[1].equals(code)){
					Cuser findByField = cuserService.findByField(phone, "phone");
					if(findByField==null){
						result.setStatus(2);//用户不存在
						errorMsg = "用户不存在";
					}else{
						session.setAttribute("setnewpwd", phone);
						result.setData(phone);
					}
				}else{
					session.removeAttribute("setnewpwd");
					result.setStatus(7);//手机验证码错误
					errorMsg = "手机验证码错误";
				}
			}else{
				result.setStatus(8);//未发送手机验证码
				errorMsg = "未发送手机验证码";
			}
			if(result.getStatus() == 0){
				userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			}else{
				userOperateLogService.saveUserOperateLog(username, tranName, false, errorMsg);
			}
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}

	}
	
	/**
	 * 通过手机重置密码
	 * @param phone		手机号
	 * @param password	新密码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("findPwdByMobileStep2")
	@ResponseBody
	public JsonObj resetPwdByMobileStep2(@RequestParam String phone, @RequestParam String password, HttpServletRequest request, HttpServletResponse response){
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "通过手机重置密码-2";
		
		try {

			JsonObj result = new JsonObj();
			String errorMsg = "";
			HttpSession session = request.getSession(true);
			String setnewpwd = (String)session.getAttribute("setnewpwd");
			if(setnewpwd!=null){
				if(setnewpwd.equals(phone)){
					Cuser findByField = cuserService.findByField(phone, "phone");
					if(findByField==null){
						result.setStatus(2);//用户不存在
						errorMsg = "用户不存在";
					}else{
						cuserService.saveNewPwd(findByField.getId(), Toolkit.randString(4), password);
						session.removeAttribute("randcode");
						session.removeAttribute("setnewpwd");
						result.setData(phone);
					}
				}else{
					result.setStatus(-1);
					result.setMessage("手机号错误");
					errorMsg = "手机号错误";
				}
			}else{
				result.setStatus(8);//未发送手机验证码
				errorMsg = "未发送手机验证码";
			}
			if(result.getStatus() == 0){
				userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			}else{
				userOperateLogService.saveUserOperateLog(username, tranName, false, errorMsg);
			}

			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}
	
	/**
	 * 修改密码
	 * @param oldpassword
	 * @param newpassword
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("resetPassword")
	@ResponseBody
	public JsonObj resetPassword(@RequestParam String oldpassword, @RequestParam String newpassword, HttpServletRequest request, HttpServletResponse response){
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "修改密码";
		
		try {
			JsonObj result = new JsonObj();
			//是否登录
			if(cuser == null){
				result.setStatus(401); return result;
			}
			
			Cuser u = cuserService.alterPwd(cuser, oldpassword, newpassword);
			if(u==null){
				result.setStatus(110); 
				result.setMessage("原始密码错误！"); 
				userOperateLogService.saveUserOperateLog(username, tranName, false, "原始密码错误");
				return result;
			}
			
			result.setData("success");
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	
	}
	
	/**
	 * 重新绑定手机号
	 * @param phone
	 * @param code
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("rebindPhone")
	@ResponseBody
	public JsonObj rebindPhone(@RequestParam String phone, @RequestParam String code, HttpServletRequest request, HttpServletResponse response){
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "重新绑定手机号";
		
		try {
			JsonObj result = new JsonObj();
			HttpSession session = request.getSession(true);
			
			if(cuser==null){
				result.setStatus(401); 
				
				return result;
			}
			
			String randcode = (String)session.getAttribute("randcode");
			if(randcode!=null){
				String[] split = randcode.split(":");
				if(split[0].equals(phone)&&split[1].equals(code)){
					cuser.setPhone(phone);
					cuserDAO.store(cuser);
					session.removeAttribute("randcode");
					result.setData("success");
				}else{
					result.setStatus(7);
				}
			}else{
				result.setStatus(8);
			}
						
			if(result.getStatus() == 0){
				userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			}else{
				userOperateLogService.saveUserOperateLog(username, tranName, false, "交易失败");
			}
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}
	
	/**
	 * 检测用户名是否已存在
	 * @param username
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkUsername")
	@ResponseBody
	public JsonObj checkUsername(@RequestParam String username, HttpServletRequest request, HttpServletResponse response)
	{
		JsonObj result = new JsonObj();
		boolean exist = cuserService.isExist(username, "username");
		result.setData(exist);
		return result;
	}
	
	/**
	 * 检测手机号是否已存在
	 * @param phone
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkPhone")
	@ResponseBody
	public JsonObj checkPhone(@RequestParam String phone, HttpServletRequest request, HttpServletResponse response)
	{
		JsonObj result = new JsonObj();
		boolean exist = cuserService.isExist(phone, "phone");
		result.setData(exist);
		return result;
	}
	
	/**
	 * 检测邮箱地址是否已存在
	 * @param email
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/checkEmail")
	@ResponseBody
	public JsonObj checkEmail(@RequestParam String email, HttpServletRequest request, HttpServletResponse response)
	{
		JsonObj result = new JsonObj();
		boolean exist = cuserService.isExist(email, "email");
		result.setData(exist);
		return result;
	}
	
	/**
	 * 禁用 、 启用 用户
	 * @param id
	 * @param flag
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/enableUser")
	@ResponseBody
	public JsonObj enableUser(@RequestParam Integer id, @RequestParam Boolean flag, HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "禁用 、 启用 用户";
		
		try {
			JsonObj result = new JsonObj();
			if(Toolkit.checkUser(cuser, result, null)==false) return result;
			
			if(cuser.getUsertype()!=Constant.ADMIN_USERTYPE){
				result.setStatus(403);
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权限");
				return result;
			}
			
			Cuser findById = cuserDAO.findCuserById(id);
			if(findById==null){
				result.setStatus(404);//用户不存在
				userOperateLogService.saveUserOperateLog(username, tranName, false, "不存在");
				return result;
			}else{
				findById.setCheckStatus(flag);
				cuserDAO.store(findById);
				result.setData(flag);
			}
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
	
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public JsonObj deleteUser(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) {
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "删除用户";
		
		try {
			JsonObj result = new JsonObj();
			if(Toolkit.checkUser(cuser, result, null)==false) return result;
			
			if(cuser.getUsertype()!=Constant.ADMIN_USERTYPE){
				result.setStatus(403);
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权限");
				return result;
			}
			
			Cuser findById = cuserDAO.findCuserById(id);
			if(findById==null){
				result.setStatus(404);//用户不存在
				userOperateLogService.saveUserOperateLog(username, tranName, false, "不存在");
			}else{
				findById.setIsDeleted(true);
				cuserDAO.store(findById);
				result.setData(true);
			}
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
	}
	
	/**
	 * 重置密码为123456
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/repwdUser")
	@ResponseBody
	public JsonObj repwdUser(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) {
		
		Cuser cuser = currentUser.getCuser(request, response);
		String username = (cuser == null) ? "" : cuser.getUsername();
		String tranName = "重置密码";
		
		try {
			JsonObj result = new JsonObj();
			if(Toolkit.checkUser(cuser, result, null)==false) return result;
			
			if(cuser.getUsertype()!=Constant.ADMIN_USERTYPE){
				userOperateLogService.saveUserOperateLog(username, tranName, false, "无权限");
				result.setStatus(403);
				return result;
			}
			
			Cuser findById = cuserService.saveNewPwd(id, "init", "123456");
			if(findById==null){
				result.setStatus(404);//用户不存在
				userOperateLogService.saveUserOperateLog(username, tranName, false, "不存在");
				return result;
			}else{
				result.setData(true);
			}
			userOperateLogService.saveUserOperateLog(username, tranName, true, "交易成功");
			return result;
		
		} catch (Exception e) {
			userOperateLogService.saveUserOperateLog(username, tranName, false, "交易异常失败",e.toString()); 
			throw e;
		}
		
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
	    binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor("yyyy.MM.dd"));
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}
}
