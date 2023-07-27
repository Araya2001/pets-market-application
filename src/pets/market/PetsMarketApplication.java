/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pets.market;


import pets.market.service.JOptionPaneWrapper;
import pets.market.service.JOptionPaneWrapperImpl;

/**
 * @author aaj, dmmb, vvm
 */
public class PetsMarketApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JOptionPaneWrapper jOptionPaneWrapper = new JOptionPaneWrapperImpl();

        jOptionPaneWrapper.doRequestInputData("Por favor ingrese su identificador de usuario:");
        jOptionPaneWrapper.doShowOutputData("Bienvenido");

    }


}
