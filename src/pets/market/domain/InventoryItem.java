package pets.market.domain;

/**
 * @author Valeria
 */
public class InventoryItem extends BaseEntity<Long> {

    private Object petType;
    private String name;
    private Double priceValue;
    private Integer quantity;
    private Object itemType;

    public Object getPetType() {
        return petType;
    }

    public InventoryItem setPetType(Object petType) {
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

    public Object getItemType() {
        return itemType;
    }

    public InventoryItem setItemType(Object itemType) {
        this.itemType = itemType;
        return this;
    }
}
