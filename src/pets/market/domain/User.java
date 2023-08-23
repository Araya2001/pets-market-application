/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.domain;

import pets.market.dto.RoleType;

import java.util.Objects;

public class User extends BaseEntity<String> {
  public String firstName;
  public String lastName;
  private String password;
  private RoleType roleType;

  public String getFirstName() {
    return firstName;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
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
    User user = (User) o;
    return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password) && roleType == user.roleType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, password, roleType);
  }

  public RoleType getRoleType() {
    return roleType;
  }

  public User setRoleType(RoleType roleType) {
    this.roleType = roleType;
    return this;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("User{");
    sb.append("firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", roleType=").append(roleType);
    sb.append(", id=").append(id);
    sb.append('}');
    return sb.toString();
  }
}




