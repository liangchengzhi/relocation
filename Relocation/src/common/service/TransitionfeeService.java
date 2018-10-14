package common.service;

import common.entity.service.CalcRecordTransitionfeeRequestDTO;
import common.entity.service.CalcRecordTransitionfeeSectionRequestDTO;
import common.util.JsonObj;

/**
 * 过渡费计算service
 * @author liangcz
 * @version 2016/10/04
 * @see TransitionfeeServiceImpl
 */
public interface TransitionfeeService {
	/**
	 * 计算过渡费
	 * @param requestDTO
	 * @return
	 */
	public JsonObj calcRecordTransitionfee(CalcRecordTransitionfeeRequestDTO requestDTO);
	/**
	 * 计算过渡费(使用多线程)
	 * @param calcRecordTransitionfeeSectionRequestDTO
	 */
	public void calcRecordTransitionfee(CalcRecordTransitionfeeSectionRequestDTO calcRecordTransitionfeeSectionRequestDTO);
}
