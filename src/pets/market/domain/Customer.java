/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.domain;

import java.util.Objects;

public class Customer extends BaseEntity<String> {
  public String fullName;
  public String email;

  // Constructor
  public Customer(String fullName, String email, String id) {
    this.fullName = fullName;
    this.email = email;
  }

  // Método "get" para fullName
  public String getFullName() {
    return fullName;
  }

  // Método "set" para fullName
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  // Método "get" para email
  public String getEmail() {
    return email;
  }

  // Método "set" para email
  public void setEmail(String email) {
    this.email = email;
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
    return Objects.equals(fullName, customer.fullName) && Objects.equals(email, customer.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fullName, email);
  }

  @Override
  public String toString() {
    String sb = "Customer{" + "fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        '}';
    return sb;
  }
}



