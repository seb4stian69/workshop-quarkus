package org.application.usecase;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.application.service.CreateBuyService;
import org.application.usecase.mapper.ProductCommandToEntityProduct;
import org.domain.BuyAggregate;
import org.domain.commands.CreateBuy;
import org.domain.entities.Product;
import org.domain.entities.User;
import org.domain.values.CardNumber;
import org.domain.values.UserName;
import org.domain.values.identificators.BuyID;
import org.domain.values.identificators.UserID;
import org.eclipse.microprofile.opentracing.Traced;
import org.quarkus.database.EventStoreDB;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@ApplicationScoped
public class CreateBuyUseCase implements CreateBuyService {

    private final Logger logger = Logger.getLogger("CreateBuyUseCase.class");
    @Inject/*-->*/ EventStoreDB eventStoreDB;

    @Traced/**/@Override
    public Uni<String> apply(CreateBuy command) {

        final BuyID buyID = BuyID.of(UUID.randomUUID().toString());
        final BuyAggregate aggregate = new BuyAggregate(buyID);

        final User user = new User(
            UserID.of(command.userID()),
            UserName.of(command.userName()),
            CardNumber.of(command.cardNumber())
        );

        List<Product> cart = command.cart().stream().map(ProductCommandToEntityProduct::mapper).toList();

        aggregate.createBuy(user, cart);

        return eventStoreDB.save(aggregate)
                .replaceWith(aggregate.getId())
                .onItem().invoke( () -> logger.info( String.format( "create buy: %s user: %s", buyID.getId(), command.userID() ) ) );

    }

}
