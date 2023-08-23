/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pets.market.dto;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author diana
 */
public enum RoleType {
  SELLER(1),
  MANAGER(0);
  private final Integer type;

  RoleType(Integer type) {
    this.type = type;
  }

  public static Optional<RoleType> findByPredicate(Predicate<RoleType> roleTypePredicate) {
    return Arrays.stream(values()).filter(roleTypePredicate).findFirst();
  }

  public Integer getType() {
    return type;
  }
}
