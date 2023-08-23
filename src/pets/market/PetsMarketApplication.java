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
    InventoryItem inventoryItem2 = new InventoryItem();
    InventoryItem inventoryItem3 = new InventoryItem();
    InventoryItem inventoryItem4 = new InventoryItem();
    InventoryItem inventoryItem5 = new InventoryItem();
    InventoryItem inventoryItem6 = new InventoryItem();
    InventoryItem inventoryItem7 = new InventoryItem();
    InventoryItem inventoryItem8 = new InventoryItem();
    InventoryItem inventoryItem9 = new InventoryItem();
    InventoryItem inventoryItem10 = new InventoryItem();
    InventoryItem inventoryItem11 = new InventoryItem();
    InventoryItem inventoryItem12 = new InventoryItem();
    InventoryItem inventoryItem13 = new InventoryItem();
    InventoryItem inventoryItem14 = new InventoryItem();
    InventoryItem inventoryItem15 = new InventoryItem();
    InventoryItem inventoryItem16 = new InventoryItem();
    InventoryItem inventoryItem17 = new InventoryItem();
    InventoryItem inventoryItem18 = new InventoryItem();
    InventoryItem inventoryItem19 = new InventoryItem();
    InventoryItem inventoryItem20 = new InventoryItem();
    inventoryItem1.setPetType("GATO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(10000.00).setName("METACAM").setId("001-MED-METACAM");
    inventoryItem2.setPetType("PERRO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(5000.00).setName("IBUPROFENO").setId("002-MED-IBUPROFENO");
    inventoryItem3.setPetType("GATO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(9000.00).setName("AMOXICILINA").setId("003-MED-AMOXICILINA");
    inventoryItem4.setPetType("PERRO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(20000.00).setName("DERAMAX").setId("004-MED-DERAMAX");
    inventoryItem5.setPetType("PERRO").setItemType("MEDICAMENTOS").setQuantity(10).setPriceValue(15000.00).setName("RIMADYL").setId("005-MED-RIMADYL");
    inventoryItem6.setPetType("PERRO").setItemType("GROOMING").setPriceValue(2.0000).setQuantity(10).setId("001-GRO-FullXL");
    inventoryItem7.setPetType("GATO").setItemType("GROOMING").setPriceValue(5.0000).setQuantity(10).setId("002-GRO-MEDXL");
    inventoryItem8.setPetType("PERRO").setItemType("GROOMING").setPriceValue(10.0000).setQuantity(10).setId("003-GRO-FULLS");
    inventoryItem9.setPetType("GATO").setItemType("GROOMING").setPriceValue(11.0000).setQuantity(10).setId("004-GRO-MEDS");
    inventoryItem10.setPetType("GATO").setItemType("GROOMING").setPriceValue(3.0000).setQuantity(10).setId("005-GRO-BASIC");
    inventoryItem11.setPetType("GATO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(3000.00).setName("ATUN").setId("001-ALI-ATUN");
    inventoryItem12.setPetType("PERRO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(5000.00).setName("CROQUETAS").setId("002-ALI-CROQUETAS");
    inventoryItem13.setPetType("GATO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(1000.00).setName("HELADO").setId("003-ALI-HELADO");
    inventoryItem14.setPetType("PERRO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(10000.00).setName("ALIMENTO CACHORRO").setId("004-ALI-CACHORRO");
    inventoryItem15.setPetType("PERRO").setItemType("ALIMENTOS").setQuantity(10).setPriceValue(4000.00).setName("SNACK").setId("005-ALI-SNACK");
    inventoryItem11.setPetType("GATO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(3000.00).setName("COLLAR").setId("001-ART-COLLAR");
    inventoryItem12.setPetType("PERRO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(4000.00).setName("RATON").setId("002-ART-RATON");
    inventoryItem13.setPetType("GATO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(2000.00).setName("HUESO PERRO").setId("003-ART-HUESO");
    inventoryItem14.setPetType("PERRO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(10000.00).setName("HARNES").setId("004-ART-HARNES");
    inventoryItem15.setPetType("PERRO").setItemType("ARTICULOS").setQuantity(10).setPriceValue(5000.00).setName("PELOTA").setId("005-ART-PELOTA");
    inventoryRepository.save(inventoryItem1);
    inventoryRepository.save(inventoryItem2);
    inventoryRepository.save(inventoryItem3);
    inventoryRepository.save(inventoryItem4);
    inventoryRepository.save(inventoryItem5);
    inventoryRepository.save(inventoryItem6);
    inventoryRepository.save(inventoryItem7);
    inventoryRepository.save(inventoryItem8);
    inventoryRepository.save(inventoryItem9);
    inventoryRepository.save(inventoryItem10);
    inventoryRepository.save(inventoryItem11);
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
