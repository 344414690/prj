package com.woniuxy.service;

import java.util.List;
import com.woniuxy.domain.PageBean;
import com.woniuxy.domain.Student;

public interface IStudentService {
	List findAll(PageBean pb);
	int delete(Integer stid);
	void deleteBatch(Integer[] stids);
	void save(Student student);
	Student findByID(Integer stid);
	void update(Student student);
}
