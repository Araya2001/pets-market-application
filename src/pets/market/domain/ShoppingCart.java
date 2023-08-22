package pets.market.domain;

import java.util.HashMap;
import java.util.Objects;

public class ShoppingCart extends BaseEntity<Long> {
  private Object customer;
  private HashMap<String, Integer> inventoryItems;

  public Object getCustomer() {
    return customer;
  }

  public ShoppingCart setCustomer(Object customer) {
    this.customer = customer;
    return this;
  }

  public HashMap<String, Integer> getInventoryItems() {
    return inventoryItems;
  }

  public ShoppingCart setInventoryItems(HashMap<String, Integer> inventoryItems) {
    this.inventoryItems = inventoryItems;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ShoppingCart that = (ShoppingCart) o;
    return Objects.equals(customer, that.customer) && Objects.equals(inventoryItems, that.inventoryItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, inventoryItems);
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("ShoppingCart{");
    sb.append("customer=").append(customer);
    sb.append(", inventoryItems=").append(inventoryItems);
    sb.append('}');
    return sb.toString();
  }
}
