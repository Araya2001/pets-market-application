package pets.market.menu;

import pets.market.domain.User;
import pets.market.dto.RoleType;
import pets.market.service.JOptionPaneWrapper;

public class MainMenu {
  private final JOptionPaneWrapper gui;
  private final SalesMenu salesMenu;
  private final InventoryMenu inventoryMenu;
  private final UserMenu userMenu;
  private final User user;

  public MainMenu(JOptionPaneWrapper gui, SalesMenu salesMenu, InventoryMenu inventoryMenu, UserMenu userMenu, User user) {
    this.gui = gui;
    this.salesMenu = salesMenu;
    this.inventoryMenu = inventoryMenu;
    this.userMenu = userMenu;
    this.user = user;
  }

  public void drawMainMenu() {
    if (user.getRoleType().equals(RoleType.MANAGER)) {
      drawAdminMenu();
    } else {
      drawSellerMenu();
    }
  }

  private void drawSellerMenu() {
    String[] buttons = {"Ventas", "Salir"};
    int selection = 0;
    boolean isRunning = true;
    while (isRunning) {
      selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Menu Principal", buttons, 0);
      switch (selection) {
        case 0 -> salesMenu.drawSalesMenu();
        case 1 -> isRunning = false;
      }
    }
  }

  private void drawAdminMenu() {
    String[] buttons = {"Administración de Usuario", "Administración de Inventario", "Ventas", "Salir"};
    int selection = 0;
    boolean isRunning = true;
    while (isRunning) {
      selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Menu Principal", buttons, 0);
      switch (selection) {
        case 0 -> drawUserMenu();
        case 1 -> drawInventoryMenu();
        case 2 -> salesMenu.drawSalesMenu();
        case 3 -> isRunning = false;
      }
    }
  }

  private void drawUserMenu() {
    String[] buttons = {"Crear Usuario", "Modificar Usuario", "Eliminar Usuario", "Ver Usuarios", "Consultar Usuario", "Salir"};
    int selection = 0;
    boolean isRunning = true;
    while (isRunning) {
      selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Menu Principal", buttons, 0);
      switch (selection) {
        case 0 -> userMenu.createUser();
        case 1 -> userMenu.modifyUser();
        case 2 -> userMenu.deleteUser();
        case 3 -> userMenu.showAll();
        case 4 -> userMenu.query();
        case 5 -> isRunning = false;
      }
    }
  }

  private void drawInventoryMenu() {
    String[] buttons = {"Crear Item", "Modificar Item", "[","Salir"};
    int selection = 0;
    boolean isRunning = true;
    while (isRunning) {
      selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Menu Principal", buttons, 0);
      switch (selection) {
        case 0 -> inventoryMenu.createItem();
        case 1 -> inventoryMenu.modifyItem();
        case 2 -> isRunning = false;
      }
    }
  }
}
