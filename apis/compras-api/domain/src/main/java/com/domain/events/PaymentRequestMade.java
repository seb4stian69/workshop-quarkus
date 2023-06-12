package com.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.domain.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter/* */@Setter
public class PaymentRequestMade extends DomainEvent {

    private User user;
    private Double total;
    private Instant date;

    public PaymentRequestMade(User user, Double total, Instant date) {
        super("buys.paymentrequestmade");
        this.user = user;
        this.total = total;
        this.date = date;
    }

}
