package org.domain.events;

import lombok.Builder;
import lombok.Data;
import org.domain.BuyAggregate;
import org.domain.entities.Product;
import org.domain.values.identificators.BuyID;
import org.quarkus.events.BaseEvent;

@Data
public class ProductAdded extends BaseEvent {

    /* | ---------------------------------------- + Attributes + ---------------------------------------- | */
    private Product productToCart;

    /* | ---------------------------------------- +   Settings   + ---------------------------------------- | */
    public static final String PRODUCT_CREATED_V1 = "PRODUCT_CREATED_V1";
    public static final String AGGREGATE_TYPE = BuyAggregate.AGGREGATE_TYPE;

    /* | ---------------------------------------- + Constructor + ---------------------------------------- | */
    @Builder
    public ProductAdded(BuyID aggregateId, Product productToCart) {
        super(aggregateId.getId());
        this.productToCart = productToCart;
    }

}
