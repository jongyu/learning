package com.zhongyu.dao;

import com.zhongyu.bean.Example;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhongYu on 3/31/2017.
 */
public interface ExampleDao {

    List<Example> list();

    Example get(Integer id);

    Serializable insert(Example example);

    void update(Example example);

    boolean delete(Example example);

}
