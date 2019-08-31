package com.woniuxy.dao;

import com.woniuxy.domain.Zone;
import com.woniuxy.domain.ZoneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZoneMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int countByExample(ZoneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int deleteByExample(ZoneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int deleteByPrimaryKey(String zid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int insert(Zone record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int insertSelective(Zone record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	List<Zone> selectByExample(ZoneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	Zone selectByPrimaryKey(String zid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Zone record, @Param("example") ZoneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int updateByExample(@Param("record") Zone record, @Param("example") ZoneExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int updateByPrimaryKeySelective(Zone record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table zone
	 * @mbggenerated  Sun Aug 25 19:35:48 CST 2019
	 */
	int updateByPrimaryKey(Zone record);
}