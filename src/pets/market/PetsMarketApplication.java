package pets.market;

import pets.market.domain.*;
import pets.market.dto.RoleType;
import pets.market.menu.*;
import pets.market.repository.BaseDomainRepository;
import pets.market.repository.GenericDomainRepository;
import pets.market.service.JOptionPaneWrapper;
import pets.market.service.JOptionPaneWrapperImpl;

public class PetsMarketApplication {
  public static void main(String[] args) {
    JOptionPaneWrapper gui = new JOptionPaneWrapperImpl();
    User[] users = new User[10];
    InventoryItem[] inventoryItems = new InventoryItem[10];
    ShoppingCart[] shoppingCarts = new ShoppingCart[10];
    Sale[] sales = new Sale[10];
    Appointment[] appointments = new Appointment[10];
    Customer[] customers = new Customer[10];
    BaseDomainRepository<User, String> userRepository = new GenericDomainRepository<>(users);
    BaseDomainRepository<InventoryItem, String> inventoryRepository = new GenericDomainRepository<>(inventoryItems);
    BaseDomainRepository<ShoppingCart, Long> shoppingCartRepository = new GenericDomainRepository<>(shoppingCarts);
    BaseDomainRepository<Sale, Long> saleRepository = new GenericDomainRepository<>(sales);
    BaseDomainRepository<Appointment, String> appointmentRepository = new GenericDomainRepository<>(appointments);
    BaseDomainRepository<Customer, String> customerRepository = new GenericDomainRepository<>(customers);
    LoginMenu loginMenu = new LoginMenu(userRepository, gui);
    CustomerMenu customerMenu = new CustomerMenu(customerRepository, gui);
    AppointmentMenu appointmentMenu = new AppointmentMenu(appointmentRepository, gui, customerRepository);
    UserMenu userMenu = new UserMenu(userRepository, gui);
    ShoppingCartMenu shoppingCartMenu = new ShoppingCartMenu(shoppingCartRepository, inventoryRepository, customerRepository, gui);
    InventoryMenu inventoryMenu = new InventoryMenu(inventoryRepository, gui);
    // BLOQUE USUARIO
    User root = new User().setFirstName("root").setFirstName("Admin").setLastName("Root").setRoleType(RoleType.MANAGER).setPassword("Clave1234");
    root.setId("1");
    userRepository.save(root);
    // BLOQUE PRODUCTOS
    InventoryItem inventoryItem1 = new InventoryItem();

    while (gui.doRequestYesNoMenu("Desea ingresar a la aplicación?")) {
      User user = loginMenu.doLogin();
      if (user != null) {
        SalesMenu salesMenu = new SalesMenu(saleRepository, customerRepository, shoppingCartRepository, inventoryRepository, appointmentMenu, shoppingCartMenu, customerMenu, gui, user);
        MainMenu mainMenu = new MainMenu(gui, salesMenu, inventoryMenu, userMenu, user);
        mainMenu.drawMainMenu();
      } else {
        gui.doShowErrorData("Usuario/Contraseña no son correctas.");
      }
    }
  }
}
