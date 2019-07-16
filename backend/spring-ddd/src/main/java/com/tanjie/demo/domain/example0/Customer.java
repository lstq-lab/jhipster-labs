/**
 * Customer.java 2019年7月16日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.demo.domain.example0;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author tanjie
 *
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Order> orders = new HashSet<>();

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
     * @return the orders
     */
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Customer addOrder(Order newOrder) {
        this.orders.add(newOrder);
        return this;
    }

}
