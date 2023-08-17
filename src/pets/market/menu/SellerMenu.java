/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;

/**
 * @author Valeria
 */

import javax.swing.*;

public class SellerMenu {

    public String SellerS;


    public void sellerMenu() {

        String[] botones = {"Ventas", "Control de Citas", "Salir"};

        int Seller = JOptionPane.showOptionDialog(
                null,
                "Seleccione su Opcion: ",
                "Menu de Vendedor",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botones, botones[0]);

        switch (Seller) {
            case 0:
                SellerS = botones[0];
//  SalesMenu.salesMenu();
                break;

            case 1:
                SellerS = botones[1];
//  AppointmentMenu.appointmentMenu();
                break;

            case 2:
                SellerS = botones[2];
                JOptionPane.showMessageDialog(null, "Saliendo...");
                System.exit(0);
                break;

        }
    }
}


