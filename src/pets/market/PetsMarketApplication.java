package pets.market;

import pets.market.service.JOptionPaneWrapper;
import pets.market.service.JOptionPaneWrapperImpl;

public class PetsMarketApplication {
  public static void main(String[] args) {
    // TODO code application logic here
    JOptionPaneWrapper jOptionPaneWrapper = new JOptionPaneWrapperImpl();
    jOptionPaneWrapper.doRequestInputData("Por favor ingrese su identificador de usuario:");
    jOptionPaneWrapper.doShowOutputData("Bienvenido");
    jOptionPaneWrapper.doShowOutputData("Bienvenido, Gerente:");
    String optionsMessageGerente = "Seleccione una opción:\n" +
        "1. Control de Usuarios\n" +
        "2. Ventas\n" +
        "3. Inventario";
    String inputGerente = jOptionPaneWrapper.doRequestInputData(optionsMessageGerente);
    switch (inputGerente) {
      case "1" -> jOptionPaneWrapper.doShowOutputData("Ha elegido: Control de Usuarios");
      // Lógica para Control de Usuarios
      case "2" -> jOptionPaneWrapper.doShowOutputData("Ha elegido: Ventas");
      // Lógica para Ventas
      case "3" -> jOptionPaneWrapper.doShowOutputData("Ha elegido: Inventario");
      // Lógica para Inventario
      default -> jOptionPaneWrapper.doShowOutputData("Opción no válida");
    }
    jOptionPaneWrapper.doShowOutputData("Bienvenido, Vendedor:");
    String optionsMessageVendedor = "Seleccione una opción:\n" +
        "1. Ventas\n" +
        "2. Control de Citas para Grooming";
    String inputVendedor = jOptionPaneWrapper.doRequestInputData(optionsMessageVendedor);
    switch (inputVendedor) {
      case "1" -> jOptionPaneWrapper.doShowOutputData("Ha elegido ventas");
      // Lógica para ventas
      case "2" -> jOptionPaneWrapper.doShowOutputData("Ha elegido: Control de citas para Grooming");
      // Lógica para citas grooming
      default -> jOptionPaneWrapper.doShowOutputData("Opción no válida");
    }
  }
}//mensajes de bienvenida
