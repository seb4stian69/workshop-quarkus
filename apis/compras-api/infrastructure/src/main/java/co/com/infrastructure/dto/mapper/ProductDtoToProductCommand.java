package co.com.infrastructure.dto.mapper;

import co.com.infrastructure.dto.utils.ProductDTO;
import org.domain.commands.utils.ProductToCommand;

public class ProductDtoToProductCommand {

    private ProductDtoToProductCommand(){/*Utility class*/}

    public static ProductToCommand mapper(ProductDTO productDto){
        return new ProductToCommand(
                productDto.getProductID(),
                productDto.getName(),
                productDto.getQuantity(),
                productDto.getPrice(),
                productDto.getImageUrl()
        );
    }

}
