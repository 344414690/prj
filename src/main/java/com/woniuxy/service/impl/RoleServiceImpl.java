package com.woniuxy.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniuxy.dao.RoleMapper;
import com.woniuxy.domain.Role;
import com.woniuxy.service.IRoleService;
@Service
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper roleMapper;
	@Override
	public void save(Role role) {
		roleMapper.insertSelective(role);
	}

	@Override
	public void update(Role role) {
		roleMapper.updateByPrimaryKey(role);
	}

	@Override
	public Role findOne(Integer rid) {
		return roleMapper.selectByPrimaryKey(rid);
	}

	@Override
	public List findAll() {
		return roleMapper.selectByExample(null);
	}

}
