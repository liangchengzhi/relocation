package common.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.stereotype.Repository;
import common.domain.RecordTransitionfeeDtl;
@Repository("recordTransitionfeeDtlDAO")
public class RecordTransitionfeeDtlDAOImpl extends AbstractJpaDao<RecordTransitionfeeDtl> implements RecordTransitionfeeDtlDAO{
	
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { RecordTransitionfeeDtl.class }));

	@PersistenceContext(unitName = "relocation")
	private EntityManager entityManager;

	public RecordTransitionfeeDtlDAOImpl() {
		super();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	@Override
	public boolean canBeMerged(RecordTransitionfeeDtl o) {
		return true;
	}


}
