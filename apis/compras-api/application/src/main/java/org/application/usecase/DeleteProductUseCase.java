package org.application.usecase;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.application.service.DeleteProductService;
import org.domain.BuyAggregate;
import org.domain.commands.DeleteProductInCart;
import org.domain.values.identificators.ProductID;
import org.eclipse.microprofile.opentracing.Traced;
import org.quarkus.database.EventStoreDB;
import java.util.logging.Logger;

@ApplicationScoped
public class DeleteProductUseCase implements DeleteProductService {

    private final Logger logger = Logger.getLogger("DeleteProductUseCase.class");
    @Inject/*-->*/ EventStoreDB eventStoreDB;

    @Traced/**/@Override
    public Uni<Void> apply(DeleteProductInCart command) {

        return eventStoreDB

            .load(command.buyID(), BuyAggregate.class)

            .onItem().transform(aggregate -> {
                aggregate.deleteProduct(ProductID.of(command.productId()));
                return aggregate;
            })

            .chain(aggregate -> eventStoreDB.save(aggregate))

            .onItem().invoke( () -> logger.info( String.format( "delete product: %s in buy: %s ", command.productId(), command.buyID() ) ) );

    }

}
