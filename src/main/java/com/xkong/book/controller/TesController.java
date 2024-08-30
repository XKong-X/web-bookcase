package com.xkong.book.controller;

import com.xkong.book.model.BookInfo;
import com.xkong.book.model.Result;
import com.xkong.book.model.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-24
 * Time: 19:55
 * Version:
 */
@RequestMapping("/test")
@RestController
public class TesController {
    @RequestMapping("/t1")
    public Boolean t1() {
        int a = 10/0;
        return true;
    }

    @RequestMapping("/t2")
    public Integer t2() {
        return 123;
    }

    @RequestMapping("/t3")
    public String t3() {
        return "Java";
    }

    @RequestMapping("/t4")
    public BookInfo t4() {
        return new BookInfo();
    }

    @RequestMapping("/t5")
    public Result t5() {
        return Result.success("success");
    }
}
