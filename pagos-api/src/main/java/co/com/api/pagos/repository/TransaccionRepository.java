package co.com.api.pagos.repository;

import co.com.api.pagos.entity.Transaccion;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransaccionRepository implements ReactivePanacheMongoRepositoryBase<Transaccion, String> {
}
