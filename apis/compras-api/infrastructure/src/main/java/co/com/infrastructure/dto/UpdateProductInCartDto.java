package co.com.infrastructure.dto;

public record UpdateProductInCartDto
(
    String buyID,
    String productId,
    Integer quantity
)
{/*DataClass*/}