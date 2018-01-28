package com.zhongyu.dao.impl;

import com.zhongyu.bean.Example;
import com.zhongyu.dao.ExampleDao;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhongYu on 3/31/2017.
 */
@Repository
@Transactional
public class ExampleDaoImpl implements ExampleDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Example> list() {
        String hql = "from com.zhongyu.bean.Example";
        return (List<Example>) hibernateTemplate.find(hql);
    }

    @Override
    public Example get(Integer id) {
        return hibernateTemplate.get(Example.class, id);
    }

    @Override
    public Serializable insert(Example example) {
        return hibernateTemplate.save(example);
    }

    @Override
    public void update(Example example) {
        hibernateTemplate.update(example);
    }

    @Override
    public boolean delete(Example example) {
        try {
            hibernateTemplate.delete(example);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }
}
