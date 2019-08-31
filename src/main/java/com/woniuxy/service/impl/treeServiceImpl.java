package com.woniuxy.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.woniuxy.dao.TreeMapper;
import com.woniuxy.service.ITreeService;
@Service
public class treeServiceImpl implements ITreeService {
	@Resource
	private TreeMapper mapper;

	@Override
	public List findAll() {
		return mapper.selectByExample(null);
	}

}
