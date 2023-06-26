package org.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.domain.values.ImgUrl;
import org.domain.values.Price;
import org.domain.values.ProductName;
import org.domain.values.Quantity;
import org.domain.values.identificators.ProductID;

@Data/**/@AllArgsConstructor
public class Product {

    private ProductID productID;
    private ProductName name;
    private Quantity quantity;
    private Price price;
    private ImgUrl imageUrl;

}
