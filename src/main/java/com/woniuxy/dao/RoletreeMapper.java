package com.woniuxy.dao;

import com.woniuxy.domain.RoletreeExample;
import com.woniuxy.domain.RoletreeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoletreeMapper {
    long countByExample(RoletreeExample example);

    int deleteByExample(RoletreeExample example);

    int deleteByPrimaryKey(RoletreeKey key);

    int insert(RoletreeKey record);

    int insertSelective(RoletreeKey record);

    List<RoletreeKey> selectByExample(RoletreeExample example);

    int updateByExampleSelective(@Param("record") RoletreeKey record, @Param("example") RoletreeExample example);

    int updateByExample(@Param("record") RoletreeKey record, @Param("example") RoletreeExample example);
}