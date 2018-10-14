package common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common.domain.Cuser;
import common.domain.UserOperateLog;
import common.service.UserOperateLogService;
import common.service.UserOperateLogServiceImpl;
import common.util.Pager;
import common.util.Toolkit;
import common.web.util.CurrentUser;

/** 
 * 用户操作日志控制层
 * @author liangcz
 * @see UserOperateLogServiceImpl
 */
@Controller("userOperatorLogController")
public class UserOperatorLogController {
	
	@Autowired
	private UserOperateLogService userOperateLogService;
	@Autowired
	private CurrentUser currentUser;
	
	 /**
     * 查询用户操作日志
     * @param status
     * @param usernmae
     * @param tranname
     * @param dateTime
     * @return
     */
	@RequestMapping("/listUserOperatorLog")
	public ModelAndView listUserOperatorLog(@RequestParam(value = "status", required = false) Boolean status,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "tranName", required = false) String tranName,
			@RequestParam(value = "begin", required = false) Integer begin,
			@RequestParam(value = "offeset", required = false) Integer offeset,
			HttpServletRequest request,HttpServletResponse response
			){
		ModelAndView mav = new ModelAndView();
		Cuser cuser = currentUser.getCuser(request, response);
		if (Toolkit.checkUser(cuser, null, mav) == false)
			return mav;
		
		mav.addObject("cuser", cuser);
		UserOperateLog userOperateLog = new UserOperateLog();
		userOperateLog.setUsername(username);
		userOperateLog.setTranName(tranName);
		userOperateLog.setStatus(status);
		
		if(begin == null || offeset == null){
			begin = -1;
			offeset = -1;
		}
		
		int totalcount = userOperateLogService.countUserOperateLog(userOperateLog);
		Pager pager = new Pager(request, totalcount);
		List<UserOperateLog> list = userOperateLogService.listUserOperateLog(userOperateLog, pager.offset, pager.ps);
		
		mav.addObject("list", list);		
		pager.url = "listUserOperatorLog?pS=" + pager.ps;
		if (status != null)
			pager.url += "&status=" + status;
		if (username != null)
			pager.url += "&username=" + username;
		if (tranName != null)
			pager.url += "&tranName=" + tranName;
		if (begin != null)
			pager.url += "&begin=" + begin;
		if (begin != null)
			pager.url += "&offeset=" + offeset;
		
		mav.addObject("pager", pager);
		mav.setViewName("userOpearatorLog/listUserOperatorLog.jsp");
		return mav;
	}
}
