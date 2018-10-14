package common.service.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import common.dao.QxdmkDAO;
import common.dao.util.NativesqlDao;
import common.domain.Qxdmk;
import common.util.Toolkit;

@Service("CommonService")
public class CommonServiceImpl  implements CommonService{
	@Autowired
	MySendsmsService sendsmsService;
	@Autowired
	SendSms sendSms;
	@Autowired
	NativesqlDao nativesqlDao;
	@Autowired
	QxdmkDAO qxdmkDAO;
	
	@Override
	public String sendPhoneRandcode(String phone, String ip, String username) {
		if(5<=sendsmsService.countTodaySend(phone, null)){
			return "-110"; // 同一手机号每日最多5条
		}
		if(10<=sendsmsService.countTodaySend(null, ip)){
			return "-120"; // 同一IP地址每日最多10条
		}
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("M月d日HH时mm分");
		String format = sdf.format(now.getTime());
		
		String randcode = Toolkit.randNumber(6);
		
		// 发送手机验证码
		String content = "用户"+(username==null?"":""+username)+"您好，您在"+format+"收到的验证码为："+randcode+"，请及时验证。";
				//"您的验证码是："+randcode+"。请不要把验证码泄露给其他人。";//(username==null?"":"用户"+username)+"您好，您在"+format+"收到的验证码为："+randcode+"，请及时验证。";
		String result = sendSms.sendSms(phone, content);
		
		int res = Integer.parseInt("1");
		if(res>0){
			HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession(true);
			session.setAttribute("randcode", phone+":"+randcode);
			sendsmsService.addSendsms(phone, randcode, content, ip);
		}
		
		return res+"";
	}
	
	@Override
	public List<Qxdmk> listQxdmk(String parentCode) {
		String sql = "select * from qxdmk";
		if(parentCode.endsWith("000000")){
			sql += " where qxdm like '%0000'";
		}else if(parentCode.endsWith("0000")){
			sql += " where qxdm like '"+parentCode.substring(0,2)+"%00' and qxdm!='"+parentCode+"'";
		}else if(parentCode.endsWith("00")){
			sql += " where qxdm like '"+parentCode.substring(0,4)+"%' and qxdm!='"+parentCode+"'";
		}
		
		List<Qxdmk> listBySql = nativesqlDao.listBySql(sql, new Qxdmk());
		return listBySql;
	}

}
