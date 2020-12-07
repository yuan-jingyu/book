package com.yuanjingyu.mapper;

import com.yuanjingyu.entity.Category;

import java.util.List;

/**
 * 分类接口持久层
 */
public interface CategoryMapper {

    /*查询分类列表*/
    List<Category> getCategorys();

}
