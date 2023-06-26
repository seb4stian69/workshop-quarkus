package org.application.usecase;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.application.service.AddProductToCartService;
import org.application.usecase.mapper.ProductCommandToEntityProduct;
import org.domain.BuyAggregate;
import org.domain.commands.AddProductToCart;
import org.eclipse.microprofile.opentracing.Traced;
import org.quarkus.database.EventStoreDB;
import java.util.logging.Logger;

@ApplicationScoped
public class AddProductToCartUseCase implements AddProductToCartService {

    private final Logger logger = Logger.getLogger("AddProductToCartUseCase.class");
    @Inject/*-->*/ EventStoreDB eventStoreDB;

    @Traced/**/@Override
    public Uni<Void> apply(AddProductToCart command) {

        return eventStoreDB

            .load(command.buyID(), BuyAggregate.class)

            .onItem().transform(aggregate -> {
                aggregate.addProduct(ProductCommandToEntityProduct.mapper(command.product()));
                return aggregate;
            })

            .chain(aggregate -> eventStoreDB.save(aggregate))

            .onItem().invoke( () -> logger.info( String.format( "add product: %s to buyCart: %s", command.product(), command.buyID() ) ) );

    }

}
