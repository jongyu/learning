package com.zhongyu.service;

import com.zhongyu.bean.User;

import java.util.List;

/**
 * Created by ZhongYu on 3/14/2017.
 */
public interface UserService {

    List<User> listUser();

    User getUser(Long id);

    Integer save(User user);

    Integer update(User user);

    Integer delete(Long id);

}
