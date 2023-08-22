package pets.market.dto;

import pets.market.domain.InventoryItem;
import pets.market.domain.Sale;
import pets.market.domain.ShoppingCart;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum DomainType {
  SALE_ENTITY("Sale", "Domain Class for Sale Entity", Sale.class),
  INVENTORY_ITEM_ENTITY("Inventory Item", "Domain Class for Inventory Item Entity", InventoryItem.class),
  SHOPPING_CART_ENTITY("Shopping Cart", "Domain Class for Shopping Cart Entity", ShoppingCart.class);
  private final String name;
  private final String description;
  private final Class<T> aClass;

  DomainType(String name, String description, Class<T> aClass) {
    this.name = name;
    this.description = description;
    this.aClass = aClass;
  }

  public static List<DomainType> findByPredicate(Predicate<DomainType> domainTypePredicate) {
    return Arrays.stream(DomainType.values()).filter(domainTypePredicate).collect(Collectors.toList());
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Class<T> getaClass() {
    return aClass;
  }
}
