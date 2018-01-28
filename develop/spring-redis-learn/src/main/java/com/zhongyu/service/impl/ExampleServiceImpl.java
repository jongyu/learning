package com.zhongyu.service.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.common.bean.Pager;
import com.zhongyu.dao.ExampleDao;
import com.zhongyu.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhongYu on 4/18/2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    private ExampleDao exampleDao;

    @Override
    @Cacheable(value = "pagerExample", keyGenerator = "customKeyGenerator")
    public List<Example> examplePager(Pager pager) {
        return exampleDao.examplePager(pager);
    }

    @Override
    @Cacheable(value = "getExample", keyGenerator = "customKeyGenerator")
    public Example getExample(Integer id) {
        return exampleDao.getExample(id);
    }

    @Override
    @CacheEvict(value = {"saveExample", "countExample"}, allEntries = true)
    public Integer saveExample(Example example) {
        return exampleDao.insertExample(example);
    }

    @Override
    @CacheEvict(value = {"pagerExample", "countExample", "getExample"}, allEntries = true)
    public Integer updateExample(Example example) {
        return exampleDao.updateExample(example);
    }

    @Override
    @CacheEvict(value = {"pagerExample", "countExample", "getExample"}, allEntries = true)
    public Integer removeExample(Integer id) {
        return exampleDao.deleteExample(id);
    }

    @Override
    @Cacheable(value = "countExample", keyGenerator = "customKeyGenerator")
    public Integer countExample() {
        return exampleDao.countExample();
    }
}
