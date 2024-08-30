package com.xkong.book.model;

import com.xkong.book.enums.ResultCode;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-22
 * Time: 21:33
 * Version:
 */
@Data
public class Result {
    // 业务状态码
    private ResultCode code;// 0 成功, -1 失败,-2 未登录
    // 错误信息
    private String errMsg;
    private Object data;

//    private Result result = new Result();
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setErrMsg("");// 表示已登录
        result.setData(data);
        return result;
    }

    public static Result fail(String errMsg) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }

    public static Result fail(Object data,String errMsg) {
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }

    public static Result unLogin() {
        Result result = new Result();
        result.setCode(ResultCode.UNLOGIN);
        result.setErrMsg("用户未登录!");
        result.setData(null);
        return result;
    }
}
