/**
 * Address.java 2019年7月16日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.demo.domain.example2;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author tanjie
 *
 */
@Embeddable()
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;

    private String province;
    private String city;
    private String street;
    private String zipcode;

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }
    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }
    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }
    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }
    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
}
