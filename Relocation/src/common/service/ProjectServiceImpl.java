package common.service;

import common.dao.ProjectDAO;
import common.dao.RecordDAO;

import common.domain.Project;
import common.domain.Record;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Project entities
 * 
 */

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Record entities
	 * 
	 */
	@Autowired
	private RecordDAO recordDAO;

	/**
	 * Instantiates a new ProjectServiceImpl.
	 *
	 */
	public ProjectServiceImpl() {
	}

	/**
	 * Return a count of all Project entity
	 * 
	 */
	public Integer countProjects() {
		return ((Long) projectDAO.createQuerySingleResult("select count(o) from Project o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Record entity
	 * 
	 */
	public Project saveProjectRecords(Integer id, Record related_records) {
		Project project = projectDAO.findProjectByPrimaryKey(id, -1, -1);
		Record existingrecords = recordDAO.findRecordByPrimaryKey(related_records.getId());

		// copy into the existing record to preserve existing relationships
		if (existingrecords != null) {
			existingrecords.setId(related_records.getId());
			existingrecords.setProjectName(related_records.getProjectName());
			existingrecords.setUsername(related_records.getUsername());
			existingrecords.setUsercontact(related_records.getUsercontact());
			existingrecords.setUseraddress(related_records.getUseraddress());
			existingrecords.setUseridcard(related_records.getUseridcard());
			existingrecords.setContractNumber(related_records.getContractNumber());
			existingrecords.setRecordNumber(related_records.getRecordNumber());
			existingrecords.setCoveredArea(related_records.getCoveredArea());
			existingrecords.setCoveredAreaBack(related_records.getCoveredAreaBack());
			existingrecords.setHouseArea(related_records.getHouseArea());
			existingrecords.setHouseAreaBack(related_records.getHouseAreaBack());
			existingrecords.setHouseAreaBackRoom(related_records.getHouseAreaBackRoom());
			existingrecords.setBusinessArea(related_records.getBusinessArea());
			existingrecords.setBusinessAreaBack(related_records.getBusinessAreaBack());
			existingrecords.setBusinessAreaBackRoom(related_records.getBusinessAreaBackRoom());
			existingrecords.setProductionArea(related_records.getProductionArea());
			existingrecords.setProductionAreaBack(related_records.getProductionAreaBack());
			existingrecords.setProductionAreaBackRoom(related_records.getProductionAreaBackRoom());
			existingrecords.setBalance1(related_records.getBalance1());
			existingrecords.setBalance2(related_records.getBalance2());
			existingrecords.setSelfRemoveArea(related_records.getSelfRemoveArea());
			existingrecords.setSelfSimplyArea(related_records.getSelfSimplyArea());
			existingrecords.setSelfRemoveAmount(related_records.getSelfRemoveAmount());
			existingrecords.setRemark(related_records.getRemark());
			existingrecords.setCreatedTime(related_records.getCreatedTime());
			existingrecords.setLastEditTime(related_records.getLastEditTime());
			existingrecords.setDeletedTime(related_records.getDeletedTime());
			existingrecords.setIsDeleted(related_records.getIsDeleted());
			related_records = existingrecords;
		} else {
			related_records = recordDAO.store(related_records);
			recordDAO.flush();
		}

		related_records.setProject(project);
		project.getRecords().add(related_records);
		related_records = recordDAO.store(related_records);
		recordDAO.flush();

		project = projectDAO.store(project);
		projectDAO.flush();

		return project;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	public void saveProject(Project project) {
		Project existingProject = projectDAO.findProjectByPrimaryKey(project.getId());

		if (existingProject != null) {
			if (existingProject != project) {
				existingProject.setId(project.getId());
				existingProject.setName(project.getName());
				existingProject.setIsDeleted(project.getIsDeleted());
			}
			project = projectDAO.store(existingProject);
		} else {
			project = projectDAO.store(project);
		}
		projectDAO.flush();
	}

	/**
	 * Return all Project entity
	 * 
	 */
	public List<Project> findAllProjects(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Project>(projectDAO.findAllProjects(startResult, maxRows));
	}

	/**
	 * Load an existing Project entity
	 * 
	 */
	public Set<Project> loadProjects() {
		return projectDAO.findAllProjects();
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public void deleteProject(Project project) {
		projectDAO.remove(project);
		projectDAO.flush();
	}

	/**
	 */
	public Project findProjectByPrimaryKey(Integer id) {
		return projectDAO.findProjectByPrimaryKey(id);
	}

	/**
	 * Delete an existing Record entity
	 * 
	 */
	public Project deleteProjectRecords(Integer project_id, Integer related_records_id) {
		Record related_records = recordDAO.findRecordByPrimaryKey(related_records_id, -1, -1);

		Project project = projectDAO.findProjectByPrimaryKey(project_id, -1, -1);

		related_records.setProject(null);
		project.getRecords().remove(related_records);

		recordDAO.remove(related_records);
		recordDAO.flush();

		return project;
	}
}
