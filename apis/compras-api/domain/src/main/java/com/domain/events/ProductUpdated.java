package com.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.domain.value.BuyID;
import com.domain.value.ProductID;
import com.domain.value.Quantity;
import lombok.Getter;
import lombok.Setter;

@Getter/* */@Setter
public class ProductUpdated extends DomainEvent {

    private BuyID buyID;
    private ProductID productID;
    private Quantity quantity;

    public ProductUpdated(BuyID buyID, ProductID productID, Quantity quantity) {
        super("buys.productupdated");
        this.buyID = buyID;
        this.productID = productID;
        this.quantity = quantity;
    }
}
