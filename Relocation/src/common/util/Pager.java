package common.util;

import javax.servlet.http.HttpServletRequest;

public class Pager {
	public int p = 1;
	public int ps = 10;
	public int totalcount = 0;
	public int totalpage = 0;
	public int offset = 0;
	public String url = "";
	
	public Pager(HttpServletRequest request, int totalcount){
		String tmp = null;
		this.p = Integer.parseInt((tmp =request.getParameter("p"))==null?"1":tmp);
		this.ps = Integer.parseInt((tmp =request.getParameter("pS"))==null?"10":tmp);
		this.totalcount = totalcount;
		this.totalpage = (totalcount - 1)/ps+1;
		this.offset = ((p = (p = p<1?1:p)>totalpage?totalpage:p)-1)*ps;
	}
	
	public Pager(HttpServletRequest request, int totalcount, int defaultPageSize){
		String tmp = null;
		this.p = Integer.parseInt((tmp =request.getParameter("p"))==null?"1":tmp);
		this.ps = (tmp =request.getParameter("pS"))==null?defaultPageSize:Integer.parseInt(tmp);
		this.totalcount = totalcount;
		this.totalpage = (totalcount - 1)/ps+1;
		this.offset = ((p = (p = p<1?1:p)>totalpage?totalpage:p)-1)*ps;
	}
	
	public int getP() {
		return p;
	}
	public int getPs() {
		return ps;
	}
	public int getOffset() {
		return offset;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public String getUrl() {
		return url;
	}
}