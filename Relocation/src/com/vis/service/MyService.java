package com.vis.service;

import java.util.List;

import common.domain.Authority;

public interface MyService {
	
	/**
	 * 列出有效的权限组
	 * @return
	 */
	public List<Authority> listAuthority();
}
