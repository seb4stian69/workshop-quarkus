package com.domain.value;

import co.com.sofka.domain.generic.Identity;

public class BuyID extends Identity {

    public BuyID(String id) {
        super(id);
    }

    public static BuyID of(String id) {
        return new BuyID(id);
    }

}
