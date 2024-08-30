package com.xkong.book.enums;

import com.xkong.book.service.BookService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-21
 * Time: 13:28
 * Version:
 */
public enum BookStatusEnum {
    DELETE(0, "已删除"),
    NORMAL(1, "可借阅"),
    FORBIDDEN(2, "不可借阅");

    public static BookStatusEnum getNameByCode(int code) {
        switch (code) {
            case 0: return DELETE;
            case 1: return NORMAL;
            default: return FORBIDDEN;// 2
        }
    }

    private int code;
    private String name;

    BookStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
