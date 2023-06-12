package com.domain;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.domain.entities.Product;
import com.domain.entities.User;
import com.domain.events.BuyCreated;
import com.domain.events.ProductAdded;
import com.domain.events.ProductDeleted;
import com.domain.events.ProductUpdated;
import com.domain.value.BuyID;
import com.domain.value.ProductID;
import com.domain.value.Quantity;

import java.util.List;
import java.util.Objects;

public class Buy extends AggregateEvent<BuyID> {

    // + ------------------------      Atributes      ------------------------ + //

    protected User user;
    protected List<Product> cart;

    // + ------------------------     Constructor     ------------------------ + //

    public Buy(BuyID entityId, List<Product> cart, User user) {
        super(entityId);
        this.cart = cart;
        this.user = user;
        subscribe(new BuyChange(this));
        appendChange(new BuyCreated(entityId, cart, user)).apply();
    }

    public Buy(BuyID entityId) {
        super(entityId);
        subscribe(new BuyChange(this));
    }

    public static Buy from(BuyID entityId, List<DomainEvent> events){
        var buy = new Buy(entityId);
        events.forEach(buy::applyEvent);
        return buy;
    }

    // + ------------------------ Commands and Events ------------------------ + //

    public void addProductToCart(BuyID buyID, Product product){

        Objects.requireNonNull(buyID, "La identificacion de la compra es necesaria para poder agregarle un producto al carrito");
        Objects.requireNonNull(product, "El producto a agregar es necesario para poder registrarlo en el carrito");

        appendChange(
            new ProductAdded(buyID, product)
        ).apply();

    }

    public void updateProductInCart(String buyID, String productID, Integer quantity){

        Objects.requireNonNull(buyID, "La identificacion de la compra es necesaria para poder actualizar un producto en el carrito");
        Objects.requireNonNull(productID, "La identificacion del producto es necesaria para poder actualizar el producto en el carrito");
        Objects.requireNonNull(quantity, "La cantidad es necesaria para poder actualizarla en el carrito");

        appendChange(
                new ProductUpdated(BuyID.of(buyID), ProductID.of(productID), Quantity.of(quantity))
        ).apply();

    }

    public void deleteProductInCart(String buyID, String productID){

        Objects.requireNonNull(buyID, "La identificacion de la compra es necesaria para poder eliminar un producto en el carrito");
        Objects.requireNonNull(productID, "La identificacion del producto es necesaria para poder eliminar el producto en el carrito");

        appendChange(
                new ProductDeleted(BuyID.of(buyID), ProductID.of(productID))
        ).apply();

    }

}
