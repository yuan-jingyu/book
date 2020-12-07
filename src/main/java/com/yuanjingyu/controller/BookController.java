package com.yuanjingyu.controller;

import com.yuanjingyu.dto.Page;
import com.yuanjingyu.entity.Book;
import com.yuanjingyu.entity.Category;
import com.yuanjingyu.service.BookService;
import com.yuanjingyu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.Predicate;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

/**
 * book内部功能实现
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    /*跳转book主页界面*/
    @RequestMapping(value = "/jumpBookList")
    public String jumpBookList(){
        System.out.println("跳转到主页界面book_list.jsp====>>>跳转...");
        return "book_list";
    }

    /*获取分页接口接口*/
    @ResponseBody
    @RequestMapping(value = "/getBookPage")
    public Page getBookPage(Integer pageNo,Integer pageSize){
        if (pageNo == null){
            pageNo = 1;
        }
        if (pageSize == null){
            pageSize = 2;
        }
        Page books = bookService.getBooks(pageNo, pageSize);
        return books;
    }

    /*删除图书*/
    @RequestMapping(value = "/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer bookId){
        System.out.println("删除图书===>"+bookId);
        bookService.deleteBook(bookId);
        //重定向
        return "redirect:/jumpBookList";
    }

    /*跳转添加图书*/
    @RequestMapping(value = "/jumpAddBook")
    public String jumpAddBook(Model model){
        System.out.println("跳转添加员工...");
        List<Category> category = categoryService.getCategorys();
        model.addAttribute("category",category);
        return "book_add";
    }

    /*添加图书*/
    @RequestMapping(value = "/addBook")
    public String addBook(Book book){
        System.out.println("添加图书界面"+book);
        bookService.addBook(book);
        return "redirect:/jumpBookList";
    }

    /*跳转更新界面*/
    @RequestMapping(value = "/jumpUpdateBook")
    public String jumpUpdateBook(Integer bookId,Model model){
        System.out.println("跳转到更新界面.........."+bookId);
        //获取图书数据
        Book book = bookService.getBookByBookId(bookId);
        model.addAttribute("book",book);
        //获取下拉列表
        List<Category> categorys = categoryService.getCategorys();
        model.addAttribute("categorys",categorys);
        return "book_update";
    }


    /*更新图书*/
    @RequestMapping(value = "/updateBook")
    public String updateBook(Book book){
        System.out.println("更新图书:"+book);
        bookService.updateBook(book);
        return "redirect:/jumpBookList";
    }











}





















