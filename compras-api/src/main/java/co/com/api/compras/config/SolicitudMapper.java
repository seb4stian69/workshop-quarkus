package co.com.api.compras.config;

import co.com.api.compras.dto.SolicitudDTO;
import co.com.api.compras.entity.Solicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SolicitudMapper {
    Solicitud toEntity (SolicitudDTO solicitudDTO);

    @Mapping(target = "id", expression = "java(solicitud.getId())")
    SolicitudDTO toDto (Solicitud solicitud);
}
