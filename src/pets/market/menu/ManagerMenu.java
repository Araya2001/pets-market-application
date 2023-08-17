/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;

/**
 * @author Valeria
 */

import javax.swing.*;

public class ManagerMenu {

    public String ManagerS;



    public void managerMenu() {

        String[] botones = {"Control de Usuarios", "Inventario", "Ventas", "Control de Citas", "Salir"};

        int Manager = JOptionPane.showOptionDialog(
                null,
                "Seleccione su Opcion: ",
                "Menu de Gerente",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, botones, botones[0]);

        switch (Manager) {
            case 0:
                ManagerS = botones[0];
                //  ManageUserMenu manageUserMenu();
                break;

            case 1:
                ManagerS = botones[1];
                //  InventoryMenu.inventoryMenu();
                break;

            case 2:
                ManagerS = botones[2];
                //  SalesMenu.salesMenu();
                break;

            case 3:
                ManagerS = botones[3];
                //  AppointmentMenu.appointmentMenu();
                break;

            case 4:
                ManagerS = botones[4];
                JOptionPane.showMessageDialog(null, "Saliendo...");
                System.exit(0);
                break;

        }
    }
}
