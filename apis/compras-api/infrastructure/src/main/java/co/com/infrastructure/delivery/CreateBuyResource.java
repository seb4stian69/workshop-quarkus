package co.com.infrastructure.delivery;

import co.com.infrastructure.dto.CreatBuyRequestDto;
import co.com.infrastructure.dto.mapper.ProductDtoToProductCommand;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.application.usecase.CreateBuyUseCase;
import org.domain.commands.CreateBuy;
import org.jboss.logging.Logger;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.opentracing.Traced;

@Path(value = "/api/v1/buy/make")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreateBuyResource {

    private final Logger logger = Logger.getLogger(CreateBuyResource.class);
    @Inject/*-->*/ CreateBuyUseCase service;

    @POST
    @Traced
    @Retry(delay = 300)
    @Timeout(value = 5000)
    @CircuitBreaker(requestVolumeThreshold = 30, delay = 3000, failureRatio = 0.6)
    public Uni<Response> createBanAccount(@Valid CreatBuyRequestDto dto) {

        final var command = new CreateBuy(
            dto.userID(),
            dto.userName(),
            dto.cardNumber(),
            dto.cart().stream().map(ProductDtoToProductCommand::mapper).toList()
        );

        logger.infof("CreateBuyCommand: %s", command);

        return service.apply(command).onItem().transform(id -> Response.status(Response.Status.CREATED).entity(id).build());

    }

}
