package org.application.usecase;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.application.service.UpdateProductService;
import org.domain.BuyAggregate;
import org.domain.commands.UpdateProductInCart;
import org.domain.values.Quantity;
import org.domain.values.identificators.ProductID;
import org.eclipse.microprofile.opentracing.Traced;
import org.quarkus.database.EventStoreDB;
import java.util.logging.Logger;

@ApplicationScoped
public class UpdateProductUseCase implements UpdateProductService {

    private final Logger logger = Logger.getLogger("DeleteProductUseCase.class");
    @Inject/*-->*/ EventStoreDB eventStoreDB;

    @Traced/**/@Override
    public Uni<Void> apply(UpdateProductInCart command) {

        return eventStoreDB

            .load(command.buyID(), BuyAggregate.class)

            .onItem().transform(aggregate -> {
                aggregate.updateProduct(ProductID.of(command.productId()), Quantity.of(command.quantity()));
                return aggregate;
            })

            .chain(aggregate -> eventStoreDB.save(aggregate))

            .onItem().invoke( () -> logger.info( String.format( "update product: %s in buy: %s ", command.productId(), command.buyID() ) ) );

    }

}
