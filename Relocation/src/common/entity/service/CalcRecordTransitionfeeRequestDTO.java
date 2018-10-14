package common.entity.service;

import java.io.Serializable;

import common.domain.Cuser;
import common.domain.Sysconfig;

/**
 * 过渡费计算方法请求DTO
 * @author liangcz
 * @version 2016/10/06
 * @see TransitionfeeServiceImpl
 */
public class CalcRecordTransitionfeeRequestDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 系统配置
	 */
	private Sysconfig sysconfig;
	
	/**
	 *  当前登录用户
	 */
	private Cuser cuser;
	
	private String preQuarter;

	public Sysconfig getSysconfig() {
		return sysconfig;
	}

	public void setSysconfig(Sysconfig sysconfig) {
		this.sysconfig = sysconfig;
	}

	public Cuser getCuser() {
		return cuser;
	}

	public void setCuser(Cuser cuser) {
		this.cuser = cuser;
	}

	public String getPreQuarter() {
		return preQuarter;
	}

	public void setPreQuarter(String preQuarter) {
		this.preQuarter = preQuarter;
	}

	@Override
	public String toString() {
		return "CalcRecordTransitionfeeRequestDTO [sysconfig=" + sysconfig
				+ ", cuser=" + cuser + ", preQuarter=" + preQuarter + "]";
	} 
	
	
	
	
}
