package com.xkong.book.model;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-20
 * Time: 23:59
 * Version:
 */
@Data
public class PageResult<T> {
    // 当前页的记录
    private List<T> records;
    //总记录数
    private Integer total;
    private PageRequest pageRequest;

    public PageResult(List<T> records, Integer total, PageRequest pageRequest) {
        this.records = records;
        this.total = total;
        this.pageRequest = pageRequest;
    }
}
