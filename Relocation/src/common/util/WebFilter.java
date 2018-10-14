package common.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WebFilter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String pathString = request.getContextPath();

		String host = request.getHeader("Host");

		String url = request.getRequestURL().toString();
		String path = url.replace(host, "");

		if(url.indexOf(host + pathString)+(host + pathString).length()==url.length()){
			path = "/";
		}else{
			path = url.substring((host + pathString).length() + url.indexOf(host + pathString) + 1);
		}
		
		System.out.println("orgionpath:" + pathString + ", host:" + host + ", url:" + url + ", editpath:" + path);

		String tmp = null;
		// 缩略图处理
		String queryString = request.getQueryString();
		if (queryString != null && queryString.startsWith("thumb=")) {
			queryString = queryString.substring(6).trim();
			String imgFile = request.getSession().getServletContext()
					.getRealPath("/" + path);
			if (imgFile != null) {
				File file = new File(imgFile);
				int w = 1200, h = 900;
				if (queryString.equals("middle")) {
					w = 400;
					h = 300;
				} else if (queryString.equals("small")) {
					w = 200;
					h = 150;
				} else if (queryString.equals("mini")) {
					w = 80;
					h = 80;
				}
				String thumbnailImage = Toolkit.thumbnailImage(file, w, h,
						queryString, false);
				if (thumbnailImage != null) {
					request.getRequestDispatcher(thumbnailImage + "?nothumb=1")
							.forward(request, response);
					return false;
				}
			}
		}
		/*// 记录分享浏览
		else if ((tmp = request.getParameter("distr")) != null) {
			Integer uid = null;
			String distr = tmp;
			String ip = ((tmp = request.getHeader("x-forwarded-for")) == null) ? request
					.getRemoteAddr() : tmp;
			Cuser cuser = currentUser.getCuser();
			if (cuser != null)
				uid = cuser.getCuserid();
			url = request.getRequestURL().toString();
			String query = request.getQueryString();
			if (query != null)
				url += "?" + query;
			distributionService.view(url, distr, ip, uid);
		}*/

		return true;
	}
}
