package com.domain.commands;

import co.com.sofka.domain.generic.Command;
import com.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter/*-*/@Setter
@AllArgsConstructor/*-*/@NoArgsConstructor
public class CreateBuy extends Command {

    private String firstName;
    private String lastName;
    private Integer cardNumber;
    private String buyID;
    private List<Product> products;

}
