package com.zhongyu.service;

import com.zhongyu.bean.Example;

import java.util.List;

/**
 * Created by ZhongYu on 2017/3/8.
 */
public interface ExampleService {

    List<Example> listExample();

    int removeByPrimaryKey(Integer id);

    int save(Example record);

    int saveSelective(Example record);

    Example getByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Example record);

    int updateByPrimaryKey(Example record);

}
