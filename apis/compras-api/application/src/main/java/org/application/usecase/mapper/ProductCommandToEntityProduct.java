package org.application.usecase.mapper;

import org.domain.commands.utils.ProductToCommand;
import org.domain.entities.Product;
import org.domain.values.ImgUrl;
import org.domain.values.Price;
import org.domain.values.ProductName;
import org.domain.values.Quantity;
import org.domain.values.identificators.ProductID;

public class ProductCommandToEntityProduct {

    private ProductCommandToEntityProduct(){/*Utility class*/}

    public static Product mapper(ProductToCommand productCommand){
        return new Product(
                ProductID.of(productCommand.getProductID()),
                ProductName.of(productCommand.getName()),
                Quantity.of(productCommand.getQuantity()),
                Price.of(productCommand.getPrice()),
                ImgUrl.of(productCommand.getImageUrl())
        );
    }

}
