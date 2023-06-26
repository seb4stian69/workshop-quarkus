package co.com.infrastructure.dto;

import co.com.infrastructure.dto.utils.ProductDTO;
import java.util.List;

public record CreatBuyRequestDto
(
        String userID,
        String userName,
        Integer cardNumber,
        List<ProductDTO> cart
)
{/*DataClass*/}