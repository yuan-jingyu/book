package com.yuanjingyu.service;

import com.yuanjingyu.entity.Category;

import java.util.List;

/**
 * 图书分类接口
 */
public interface CategoryService {

    /*查询分类列表*/
    List<Category> getCategorys();

}
