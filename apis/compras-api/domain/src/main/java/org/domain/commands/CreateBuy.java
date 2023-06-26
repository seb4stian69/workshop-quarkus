package org.domain.commands;

import org.domain.commands.utils.ProductToCommand;

import java.util.List;

public record CreateBuy
(
    String userID,
    String userName,
    Integer cardNumber,
    List<ProductToCommand> cart
)
{/*DataClass*/}

