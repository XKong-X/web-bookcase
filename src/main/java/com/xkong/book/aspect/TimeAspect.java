package com.xkong.book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-26
 * Time: 12:35
 * Version:
 */
@Slf4j
@Aspect
@Component
public class TimeAspect {
    @Around("execution(* com.xkong.book.controller.*.*(..))")
    public Object timeCost(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info(joinPoint + ", 消耗时间: " + (end - start) + "ms");
        return result;
    }
}
