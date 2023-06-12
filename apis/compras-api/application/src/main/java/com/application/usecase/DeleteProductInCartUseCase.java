package com.application.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.application.gateway.ShopDomainEventRepository;
import com.application.generic.UseCaseForCommand;
import com.domain.Buy;
import com.domain.commands.DeleteProductInCart;
import com.domain.value.BuyID;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class DeleteProductInCartUseCase extends UseCaseForCommand<DeleteProductInCart> {

    // + ------------------------         Utils         ------------------------ + //

    private final ShopDomainEventRepository repository;

    // + ------------------------      Constructor       ------------------------ + //

    public DeleteProductInCartUseCase(ShopDomainEventRepository repository) {
        this.repository = repository;
    }

    // + ------------------------    Command actions     ------------------------ + //

    @Override
    public Multi<DomainEvent> apply(Uni<DeleteProductInCart> input) {
        return input
        .toMulti()
        .onItem().transformToUni( command -> repository
            .getEventBy(command.getBuyID())
            .collect()
            .asList()
            .map(events -> {

                Buy buy = Buy.from(BuyID.of(command.getBuyID()), events);
                buy.deleteProductInCart(command.getBuyID(), command.getProductID());
                return Multi.createFrom().iterable(buy.getUncommittedChanges());

            })
        ).concatenate().flatMap(events -> events);
    }

}