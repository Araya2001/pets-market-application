/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;
/**
 * @author Valeria
 */

import javax.swing.*;

public class SalesMenu {
  public String SalesS;

  public void salesMenu() {
    String[] botones = {"Cliente Existente", "Cliente Nuevo", "Editar Cliente", "Salir"};
    int Sales = JOptionPane.showOptionDialog(
        null,
        "Seleccione su Opcion: ",
        "Menu de Ventas",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null, botones, botones[0]);
    switch (Sales) {
      case 0:
        SalesS = botones[0];
        //  find();
        //  customer();
        //  ShoppingCartMenu.shoppingcartMenu();
        break;
      case 1:
        SalesS = botones[1];
        //  add();
        //  customer();
        //  ShoppingCartMenu.shoppingcartMenu();
        break;
      case 2:
        SalesS = botones[2];
        //  modify();
        //  customer();
        //  ShoppingCartMenu.shoppingcartMenu();
        break;
      case 3:
        SalesS = botones[3];
        JOptionPane.showMessageDialog(null, "Saliendo...");
        System.exit(0);
        break;
    }
  }
}
