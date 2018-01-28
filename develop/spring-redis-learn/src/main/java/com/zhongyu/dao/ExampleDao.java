package com.zhongyu.dao;

import com.zhongyu.bean.Example;
import com.zhongyu.common.bean.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZhongYu on 4/18/2017.
 */
@Repository
public interface ExampleDao {

    List<Example> examplePager(@Param("pager") Pager pager);

    Example getExample(Integer id);

    Integer insertExample(Example example);

    Integer updateExample(Example example);

    Integer deleteExample(Integer id);

    Integer countExample();

}
