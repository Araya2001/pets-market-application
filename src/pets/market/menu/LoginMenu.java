package pets.market.menu;

import pets.market.domain.User;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

public class LoginMenu {
  private final BaseDomainRepository<User, String> repository;
  private final JOptionPaneWrapper gui;

  public LoginMenu(BaseDomainRepository<User, String> repository, JOptionPaneWrapper gui) {
    this.repository = repository;
    this.gui = gui;
  }

  public User doLogin() {
    User user = repository.findById(gui.doRequestInputData("Ingrese la cédula del usuario:")).orElse(null);
    if (user != null) {
      if (user.getPassword().equals(gui.doRequestInputData("Ingrese su contraseña:"))) {
        return user;
      }
    }
    return null;
  }
}
