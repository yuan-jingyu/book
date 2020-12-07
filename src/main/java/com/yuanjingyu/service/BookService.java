package com.yuanjingyu.service;

import com.yuanjingyu.dto.Page;
import com.yuanjingyu.entity.Book;

import java.util.List;

/**
 * 图书接口
 */
public interface BookService {

    /*查询分页全部*/
    Page getBooks(Integer pageNo,Integer pageSize);

    /*添加图书*/
    void addBook(Book book);

    /*删除图书*/
    void deleteBook(Integer book);

    /*根据id查询图书信息*/
    Book getBookByBookId(Integer bookId);

    /*更新员工信息*/
    void updateBook(Book book);


}
