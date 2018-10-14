package relocation.common.dao;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import relocation.BaseTest;
import common.dao.RecordTransitionfeeDAO;
import common.util.JsonUtil;

/**
 * 过渡费计算dao
 * @author liangcz
 * @Date   2018年3月9日 下午3:55:19
 * @version 1.0
 */
public class RecordTransitionfeeDAOTest extends BaseTest{
	@Autowired
	private RecordTransitionfeeDAO recordTransitionfeeDAO;
	
	@Test
	public void test_inquiryLastComputeTime(){
		Integer recordId = 64060;
		Calendar  cal = recordTransitionfeeDAO.inquiryLastRecordFeeTime(recordId);
		System.out.println(JsonUtil.toJson(cal));
	}
}
