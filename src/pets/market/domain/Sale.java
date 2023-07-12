package pets.market.domain;

import java.util.HashMap;

public class Sale {
    private Long id;
    private Object saleByUser;
    private Object customer;
    private HashMap<String, Integer> inventoryItems;
    private Object taxType;
    private Double subTotalChargeValue;
    private Double totalChargeValue;

    public Long getId() {
        return id;
    }

    public Sale setId(Long id) {
        this.id = id;
        return this;
    }

    public Object getSaleByUser() {
        return saleByUser;
    }

    public Sale setSaleByUser(Object saleByUser) {
        this.saleByUser = saleByUser;
        return this;
    }

    public Object getCustomer() {
        return customer;
    }

    public Sale setCustomer(Object customer) {
        this.customer = customer;
        return this;
    }

    public HashMap<String, Integer> getInventoryItems() {
        return inventoryItems;
    }

    public Sale setInventoryItems(HashMap<String, Integer> inventoryItems) {
        this.inventoryItems = inventoryItems;
        return this;
    }

    public Object getTaxType() {
        return taxType;
    }

    public Sale setTaxType(Object taxType) {
        this.taxType = taxType;
        return this;
    }

    public Double getSubTotalChargeValue() {
        return subTotalChargeValue;
    }

    public Sale setSubTotalChargeValue(Double subTotalChargeValue) {
        this.subTotalChargeValue = subTotalChargeValue;
        return this;
    }

    public Double getTotalChargeValue() {
        return totalChargeValue;
    }

    public Sale setTotalChargeValue(Double totalChargeValue) {
        this.totalChargeValue = totalChargeValue;
        return this;
    }
}
