package common.dao.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("NativesqlDao")
public class NativesqlDaoImpl implements NativesqlDao{
	
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;
	
	@Override
	public List listBySql(String sql,Object c) {
		return entityManager.createNativeQuery(sql, c.getClass()).getResultList();
	}

	@Override
	public int countBySql(String sql) {
		List list = entityManager.createNativeQuery(sql).getResultList();
		if(list==null||list.size()==0||list.get(0)==null) return 0;
		return ((Number)list.get(0)).intValue();
	}
	
	@Override
	public int executeSql(String sql){
		return entityManager.createNativeQuery(sql).executeUpdate();
	}
	
	@Override
	public Integer findIdBySql(String sql){
		List list = entityManager.createNativeQuery(sql).getResultList();
		if(list==null||list.size()==0) return null;
		return ((Number)entityManager.createNativeQuery(sql).getResultList().get(0)).intValue();
	}
	
	public List queryList(String sql){
		return entityManager.createNativeQuery(sql).getResultList();
	}
}
