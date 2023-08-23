/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.menu;

import pets.market.domain.InventoryItem;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

import java.util.Arrays;

/**
 * @author Valeria
 */
public class InventoryMenu {
  private final BaseDomainRepository<InventoryItem, String> repository;
  private final JOptionPaneWrapper gui;

  public InventoryMenu(BaseDomainRepository<InventoryItem, String> repository, JOptionPaneWrapper gui) {
    this.repository = repository;
    this.gui = gui;
  }

  public void createItem() {
    InventoryItem inventoryItem = new InventoryItem();
    try {
      inventoryItem.setName(gui.doRequestInputData("Ingrese el nombre del producto:"))
          .setItemType(gui.doRequestInputData("Ingrese el tipo del producto:"))
          .setPetType(gui.doRequestInputData("Ingrese el animal al que aplica este producto:"))
          .setQuantity(Integer.parseInt((gui.doRequestInputData("Ingrese la cantidad de productos disponibles:"))))
          .setPriceValue(Double.parseDouble((gui.doRequestInputData("Ingrese el precio unitario del producto (0.00):"))))
          .setId(gui.doRequestInputData("Ingrese la cédula del usuario:"));
      if (repository.save(inventoryItem) != null) {
        gui.doShowOutputData("Item guardado con éxito");
      } else {
        gui.doShowErrorData("Item no pudo ser guardado!!!");
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void modifyItem() {
    try {
      InventoryItem item = Arrays.stream(repository.findByPredicate(inventoryItem -> inventoryItem.getId().equals(gui.doRequestInputData("Ingrese el código del producto a consultar:")))).findFirst().orElse(null);
      if (item != null) {
        item.setName(gui.doRequestInputData("Ingrese el nombre del producto:"))
            .setItemType(gui.doRequestInputData("Ingrese el tipo del producto:"))
            .setPetType(gui.doRequestInputData("Ingrese el animal al que aplica este producto:"))
            .setQuantity(Integer.parseInt((gui.doRequestInputData("Ingrese la cantidad de productos disponibles:"))))
            .setPriceValue(Double.parseDouble((gui.doRequestInputData("Ingrese el precio unitario del producto (0.00):"))))
            .setId(gui.doRequestInputData("Ingrese la cédula del usuario:"));
      } else {
        gui.doShowErrorData("No se logró encontrar el producto especificado");
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
          sb.append(i + 1).append(". ").append(repository.findAll()[i]).append("\n");
        }
      }
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void showWithTypeFilter() {
    StringBuffer sb = new StringBuffer();
    String filter = gui.doRequestInputData("Ingrese el Tipo (MEDICAMENTO, GROOMING, ALIMENTOS, ARTÍCULOS)");
    try {
      for (int i = 0; i < repository.findAll().length; i++) {
        if (repository.findAll()[i] != null) {
          if (repository.findAll()[i].getItemType().equals(filter)) {
            sb.append(i + 1).append(". ").append(repository.findAll()[i]).append("\n");
          }
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
      String product = gui.doRequestInputData("Ingrese el código del producto a consultar:");
      Arrays.stream(repository.findByPredicate(inventoryItem -> inventoryItem.getId().equals(product))).findFirst().ifPresent(sb::append);
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }
}
