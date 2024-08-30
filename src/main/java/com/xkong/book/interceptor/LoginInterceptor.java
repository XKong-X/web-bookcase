package com.xkong.book.interceptor;

import com.xkong.book.constant.Constants;
import com.xkong.book.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-22
 * Time: 23:20
 * Version:
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    // 目标方法执行前执行,true 表示放行,false 表示拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登录拦截器校验...");
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute(Constants.SESSION_USER_KEY) != null) {
//            UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
//            if (userInfo != null && userInfo.getId() > 1) {
//                return true;
//            }
//        }
        HttpSession session = request.getSession(true);
        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
        if (userInfo != null && userInfo.getId() > 0) {
            return true;
        }
        response.setStatus(401);
        return false;
    }

    // 目标方法执行后执行
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("执行后");
//    }

//    // 视图渲染后执行
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//    }
}
