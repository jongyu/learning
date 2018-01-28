package com.zhongyu.controller;

import com.zhongyu.bean.User;
import com.zhongyu.common.bean.Result;
import com.zhongyu.common.utils.ResultUtil;
import com.zhongyu.enums.ResultEnum;
import com.zhongyu.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZhongYu on 3/14/2017.
 */
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping("user")
    public Result<User> listUser() {
        List<User> users = userService.listUser();
        if (users.size() > 0) {
            return ResultUtil.success(users);
        }
        return ResultUtil.failed(ResultEnum.FAILED);
    }

    @PostMapping("user")
    public Result<User> saveUser(User user) {
        Integer result = userService.save(user);
        if (result > 0) {
            return ResultUtil.success(ResultEnum.SUCCESS);
        }
        return ResultUtil.failed(ResultEnum.FAILED);
    }

    @GetMapping("user/{id}")
    public Result<User> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResultUtil.success(user);
        }
        return ResultUtil.failed(ResultEnum.FAILED);
    }

    @PutMapping("user/{id}")
    public Result<User> updateUser(User user, @PathVariable("id") Long id) {
        user.setId(id);
        Integer result = userService.update(user);
        if (result > 0) {
            return ResultUtil.success(ResultEnum.SUCCESS);
        }
        return ResultUtil.failed(ResultEnum.FAILED);
    }

    @DeleteMapping("user/{id}")
    public Result deleteUser(@PathVariable("id") Long id) {
        Integer result = userService.delete(id);
        if (result > 0) {
            return ResultUtil.success(ResultEnum.SUCCESS);
        }
        return ResultUtil.failed(ResultEnum.FAILED);
    }

}
