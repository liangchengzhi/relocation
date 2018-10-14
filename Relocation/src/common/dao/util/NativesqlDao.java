package common.dao.util;

import java.util.List;

public interface NativesqlDao
{
	public List listBySql(String sql,Object c); //对象列表
	public Integer findIdBySql(String sql);     //指定记录的ID
	public int countBySql(String sql);          //记录数量
	public int executeSql(String sql);          //更新、插入、删除操作
	public List queryList(String sql);          //数组列表
}
