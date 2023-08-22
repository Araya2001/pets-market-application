package pets.market.domain;

import java.util.HashMap;
import java.util.Objects;

public class Sale extends BaseEntity<Long> {
  private String saleByUser;
  private String customer;
  private HashMap<String, Integer> inventoryItems;
  private String taxType;
  private Double subTotalChargeValue;
  private Double totalChargeValue;

  public Object getSaleByUser() {
    return saleByUser;
  }

  public Sale setSaleByUser(String saleByUser) {
    this.saleByUser = saleByUser;
    return this;
  }

  public String getCustomer() {
    return customer;
  }

  public Sale setCustomer(String customer) {
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

  public String getTaxType() {
    return taxType;
  }

  public Sale setTaxType(String taxType) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sale sale = (Sale) o;
    return Objects.equals(saleByUser, sale.saleByUser) && Objects.equals(customer, sale.customer) && Objects.equals(inventoryItems, sale.inventoryItems) && Objects.equals(taxType, sale.taxType) && Objects.equals(subTotalChargeValue, sale.subTotalChargeValue) && Objects.equals(totalChargeValue, sale.totalChargeValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleByUser, customer, inventoryItems, taxType, subTotalChargeValue, totalChargeValue);
  }

  @Override
  public String toString() {
    String sb = "Sale{" + "saleByUser=" + saleByUser +
        ", customer=" + customer +
        ", inventoryItems=" + inventoryItems +
        ", taxType=" + taxType +
        ", subTotalChargeValue=" + subTotalChargeValue +
        ", totalChargeValue=" + totalChargeValue +
        '}';
    return sb;
  }
}
