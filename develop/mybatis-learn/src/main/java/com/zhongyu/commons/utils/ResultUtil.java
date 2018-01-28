package com.zhongyu.commons.utils;


import com.zhongyu.commons.enums.ResultEnum;
import com.zhongyu.commons.result.Result;

/**
 * Created by ZhongYu on 3/25/2017.
 */
public class ResultUtil {
    
    public static Result success(ResultEnum failed) {
        Result result = new Result();
        result.setCode(failed.getCode());
        result.setMessage(failed.getMessage());
        return result;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(null);
        return result;
    }

    public static Result success(String message) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    public static Result success(String message, Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage(message);
        result.setData(object);
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static Result failed(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static Result failed(ResultEnum failed) {
        Result result = new Result();
        result.setCode(failed.getCode());
        result.setMessage(failed.getMessage());
        return result;
    }

}
