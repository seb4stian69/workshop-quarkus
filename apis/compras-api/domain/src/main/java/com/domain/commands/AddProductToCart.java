package com.domain.commands;

import co.com.sofka.domain.generic.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter/*-*/@Setter
@AllArgsConstructor/*-*/@NoArgsConstructor
public class AddProductToCart extends Command {

    private String buyID;
    private String productID;
    private String name;
    private Integer quantity;
    private Integer price;
    private String imageUrl;

}
