/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;

/**
 * @author Valeria
 */

import javax.swing.*;

public class SalerMenu {

    public String SalerS;

    public void salerMenu() {

        String[] botones = {"Ventas", "Control de Citas", "Salir"};

        int Saler = JOptionPane.showOptionDialog(
                null,
                "Seleccione su Opcion: ",
                "Menu de Vendedor",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botones, botones[0]);

        switch (Saler) {
            case 0:
                SalerS = botones[0];
//  SalesMenu.salesMenu();
                break;

            case 1:
                SalerS = botones[1];
//  AppointmentMenu.appointmentMenu();
                break;

            case 2:
                SalerS = botones[2];
                JOptionPane.showMessageDialog(null, "Saliendo...");
                System.exit(0);
                break;

        }
    }
}


