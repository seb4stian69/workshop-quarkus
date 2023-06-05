package co.com.api.pagos.repository;

import co.com.api.pagos.entity.Transaccion;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransaccionRepository implements PanacheMongoRepositoryBase<Transaccion, String> {
}
