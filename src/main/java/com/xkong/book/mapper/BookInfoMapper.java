package com.xkong.book.mapper;

import com.xkong.book.model.BookInfo;
import com.xkong.book.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-21
 * Time: 0:13
 * Version:
 */
@Mapper
public interface BookInfoMapper {
    //获取当前页的信息
    @Select("select * from book_info /*where status!=0*/ order by id asc limit #{offset},#{pageSize}")
    List<BookInfo> selectBookInfoByPage(Integer offset, Integer pageSize);

    // 获取总记录数
    @Select("select count(1) from book_info /*where status!=0*/")
    Integer count();

    // 添加
    @Insert("insert into book_info (book_name, author, count, price, publish, status) " +
            "values (#{bookName}, #{author}, #{count}, #{price}, #{publish}, #{status})")
    Integer insertBook(BookInfo bookInfo);

    // 根据 id 查
    @Select("select * from book_info where id=#{id}")
    BookInfo queryBookInfoById(Integer id);

    // 修改图书信息
    Integer updateBook(BookInfo bookInfo);

    // 批量删除
    Integer batchDelete(List<Integer> ids);
}
