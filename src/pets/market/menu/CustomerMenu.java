/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pets.market.menu;

/**
 * @author Valeria
 */

import pets.market.domain.Customer;
import pets.market.domain.User;
import pets.market.dto.RoleType;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

public class CustomerMenu {

    private final BaseDomainRepository<Customer, String> repository;
    private final JOptionPaneWrapper gui;

    public CustomerMenu(BaseDomainRepository<Customer, String> repository, JOptionPaneWrapper gui) {
        this.repository = repository;
        this.gui = gui;
    }

    public void createCustomer() {
        Customer customer = new Customer();
        try {
            customer.setFullName(gui.doRequestInputData("Ingrese el nombre completo del cliente"))
                    .setEmail(gui.doRequestInputData("Ingrese el correo del cliente"))
                    .setPhoneNumber(gui.doRequestInputData("Ingrese el número de teléfono del cliente"))
                    .setId(gui.doRequestInputData("Ingrese la cédula del cliente:"));
            if (repository.save(customer) != null) {
                gui.doShowOutputData("Cliente guardado con éxito");
            } else {
                gui.doShowErrorData("Cliente no pudo ser guardado!!!");
            }
        } catch (Exception e) {
            gui.doShowErrorData(e.getMessage());
        }
    }

    public void modifyCustomer() {

        try {
            Customer customer = repository.findById(gui.doRequestInputData("Ingrese la cédula del usuario a modificar:")).orElse(null);
            if (customer != null) {
                customer.setFullName(gui.doRequestInputData("Ingrese el nombre completo del cliente"))
                        .setEmail(gui.doRequestInputData("Ingrese el correo del cliente"))
                        .setPhoneNumber(gui.doRequestInputData("Ingrese el número de teléfono del cliente"))
                        .setId(gui.doRequestInputData("Ingrese la cédula del cliente:"));
            } else {
                gui.doShowErrorData("No se logró encontrar el usuario especificado");
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
            repository.findById(gui.doRequestInputData("Ingrese la cédula del cliente a consultar:")).ifPresent(sb::append);
            gui.doShowOutputData(sb.toString());
        } catch (Exception e) {
            gui.doShowErrorData(e.getMessage());
        }
    }
}




