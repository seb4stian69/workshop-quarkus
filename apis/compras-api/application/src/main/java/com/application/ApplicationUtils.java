package com.application;

import com.application.gateway.ModelProduct;
import com.domain.entities.Product;
import com.domain.value.ImgUrl;
import com.domain.value.PName;
import com.domain.value.Price;
import com.domain.value.ProductID;
import com.domain.value.Quantity;

public class ApplicationUtils {

    private ApplicationUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Product ConvertModelProductToProduct(ModelProduct modelProduct){

        return new Product(
            ProductID.of(modelProduct.getProductID()),
            PName.of(modelProduct.getName()),
            Quantity.of(modelProduct.getQuantity()),
            Price.of(modelProduct.getPrice()),
            ImgUrl.of(modelProduct.getImageUrl())
        );

    }

}
