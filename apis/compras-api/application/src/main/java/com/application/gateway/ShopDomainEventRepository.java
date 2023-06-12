package com.application.gateway;

import co.com.sofka.domain.generic.DomainEvent;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface ShopDomainEventRepository {
    Multi<DomainEvent> getEventBy(String id);
    Uni<Boolean> exist(String id);
}