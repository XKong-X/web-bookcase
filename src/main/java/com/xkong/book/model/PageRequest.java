package com.xkong.book.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-07-21
 * Time: 0:02
 * Version:
 */
@Data
public class PageRequest {
    // 当前页码
    private Integer currentPage = 1;
    // 每页显示条数
    private Integer pageSize = 6;
    private Integer offset;

    public Integer getOffset() {
        return (currentPage - 1) * pageSize;
    }
}
