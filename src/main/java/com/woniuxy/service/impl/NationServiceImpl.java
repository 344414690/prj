package com.woniuxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniuxy.dao.NationMapper;
import com.woniuxy.service.INationService;

@Service
public class NationServiceImpl implements INationService {
	@Resource
	private NationMapper NationMapper;
	
	@Override
	public List findByNation(String nation) {
		return NationMapper.findByNation(nation);
	}

}
