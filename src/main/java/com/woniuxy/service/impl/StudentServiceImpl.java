package com.woniuxy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniuxy.dao.StudentMapper;
import com.woniuxy.domain.PageBean;
import com.woniuxy.domain.Student;
import com.woniuxy.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Resource
	private StudentMapper studentMapper;
	
	@Override
	public List findAll(PageBean pb) {
		List list = studentMapper.selectByExample(null,new RowBounds(pb.getOffset(), pb.getLimit()));
		int count  = studentMapper.countByExample(null);
		pb.setCount(count);
		return list;
	}
	@Override
	public int delete(Integer stid) {
		return studentMapper.deleteByPrimaryKey(stid);
	}
	@Override
	public void deleteBatch(Integer[] stids) {
		studentMapper.deleteBatch(stids);
	}
	@Override
	public void save(Student student) {
		studentMapper.insert(student);
	}
	@Override
	public Student findByID(Integer stid) {
		return studentMapper.selectByPrimaryKey(stid);
	}
	@Override
	public void update(Student student) {
		studentMapper.updateByPrimaryKey(student);
	}

}
