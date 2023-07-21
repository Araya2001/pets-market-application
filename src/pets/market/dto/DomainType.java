package pets.market.dto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum DomainType {
    SALE_ENTITY("Sale", "Domain Class for Sale Entity"),
    INVENTORY_ITEM_ENTITY("Inventory Item", "Domain Class for Inventory Item Entity"),
    SHOPPING_CART_ENTITY("Shopping Cart", "Domain Class for Shopping Cart Entity");

    private final String name;
    private final String description;

    DomainType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<DomainType> findByPredicate(Predicate<DomainType> domainTypePredicate) {
        return Arrays.stream(DomainType.values()).filter(domainTypePredicate).collect(Collectors.toList());
    }

}
