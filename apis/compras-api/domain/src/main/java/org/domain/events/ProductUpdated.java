package org.domain.events;

import lombok.Builder;
import lombok.Data;
import org.domain.BuyAggregate;
import org.domain.values.Quantity;
import org.domain.values.identificators.BuyID;
import org.domain.values.identificators.ProductID;
import org.quarkus.events.BaseEvent;

@Data
public class ProductUpdated extends BaseEvent {

    /* | ---------------------------------------- + Attributes + ---------------------------------------- | */
    private ProductID productID;
    private Quantity quantity;

    /* | ---------------------------------------- +   Settings   + ---------------------------------------- | */
    public static final String PRODUCT_UPDATED_V1 = "PRODUCT_UPDATED_V1";
    public static final String AGGREGATE_TYPE = BuyAggregate.AGGREGATE_TYPE;

    /* | ---------------------------------------- + Constructor + ---------------------------------------- | */
    @Builder
    public ProductUpdated(BuyID aggregateId, ProductID productID, Quantity quantity) {
        super(aggregateId.getId());
        this.productID = productID;
        this.quantity = quantity;
    }

}
