package com.domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class Quantity implements ValueObject<Integer> {

    private final Integer productQuantity;

    public Quantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public static Quantity of(Integer productQuantity) {
        return new Quantity(productQuantity);
    }

    @Override
    public Integer value() {
        return productQuantity;
    }

}
