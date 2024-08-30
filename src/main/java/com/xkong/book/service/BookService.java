package com.xkong.book.service;

import com.xkong.book.enums.BookStatusEnum;
import com.xkong.book.mapper.BookInfoMapper;
import com.xkong.book.model.BookInfo;
import com.xkong.book.model.PageRequest;
import com.xkong.book.model.PageResult;
import com.xkong.book.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: 行空XKong
 * Date: 2024-06-27
 * Time: 16:27
 * Version:
 */
@Slf4j
@Service
public class BookService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    public PageResult<BookInfo> selectBookInfoByPage(PageRequest pageRequest) {
        if (pageRequest == null) {
            return null;
        }
        // 获取总记录数
        Integer count = bookInfoMapper.count();
        // 获取当前记录
        List<BookInfo> bookInfos = bookInfoMapper.selectBookInfoByPage(pageRequest.getOffset(), pageRequest.getPageSize());
        if (bookInfos != null && bookInfos.size() > 0) {
            for (BookInfo bookInfo : bookInfos) {
                bookInfo.setStatusCN(BookStatusEnum.getNameByCode(bookInfo.getStatus()).getName());
            }
        }

        return new PageResult<>(bookInfos, count, pageRequest);
    }

    // 添加图书
    public Integer addBook(BookInfo bookInfo) {
        Integer result = 0;
        try {
            result = bookInfoMapper.insertBook(bookInfo);

        } catch (Exception e) {
            log.error("添加图书异常, e:{}", e);
        }
        return result;
    }

    // 根据 id 查
    public BookInfo queryBookInfoById(Integer id) {
        return bookInfoMapper.queryBookInfoById(id);
    }

    // 修改图数信息
    public Integer updateBook(BookInfo bookInfo) {
        Integer result = 0;
        try {
            result = bookInfoMapper.updateBook(bookInfo);
        } catch (Exception e) {
            log.error("图书更新失败，e:{}", e);
        }
        return result;
    }

    // 批量删除
    public Integer batchDelete(List<Integer> ids) {
        Integer result = 0;
        try {
            result = bookInfoMapper.batchDelete(ids);
            if (result == 0) {
                log.info("批量删除失败");
            }
        } catch (Exception e) {
            log.error("批量删除失败, ids:{}", ids);
        }
        return result;
    }
}
