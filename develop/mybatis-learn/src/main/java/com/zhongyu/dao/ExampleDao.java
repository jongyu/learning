package com.zhongyu.dao;

import com.zhongyu.bean.Example;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExampleDao {

    List<Example> listExample();

    int deleteByPrimaryKey(Integer id);

    int insert(Example record);

    int insertSelective(Example record);

    Example selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Example record);

    int updateByPrimaryKey(Example record);

}