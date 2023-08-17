/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;

import pets.market.service.JOptionPaneWrapper;
import pets.market.service.JOptionPaneWrapperImpl;

import javax.swing.*;

public class UserMenu {

    public String UserS;

    public void userMenu() {

        String[] botones = {"Gerente", "Vendedor", "Salir"};

        JOptionPaneWrapper menu = new JOptionPaneWrapperImpl();

        int user = menu.doShowInputMenu("Seleccione su roll: ", "Menu de Usuario", botones, 0);

        switch (user) {
            case 0:
                UserS = botones[0];
                //  ManagerMenu.managerMenu();
                break;

            case 1:
                UserS = botones[1];
//  SalerMenu.salerMenu();    
                break;

            case 2:
                UserS = botones[2];
                JOptionPane.showMessageDialog(null, "Saliendo...");
                System.exit(0);
                break;

        }
    }
}
