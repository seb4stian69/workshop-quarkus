package org.domain.commands;

public record UpdateProductInCart
(
    String buyID,
    String productId,
    Integer quantity
)
{/*DataClass*/}