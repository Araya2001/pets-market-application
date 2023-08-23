/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;

import pets.market.domain.User;
import pets.market.dto.RoleType;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

public class UserMenu {
  private final BaseDomainRepository<User, String> repository;
  private final JOptionPaneWrapper gui;

  public UserMenu(BaseDomainRepository<User, String> repository, JOptionPaneWrapper gui) {
    this.repository = repository;
    this.gui = gui;
  }

  public void createUser() {
    User user = new User();
    String[] typeButton = {"Administrador", "Cajero"};
    try {
      user.setFirstName(gui.doRequestInputData("Ingrese el nombre del usuario:"))
          .setLastName(gui.doRequestInputData("Ingrese el apellido del usuario"))
          .setPassword(gui.doRequestInputData("Ingrese la contraseña que desea asignarle a este usuario"))
          .setRoleType(RoleType.findByPredicate(roleType -> roleType.getType().equals(gui.doShowInputMenu("Seleccione el tipo de usuario:", "USUARIO", typeButton, 0))).orElse(RoleType.SELLER))
          .setId(gui.doRequestInputData("Ingrese la cédula del usuario:"));
      if (repository.save(user) != null) {
        gui.doShowOutputData("Usuario guardado con éxito");
      } else {
        gui.doShowErrorData("Usuario no pudo ser guardado!!!");
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void modifyUser() {
    String[] typeButton = {"Administrador", "Cajero"};
    try {
      User user = repository.findById(gui.doRequestInputData("Ingrese la cédula del usuario a modificar:")).orElse(null);
      if (user != null) {
        user.setFirstName(gui.doRequestInputData("Ingrese el nombre del usuario:"))
            .setLastName(gui.doRequestInputData("Ingrese el apellido del usuario"))
            .setPassword(gui.doRequestInputData("Ingrese la contraseña que desea asignarle a este usuario"))
            .setRoleType(RoleType.findByPredicate(roleType -> roleType.getType().equals(gui.doShowInputMenu("Seleccione el tipo de usuario:", "USUARIO", typeButton, 0))).orElse(RoleType.SELLER))
            .setId(gui.doRequestInputData("Ingrese la cédula del usuario:"));
      } else {
        gui.doShowErrorData("No se logró encontrar el usuario especificado");
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void deleteUser() {
    try {
      User user = repository.findById(gui.doRequestInputData("Ingrese la cédula del usuario a eliminar:")).orElse(null);
      if (user != null) {
        if (repository.delete(user)) {
          gui.doShowOutputData("Usuario se eliminó con éxito");
        } else {
          gui.doShowErrorData("Usuario no logró ser eliminado!!!");
        }
      } else {
        gui.doShowErrorData("No se logró encontrar el usuario especificado");
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void showAll() {
    StringBuffer sb = new StringBuffer();
    try {
      for (int i = 0; i < repository.findAll().length; i++) {
        if (repository.findAll()[i] != null) {
          sb.append(i + 1).append(". ").append(repository.findAll()[i]);
        }
      }
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void query() {
    StringBuffer sb = new StringBuffer();
    try {
      repository.findById(gui.doRequestInputData("Ingrese la cédula del usuario a consultar:")).ifPresent(sb::append);
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }
}
