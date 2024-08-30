package com.xkong.book.dao;

import com.xkong.book.model.BookInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 16:26
 * Version:
 */
public class BookDao {
    // 假的测试数据
    public List<BookInfo> mockData() {
        List<BookInfo> bookInfos = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setId(i);
            bookInfo.setBookName("图书" + i);
            bookInfo.setAuthor("作者" + i);
            bookInfo.setCount(new Random().nextInt(200));
            bookInfo.setPrice(new BigDecimal(new Random().nextInt(100)));
            bookInfo.setPublish("出版社" + i);
            bookInfo.setStatus(i % 5 == 0 ? 0 : 1);
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
