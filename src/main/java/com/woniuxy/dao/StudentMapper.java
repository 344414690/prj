package com.woniuxy.dao;

import com.woniuxy.domain.Student;
import com.woniuxy.domain.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StudentMapper {
	void deleteBatch(Integer[] stids);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int countByExample(StudentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int deleteByExample(StudentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int deleteByPrimaryKey(Integer stid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int insert(Student record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int insertSelective(Student record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	List<Student> selectByExample(StudentExample example,RowBounds rowBounds);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	Student selectByPrimaryKey(Integer stid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int updateByPrimaryKeySelective(Student record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table student
	 * @mbggenerated  Sun Aug 25 21:53:47 CST 2019
	 */
	int updateByPrimaryKey(Student record);
}