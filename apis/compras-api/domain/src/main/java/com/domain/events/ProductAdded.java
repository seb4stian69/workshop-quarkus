package com.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.domain.entities.Product;
import com.domain.value.BuyID;
import lombok.Getter;
import lombok.Setter;

@Getter/* */@Setter
public class ProductAdded extends DomainEvent {

    private BuyID buyID;
    private Product product;

    public ProductAdded(BuyID buyID, Product product) {
        super("buys.productadded");
        this.buyID = buyID;
        this.product = product;
    }

}
