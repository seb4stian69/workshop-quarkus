package co.com.infrastructure.repository;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.opentracing.Traced;

@ApplicationScoped
@Traced
public class BankAccountMongoPanacheRepository implements ReactivePanacheMongoRepository<BankAccountDocument> {

    public Uni<BankAccountDocument> findByAggregateId(String aggregateId) {
        return find("aggregateId", aggregateId).firstResult();
    }

    public Uni<Long> deleteByAggregateId(String aggregateId) {
        return delete("aggregateId", aggregateId);
    }

    public Uni<List<BankAccountDocument>> findAllSortByBalanceWithPagination(Page page) {
        return findAll(Sort.ascending("balance")).page(page).list();
    }
}
