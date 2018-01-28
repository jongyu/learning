package com.zhongyu.service;

import com.zhongyu.bean.Example;
import com.zhongyu.common.bean.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhongYu on 4/18/2017.
 */
public interface ExampleService {

    List<Example> examplePager(@Param("pager")Pager pager);

    Example getExample(Integer id);

    Integer saveExample(Example example);

    Integer updateExample(Example example);

    Integer removeExample(Integer id);

    Integer countExample();

}
