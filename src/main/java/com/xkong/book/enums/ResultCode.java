package com.xkong.book.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-22
 * Time: 21:36
 * Version:
 */
public enum ResultCode {
    SUCCESS(0),
    FAIL(-1),
    UNLOGIN(-2);
    private int code;// 0 成功, -1 失败,-2 未登录

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
