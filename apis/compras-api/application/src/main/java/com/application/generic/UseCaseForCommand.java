package com.application.generic;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.generic.DomainEvent;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.function.Function;

public abstract class UseCaseForCommand<R extends Command> implements Function<Uni<R>, Multi<DomainEvent>> {
    public abstract Multi<DomainEvent> apply(Uni<R> rUni);
}