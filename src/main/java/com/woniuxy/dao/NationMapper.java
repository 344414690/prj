package com.woniuxy.dao;

import com.woniuxy.domain.Nation;
import com.woniuxy.domain.NationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NationMapper {
	List findByNation(String nation);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int countByExample(NationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int deleteByExample(NationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int insert(Nation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int insertSelective(Nation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    List<Nation> selectByExample(NationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    Nation selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int updateByExampleSelective(@Param("record") Nation record, @Param("example") NationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int updateByExample(@Param("record") Nation record, @Param("example") NationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int updateByPrimaryKeySelective(Nation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nation
     *
     * @mbggenerated Mon Aug 12 21:49:09 CST 2019
     */
    int updateByPrimaryKey(Nation record);
}