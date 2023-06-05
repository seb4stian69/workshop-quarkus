package co.com.api.compras.repository;

import co.com.api.compras.entity.Solicitud;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SolicitudRepository implements ReactivePanacheMongoRepositoryBase<Solicitud, String> {
}
