package com.zhongyu.service.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.dao.ExampleDao;
import com.zhongyu.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhongYu on 3/31/2017.
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleDao exampleDao;

    @Override
    public List<Example> list() {
        return exampleDao.list();
    }

    @Override
    public Example get(Integer id) {
        return exampleDao.get(id);
    }

    @Override
    public Serializable save(Example example) {
        return exampleDao.insert(example);
    }

    @Override
    public void update(Example example) {
        exampleDao.update(example);
    }

    @Override
    public boolean delete(Example example) {
        return exampleDao.delete(example);
    }
}
