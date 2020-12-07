package com.yuanjingyu.service.impl;

import com.yuanjingyu.entity.Category;
import com.yuanjingyu.mapper.CategoryMapper;
import com.yuanjingyu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 分类接口实现类
 */
@Transactional//开启事务
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategorys() {
        return categoryMapper.getCategorys();
    }
}
