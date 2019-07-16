/**
 * CategoryRepository.java 2019年7月16日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.demo.repository.example1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tanjie.demo.domain.example1.Category;

/**
 * @author tanjie
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
