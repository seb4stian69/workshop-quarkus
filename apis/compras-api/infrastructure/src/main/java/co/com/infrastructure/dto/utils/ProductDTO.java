package co.com.infrastructure.dto.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor/**/@Data
public class ProductDTO {
    private String productID;
    private String name;
    private Integer quantity;
    private Integer price;
    private String imageUrl;
}