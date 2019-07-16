/**
 * Category.java 2019年7月16日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.demo.domain.example1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author tanjie
 *
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToOne
    private Category parentCategory;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Set<Category> childCategories = new HashSet<Category>();

    
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parentCategory
     */
    public Category getParentCategory() {
        return parentCategory;
    }

    /**
     * @param parentCategory the parentCategory to set
     */
    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    /**
     * @return the childCategories
     */
    public Set<Category> getChildCategories() {
        return childCategories;
    }
    
    public void addChildCategory(Category childCategory) {
        this.childCategories.add(childCategory);
        childCategory.setParentCategory(this);
    }
    

    /**
     * @param childCategories the childCategories to set
     */
    public void setChildCategories(Set<Category> childCategories) {
        this.childCategories = childCategories;
    }
    
    
}
