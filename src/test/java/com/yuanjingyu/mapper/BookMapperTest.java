package com.yuanjingyu.mapper;

import com.yuanjingyu.base.BaseTest;
import com.yuanjingyu.entity.Book;
import com.yuanjingyu.entity.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class BookMapperTest extends BaseTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void getBooks() {
        bookMapper.getBooks().forEach(System.out::println);
    }

    @Test
    public void addBook() {
        Book book = new Book();
        book.setBookName("明朝那些事儿");
        book.setPrice(55.55);
        book.setAuthorName("石悦");
        Category category = new Category();
        category.setCategoryId(1001);
        book.setCategory(category);

        bookMapper.addBook(book);
        System.out.println(book);
    }

    @Test
    public void deleteBook() {
        bookMapper.deleteBook(1004);
    }

    @Test
    public void getBookByBookId() {
        Book id = bookMapper.getBookByBookId(1000);
        System.out.println(id);
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setBookId(1000);
        book.setBookName("三体");
        book.setAuthorName("刘念慈");
        book.setPrice(98.99);
        Category category = new Category();
        category.setCategoryId(1002);
        book.setCategory(category);

        bookMapper.updateBook(book);
        System.out.println(book);
    }
}