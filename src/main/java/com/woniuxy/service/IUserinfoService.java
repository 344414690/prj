package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Userinfo;

public interface IUserinfoService {
	Userinfo login(Userinfo Userinfo);
	List findAll();
	void save(Userinfo userinfo,Integer[] chk);
	void delete(Integer uid);
	void revoke(Integer uid);
	
	Userinfo findById(Integer uid);
	void update(Userinfo info,Integer[] chk);
}
