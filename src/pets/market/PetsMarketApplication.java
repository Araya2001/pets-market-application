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
    inventoryItem1.setPetType("PERRO").setItemType("MEDICINA");
    
    
    
    
    
    
    
    InventoryItem inventoryItem11 = new InventoryItem();
    inventoryItem11.setPetType("GATO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(3000.00).setName("ATUN").setId("001-ALI-ATUN");
    
    InventoryItem inventoryItem12 = new InventoryItem();
    inventoryItem12.setPetType("PERRO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(5000.00).setName("CROQUETAS").setId("002-ALI-CROQUETAS");
 
    InventoryItem inventoryItem13 = new InventoryItem();
    inventoryItem13.setPetType("GATO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(1000.00).setName("HELADO").setId("003-ALI-HELADO");
    
    InventoryItem inventoryItem14 = new InventoryItem();
    inventoryItem14.setPetType("PERRO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(10000.00).setName("ALIMENTO CACHORRO").setId("004-ALI-CACHORRO");
    
    InventoryItem inventoryItem15 = new InventoryItem();
    inventoryItem15.setPetType("PERRO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(4000.00).setName("SNACK").setId("005-ALI-SNACK");
    
    InventoryItem inventoryItem16 = new InventoryItem();
    inventoryItem11.setPetType("GATO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(3000.00).setName("COLLAR").setId("001-ART-COLLAR");
    
    InventoryItem inventoryItem17 = new InventoryItem();
    inventoryItem12.setPetType("PERRO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(5000.00).setName("RATON").setId("002-ART-RATON");
 
    InventoryItem inventoryItem18 = new InventoryItem();
    inventoryItem13.setPetType("GATO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(1000.00).setName("HUESO PERRO").setId("003-ART-HUESO");
    
    InventoryItem inventoryItem19 = new InventoryItem();
    inventoryItem14.setPetType("PERRO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(10000.00).setName("HARNES").setId("004-ART-HARNES");
    
    InventoryItem inventoryItem20 = new InventoryItem();
    inventoryItem15.setPetType("PERRO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(4000.00).setName("PELOTA").setId("005-ART-PELOTA");
    
    inventoryRepository.save(inventoryItem1);
    inventoryRepository.save(inventoryItem12);
    inventoryRepository.save(inventoryItem13);
    inventoryRepository.save(inventoryItem14);
    inventoryRepository.save(inventoryItem15);
    inventoryRepository.save(inventoryItem16);
    inventoryRepository.save(inventoryItem17);
    inventoryRepository.save(inventoryItem18);
    inventoryRepository.save(inventoryItem19);
    inventoryRepository.save(inventoryItem20);

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
