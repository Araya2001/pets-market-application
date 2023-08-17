package pets.market.repository;

import pets.market.domain.InventoryItem;

public interface InventoryItemRepository extends BaseDomainRepository<InventoryItem, Long> {
} // acá en lugar de "SALE" no deberia de ir "InventoryItem"?
