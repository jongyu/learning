package com.zhongyu.dao.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.dao.ExampleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZhongYu on 3/31/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ExampleDaoImplTest {

    @Autowired
    private ExampleDao exampleDao;

    @Test
    public void insert() throws Exception {
        Example example = new Example();
        example.setName("张三丰");
        example.setAge(100);
        example.setSex("男");
        example.setBirthday(new Date());
        Serializable result = exampleDao.insert(example);
        System.out.println(result);
    }

}