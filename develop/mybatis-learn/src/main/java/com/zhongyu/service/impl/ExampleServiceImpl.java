package com.zhongyu.service.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.dao.ExampleDao;
import com.zhongyu.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhongYu on 2017/3/8.
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleDao exampleDao;

    @Override
    public List<Example> listExample() {
        return exampleDao.listExample();
    }

    @Override
    public int removeByPrimaryKey(Integer id) {
        return exampleDao.deleteByPrimaryKey(id);
    }

    @Override
    public int save(Example record) {
        return exampleDao.insert(record);
    }

    @Override
    public int saveSelective(Example record) {
        return exampleDao.insertSelective(record);
    }

    @Override
    public Example getByPrimaryKey(Integer id) {
        return exampleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Example record) {
        return exampleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Example record) {
        return exampleDao.updateByPrimaryKey(record);
    }

}
