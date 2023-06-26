package org.application.service;

import io.smallrye.mutiny.Uni;
import org.domain.commands.AddProductToCart;

public interface AddProductToCartService {
    Uni<Void> apply(AddProductToCart command);
}
