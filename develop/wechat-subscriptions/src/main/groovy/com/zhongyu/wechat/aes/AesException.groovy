package com.zhongyu.wechat.aes

class AesException extends Exception {

    public final static int ValidateSignatureError = -40001
    public final static int ComputeSignatureError = -40003

    private int code

    private static String getMessage(int code) {
        switch (code) {
            case ValidateSignatureError:
                return "签名验证错误"
            case ComputeSignatureError:
                return "sha加密生成签名失败"
            default:
                return null //cannot be
        }
    }

    AesException(int code) {
        super(getMessage(code))
        this.code = code
    }

}
