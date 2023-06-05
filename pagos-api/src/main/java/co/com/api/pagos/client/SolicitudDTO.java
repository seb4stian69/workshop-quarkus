package co.com.api.pagos.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
    private String id;
    private Usuario usuario;
    private Double total;
    private Date timestamp;
}
