package co.com.api.pagos.entity;

import co.com.api.pagos.client.SolicitudDTO;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "transacciones")
public class Transaccion {
    @BsonProperty("id")
    private String id= UUID.randomUUID().toString().substring(0, 10);
    private SolicitudDTO solicitudDTO;
    private Boolean estado;
    private Date timestamp;
}
