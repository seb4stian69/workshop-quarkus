package com.domain.entities;

import co.com.sofka.domain.generic.Entity;
import com.domain.value.ImgUrl;
import com.domain.value.PName;
import com.domain.value.Price;
import com.domain.value.ProductID;
import com.domain.value.Quantity;
import lombok.Getter;
import lombok.Setter;

@Getter/*-*/@Setter
public class Product extends Entity<ProductID> {

    private PName name;
    private Quantity quantity;
    private Price price;
    private ImgUrl imageUrl;

    public  Product(ProductID id, PName name, Quantity quantity, Price price, ImgUrl imageUrl) {
        super(id);
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageUrl = imageUrl;
    }

}
