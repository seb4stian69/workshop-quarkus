package com.domain;

import co.com.sofka.domain.generic.EventChange;
import com.domain.events.BuyCreated;
import com.domain.events.ProductAdded;
import com.domain.events.ProductDeleted;
import com.domain.events.ProductUpdated;

public class BuyChange extends EventChange {

    public BuyChange(Buy buy){

        apply( (BuyCreated event) -> {
            buy.user = event.getUser();
            buy.cart = event.getProducts();
        });

        apply( (ProductAdded event) -> buy.cart.add( event.getProduct() ));

        apply( (ProductUpdated event) -> BuyUtils.findProductById(event.getProductID(), buy.cart)
                .setQuantity(event.getQuantity())
        );

        apply( (ProductDeleted event) -> buy.cart = BuyUtils.deleteProduct(event.getProductID(), buy.cart) );

    }

}
