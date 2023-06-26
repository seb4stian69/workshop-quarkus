package org.application.service;

import io.smallrye.mutiny.Uni;
import org.domain.commands.DeleteProductInCart;

public interface DeleteProductService {
    Uni<Void> apply(DeleteProductInCart command);

}
