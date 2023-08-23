/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;
/**
 * @author Valeria
 */

import pets.market.domain.*;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

import java.util.Arrays;
import java.util.Objects;

public class SalesMenu {
  private final BaseDomainRepository<Sale, Long> repository;
  private final BaseDomainRepository<Customer, String> customerRepository;
  private final BaseDomainRepository<ShoppingCart, Long> shoppingCartRepository;
  private final BaseDomainRepository<InventoryItem, String> inventoryItemRepository;
  private final AppointmentMenu appointmentMenu;
  private final ShoppingCartMenu shoppingCartMenu;
  private final CustomerMenu customerMenu;
  private final JOptionPaneWrapper gui;
  private final User user;

  public SalesMenu(BaseDomainRepository<Sale, Long> repository, BaseDomainRepository<Customer, String> customerRepository, BaseDomainRepository<ShoppingCart, Long> shoppingCartRepository, BaseDomainRepository<InventoryItem, String> inventoryItemRepository, AppointmentMenu appointmentMenu, ShoppingCartMenu shoppingCartMenu, CustomerMenu customerMenu, JOptionPaneWrapper gui, User user) {
    this.repository = repository;
    this.customerRepository = customerRepository;
    this.shoppingCartRepository = shoppingCartRepository;
    this.inventoryItemRepository = inventoryItemRepository;
    this.appointmentMenu = appointmentMenu;
    this.shoppingCartMenu = shoppingCartMenu;
    this.customerMenu = customerMenu;
    this.gui = gui;
    this.user = user;
  }

  public void drawSalesMenu() {
    String[] buttons = {"Clientes", "Carro de compras", "Citas grooming", "Generar factura", "Ver facturas", "Ver facturas cliente", "Salir"};
    int selection = 0;
    boolean isRunning = true;
    while (isRunning) {
      selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Menu Principal", buttons, 0);
      switch (selection) {
        case 0 -> drawCustomerMenu();
        case 1 -> drawShoppingCartMenu();
        case 2 -> drawAppointmentMenu();
        case 3 -> createInvoice();
        case 4 -> showAll();
        case 5 -> query();
        case 6 -> isRunning = false;
      }
    }
  }

  public void drawCustomerMenu() {
    String[] buttons = {"Registrar Cliente", "Modificar Cliente", "Mostrar todos", "Mostrar Cliente", "Salir"};
    int selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Administración de Cliente", buttons, 0);
    switch (selection) {
      case 0 -> customerMenu.createCustomer();
      case 1 -> customerMenu.modifyCustomer();
      case 2 -> customerMenu.showAll();
      case 3 -> customerMenu.query();
      case 4 -> {
      }
    }
  }

  public void drawShoppingCartMenu() {
    String[] buttons = {"Agregar productos", "Modificar productos", "Mostrar todos", "Mostrar Carro de Cliente", "Salir"};
    int selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Carro de compras", buttons, 0);
    switch (selection) {
      case 0 -> shoppingCartMenu.addItemToCart();
      case 1 -> shoppingCartMenu.modifyItemFromCart();
      case 2 -> shoppingCartMenu.showAll();
      case 3 -> shoppingCartMenu.query();
      case 4 -> {
      }
    }
  }

  public void drawAppointmentMenu() {
    String[] buttons = {"Agendar Cita", "Modificar Cita", "Eliminar Cita", "Mostrar citas", "Mostrar cita de cliente", "Salir"};
    int selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Citas Grooming", buttons, 0);
    switch (selection) {
      case 0 -> appointmentMenu.createAppointmentReservation();
      case 1 -> appointmentMenu.modifyAppointmentReservation();
      case 2 -> appointmentMenu.deleteAppointmentReservation();
      case 3 -> appointmentMenu.showAll();
      case 4 -> appointmentMenu.query();
      case 5 -> {
      }
    }
  }

  public void createInvoice() {
    StringBuffer sb = new StringBuffer();
    ShoppingCart shoppingCart = shoppingCartRepository.findByPredicate(Objects::nonNull).stream().filter(shoppingCart1 -> shoppingCart1.getCustomer().equals(gui.doRequestInputData("Ingrese la cédula del cliente:"))).findFirst().orElse(null);
    Customer customer;
    if (shoppingCart != null) {
      customer = customerRepository.findById(shoppingCart.getCustomer()).orElse(null);
      if (customer != null) {
        Sale sale = new Sale();
        sale.setSaleByUser(this.user.getId());
        sale.setCustomer(shoppingCart.getCustomer());
        sale.setInventoryItems(shoppingCart.getInventoryItems());
        sale.setTaxType("13IVA");
        sale.setSubTotalChargeValue(shoppingCart.getInventoryItems().entrySet().stream()
            .mapToDouble(kv -> Objects.requireNonNull(inventoryItemRepository.findById(kv.getKey()).orElse(null)).getPriceValue() * kv.getValue()).sum());
        sale.setTotalChargeValue(sale.getSubTotalChargeValue() * 1.13);
        if (repository.save(sale) != null) {
          sb.append("Detalle de Factura:")
              .append("\n")
              .append("Cliente: ")
              .append("\n")
              .append(customer.getFullName())
              .append("\n")
              .append(customer.getId())
              .append("\n")
              .append(customer.getPhoneNumber())
              .append("\n")
              .append(customer.getEmail())
              .append("\n\n")
              .append("Artículos: ");
          sale.getInventoryItems().forEach((string, integer) ->
              inventoryItemRepository.findById(string).ifPresent(inventoryItem ->
                  sb.append("\nNombre: ").append(inventoryItem.getName()).append("\n")
                      .append("Código: ").append(inventoryItem.getId()).append("\n")
                      .append("Precio Unitario: ").append(inventoryItem.getPriceValue()).append("\n")
                      .append("Cantidad: ").append(integer).append("\n")
                      .append("Tipo: ").append(inventoryItem.getItemType()).append("\n")
                      .append("Tipo de Animal: ").append(inventoryItem.getPetType()).append("\n"))
          );
          sb.append("\nSubtotal de factura: ").append(sale.getSubTotalChargeValue()).append("\n");
          sb.append("\nTotal de factura: ").append(sale.getTotalChargeValue()).append("\n");
          gui.doShowOutputData(sb.toString());
        }
      } else {
        gui.doShowErrorData("No se logró encontrar el Usuario");
      }
    } else {
      gui.doShowErrorData("No se logró encontrar el Carro de compras");
    }
  }

  public void showAll() {
    StringBuffer sb = new StringBuffer();
    try {
      for (int i = 0; i < repository.findAll().length; i++) {
        if (repository.findAll()[i] != null) {
          sb.append(i + 1).append(". ").append(repository.findAll()[i]).append("\n");
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
      String filter = gui.doRequestInputData("Ingrese la cédula del cliente");
      Arrays.stream(repository.findAll()).filter(sale1 -> sale1.getCustomer().equals(filter))
          .forEach(sb::append);
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }
}
