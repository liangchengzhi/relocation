package common.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import common.domain.Cuser;

public class Toolkit {
	
	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			session = getRequest().getSession();
		} catch (Exception e) {
		}
		return session;
	}
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		return attrs.getRequest();
	}
	
	
	/**
	 * 产生随机字符串
	 */
	public static String ALPHANUM = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static String randString(int length){
		String str = "";
		for(int i = 0; i<length; i++){
			str += ALPHANUM.charAt((int)(Math.random()*ALPHANUM.length()));
		}
		return str;
	}
	public static String randNumber(int length){
		String str = "";
		for(int i = 0; i<length; i++){
			str += ALPHANUM.charAt((int)(Math.random()*9));
		}
		return str;
	}
	
	/**
	 * 登陆用户检测
	 * @param cuser
	 * @param result
	 * @param mav
	 * @return
	 */
	public static boolean checkUser(Cuser cuser, JsonObj result, ModelAndView mav){
		
		if(cuser==null){//未登录
			if(result!=null){
				result.setStatus(401);
			}
			if(mav!=null){
				mav.addObject("message", "未登录！");
				mav.setViewName("_common/goback.jsp");
				//mav.addObject("page", -1);
				//mav.addObject("url", "http://baidu.com");
			}
			return false;
		}
		if(cuser.getSalt()!=null&&cuser.getSalt().equals("init")){
			if(result!=null){
				result.setStatus(406);
			}
			if(mav!=null){
				mav.addObject("message", "初始密码不安全，请重设密码！");
				if(cuser.getUsertype()<2){
					mav.addObject("url", "./UserCenter?act=4");
				}else{
					mav.addObject("url", "./Admin?page=pwd");
				}
				mav.setViewName("_common/goback.jsp");
			}
			return false;
		}
		
		if(cuser.getUsertype()>1){
			if(cuser.getNickname()==null||cuser.getNickname().equals("")||cuser.getPhone()==null||cuser.getPhone().equals("")){
				if(result!=null){
					result.setStatus(407);
				}
				if(mav!=null){
					mav.addObject("message", "用户信息不完善，请补充！");
					mav.addObject("url", "./Admin?page=profile");
					mav.setViewName("_common/goback.jsp");
				}
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 图片缩略图生成
	 * @param imgFile
	 * @param w
	 * @param h
	 * @param addName
	 * @param force
	 * @return
	 */
	public static String thumbnailImage(File imgFile, int w, int h, String addName, boolean force){
		if(imgFile.exists()){
            try {
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames()).toLowerCase();
                String suffix = null;
                // 获取图片后缀
                if(imgFile.getName().indexOf(".") > -1) {
                    suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                }// 类型和图片后缀全部小写，然后判断后缀是否合法
                if(suffix == null || types.indexOf(suffix.toLowerCase()) < 0){
                    return null;
                }
                
                File file = new File(imgFile.getPath() + "." + addName + "." +suffix);
                if(file.exists()) return file.getName();
                
                Image img = ImageIO.read(imgFile);
                if(!force){
                    // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if((width*1.0)/w < (height*1.0)/h){
                        if(width > w){
                            h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                        }
                    } else {
                        if(height > h){
                            w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                        }
                    }
                    if(height<h || width<w){
                    	h = height;w = width;
                    }
                }
                Image src = javax.imageio.ImageIO.read(imgFile);
                BufferedImage tag= new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);   
                tag.getGraphics().drawImage(src.getScaledInstance(w, h,  Image.SCALE_SMOOTH), 0, 0,  null);        
                
                FileOutputStream out = new FileOutputStream(file);        
                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);        
                encoder.encode(tag);
                
                /*
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                // 将图片保存在原目录并加上后缀，如 fsf.jpg ==> fsf.jpg.big.jpg
                ImageIO.write(bi, suffix, file);*/
                return file.getName();
            } catch (IOException e) {
            	return null;
            }
        }else{
            return null;
        }
	}
	
	
	/**
	 * 日历相加
	 * @param day
	 * @param cal
	 * @return
	 */
	public static Calendar addMinute(int day, Calendar cal) {
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal;
	}
	public static Calendar addHourMinute(String hour, String min, Calendar cal){
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
		cal.set(Calendar.MINUTE, Integer.parseInt(min));
		return cal;
	}

	/**
	 * 日期个性化格式
	 * @param time
	 * @param defaultFormat 默认格式，包括"日期部分"和"时间部分"
	 * @param twoDayFormat 两日内默认"时间部分"
	 * @return
	 */
	public static String floridTime(Calendar time, String format,
			String twoDay) {
		String result = "";
		Calendar now = Calendar.getInstance();
		long dt = (now.getTimeInMillis() - time.getTimeInMillis()) / 1000;
		if (dt < 60) { //一分钟之内
			result = "刚刚";
		} else if (dt < 60 * 60) { //一个小时之内
			result = ((int) (dt / 60)) + "分钟前";
		} else if (dt < 60 * 60 * 5) { //五个小时之内
			result = ((int) (dt * 1.0 / 60 / 60)) + "小时前";
		} else if (dt < 60 * 60 * 24 * 3) { //三天之内
			SimpleDateFormat sFormat = new SimpleDateFormat(
					twoDay == null ? "HH:mm" : twoDay);
			int second = now.get(Calendar.SECOND)+now.get(Calendar.MINUTE)*60+now.get(Calendar.HOUR_OF_DAY)*3600;
			if (dt < second)
				result = "今天" + sFormat.format(time.getTime());
			else if (dt < second+24*3600)
				result = "昨天" + sFormat.format(time.getTime());
			else
				result = "前天" + sFormat.format(time.getTime());
		} else {
			SimpleDateFormat sFormat = new SimpleDateFormat(
					format == null ? "yyyy-MM-dd": format);
			result = sFormat.format(time.getTime());
		}
		
		return result;
	}
	
	public static String sqlStrSafe(String str){
		str=str.replaceAll(";","");
		str=str.replaceAll("&","&amp;");
		str=str.replaceAll("<","&lt;");
		str=str.replaceAll(">","&gt;");
		str=str.replaceAll("--","");
		str=str.replaceAll("/","");
		str=str.replaceAll("%","");
		return str;
	}
	
}
