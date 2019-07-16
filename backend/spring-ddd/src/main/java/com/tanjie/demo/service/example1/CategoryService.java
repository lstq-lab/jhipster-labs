/**
 * CategoryService.java 2019年7月16日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.demo.service.example1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanjie.demo.domain.example1.Category;
import com.tanjie.demo.repository.example1.CategoryRepository;

/**
 * @author tanjie
 *
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void initial() {
        // 创建根节点
        Category rootCategory = new Category();
        rootCategory.setName("shipin");

        // 存储父节点
        categoryRepository.save(rootCategory);

        // 创建两个子节点
        Category shucaiCategory = new Category();
        shucaiCategory.setName("shucai");

        Category shuiguoCategory = new Category();
        shuiguoCategory.setName("shuiguo");

        // 存储
        categoryRepository.save(shucaiCategory);
        categoryRepository.save(shuiguoCategory);

        // 创建食品类目与子节点的关联关系
        rootCategory.addChildCategory(shuiguoCategory);
        rootCategory.addChildCategory(shucaiCategory);
        categoryRepository.save(rootCategory);

        // 创建叶子节点
        Category xihongshiCategory = new Category();
        xihongshiCategory.setName("xigongshi");
        // 存储
        categoryRepository.save(xihongshiCategory);

        // 设置蔬菜与西红柿节点的关系
        shucaiCategory.addChildCategory(xihongshiCategory);

        categoryRepository.save(shucaiCategory);


    }

    public void traverseCategory(Category rootCategory) {
        if (rootCategory != null) {
            System.out.println(rootCategory.getName());
        }
        Iterator<Category> iterator = rootCategory.getChildCategories().iterator();
        while (iterator.hasNext()) {
            // 递归查询
            traverseCategory(iterator.next());
        }
    }

    public void delteAll(Category rootCategory) {
        categoryRepository.delete(rootCategory);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
