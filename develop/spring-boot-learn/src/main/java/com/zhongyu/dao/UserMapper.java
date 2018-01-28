package com.zhongyu.dao;

import com.zhongyu.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZhongYu on 3/12/2017.
 */
@Repository
public interface UserMapper {

    List<User> selectAll();

    User select(Long id);

    Integer insert(User user);

    Integer update(User user);

    Integer delete(Long id);

}
