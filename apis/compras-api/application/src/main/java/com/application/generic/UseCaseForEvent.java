package com.application.generic;

import co.com.sofka.domain.generic.DomainEvent;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.function.Function;

public abstract class UseCaseForEvent<R extends DomainEvent>  implements Function<Uni<R>, Multi<DomainEvent>> {
    public abstract Multi<DomainEvent> apply(Uni<R> rMono);
}