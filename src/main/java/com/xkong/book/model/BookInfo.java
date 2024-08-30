package com.xkong.book.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 0:40
 * Version:
 */
@Data
public class BookInfo {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;

    // 转成字符串来显示小数
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;

    private String publish;
    private Integer status;
    private String statusCN;
}
