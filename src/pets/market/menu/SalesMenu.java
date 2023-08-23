/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;
/**
 * @author Valeria
 */

import pets.market.domain.Customer;
import pets.market.domain.Sale;
import pets.market.domain.ShoppingCart;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

public class SalesMenu {
  private final BaseDomainRepository<Sale, Long> repository;
  private final BaseDomainRepository<Customer, String> customerRepository;
  private final BaseDomainRepository<ShoppingCart, Long> shoppingCartRepository;
  private final AppointmentMenu appointmentMenu;
  private final ShoppingCartMenu shoppingCartMenu;
  private final CustomerMenu customerMenu;
  private final JOptionPaneWrapper gui;

  public SalesMenu(BaseDomainRepository<Sale, Long> repository, BaseDomainRepository<Customer, String> customerRepository, BaseDomainRepository<ShoppingCart, Long> shoppingCartRepository, AppointmentMenu appointmentMenu, ShoppingCartMenu shoppingCartMenu, CustomerMenu customerMenu, JOptionPaneWrapper gui) {
    this.repository = repository;
    this.customerRepository = customerRepository;
    this.shoppingCartRepository = shoppingCartRepository;
    this.appointmentMenu = appointmentMenu;
    this.shoppingCartMenu = shoppingCartMenu;
    this.customerMenu = customerMenu;
    this.gui = gui;
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
        case 2 -> drawInvoiceMenu();
        case 3 -> isRunning = false;
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
      case 3 -> customerMenu.query();
      case 4 -> {
      }
    }
  }

  public void drawAppointmentMenu() {
    String[] buttons = {"Agregar productos", "Modificar productos", "Mostrar todos", "Mostrar Carro de Cliente", "Salir"};
    int selection = gui.doShowInputMenu("Seleccione el módulo al que desea ingresar: ", "Citas Grooming", buttons, 0);
    switch (selection) {
      case 0 -> shoppingCartMenu.addItemToCart();
      case 1 -> shoppingCartMenu.modifyItemFromCart();
      case 2 -> shoppingCartMenu.showAll();
      case 3 -> customerMenu.query();
      case 4 -> {
      }
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
      Sale sale = repository.findAll()[Integer.parseInt(gui.doRequestInputData("Ingrese el índice mostrado por sistema:"))];
      sb.append(sale);
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }
}
