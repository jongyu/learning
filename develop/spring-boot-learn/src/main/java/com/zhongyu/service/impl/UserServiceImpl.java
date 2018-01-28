package com.zhongyu.service.impl;

import com.zhongyu.bean.User;
import com.zhongyu.dao.UserMapper;
import com.zhongyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhongYu on 3/14/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUser(Long id) {
        return userMapper.select(id);
    }

    @Override
    public Integer save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer update(User user) {
        return userMapper.update(user);
    }

    @Override
    public Integer delete(Long id) {
        return userMapper.delete(id);
    }

}
