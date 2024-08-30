package com.xkong.book.controller;

import com.xkong.book.constant.Constants;
import com.xkong.book.model.UserInfo;
import com.xkong.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 0:37
 * Version:
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        // 校验参数
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
//            System.out.println(userName);
//            System.out.println(password);
            System.out.println("用户名或密码为空！");
            return false;
        }
        // 验证用户名和密码
        // 查用户信息
        UserInfo userInfo = userService.getUserInfoByName(userName);
        // 比对
        if (userInfo == null || userInfo.getId() <= 0) {
            return false;
        }
        if (password.equals(userInfo.getPassword())) {
            // 存储 session
            userInfo.setPassword("");
            session.setAttribute(Constants.SESSION_USER_KEY, userInfo);
            return true;
        }
        System.out.println("用户名或密码错误");
        return false;
    }
}
