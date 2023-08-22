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
      Arrays.stream(repository.findByPredicate(inventoryItem -> inventoryItem.getId().equals(gui.doRequestInputData("Ingrese el código del producto a consultar:")))).findFirst().ifPresent(sb::append);
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }
}
