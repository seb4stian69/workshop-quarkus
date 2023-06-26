package org.application.service;

import io.smallrye.mutiny.Uni;
import org.domain.commands.UpdateProductInCart;

public interface UpdateProductService {
    Uni<Void> apply(UpdateProductInCart command);

}
