package co.com.infrastructure.dto;

import co.com.infrastructure.dto.utils.ProductDTO;

public record AddProductToCartDto
(
    String buyID,
    ProductDTO product
)
{/*DataClass*/}