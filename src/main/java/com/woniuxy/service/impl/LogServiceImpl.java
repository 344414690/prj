package com.woniuxy.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import com.woniuxy.dao.LogMapper;
import com.woniuxy.domain.Log;
import com.woniuxy.domain.LogExample;
import com.woniuxy.domain.LogExample.Criteria;
import com.woniuxy.domain.PageBean;
import com.woniuxy.service.ILogService;

@Service
public class LogServiceImpl implements ILogService {
	@Resource
	private LogMapper logMapper;
	
	public List findAll(Log log,PageBean pb) {
		// 创建查询条件
		LogExample example = new LogExample();
		Criteria c = example.createCriteria();
		//并且判断
		if(log.getUname()!=null && !log.getUname().equals("")) {
			// 通过uname查询结果
			c.andUnameEqualTo(log.getUname());
		}
		if(log.getAction()!= null && !log.getAction().equals("")) {
			// 通过action查询结果
			c.andActionEqualTo(log.getAction());
		}
		// 获取到日志分页数据，显示到前台页面
		List list = logMapper.selectByExample(example, new RowBounds(pb.getOffset(),pb.getLimit()));
		// 获取log中数据的总记录数
		int count = (int) logMapper.countByExample(example);
		// 并且把找到的总记录数放到pageBean中
		pb.setCount(count);
		return list;
	}

}
