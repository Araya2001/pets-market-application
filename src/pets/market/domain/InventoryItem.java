package pets.market.domain;

import java.util.Objects;

/**
 * @author Valeria
 */
public class InventoryItem extends BaseEntity<String> {
  private String petType;
  private String name;
  private Double priceValue;
  private Integer quantity;
  private String itemType;

  public String getPetType() {
    return petType;
  }

  public InventoryItem setPetType(String petType) {
    this.petType = petType;
    return this;
  }

  public String getName() {
    return name;
  }

  public InventoryItem setName(String name) {
    this.name = name;
    return this;
  }

  public Double getPriceValue() {
    return priceValue;
  }

  public InventoryItem setPriceValue(Double priceValue) {
    this.priceValue = priceValue;
    return this;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public InventoryItem setQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  public String getItemType() {
    return itemType;
  }

  public InventoryItem setItemType(String itemType) {
    this.itemType = itemType;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InventoryItem that = (InventoryItem) o;
    return Objects.equals(petType, that.petType) && Objects.equals(name, that.name) && Objects.equals(priceValue, that.priceValue) && Objects.equals(quantity, that.quantity) && Objects.equals(itemType, that.itemType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(petType, name, priceValue, quantity, itemType);
  }

  @Override
  public String toString() {
    String sb = "InventoryItem{" + "petType=" + petType +
        ", name='" + name + '\'' +
        ", priceValue=" + priceValue +
        ", quantity=" + quantity +
        ", itemType=" + itemType +
        '}';
    return sb;
  }
}
