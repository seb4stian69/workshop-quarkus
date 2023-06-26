package org.domain.events;

import lombok.Builder;
import lombok.Data;
import org.domain.BuyAggregate;
import org.domain.entities.Product;
import org.domain.entities.User;
import org.domain.values.identificators.BuyID;
import org.quarkus.events.BaseEvent;

import java.util.List;

@Data
public class BuyCreated extends BaseEvent {

    /* | ---------------------------------------- + Attributes + ---------------------------------------- | */
    private List<Product> productsToCart;
    private User user;

    /* | ---------------------------------------- +   Settings   + ---------------------------------------- | */
    public static final String BUY_CREATED_V1 = "BUY_CREATED_V1";
    public static final String AGGREGATE_TYPE = BuyAggregate.AGGREGATE_TYPE;

    /* | ---------------------------------------- + Constructor + ---------------------------------------- | */
    @Builder
    public BuyCreated(BuyID aggregateId, List<Product> productsToCart, User user) {
        super(aggregateId.getId());
        this.productsToCart = productsToCart;
        this.user = user;
    }


}
