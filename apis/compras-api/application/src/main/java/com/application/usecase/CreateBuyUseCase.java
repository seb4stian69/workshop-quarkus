package com.application.usecase;

import co.com.sofka.domain.generic.DomainEvent;
import com.application.gateway.ShopDomainEventRepository;
import com.application.generic.UseCaseForCommand;
import com.domain.Buy;
import com.domain.commands.CreateBuy;
import com.domain.entities.User;
import com.domain.value.BuyID;
import com.domain.value.CardNumber;
import com.domain.value.UName;
import com.domain.value.UserID;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class CreateBuyUseCase extends UseCaseForCommand<CreateBuy> {

    // + ------------------------         Utils         ------------------------ + //

    private final ShopDomainEventRepository repository;

    // + ------------------------      Constructor       ------------------------ + //

    public CreateBuyUseCase(ShopDomainEventRepository repository) {
        this.repository = repository;
    }

    // + ------------------------    Command actions     ------------------------ + //

    @Override
    public Multi<DomainEvent> apply(Uni<CreateBuy> input) {
        return input
        .toMulti()
        .onItem().transformToUni( command -> repository
            .getEventBy(command.getBuyID())
            .collect()
            .asList()
            .map(events -> {

                User user = new User(
                    UserID.of(command.getUserID()),
                    UName.of(command.getFirstName(), command.getLastName()),
                    CardNumber.of(command.getCardNumber())
                );

                Buy buy = new Buy(BuyID.of(command.getBuyID()), command.getProducts(), user);
                return Multi.createFrom().iterable(buy.getUncommittedChanges());

            })
        ).concatenate().flatMap(events -> events);
    }

}
