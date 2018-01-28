package com.zhongyu.service.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.service.ExampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ZhongYu on 3/31/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ExampleServiceImplTest {

    @Autowired
    private ExampleService exampleService;

    @Test
    public void list() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
        Example example = new Example();
        example.setId(13);
        boolean result = exampleService.delete(example);
        System.out.println(result);
    }

}