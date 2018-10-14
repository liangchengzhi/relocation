package com.vis.service;

import java.util.Calendar;
import java.util.List;

import common.domain.Project;
import common.domain.Record;
import common.domain.RecordReturn;
import common.domain.RecordTransitionfee;
import common.domain.RemovalRecord;

public interface MyRecordService {

	/**
	 * 最后一条拆迁记录
	 * 
	 * @return
	 */
	public Record lastRecord();

	/**
	 * 检测合同号记录是否存在
	 * 
	 * @param number
	 * @param id
	 *            除去指定ID的记录
	 * @return
	 */
	public boolean checkContractNumber(String number, Integer id);

	/**
	 * 查询拆迁记录
	 * 
	 * @param uid
	 * @param pid
	 * @param keyword
	 * @param status
	 * @param started
	 * @param ended
	 * @param offset
	 * @param ps
	 * @return
	 */
	public List<Record> listRecord(Integer uid, Integer pid, String keyword, Integer status, Integer replaceFlag,
			Boolean started, Boolean ended,Boolean pauseCalculateFee,Integer offset, Integer ps, Integer pendingState);

	public int countRecord(Integer uid, Integer pid, String keyword, Integer status, Integer replaceFlag,
			Boolean started, Boolean ended,Boolean pauseCalculateFee);

	public List<Record> listUnDealedRecord(Integer uid, Integer pid, String keyword, Integer status,
			Integer replaceFlag, Boolean started, Boolean ended, Integer offset, Integer ps);

	/**
	 * 根据项目名称查询项目
	 * 
	 * @param pname
	 * @param offset
	 * @param ps
	 * @return
	 */
	public List<Project> search(String pname, Integer offset, Integer ps);

	public Project findOrSaveProjectByName(String pname);

	/**
	 * 查询拆迁记录的过渡费流水账
	 * 
	 * @param keyword
	 * @param uid
	 * @param rid
	 * @param pname
	 * @param type
	 * @param isDealed
	 * @param year
	 * @param quarter
	 * @param offset
	 * @param ps
	 * @return
	 */
	public List<RecordTransitionfee> listTransitionfee(String keyword, Integer uid, Integer rid, String pname,
			String type, Boolean isDealed, Integer year,Integer quarter, String serviceDepartment, Integer offset, Integer ps);

	public int countTransitionfee(String keyword, Integer uid, Integer rid, String pname, String type, Boolean isDealed,
			Integer year, Integer quarter,String serviceDepartment);

	/**
	 * 获取指定拆迁记录的第一条过渡费
	 * 
	 * @param sid
	 * @return
	 */
	public RecordTransitionfee findFirstTransitionfee(Integer sid);

	/**
	 * 根据合同号查找
	 * 
	 * @param number
	 * @return
	 */
	public Record findByContractNumber(String number);

	/**
	 * 根据pid查找
	 * 
	 * @param pid
	 * @return
	 */
	public Record findByPid(Integer pid);

	/**
	 * 列出指定拆迁记录的 还房记录
	 * 
	 * @param sid
	 * @return
	 */
	public List<RecordReturn> listReturn(int sid);

	public abstract Long pendingRecordCount(String paramString);

	public abstract RemovalRecord initRemovalRecord();
	/**
	 *  查询ids 查询过渡费拆迁记录
	 * @param ids
	 * @return
	 */
	public List<RecordTransitionfee> findTransitionfeeByIds(String ids);

}
