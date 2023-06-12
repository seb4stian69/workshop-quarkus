package com.domain.value;

import co.com.sofka.domain.generic.ValueObject;

public class CardNumber implements ValueObject<Integer> {

    private final Integer userCardNumber;

    public CardNumber(Integer userCardNumber) {
        this.userCardNumber = userCardNumber;
    }

    public static CardNumber of(Integer userCardNumber) {
        return new CardNumber(userCardNumber);
    }

    @Override
    public Integer value() {
        return userCardNumber;
    }

}