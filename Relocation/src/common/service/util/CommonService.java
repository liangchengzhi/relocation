package common.service.util;

import java.util.List;

import common.domain.Qxdmk;


public interface CommonService {

	/**
	 * 发送手机验证码
	 * @param phone
	 * @param ip
	 * @param username
	 * @return
	 */
	String sendPhoneRandcode(String phone, String ip, String username);

	/**
	 * 获取区县列表
	 * @param parent
	 * @return
	 */
	List<Qxdmk> listQxdmk(String parent);
	

	

}
