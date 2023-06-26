package org.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.domain.entities.Product;
import org.domain.entities.User;
import org.domain.events.BuyCreated;
import org.domain.events.ProductAdded;
import org.domain.events.ProductDeleted;
import org.domain.events.ProductUpdated;
import org.domain.values.Quantity;
import org.domain.values.identificators.BuyID;
import org.domain.values.identificators.ProductID;
import org.quarkus.AggregateRoot;
import org.quarkus.broker.utils.SerializerUtils;
import org.quarkus.events.Event;
import org.quarkus.exceptions.InvalidEventTypeException;
import java.util.ArrayList;
import java.util.List;

@Data/**/@Builder
@AllArgsConstructor/**/@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BuyAggregate extends AggregateRoot {

    /* | ---------------------------------------- + Attributes + ---------------------------------------- | */

    private User user;
    private List<Product> cart = new ArrayList<>();

    /* | ---------------------------------------- +   Settings   + ---------------------------------------- | */

    public static final String AGGREGATE_TYPE = "BuyAggregateType";

    /* | ---------------------------------------- + Constructor + ---------------------------------------- | */

    public BuyAggregate(BuyID buyID) {
        super(buyID.getId(), AGGREGATE_TYPE);
    }

    /* | ---------------------------------------- +    handles    + ---------------------------------------- | */

    private void handle(final BuyCreated event) {
        this.user = event.getUser();
        this.cart = event.getProductsToCart();
    }

    private void handle(final ProductAdded event) {
        this.cart.add(event.getProductToCart());
    }

    private void handle(final ProductUpdated event) {
        for (Product product : cart) {
            if (product.getProductID() == event.getProductID()) {
                product.setQuantity(event.getQuantity());
                break;
            }
        }
    }

    private void handle(final ProductDeleted event) {
        this.cart.removeIf(product -> product.getProductID() == event.getProductID());
    }

    /* | ---------------------------------------- +     methods     + ---------------------------------------- | */

    public void createBuy(User user, List<Product> cart) {

        final var data = BuyCreated.builder()
                .aggregateId(BuyID.of(id))
                .user(user)
                .productsToCart(cart)
                .build();

        final byte[] dataBytes = SerializerUtils.serializeToJsonBytes(data);
        final var event = this.createEvent(BuyCreated.BUY_CREATED_V1, dataBytes, null);

        this.apply(event);

    }

    public void addProduct(Product product) {

        final var data = ProductAdded.builder()
                .aggregateId(BuyID.of(id))
                .productToCart(product)
                .build();

        final byte[] dataBytes = SerializerUtils.serializeToJsonBytes(data);
        final var event = this.createEvent(ProductAdded.PRODUCT_CREATED_V1, dataBytes, null);

        this.apply(event);

    }

    public void updateProduct(ProductID productID, Quantity quantity) {

        final var data = ProductUpdated.builder()
                .aggregateId(BuyID.of(id))
                .productID(productID)
                .quantity(quantity)
                .build();

        final byte[] dataBytes = SerializerUtils.serializeToJsonBytes(data);
        final var event = this.createEvent(ProductUpdated.PRODUCT_UPDATED_V1, dataBytes, null);

        this.apply(event);

    }

    public void deleteProduct(ProductID productID) {

        final var data = ProductDeleted.builder()
                .aggregateId(BuyID.of(id))
                .productID(productID)
                .build();

        final byte[] dataBytes = SerializerUtils.serializeToJsonBytes(data);
        final var event = this.createEvent(ProductDeleted.PRODUCT_DELETED_V1, dataBytes, null);

        this.apply(event);

    }

    /* | ---------------------------------------- +    when    + ---------------------------------------- | */

    @Override
    public void when(Event event) {

        switch (event.getEventType()) {

            case BuyCreated.BUY_CREATED_V1 ->
                    handle(SerializerUtils.deserializeFromJsonBytes(event.getData(), BuyCreated.class));

            case ProductAdded.PRODUCT_CREATED_V1->
                    handle(SerializerUtils.deserializeFromJsonBytes(event.getData(), ProductAdded.class));

            case ProductUpdated.PRODUCT_UPDATED_V1->
                    handle(SerializerUtils.deserializeFromJsonBytes(event.getData(), ProductUpdated.class));

            case ProductDeleted.PRODUCT_DELETED_V1 ->
                    handle(SerializerUtils.deserializeFromJsonBytes(event.getData(), ProductDeleted.class));

            default -> throw new InvalidEventTypeException(event.getEventType());

        }

    }

    /* | ---------------------------------------- +     utils     + ---------------------------------------- | */

    @Override
    public String toString() {
        return "BuyAggregate{" +
            "user='" + this.user + '\'' +
            ", cart='" + this.cart + '\'' +
            ", id='" + id + '\'' +
            ", type='" + type + '\'' +
            ", version=" + version +
            ", changes=" + changes.size() +
        '}';
    }

}
