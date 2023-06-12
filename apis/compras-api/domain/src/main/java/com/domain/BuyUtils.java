package com.domain;

import com.domain.entities.Product;
import com.domain.value.ProductID;

import java.util.List;
import java.util.stream.Collectors;

public class BuyUtils {

    private BuyUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Product findProductById(ProductID id, List<Product> products) {
        return products.stream()
            .filter( product -> id.value().equals(product.identity().value()) )
            .findFirst()
            .orElse(null);
    }

    public static List<Product> deleteProduct(ProductID id, List<Product> products) {
        return products.stream()
            .filter(product -> id.value().equals(product.identity().value()))
            .collect(Collectors.toList());
    }

}
