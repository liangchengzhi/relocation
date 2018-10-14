package common.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import common.domain.Cuser;
import common.domain.Record;
import common.domain.RecordTransitionfee;
import common.util.JsonObj;

public interface AdminService {
	
	/**
	 * 保存拆迁记录
	 * @param entity
	 * @param cuser
	 * @return
	 */
	JsonObj saveRecord(Record entity, Cuser cuser);
	
	/**
	 *  导入还房数据
	 * @param path
	 * @param source
	 * @param cuser
	 */
	JsonObj importRecord(String path, String source, Cuser cuser);

	/**
	 * 还房信息导入
	 * @param path
	 * @param source
	 * @param cuser
	 * @return
	 */
	JsonObj importReturnArea(String path, String source, Cuser cuser);
	
	/**
	 * 创建过渡费excel 文件
	 * @param list
	 * @param request
	 * @param nickname
	 * @param year
	 * @param quarter
	 * @param pname
	 * @param feetype
	 * @param dealed
	 * @return
	 * @throws IOException
	 */
	public HSSFWorkbook createTransitionfeeExportExcel(List<RecordTransitionfee> list,String source,
			String nickname,Integer year,Integer quarter,String pname,String feetype,Boolean dealed) throws IOException;

}
