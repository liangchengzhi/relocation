package com.vis.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.ProjectDAO;
import common.dao.RecordDAO;
import common.dao.RecordReturnDAO;
import common.dao.RecordTransitionfeeDAO;
import common.dao.util.NativesqlDao;
import common.domain.Project;
import common.domain.Record;
import common.domain.RecordReturn;
import common.domain.RecordTransitionfee;
import common.domain.RemovalRecord;

@Service("MyRecordService")
public class MyRecordServiceImpl implements MyRecordService {
	@Autowired
	NativesqlDao nativesqlDao;
	@Autowired
	RecordDAO recordDAO;
	@Autowired
	ProjectDAO projectDAO;
	@Autowired
	RecordTransitionfeeDAO transitionfeeDAO;
	@Autowired
	RecordReturnDAO returnDAO;

	public Record lastRecord() {
		String hql = "from Record t where (t.isDeleted is null or t.isDeleted=false)";
		hql += " order by t.id desc";
		List<Record> list = recordDAO.executeQuery(hql, 0, 1);
		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	public boolean checkContractNumber(String number, Integer id) {
		String hql = "select count(t.id) from Record t where (t.isDeleted is null or t.isDeleted=false)";
		if (id != null)
			hql += " and t.id !=" + id;
		hql += " and t.contractNumber = ?1";
		Query query = null;
		query = recordDAO.createQuerySingleResult(hql, number);

		return ((Long) query.getSingleResult()).intValue() == 0 ? false : true;
	}

	@Override
	public List<Record> listRecord(Integer uid, Integer pid, String keyword, Integer status, Integer replaceFlag,
			Boolean started, Boolean ended, Boolean pauseCalculateFee, Integer offset, Integer ps, Integer pendingState) {
		String hql = "from Record t where (t.isDeleted is null or t.isDeleted=false)";
		if (uid != null) {
			hql += " and t.cuser.id=" + uid;
		}
		if (pid != null) {
			hql += " and t.project.id=" + pid;
		}
		if (replaceFlag != null) {
			hql += " and t.replaceFlag=" + replaceFlag;
		}
		if (started != null && started == true) {
			hql += " and (t.isStart is not null and t.isStart=true)";
		} else if (started != null && started == false) {
			hql += " and (t.isStart is null or t.isStart!=true)";
		}
		if (ended != null && ended == true) {
			hql += " and (t.isEnd is not null and t.isEnd=true)";
		} else if (ended != null && ended == false) {
			hql += " and (t.isEnd is null or t.isEnd!=true)";
		}
		if (pauseCalculateFee != null && pauseCalculateFee == true) {
			hql += " and (t.pauseCalculateFee is not null and t.pauseCalculateFee=true)";
		} else if (pauseCalculateFee != null && pauseCalculateFee == false) {
			hql += " and (t.pauseCalculateFee is null or t.pauseCalculateFee!=true)";
		}
		if (status != null) {
			if (status == 1) {
				hql += " and t.startTime>now()";
			} else if (status == 2) {
				hql += " and t.startTime<now() and t.endTime>now()";
			} else if (status == 3) {
				hql += " and (t.endTime is null or t.endTime<now())";
			}
		}
		if (pendingState != null) {
			hql += " and t.pendingState=" + pendingState;
		}
		if (keyword != null && !keyword.equals("")) {
			hql += " and (t.username like ?1 or t.projectName like ?2 or t.contractNumber like ?3 or t.recordNumber like ?4)";
		}
		hql += " order by t.id desc";

		List<Record> list = null;
		if (keyword != null && !keyword.equals("")) {
			list = recordDAO.executeQuery(hql, offset, ps, "%" + keyword + "%", "%" + keyword + "%",
					"%" + keyword + "%", "%" + keyword + "%");
		} else {
			list = recordDAO.executeQuery(hql, offset, ps);
		}
		return list;
	}

	@Override
	public List<Record> listUnDealedRecord(Integer uid, Integer pid, String keyword, Integer status,
			Integer replaceFlag, Boolean started, Boolean ended, Integer offset, Integer ps) {
		
		String hql = "from Record t where (t.isDeleted is null or t.isDeleted=false and (t.pauseCalculateFee is null or t.pauseCalculateFee=false)) ";
		// String hql = "from Record t where 1=1 and t.username = '吕洞仙' and (t.isDeleted is null or t.isDeleted=false) and (t.isDealed is null or t.isDealed=false)";
		
		/* 查询一个月外计算的数据 */
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = sdf.format(c.getTime());
		hql += " and (t.lastComputeTime is null or "+ dateStr + " >= DATE_FORMAT(t.lastComputeTime,'%Y%m%d')) ";
		hql += " and (t.isEnd is null or t.isEnd!=true)";
		if (uid != null) {
			hql += " and t.cuser.id=" + uid;
		}
		if (pid != null) {
			hql += " and t.project.id=" + pid;
		}
		if (replaceFlag != null) {
			hql += " and t.replaceFlag=" + replaceFlag;
		}
		if (started != null && started == true) {
			hql += " and (t.isStart is not null and t.isStart=true)";
		} else if (started != null && started == false) {
			hql += " and (t.isStart is null or t.isStart!=true)";
		}
		if (status != null) {
			if (status == 1) {
				hql += " and t.startTime>now()";
			} else if (status == 2) {
				hql += " and t.startTime<now() and t.endTime>now()";
			} else if (status == 3) {
				hql += " and (t.endTime is null or t.endTime<now())";
			}
		}

		if (keyword != null && !keyword.equals("")) {
			hql += " and (t.username like ?1 or t.projectName like ?2 or t.contractNumber like ?3 or t.recordNumber like ?4)";
		}
		hql += " order by t.id desc";

		List<Record> list = null;
		if (keyword != null && !keyword.equals("")) {
			list = recordDAO.executeQuery(hql, offset, ps, "%" + keyword + "%", "%" + keyword + "%",
					"%" + keyword + "%", "%" + keyword + "%");
		} else {
			list = recordDAO.executeQuery(hql, offset, ps);
		}
		return list;
	}

	@Override
	public int countRecord(Integer uid, Integer pid, String keyword, Integer status, Integer replaceFlag,
			Boolean started, Boolean ended,Boolean pauseCalculateFee) {
		String hql = "select count(t.id) from Record t where (t.isDeleted is null or t.isDeleted=false)";
		if (uid != null) {
			hql += " and t.cuser.id=" + uid;
		}
		if (pid != null) {
			hql += " and t.project.id=" + pid;
		}
		if (replaceFlag != null) {
			hql += " and t.replaceFlag=" + replaceFlag;
		}
		if (started != null && started == true) {
			hql += " and (t.isStart is not null and t.isStart=true)";
		} else if (started != null && started == false) {
			hql += " and (t.isStart is null or t.isStart!=true)";
		}
		if (ended != null && ended == true) {
			hql += " and (t.isEnd is not null and t.isEnd=true)";
		} else if (ended != null && ended == false) {
			hql += " and (t.isEnd is null or t.isEnd!=true)";
		}
		if (pauseCalculateFee != null && pauseCalculateFee == true) {
			hql += " and (t.pauseCalculateFee is not null and t.pauseCalculateFee=true)";
		} else if (pauseCalculateFee != null && pauseCalculateFee == false) {
			hql += " and (t.pauseCalculateFee is null or t.pauseCalculateFee!=true)";
		}
		
		if (status != null) {
			if (status == 1) {
				hql += " and t.startTime>now()";
			} else if (status == 2) {
				hql += " and t.startTime<now() and t.endTime>now()";
			} else if (status == 3) {
				hql += " and (t.endTime is null or t.endTime<now())";
			}
		}

		if (keyword != null && !keyword.equals("")) {
			hql += " and (t.username like ?1 or t.projectName like ?2 or t.contractNumber like ?3 or t.recordNumber like ?4)";
		}
		Query query = null;
		if (keyword != null && !keyword.equals("")) {
			query = recordDAO.createQuerySingleResult(hql, "%" + keyword + "%", "%" + keyword + "%",
					"%" + keyword + "%", "%" + keyword + "%");
		} else {
			query = recordDAO.createQuerySingleResult(hql);
		}

		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public List<Project> search(String pname, Integer offset, Integer ps) {
		String hql = "from Project t where (t.isDeleted is null or t.isDeleted=false)";
		hql += " and t.name like ?1 order by CHAR_LENGTH(t.name)";

		List<Project> list = projectDAO.executeQuery(hql, offset, ps, "%" + pname + "%");
		return list;
	}

	@Override
	public Project findOrSaveProjectByName(String pname) {
		String hql = "from Project t where (t.isDeleted is null or t.isDeleted=false)";
		hql += " and t.name = ?1";
		List<Project> executeQuery = projectDAO.executeQuery(hql, 0, 1, pname);
		if (executeQuery == null || executeQuery.size() == 0) {
			Project project = new Project();
			project.setName(pname);
			project.setIsDeleted(false);
			return projectDAO.store(project);
		}
		return executeQuery.get(0);
	}

	@Override
	public List<RecordTransitionfee> listTransitionfee(String keyword, Integer uid, Integer rid, String pname,
			String type, Boolean isDealed, Integer year, Integer quarter,String serviceDepartment, Integer offset, Integer ps) {
		String hql = "from RecordTransitionfee t where (t.isDeleted is null or t.isDeleted=false)";
		if (uid != null) {
			hql += " and t.record.cuser.id=" + uid;
		}
		if (rid != null) {
			hql += " and t.record.id=" + rid;
		}
		if (pname != null && !pname.equals("")) {
			hql += " and t.record.projectName='" + pname + "'";
		}
		if (type != null && !type.equals("")) {
			hql += " and t.type='" + type + "'";
		}
		if (isDealed != null) {
			hql += " and t.isDealed=" + isDealed;
		}
		if (year != null) {
			hql += " and t.year=" + year;
		}
		if (quarter != null) {
			hql += " and t.quarter=" + quarter;
		}
		if (org.apache.commons.lang3.StringUtils.isNotBlank(serviceDepartment)) {
			hql += " and t.record.serviceDepartment=" + serviceDepartment;
		}
		if (keyword != null && !keyword.equals("")) {
			hql += " and (t.record.username like ?1 or t.record.contractNumber like ?2)";
		}
		hql += " order by t.record.project.id,cast(t.record.recordNumber as int) asc ,t.record.recordNumber asc,t.isDealed asc,t.id desc, t.year desc, t.quarter desc";
		List<RecordTransitionfee> list = null;
		if (keyword != null && !keyword.equals("")) {
			list = transitionfeeDAO.executeQuery(hql, offset, ps, "%" + keyword + "%", "%" + keyword + "%");
		} else {
			list = transitionfeeDAO.executeQuery(hql, offset, ps);
		}

		return list;
	}
	
	/**
	 *  根据id查询对应的过渡费记录
	 * @param ids
	 * @return
	 */
	public List<RecordTransitionfee> findTransitionfeeByIds(String ids){
		String hql = "from RecordTransitionfee t where 1=1 and (t.isDeleted is null or t.isDeleted=false) ";
		hql += " and t.id in (" + ids + ") ";
		hql += " order by t.record.project.id,cast(t.record.recordNumber as int) asc ,t.record.recordNumber asc";
		List<RecordTransitionfee> list = transitionfeeDAO.executeQuery(hql);
		return list;
	}
	@Override
	public int countTransitionfee(String keyword, Integer uid, Integer rid, String pname, String type, Boolean isDealed,
			Integer year, Integer quarter,String serviceDepartment) {
		String hql = "select count(t.id) from RecordTransitionfee t where (t.isDeleted is null or t.isDeleted=false)";
		if (uid != null) {
			hql += " and t.record.cuser.id=" + uid;
		}
		if (rid != null) {
			hql += " and t.record.id=" + rid;
		}
		if (pname != null && !pname.equals("")) {
			hql += " and t.record.projectName='" + pname + "'";
		}
		if (type != null && !type.equals("")) {
			hql += " and t.type='" + type + "'";
		}
		if (isDealed != null) {
			hql += " and t.isDealed=" + isDealed;
		}
		if (year != null) {
			hql += " and t.year=" + year;
		}
		if (quarter != null) {
			hql += " and t.quarter=" + quarter;
		}
		if (org.apache.commons.lang3.StringUtils.isNotBlank(serviceDepartment)) {
			hql += " and t.record.serviceDepartment=" + serviceDepartment;
		}
		Query query = null;
		if (keyword != null && !keyword.equals("")) {
			hql += " and (t.record.username like ?1 or t.record.contractNumber like ?2)";
			query = transitionfeeDAO.createQuerySingleResult(hql, "%" + keyword + "%", "%" + keyword + "%");
		} else {
			query = transitionfeeDAO.createQuerySingleResult(hql);
		}

		return ((Long) query.getSingleResult()).intValue();
	}

	@Override
	public Record findByContractNumber(String number) {
		String hql = "from Record t where (t.isDeleted is null or t.isDeleted=false)";
		hql += " and t.contractNumber = ?1";
		List<Record> list = recordDAO.executeQuery(hql, 0, 1, number);
		return list == null || list.size() == 0 ? null : list.get(0);
	}

	@Override
	public Record findByPid(Integer pid) {
		String hql = "from Record t where (t.isDeleted is null or t.isDeleted=false)";
		hql += " and t.project.id = ?1";
		List<Record> list = recordDAO.executeQuery(hql, 0, 1, pid);
		return list == null || list.size() == 0 ? null : list.get(0);
	}

	@Override
	public RecordTransitionfee findFirstTransitionfee(Integer sid) {
		String hql = "from RecordTransitionfee t where (t.isDeleted is null or t.isDeleted=false)";
		hql += " and t.record.id=" + sid;
		hql += " order by t.year asc, t.quarter asc";

		List<RecordTransitionfee> list = transitionfeeDAO.executeQuery(hql, 0, 1);

		if (list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public List<RecordReturn> listReturn(int sid) {
		String hql = "from RecordReturn t where (t.isDeleted is null or t.isDeleted = false)";
		hql += " and t.sid = ?1";
		hql += " order by id desc";
		return returnDAO.executeQuery(hql, 0, 1000, sid);
	}

	@Override
	public Long pendingRecordCount(String status) {
		String hql = "select count(t.id) from Record t where (t.isDeleted is null or t.isDeleted=false) and (t.pendingState = "
				+ status + ")";
		return (Long) this.recordDAO.createQuerySingleResult(hql, new Object[0]).getSingleResult();
	}

	@Override
	public RemovalRecord initRemovalRecord() {
		StringBuffer sql1 = new StringBuffer(
				"select count(t.contract_number),COALESCE(sum(t.house_area),0), COALESCE(sum(t.business_area),0),COALESCE(sum(t.other_area),0), COALESCE(sum(t.transport_fee),0), COALESCE(sum(t.transition_fee),0), COALESCE(sum(t.moving_fee),0), COALESCE(sum(t.discontinued_fee),0), COALESCE(sum(t.award_fee),0), COALESCE(sum(t.other_fee),0) from record t where (t.is_dealed is null or t.is_dealed=0) and t.pending_state=0 and is_start=1  ");

		List queryList1 = this.nativesqlDao.queryList(sql1.toString());
		StringBuffer sql2 = new StringBuffer(
				"select count(t.contract_number),COALESCE(sum(t.house_area_back),0), COALESCE(sum(t.business_area_back),0) from record t where (t.is_dealed is null or t.is_dealed=0) and t.pending_state=0 and is_end=1");

		List queryList2 = this.nativesqlDao.queryList(sql2.toString());
		RemovalRecord removalRecord = null;
		if ((queryList1 != null) && (queryList1.size() > 0)) {
			Object[] objects1 = (Object[]) queryList1.get(0);
			if (removalRecord == null) {
				removalRecord = new RemovalRecord();
			}
			removalRecord.setRemovalUserCount(objects1[0].toString());
			removalRecord.setRemovalHouseAreaSum(objects1[1].toString());
			removalRecord.setRemovalBusinessAreaSum(objects1[2].toString());
			removalRecord.setRemovalOtherAreaSum(objects1[3].toString());
			removalRecord.setTransportFreeSum(objects1[4].toString());
			removalRecord.setTranstitionFreeSum(objects1[5].toString());
			removalRecord.setMovingFreeSum(objects1[6].toString());
			removalRecord.setDiscontinuedFreeSum(objects1[7].toString());
			removalRecord.setAwardFreeSum(objects1[8].toString());
			removalRecord.setOtherFreeSum(objects1[9].toString());
		}

		if ((queryList2 != null) && (queryList2.size() > 0)) {
			Object[] objects2 = (Object[]) queryList2.get(0);
			if (removalRecord == null) {
				removalRecord = new RemovalRecord();
			}
			removalRecord.setRemovalBackUserCount(objects2[0].toString());
			removalRecord.setRemovalHouseAreaBackSum(objects2[1].toString());
			removalRecord.setRemovalBusinessAreaBackSum(objects2[2].toString());
		}

		return removalRecord;
	}
}
