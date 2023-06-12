package com.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.domain.entities.Product;
import com.domain.entities.User;
import com.domain.value.BuyID;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter/* */@Setter
public class BuyCreated extends DomainEvent {

    private BuyID buyID;
    private List<Product> products;
    private User user;

    public BuyCreated(BuyID buyID, List<Product> products, User user) {
        super("buys.buycreated");
        this.buyID = buyID;
        this.products = products;
        this.user = user;
    }

}
