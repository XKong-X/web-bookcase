package com.xkong.book.controller;

import com.xkong.book.constant.Constants;
import com.xkong.book.model.*;
import com.xkong.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 0:38
 * Version:
 */
@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getBookListByPage")
    public Result getBookListByPage(PageRequest pageRequest, HttpSession session) {
        log.info("查询翻页信息, pageRequest:{}", pageRequest);
        // 登录校验
//        UserInfo userInfo = (UserInfo) session.getAttribute(Constants.SESSION_USER_KEY);
//        if (userInfo == null || userInfo.getId() < 1 || !StringUtils.hasLength(userInfo.getUserName())) {
//            // 未登录
//            return Result.unLogin();
//        }
        // 校验通过
        if (pageRequest.getPageSize() < 0 || pageRequest.getCurrentPage() < 1) {
            return Result.fail("参数校验失败!");
        }
        PageResult<BookInfo> bookInfoPageResult = null;
        try {
            bookInfoPageResult = bookService.selectBookInfoByPage(pageRequest);
            return Result.success(bookInfoPageResult);
        } catch (Exception e) {
            log.error("查询翻页信息错误,e:{}", e);
            return Result.fail(e.getMessage());
        }
//        return bookInfoPageResult;
    }

    // 检查价格是否合理
    private static boolean checkPrice(BigDecimal price) {
        if (Integer.parseInt(price.toBigInteger().toString()) < 0) {// 不合理
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/addBook", produces = "application/json")
    public String addBook(BookInfo bookInfo) {
        log.info("新的添加图书请求，bookInfo:{}", bookInfo);
        // 校验
        if (!StringUtils.hasLength(bookInfo.getBookName())
                || !StringUtils.hasLength(bookInfo.getAuthor())
                || bookInfo.getCount() < 0
                || bookInfo.getPrice() == null
                || !BookController.checkPrice(bookInfo.getPrice())) {
            return "参数校验失败，请检查输入的参数！";
        }
        Integer result = bookService.addBook(bookInfo);
        if (result < 1) {
            log.error("添加图书出错, bookInfo:{}", bookInfo);
            return "添加图书出错， 请联系管理员";
        }
        log.info("添加成功, bookName:{}", bookInfo.getBookName());
        return "";
    }

    @RequestMapping("/queryBookInfoById")
    public BookInfo queryBookInfoById(Integer bookId) {
        log.info("根据id查询图书，bookId:{}", bookId);
        BookInfo bookInfo = null;
        try {
            bookInfo = bookService.queryBookInfoById(bookId);
            if (bookInfo == null) {
                log.info("未查到书籍信息，可能由于服务器繁忙或 id 不存在导致，请再次尝试");
            }
        } catch (Exception e) {
            log.error("查询图书失败，e:{}", e);
        }
        return bookInfo;
    }

    @RequestMapping(value = "/updateBook", produces = "application/json")
    public String updateBook(BookInfo bookInfo) {
        log.info("新的修改图书信息的请求，bookInfo:{}", bookInfo);
        Integer result = bookService.updateBook(bookInfo);
        if (result == 0) {
            log.error("更新图书失败，请联系管理员！");
            return "更新图书失败，请联系管理员！";
        }
        return "";
    }

    @RequestMapping(value = "/batchDelete", produces = "application/json")
    public String batchDelete(@RequestParam List<Integer> ids) {
        log.info("新的批量删除请求, 图书id:{}", ids);
        Integer result = bookService.batchDelete(ids);
        if (result < 1) {
            log.error("批量删除失败, ids:{}", ids);
            return "批量删除失败, 请联系管理员!";
        }
        return "";
    }
}
