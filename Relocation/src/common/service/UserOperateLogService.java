package common.service;

import java.util.List;

import common.domain.UserOperateLog;

/** 
 * 用户操作日志接口
 * @author liangcz
 * @see UserOperateLogServiceImpl
 */
public interface UserOperateLogService {
	
	/**
	 * 查询用户操作日志总记录数
	 * @param userOperateLog
	 * @return
	 */
	Integer countUserOperateLog(UserOperateLog userOperateLog);
	/**
	 * 列出用户操作日志
	 * @return
	 */
	List<UserOperateLog> listUserOperateLog(UserOperateLog userOperateLog,int begin, int offeset);
	
	/**
	 * 保存用户操作日志
	 * @param userOperateLog
	 * @return
	 */
	UserOperateLog saveUserOperateLog(String username,String tranName,boolean status,String msg);
	
	/**
	 * 保存用户操作日志
	 * @param userOperateLog
	 * @return
	 */
	UserOperateLog saveUserOperateLog(String username,String tranName,boolean status,String msg,String remark);
}
