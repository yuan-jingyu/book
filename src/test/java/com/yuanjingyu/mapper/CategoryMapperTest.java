package com.yuanjingyu.mapper;

import com.yuanjingyu.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CategoryMapperTest extends BaseTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void getCategorys() {

        categoryMapper.getCategorys().forEach(System.out::println);

    }
}