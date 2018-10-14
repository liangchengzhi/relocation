package common.util;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * 日期个性化格式
 * @param time
 * @param format 默认格式，包括"日期部分"和"时间部分"
 * @param twoDay 两日内默认"时间部分"
 * @return
 */
public class Mytag4floridTime extends BodyTagSupport{
	private static final long serialVersionUID = 1L;
	private Calendar time;
	private String format;
	private String twoDay;
	
	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getTwoDay() {
		return twoDay;
	}

	public void setTwoDay(String twoDay) {
		this.twoDay = twoDay;
	}

	public int doStartTag(){
		JspWriter out= pageContext.getOut();
		String result = "";
		if(time==null){
		}else{
			result = Toolkit.floridTime(time, format, twoDay);
		}
		
		try {
			out.print(result);
		} catch (IOException e) {}
		
		return EVAL_BODY_INCLUDE;
	}
	
	public int doEndTag(){
        return  EVAL_BODY_INCLUDE;
	}
}
