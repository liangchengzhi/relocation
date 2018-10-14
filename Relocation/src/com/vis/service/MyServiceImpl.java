package com.vis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import common.dao.AuthorityDAO;
import common.dao.UserOperateLogDAO;
import common.domain.Authority;
import common.domain.UserOperateLog;

@Service("MyService")
public class MyServiceImpl implements MyService{
	@Autowired
	AuthorityDAO authorityDAO;
	
	@Autowired
	UserOperateLogDAO userOperateLogDAO;
	
	@Override
	public List<Authority> listAuthority() {
		String hql = "from Authority t where (t.isDeleted is null or t.isDeleted!=true)";
		return authorityDAO.executeQuery(hql);
	}
	
}
