package com.woniuxy.dao;

import com.woniuxy.domain.Tree;
import com.woniuxy.domain.TreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreeMapper {
    long countByExample(TreeExample example);

    int deleteByExample(TreeExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Tree record);

    int insertSelective(Tree record);

    List<Tree> selectByExample(TreeExample example);

    Tree selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeExample example);

    int updateByExample(@Param("record") Tree record, @Param("example") TreeExample example);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
}