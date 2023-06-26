package org.domain.commands.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor/**/@Data
public class ProductToCommand {
    private String productID;
    private String name;
    private Integer quantity;
    private Integer price;
    private String imageUrl;
}