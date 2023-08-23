/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.domain;

import java.util.Objects;

public class Customer extends BaseEntity<String> {
  private String fullName;
  private String email;
  private String phoneNumber;

  public String getFullName() {
    return fullName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Customer setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public Customer setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Customer setEmail(String email) {
    this.email = email;
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
    Customer customer = (Customer) o;
    return Objects.equals(fullName, customer.fullName) && Objects.equals(email, customer.email) && Objects.equals(phoneNumber, customer.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, email, phoneNumber);
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Customer{");
    sb.append("fullName='").append(fullName).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append(", id=").append(id);
    sb.append('}');
    return sb.toString();
  }
}



