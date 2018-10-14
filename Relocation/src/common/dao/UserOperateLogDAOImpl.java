package common.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.domain.UserOperateLog;

@Repository("userOperateLogDAO")
public class UserOperateLogDAOImpl extends AbstractJpaDao<UserOperateLog> implements UserOperateLogDAO {
	
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { UserOperateLog.class }));
	
	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@Override
	public boolean canBeMerged(UserOperateLog o) {
		return true;
	}

	
}
