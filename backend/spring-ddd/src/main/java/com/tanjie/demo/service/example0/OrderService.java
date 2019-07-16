/**
 * OrderService.java 2019年7月16日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.demo.service.example0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanjie.demo.domain.example0.Customer;
import com.tanjie.demo.domain.example0.Order;
import com.tanjie.demo.repository.example0.CustomerRepository;
import com.tanjie.demo.repository.example0.OrderRepository;

/**
 * @author tanjie
 *
 */
@Service
public class OrderService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    public void payOrder() {
        // 创建Customer实体对象
        Customer customer = new Customer();
        customer.setName("tanjie");
        customerRepository.save(customer);
        // 创建订单实体
        Order order = new Order();
        order.setOrderName("abc");
        orderRepository.save(order);
        // 设置order与customer的关系
        
        customer.addOrder(order);
        customerRepository.save(customer);

    }

    public void payOrder1() {
        // 创建Customer实体对象
        Customer customer = new Customer();
        customer.setName("tanjie");

        // 创建订单实体
        Order order = new Order();
        order.setOrderName("abc");

        // 建立双向关联关系
        customer.addOrder(order);
        customerRepository.save(customer);
        // orderRepository.save(order);

        Order savedOrder = orderRepository.findById(1L).get();
        savedOrder.setOrderName("123");
        orderRepository.save(savedOrder);
    }
}
