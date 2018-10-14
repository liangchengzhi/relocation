package common.service;

import java.util.Calendar;
import java.util.List;










import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import common.dao.UserOperateLogDAO;
import common.domain.UserOperateLog;
import common.web.util.CurrentUser;

/**
 * 查询操作日志service
 * @author liangcz
 * @version 2016/10/03
 * @see UserOperateLog
 * @see UserOperateLogDAO
 * @see UserOperateLogService
 */
@Service("userOperateLogService")
public class UserOperateLogServiceImpl implements UserOperateLogService {
	
	@Autowired
	private UserOperateLogDAO userOperateLogDAO;
	
	@Autowired
	CurrentUser currentUser;
	
	
	@Override
	public Integer countUserOperateLog(UserOperateLog userOperateLog) {
		String hql = "select count(log.seqNo) " + getUserOperateLogHql(userOperateLog);
		return ((Long)userOperateLogDAO.createQuerySingleResult(hql).getSingleResult()).intValue();
	}
	
	@Override
	public List<UserOperateLog> listUserOperateLog(UserOperateLog userOperateLog,int begin,int offeset) {
		String hql = "select log " + getUserOperateLogHql(userOperateLog);
		List<UserOperateLog> list = userOperateLogDAO.executeQuery(hql, begin, offeset);
		System.out.println(list);
		
		return list;
	}
	
	
	private String getUserOperateLogHql(UserOperateLog userOperateLog){
		StringBuffer hql = new StringBuffer("from UserOperateLog log where 1=1 ");  
		if(StringUtils.isNotBlank(userOperateLog.getUsername())){
			
			hql.append(" and log.username = " + "'" + userOperateLog.getUsername() + "'" );
		}
		
		if(StringUtils.isNotBlank(userOperateLog.getTranName())){
			hql.append(" and log.tranName like " + "'%" + userOperateLog.getTranName() + "%'");
		}
		
		if(userOperateLog.getStatus() != null){
			hql.append(" and log.status = " + (userOperateLog.getStatus() == true ? 0 : 1));
		}
		hql.append(" order by log.seqNo desc,log.username,log.tranTime desc");
		
		System.out.println("hql:" + hql.toString());
		return hql.toString();
	}

	
	@Override
	public UserOperateLog saveUserOperateLog(String username,String tranName, boolean status,String msg) {
		return saveUserOperateLog(username,tranName,status,msg,null);
	}

	@Override
	@Transactional
	public UserOperateLog saveUserOperateLog(String username, String tranName,
			boolean status, String msg, String remark) {
		UserOperateLog userOperateLog = new UserOperateLog();
		userOperateLog.setTranName(tranName);
		userOperateLog.setTranTime(Calendar.getInstance());
		userOperateLog.setUsername(username);
		userOperateLog.setStatus(status);
		userOperateLog.setMsg(msg);
		userOperateLog.setRemark(remark);
		return userOperateLogDAO.store(userOperateLog);
	}



}
