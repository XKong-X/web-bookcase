package com.xkong.book.config;

import com.xkong.book.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-24
 * Time: 21:47
 * Version:
 */
@ResponseBody
@Slf4j
@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public Result exception(Exception e) {
        log.error("发生异常, e:{}", e);
        return Result.fail("内部错误!");
    }

    @ExceptionHandler
    public Result exception(NullPointerException e) {
        log.error("发生异常, e:{}", e);
        return Result.fail("NullPointerException 异常!");
    }

    @ExceptionHandler
    public Result exception(ArithmeticException e) {
        log.error("发生异常, e:{}", e);
        return Result.fail("ArithmeticException 异常!");
    }
}
