package com.zhongyu.commons.enums;

/**
 * Created by ZhongYu on 3/16/2017.
 */
public enum ResultEnum {

    UNKNOWN_ERROR(-1),
    SUCCESS(1),
    FAILED(0),;

    private Integer code;

    private String message;

    ResultEnum(Integer code) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
