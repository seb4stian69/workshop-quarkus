package com.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.domain.value.BuyID;
import com.domain.value.ProductID;
import lombok.Getter;
import lombok.Setter;

@Getter/* */@Setter
public class ProductDeleted extends DomainEvent {

    private BuyID buyID;
    private ProductID productID;

    public ProductDeleted(BuyID buyID, ProductID productID) {
        super("buys.productdeleted");
        this.buyID = buyID;
        this.productID = productID;
    }

}
