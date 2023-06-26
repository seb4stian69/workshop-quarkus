package org.domain.events;

import lombok.Builder;
import lombok.Data;
import org.domain.BuyAggregate;
import org.domain.values.identificators.BuyID;
import org.domain.values.identificators.ProductID;
import org.quarkus.events.BaseEvent;

@Data
public class ProductDeleted extends BaseEvent {

    /* | ---------------------------------------- + Attributes + ---------------------------------------- | */
    private ProductID productID;

    /* | ---------------------------------------- +   Settings   + ---------------------------------------- | */
    public static final String PRODUCT_DELETED_V1 = "PRODUCT_DELETED_V1";
    public static final String AGGREGATE_TYPE = BuyAggregate.AGGREGATE_TYPE;

    /* | ---------------------------------------- + Constructor + ---------------------------------------- | */
    @Builder
    public ProductDeleted(BuyID aggregateId, ProductID productID) {
        super(aggregateId.getId());
        this.productID = productID;
    }

}
