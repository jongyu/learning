package com.zhongyu.dao.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.dao.ExampleDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by ZhongYu on 3/29/2017.
 */
public class ExampleDaoImplTest {

    private ExampleDao dao;

    public ExampleDaoImplTest() {
        dao = new ExampleDaoImpl();
    }

    @Test
    public void insert() throws Exception {
        Example example = new Example();
        example.setName("奥巴马");
        example.setAge(12);
        example.setBirthday(new Date());
        boolean result =  dao.insert(example);
        Assert.assertTrue(result);
    }

}