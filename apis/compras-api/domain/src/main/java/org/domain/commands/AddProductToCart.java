package org.domain.commands;

import org.domain.commands.utils.ProductToCommand;

public record AddProductToCart
(
    String buyID,
    ProductToCommand product
)
{/*DataClass*/}
