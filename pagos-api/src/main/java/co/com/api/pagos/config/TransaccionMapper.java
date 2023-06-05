package co.com.api.pagos.config;

import co.com.api.pagos.dto.TransaccionDTO;
import co.com.api.pagos.entity.Transaccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface TransaccionMapper {

    Transaccion toEntity(TransaccionDTO transaccionDTO);

    @Mapping(target = "id", expression = "java(transaccion.getId())")
    TransaccionDTO toDto (Transaccion transaccion);
}
