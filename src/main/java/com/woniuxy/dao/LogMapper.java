package com.woniuxy.dao;

import com.woniuxy.domain.Log;
import com.woniuxy.domain.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
public interface LogMapper {
    long countByExample(LogExample example);

    int deleteByExample(LogExample example);

    int deleteByPrimaryKey(Integer logid);

    int insert(Log record);

    int insertSelective(Log record);

//    List<Log> selectByExample(LogExample example);
    // 自定义分页
    List<Log> selectByExample(LogExample example,RowBounds rowBounds);

    Log selectByPrimaryKey(Integer logid);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}