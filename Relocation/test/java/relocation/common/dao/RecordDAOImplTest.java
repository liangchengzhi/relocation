package relocation.common.dao;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import relocation.BaseTest;
import common.dao.RecordDAO;
import common.domain.Record;
import common.util.JsonUtil;

/**
 * 拆迁记录单元测试
 * @author liangcz
 * @Date   2018年3月8日 下午9:05:08
 * @version 1.0
 */
public class RecordDAOImplTest extends BaseTest{
	@Autowired
	private RecordDAO recordDAO;
	@Test
	public void test_findRecordByPrimaryKey(){
		Record record = recordDAO.findRecordByPrimaryKey(64060);
		com.alibaba.fastjson.JSON.toJSONString(record);
	}
	@Test
	public void test_inquiryLastCalTime(){
		Integer recordId = null;
		Calendar cal = recordDAO.inquiryLastCalTime(recordId);
		System.out.println(JsonUtil.toJson(cal));
	}
	
}
