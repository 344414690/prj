package com.woniuxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniuxy.dao.ProvinceMapper;
import com.woniuxy.service.IProvinceService;

@Service
public class ProvinceServiceImpl implements IProvinceService {
	@Resource
	private ProvinceMapper provinceMapper;
	@Override
	public List findAll() {
		return provinceMapper.selectByExample(null);
	}

}
