/**
 * Customer.java 2019年7月16日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.demo.domain.example2;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author tanjie
 *
 */
//@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    private String name;
    
    @Embedded
    private Address homeAddress;
   
  //  @Embedded
    //private Address comAddress;

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
     * @return the homeAddress
     */
    public Address getHomeAddress() {
        return homeAddress;
    }

    /**
     * @param homeAddress the homeAddress to set
     */
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

   
}
