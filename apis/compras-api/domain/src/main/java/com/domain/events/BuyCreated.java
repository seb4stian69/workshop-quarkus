package com.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.domain.entities.Product;
import com.domain.value.BuyID;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter/* */@Setter
public class BuyCreated extends DomainEvent {

    private BuyID buyID;
    private List<Product> products;

    public BuyCreated(BuyID buyID, List<Product> products) {
        super("buys.buycreated");
        this.buyID = buyID;
        this.products = products;
    }

}
