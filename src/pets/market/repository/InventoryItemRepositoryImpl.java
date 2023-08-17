package pets.market.repository;

import pets.market.domain.InventoryItem;
import pets.market.service.JsonPersistService;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class InventoryItemRepositoryImpl implements InventoryItemRepository {

    private final JsonPersistService<InventoryItem> inventoryItemJsonPersistService;

    public InventoryItemRepositoryImpl(JsonPersistService<InventoryItem> inventoryItemJsonPersistService) {
        this.inventoryItemJsonPersistService = inventoryItemJsonPersistService;
    }

    @Override
    public Optional<InventoryItem> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<InventoryItem> findAll() {
        return null;
    }

    @Override
    public List<InventoryItem> findByPredicate(Predicate<InventoryItem> salePredicate) {
        return null;
    }

    @Override
    public List<InventoryItem> saveAll(List<InventoryItem> list) {
        return null;
    }

    @Override
    public List<InventoryItem> updateAll(List<InventoryItem> list) {
        return null;
    }

    @Override
    public InventoryItem save(InventoryItem sale) {
        return null;
    }

    @Override
    public InventoryItem update(InventoryItem sale) {
        return null;
    }

    @Override
    public Boolean delete(InventoryItem sale) {
        return null;
    }

    @Override
    public Boolean deleteAll(List<InventoryItem> list) {
        return null;
    }
}
