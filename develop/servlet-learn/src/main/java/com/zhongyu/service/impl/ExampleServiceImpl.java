package com.zhongyu.service.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.dao.ExampleDao;
import com.zhongyu.dao.impl.ExampleDaoImpl;
import com.zhongyu.service.ExampleService;

/**
 * Created by ZhongYu on 3/31/2017.
 */
public class ExampleServiceImpl implements ExampleService {

    private ExampleDao exampleDao;

    public ExampleServiceImpl() {
        exampleDao = new ExampleDaoImpl();
    }

    @Override
    public boolean save(Example example) {
        return exampleDao.insert(example);
    }
}
