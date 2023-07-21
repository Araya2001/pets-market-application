package pets.market.repository;

import pets.market.domain.Sale;
import pets.market.service.JsonPersistService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class InventoryItemRepositoryImpl implements InventoryItemRepository {

    private final JsonPersistService<Sale> saleJsonPersistService;

    public InventoryItemRepositoryImpl(JsonPersistService<Sale> saleJsonPersistService) {
        this.saleJsonPersistService = saleJsonPersistService;
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Sale> findAll() {
        return null;
    }

    @Override
    public List<Sale> findByPredicate(Predicate<Sale> salePredicate) {
        return null;
    }

    @Override
    public List<Sale> saveAll(List<Sale> list) {
        return null;
    }

    @Override
    public List<Sale> updateAll(List<Sale> list) {
        return null;
    }

    @Override
    public Sale save(Sale sale) {
        return null;
    }

    @Override
    public Sale update(Sale sale) {
        return null;
    }

    @Override
    public Boolean delete(Sale sale) {
        return null;
    }

    @Override
    public Boolean deleteAll(List<Sale> list) {
        return null;
    }
}
