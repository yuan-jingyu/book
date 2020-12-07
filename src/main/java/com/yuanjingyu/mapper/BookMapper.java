package com.yuanjingyu.mapper;

import com.yuanjingyu.entity.Book;

import java.util.List;

/**
 * 图书接口持久层
 */
public interface BookMapper {

    /*查询全部*/
    List<Book> getBooks();

    /*添加图书*/
    void addBook(Book book);

    /*删除图书*/
    void deleteBook(Integer book);

    /*根据id查询图书信息*/
    Book getBookByBookId(Integer bookId);

    /*更新员工信息*/
    void updateBook(Book book);


}
