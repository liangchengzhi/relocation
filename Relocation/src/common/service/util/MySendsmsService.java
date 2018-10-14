package common.service.util;

public interface MySendsmsService {
	/**
	 * 添加手机短信记录
	 * @param phone
	 * @param randcode
	 * @param content
	 * @param ip
	 */
	public void addSendsms(String phone, String randcode, String content, String ip);
	
	/**
	 * 今日向指定手机/来自执行IP的发送量
	 * @param phone
	 * @param ip
	 * @return
	 */
	public int countTodaySend(String phone, String ip);
}
