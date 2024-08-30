package com.xkong.book.mapper;

import com.xkong.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-21
 * Time: 0:06
 * Version:
 */
@Mapper
public interface UserInfoMapper {
    // 根据名称查信息
    @Select("select * from user_info where user_name=#{name}")
    UserInfo selectUserByName(String name);
}

