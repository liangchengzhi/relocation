package common.util;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import common.entity.basic.ErrorCode;
import common.entity.basic.IFSException;


public class ServletListener implements ServletContextListener{
	 private static ServletContext servletContext;
	
	@SuppressWarnings("static-access")
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		this.servletContext = sce.getServletContext();
		try {
			ImportModelUtil.getInstance().init();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IFSException(e,e.getMessage(),ErrorCode.BaseErrorCode);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static ServletContext getServletContext(){
		return servletContext;
	}

}
