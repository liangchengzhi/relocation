package common.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;   
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;   
import org.dom4j.Element; 
import org.springframework.stereotype.Component;

import com.google.inject.persist.Transactional;
import common.util.StringUtil;
import common.util.Toolkit;

@Component("SendSms")
public class SendSms {
	public SendSms() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public String sendSms(String mobile,String content) {
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(SmsConfig.serviceURL); 
			
		//client.getParams().setContentCharset("GBK");		
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
		
		NameValuePair[] data = {//提交短信
			    new NameValuePair("account", SmsConfig.username), 
			    //new NameValuePair("password", "密码"), //密码可以使用明文密码或使用32位MD5加密
			    new NameValuePair("password", StringUtil.MD5Encode(SmsConfig.password)),
			    new NameValuePair("mobile", mobile), 
			    new NameValuePair("content", content),
		};
		method.setRequestBody(data);		
		try {
			client.executeMethod(method);	
			
			String SubmitResult =method.getResponseBodyAsString();

			Document doc = DocumentHelper.parseText(SubmitResult); 
			Element root = doc.getRootElement();

			String code = root.elementText("code");	
			String msg = root.elementText("msg");	
			String smsid = root.elementText("smsid");	
			
			/*System.out.println(code);
			System.out.println(msg);
			System.out.println(smsid);*/
			 if("2".equals(code)){
				return "1";
			}
			
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
}

class SmsConfig{
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	public static String username = "cf_daliangshan";
	public static String password = "d757fee306e441493e5b";
	public static String serviceURL = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	//http://utf8.sms.webchinese.cn/?Uid=本站用户名&Key=接口安全秘钥&smsMob=手机号码&smsText=验证码:8888
	static {
		try{
			InputStream ins = Toolkit.class.getResourceAsStream("/sendsms.properties");
			Properties prop = new Properties();
			prop.load(ins);
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			serviceURL = prop.getProperty("serviceURL");
			ins.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}
