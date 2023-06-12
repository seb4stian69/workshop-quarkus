package com.domain.entities;

import co.com.sofka.domain.generic.Entity;
import com.domain.value.CardNumber;
import com.domain.value.UName;
import com.domain.value.UserID;
import lombok.Getter;
import lombok.Setter;

@Getter/*-*/@Setter
public class User extends Entity<UserID> {

    private UName name;
    private CardNumber cardNumber;

    public  User(UserID id, UName name, CardNumber cardNumber) {
        super(id);
        this.name = name;
        this.cardNumber = cardNumber;
    }

}