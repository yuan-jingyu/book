package com.yuanjingyu.service;

import com.yuanjingyu.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceTest extends BaseTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getCategorys() {
        categoryService.getCategorys().forEach(System.out::println);
    }
}