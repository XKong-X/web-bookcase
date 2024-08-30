package com.xkong.book.service;

import com.xkong.book.mapper.UserInfoMapper;
import com.xkong.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoByName(String name) {
        return userInfoMapper.selectUserByName(name);
    }
}