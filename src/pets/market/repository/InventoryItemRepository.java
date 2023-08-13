package pets.market.repository;

import pets.market.domain.Sale;

public interface InventoryItemRepository extends BaseDomainRepository<Sale, Long> {
} // acá en lugar de "SALE" no deberia de ir "InventoryItem"?
