/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.menu;

import pets.market.domain.Customer;
import pets.market.domain.InventoryItem;
import pets.market.domain.ShoppingCart;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Valeria
 */
public class ShoppingCartMenu {
  private final BaseDomainRepository<ShoppingCart, Long> repository;
  private final BaseDomainRepository<InventoryItem, String> inventoryItemRepository;
  private final BaseDomainRepository<Customer, String> customerRepository;
  private final JOptionPaneWrapper gui;

  public ShoppingCartMenu(BaseDomainRepository<ShoppingCart, Long> repository, BaseDomainRepository<InventoryItem, String> inventoryItemRepository, BaseDomainRepository<Customer, String> customerRepository, JOptionPaneWrapper gui) {
    this.repository = repository;
    this.inventoryItemRepository = inventoryItemRepository;
    this.customerRepository = customerRepository;
    this.gui = gui;
  }

  public void addItemToCart() {
    try {
      String customerId = gui.doRequestInputData("Ingresar cédula del cliente:");
      AtomicBoolean isInvalid = new AtomicBoolean(false);
      if (customerRepository.findById(customerId).isEmpty()) {
        gui.doShowErrorData("Por favor crear el cliente primero");
      } else {
        ShoppingCart cart = Arrays.stream(repository.findByPredicate(shoppingCart -> shoppingCart.getCustomer().equals(customerId))).findFirst().orElse(null);
        if (cart == null) {
          cart = new ShoppingCart().setCustomer(customerId).setInventoryItems(new HashMap<>());
          if (repository.save(cart) != null) {
            gui.doShowOutputData("Carro de compra logró ser registrado exitosamente.");
          } else {
            gui.doShowErrorData("Carro de compra no logró ser registrado!!!");
          }
        } else {
          if (gui.doRequestYesNoMenu("Desea eliminar los artículos que tenía el cliente previo a esta compra?")) {
            cart.setInventoryItems(new HashMap<>());
          }
        }
        AtomicReference<ShoppingCart> cartAR = new AtomicReference<>(cart);
        while (gui.doRequestYesNoMenu("Desea registrar un producto al carrito?")) {
          Arrays.stream(inventoryItemRepository.findAll())
              .filter(inventoryItemDTO -> inventoryItemDTO.getId().equals(gui.doRequestInputData("Ingrese el código del producto")))
              .findFirst()
              .ifPresent(inventoryItemDTO -> cartAR.get().getInventoryItems().put(inventoryItemDTO.getId(), Integer.parseInt(gui.doRequestInputData("Ingrese la cantidad del producto:"))));
        }
        cart.getInventoryItems().forEach((key, value) -> {
          if (Objects.requireNonNull(inventoryItemRepository.findById(key).orElse(null)).getQuantity() < value) {
            gui.doShowErrorData("El producto " + key + " excede la cantidad disponible, por consecuente, debe generar" +
                " el carro de nuevo con la cantidad adecuada");
            isInvalid.set(true);
          }
        });
        if (isInvalid.get()) {
          gui.doShowErrorData("El carro de compras no es válido, por favor vuelva a ingresar los datos");
        }
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void modifyItemFromCart() {
    try {
      String customerId = gui.doRequestInputData("Ingresar cédula del cliente:");
      AtomicBoolean isInvalid = new AtomicBoolean(false);
      String tempCode = "";
      if (customerRepository.findById(customerId).isEmpty()) {
        gui.doShowErrorData("No se puede modificar un carro de compras existente si no existe el cliente.");
      } else {
        ShoppingCart cart = Arrays.stream(repository.findByPredicate(shoppingCart -> shoppingCart.getCustomer().equals(customerId))).findFirst().orElse(null);
        if (cart != null) {
          if (gui.doRequestYesNoMenu("Desea eliminar los artículos que tenía el cliente previo a esta compra?")) {
            cart.setInventoryItems(new HashMap<>());
          }
          AtomicReference<ShoppingCart> cartAR = new AtomicReference<>(cart);
          while (gui.doRequestYesNoMenu("Desea modificar la cantidad de un producto al carrito?")) {
            tempCode = gui.doRequestInputData("Ingrese el código del producto");
            if (cart.getInventoryItems().containsKey(tempCode)) {
              cart.getInventoryItems().replace(tempCode, Integer.parseInt(gui.doRequestInputData("Ingrese la cantidad de productos")));
            }
          }
        }
        cart.getInventoryItems().forEach((key, value) -> {
          if (Objects.requireNonNull(inventoryItemRepository.findById(key).orElse(null)).getQuantity() < value) {
            gui.doShowErrorData("El producto " + key + " excede la cantidad disponible, por consecuente, debe generar" +
                " el carrito de nuevo con la cantidad adecuada");
            isInvalid.set(true);
          }
          if (value == 0) {
            cart.getInventoryItems().remove(key);
          }
        });
        if (!isInvalid.get()) {
          gui.doShowErrorData("El carro de compras no es válido, por favor vuelva a ingresar los datos");
        }
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
      ShoppingCart shoppingCart = Arrays.stream(repository.findByPredicate(shoppingCart1 -> shoppingCart1.getCustomer().equals(gui.doRequestInputData("Ingrese la cédula del cliente:")))).findFirst().orElse(null);
      if (shoppingCart != null) {
        sb.append(shoppingCart);
        gui.doShowOutputData(sb.toString());
      }else{
        gui.doShowErrorData("No hay carrito asociado a dicho cliente, por favor agregar items!!!");
      }

    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }
}
