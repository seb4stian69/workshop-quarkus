package com.domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Price implements ValueObject<Integer> {

    private final Integer productPrice;

    public Price(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public static Price of(Integer productPrice) {
        return new Price(productPrice);
    }

    @Override
    public Integer value() {
        return productPrice;
    }

}