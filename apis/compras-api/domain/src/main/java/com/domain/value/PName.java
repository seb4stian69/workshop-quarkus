package com.domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class PName implements ValueObject<String> {

    private final String productName;

    public PName(String productName) {
        this.productName = productName;
    }

    public static PName of(String productName) {
        return new PName(productName);
    }

    @Override
    public String value() {
        return productName;
    }

}