package common.service;

import org.apache.log4j.Logger;

import common.entity.service.CalcRecordTransitionfeeSectionRequestDTO;
import common.util.CommonsUtil;
import common.util.SpringContextUtil;

/**
 * 过渡费计算线程
 * @author liangcz
 * @version 2017/04/11
 * @see TransitionfeeService
 */
public class TransitionfeeCalThread implements Runnable{
	private CalcRecordTransitionfeeSectionRequestDTO calcRecordTransitionfeeSectionRequestDTO;
	private Logger log = Logger.getLogger(this.getClass());
	@Override
	public void run() {
		try {
			TransitionfeeService transitionfeeService = (TransitionfeeService) SpringContextUtil.getBean("TransitionfeeService");
			transitionfeeService.calcRecordTransitionfee(this.calcRecordTransitionfeeSectionRequestDTO);
		} catch (Exception e) {
			log.error(CommonsUtil.getStackTrace(e));
		}
	}
	public void setCalcRecordTransitionfeeSectionRequestDTO(
			CalcRecordTransitionfeeSectionRequestDTO calcRecordTransitionfeeSectionRequestDTO) {
		this.calcRecordTransitionfeeSectionRequestDTO = calcRecordTransitionfeeSectionRequestDTO;
	}
	
}
