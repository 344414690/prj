package com.woniuxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniuxy.dao.UserinfoMapper;
import com.woniuxy.dao.UserinforoleMapper;
import com.woniuxy.domain.Userinfo;
import com.woniuxy.domain.UserinforoleExample;
import com.woniuxy.domain.UserinforoleKey;
import com.woniuxy.service.IUserinfoService;

@Service
public class UserinfoServiceImpl implements IUserinfoService {
	// 获取用户
	@Resource
	private UserinfoMapper userMapper;
	//获取用户的角色
	@Resource
	private UserinforoleMapper UserinforoleMapper;
	@Override
	public Userinfo login(Userinfo info) {
		return userMapper.login(info);
	}
	// 查找所有用户信息
	@Override
	@Transactional(readOnly = true)
	public List findAll() {
		return userMapper.selectByExample(null);
	}

	@Override
	@Transactional
	public void save(Userinfo userinfo,Integer[] chk) {
		// 为userinfo中插入数据
		userMapper.insert(userinfo);
		// 为userinforole中插数据
		if(chk != null) {
			for (Integer rid : chk) {
				// 创建key的实例
				UserinforoleKey key = new UserinforoleKey();
				// 把uid放到key实体里
				key.setUid(userinfo.getUid());
				// 把rid放到key的实体里
				key.setRid(rid);
				// 为UserinfoRole表里面插入数据
				UserinforoleMapper.insert(key);
			}
		}
	}

	// 删除用户
	@Override
	public void delete(Integer uid) {
		Userinfo in = new Userinfo();
		in.setUid(uid);
		in.setIsdelete(true);
		userMapper.updateByPrimaryKeySelective(in);
	}
	// 恢复用户
	@Override
	public void revoke(Integer uid) {
		Userinfo in = new Userinfo();
		in.setUid(uid);
		in.setIsdelete(false);
		userMapper.updateByPrimaryKeySelective(in);
	}
	// 查找一个用户
	@Override
	public Userinfo findById(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}
	// 修改用户表，先修改用户的信息，再把用户的所有权限删除，再增加用户的权限
	@Override
	public void update(Userinfo info,Integer[] chk) {
		// 修改用户信息
		userMapper.updateByPrimaryKeySelective(info);
		// 删除对应用户的所有角色
		UserinforoleExample example = new UserinforoleExample();
		example.createCriteria().andUidEqualTo(info.getUid());
		UserinforoleMapper.deleteByExample(example);
		// 在增加对应的信息
		if(chk != null) {
			for (Integer rid : chk) {
				// 创建key的实例
				UserinforoleKey key = new UserinforoleKey();
				// 把uid放到key实体里
				key.setUid(info.getUid());
				// 把rid放到key的实体里
				key.setRid(rid);
				// 为UserinfoRole表里面插入数据
				UserinforoleMapper.insert(key);
			}
		}
	}
}
