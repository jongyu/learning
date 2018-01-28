package com.zhongyu.commons.handle;


import com.zhongyu.commons.enums.ResultEnum;
import com.zhongyu.commons.exception.WarnException;
import com.zhongyu.commons.result.Result;
import com.zhongyu.commons.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhongYu on 3/25/2017.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof WarnException) {
            WarnException warnException = (WarnException) e;
            logger.error(e.getMessage());
            return ResultUtil.failed(warnException.getCode(), warnException.getMessage());
        } else {
            return ResultUtil.failed(ResultEnum.UNKNOWN_ERROR);
        }
    }

}
