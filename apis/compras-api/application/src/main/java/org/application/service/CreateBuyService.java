package org.application.service;

import io.smallrye.mutiny.Uni;
import org.domain.commands.CreateBuy;

public interface CreateBuyService {
    Uni<String> apply(CreateBuy command);
}
