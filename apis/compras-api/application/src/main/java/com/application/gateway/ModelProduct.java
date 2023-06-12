package com.application.gateway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter/*-*/@Setter
@AllArgsConstructor/*-*/@NoArgsConstructor
public class ModelProduct {

    private String productID;
    private String name;
    private Integer quantity;
    private Integer price;
    private String imageUrl;

}
