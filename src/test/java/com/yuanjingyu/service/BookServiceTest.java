package com.yuanjingyu.service;

import com.yuanjingyu.base.BaseTest;
import com.yuanjingyu.dto.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class BookServiceTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getBooks() {
        Page page = bookService.getBooks(1, 2);
        System.out.println(page);
    }

    @Test
    public void addBook() {
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void getBookByBookId() {
    }

    @Test
    public void updateBook() {
    }
}