package pets.market.domain;

import java.util.HashMap;

public class ShoppingCart {
    private Long id;
    private Object customer;
    private HashMap<String, Integer> inventoryItems;

    public Long getId() {
        return id;
    }

    public ShoppingCart setId(Long id) {
        this.id = id;
        return this;
    }

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
}
