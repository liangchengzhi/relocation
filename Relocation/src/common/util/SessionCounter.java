package common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener{
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext ctx = session.getServletContext( ); 
		Map<String,HttpSession> sessions = (Map<String,HttpSession>) ctx.getAttribute("sessions"); 
		if (sessions == null) {  
			sessions = new HashMap<String, HttpSession>();
			ctx.setAttribute("sessions", sessions);  
		} 
		
		sessions.put(session.getId(), session);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext ctx = session.getServletContext( ); 
		Map<String,HttpSession> sessions = (Map<String,HttpSession>) ctx.getAttribute("sessions"); 
		if (sessions == null) {  
			sessions = new HashMap<String, HttpSession>();
			ctx.setAttribute("sessions", sessions);  
		}
		sessions.remove(session.getId());
		
	}
}
