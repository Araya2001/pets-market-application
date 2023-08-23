/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Valeria
 */
public class Appointment extends BaseEntity<String> {
  private LocalDateTime date;
  private String customerId;

  public LocalDateTime getDate() {
    return date;
  }

  public Appointment setDate(LocalDateTime date) {
    this.date = date;
    return this;
  }

  public String getCustomerId() {
    return customerId;
  }

  public Appointment setCustomerId(String customerId) {
    this.customerId = customerId;
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
    Appointment that = (Appointment) o;
    return Objects.equals(date, that.date) && Objects.equals(customerId, that.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, customerId);
  }

  @Override
  public String toString() {
    String sb = "Appointment{" + "date=" + date +
        ", customerId='" + customerId + '\'' +
        '}';
    return sb;
  }
}
