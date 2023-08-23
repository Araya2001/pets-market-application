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
    inventoryItem1.setPetType("GATO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(10000.00).setName("METACAM").setId("001-MED-METACAM");
    InventoryItem inventoryItem2 = new InventoryItem();
    inventoryItem2.setPetType("PERRO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(5000.00).setName("IBUPROFENO").setId("002-MED-IBUPROFENO");
    InventoryItem inventoryItem3 = new InventoryItem();
    inventoryItem3.setPetType("GATO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(9000.00).setName("AMOXICILINA").setId("003-MED-AMOXICILINA");
    InventoryItem inventoryItem4 = new InventoryItem();
    inventoryItem4.setPetType("PERRO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(20000.00).setName("DERAMAX").setId("004-MED-DERAMAX");
    InventoryItem inventoryItem5 = new InventoryItem();
    inventoryItem5.setPetType("PERRO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(15000.00).setName("RIMADYL").setId("005-MED-RIMADYL");
    inventoryRepository.save(inventoryItem1);
    inventoryRepository.save(inventoryItem2);
    inventoryRepository.save(inventoryItem3);
    inventoryRepository.save(inventoryItem4);
    inventoryRepository.save(inventoryItem5);
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
