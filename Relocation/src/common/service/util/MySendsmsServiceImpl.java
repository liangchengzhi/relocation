package common.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.util.NativesqlDao;

@Service("MySendsmsService")
public class MySendsmsServiceImpl implements MySendsmsService{
	@Autowired
	private NativesqlDao nativesqlDao;
	
	@Override
	public void addSendsms(String phone, String randcode, String content, String ip) {
		String sql = "insert into sendsms(phone,randcode,createdtime,content,ip)"
				+ " values('"+phone+"','"+randcode+"',now(),'"+content+"','"+ip+"')";
		nativesqlDao.executeSql(sql);
	}

	@Override
	public int countTodaySend(String phone, String ip) {
		String sql = "select count(*) from sendsms where 1=1";
		
		if(phone!=null&&!phone.equals("")){
			sql += " and phone='"+phone+"'";
		}
		if(ip!=null&&!ip.equals("")){
			sql += " and ip='"+ip+"'";
		}
		
		sql += " and floor(unix_timestamp(createdtime)/86400)=floor(unix_timestamp(now())/86400)";
		
		return nativesqlDao.countBySql(sql);
	}
}
