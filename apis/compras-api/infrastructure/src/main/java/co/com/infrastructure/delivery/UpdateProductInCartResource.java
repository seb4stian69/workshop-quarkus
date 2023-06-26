package co.com.infrastructure.delivery;

import co.com.infrastructure.dto.UpdateProductInCartDto;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.application.service.UpdateProductService;
import org.domain.commands.UpdateProductInCart;
import org.jboss.logging.Logger;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.opentracing.Traced;

@Path(value = "/api/v1/buy/delete-product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UpdateProductInCartResource {

    private final Logger logger = Logger.getLogger(UpdateProductInCartResource.class);
    @Inject/*-->*/ UpdateProductService service;

    @POST
    @Traced
    @Retry(delay = 300)
    @Timeout(value = 5000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> createBanAccount(@Valid UpdateProductInCartDto dto) {

        final var command = new UpdateProductInCart(
            dto.buyID(),
            dto.productId(),
            dto.quantity()
        );

        logger.infof("UpdateProductInCartCommand: %s", command);

        return service.apply(command).onItem().transform(id -> Response.status(Response.Status.ACCEPTED).entity(id).build());

    }

}
