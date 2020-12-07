package com.yuanjingyu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanjingyu.dto.Page;
import com.yuanjingyu.entity.Book;
import com.yuanjingyu.mapper.BookMapper;
import com.yuanjingyu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 图书接口实现类
 */
@Transactional//开启事务
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Page getBooks(Integer pageNo, Integer pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNo,pageSize);
        List<Book> books = bookMapper.getBooks();
        PageInfo<Book> pageInfo = new PageInfo<>(books);

        page.setHasPre(pageInfo.isHasNextPage());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setPageNo(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setCount(pageInfo.getTotal());
        page.setPageCount(pageInfo.getPages());
        page.setPage(pageInfo.getList());

        return page;
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBook(Integer book) {
        bookMapper.deleteBook(book);
    }

    @Override
    public Book getBookByBookId(Integer bookId) {
        return bookMapper.getBookByBookId(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }
}
