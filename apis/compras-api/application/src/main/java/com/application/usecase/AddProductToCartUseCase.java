package com.application.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.application.gateway.ShopDomainEventRepository;
import com.application.generic.UseCaseForCommand;
import com.domain.Buy;
import com.domain.commands.AddProductToCart;
import com.domain.entities.Product;
import com.domain.value.BuyID;
import com.domain.value.ImgUrl;
import com.domain.value.PName;
import com.domain.value.Price;
import com.domain.value.ProductID;
import com.domain.value.Quantity;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class AddProductToCartUseCase extends UseCaseForCommand<AddProductToCart> {

    // + ------------------------         Utils         ------------------------ + //

    private final ShopDomainEventRepository repository;

    // + ------------------------      Constructor       ------------------------ + //

    public AddProductToCartUseCase(ShopDomainEventRepository repository) {
        this.repository = repository;
    }

    // + ------------------------    Command actions     ------------------------ + //

    @Override
    public Multi<DomainEvent> apply(Uni<AddProductToCart> input) {
        return input
        .toMulti()
        .onItem().transformToUni( command -> repository
            .getEventBy(command.getBuyID())
            .collect()
            .asList()
            .map(events -> {

                 BuyID buyID = BuyID.of(command.getBuyID());
                 Buy buy = Buy.from(buyID, events);

                 Product product = new Product(
                    ProductID.of(command.getProductID()),
                    PName.of(command.getName()),
                    Quantity.of(command.getQuantity()),
                    Price.of(command.getPrice()),
                    ImgUrl.of(command.getImageUrl())
                 );

                buy.addProductToCart(buyID, product);
                return Multi.createFrom().iterable(buy.getUncommittedChanges());

            })
        ).concatenate().flatMap(events -> events);
    }

}
