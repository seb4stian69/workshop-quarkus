package com.domain.commands;

import co.com.sofka.domain.generic.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter/*-*/@Setter
@AllArgsConstructor/*-*/@NoArgsConstructor
public class MakePaymentRequest extends Command {

    /*User*/
    private String firstName;
    private String lastName;
    private Integer cardNumber;
    /*Calc*/
    private Double total;
    /*Auto*/
    private final Instant date = Instant.now();

}
