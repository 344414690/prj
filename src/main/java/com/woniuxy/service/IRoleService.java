package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Role;

public interface IRoleService {
	void save(Role role);
	void update(Role role);
	Role findOne(Integer rid);
	List findAll();
}
