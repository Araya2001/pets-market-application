/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.menu;

import pets.market.domain.Appointment;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

/**
 * @author Valeria
 */
public class AppointmentMenu {
  private final BaseDomainRepository<Appointment, Long> repository;
  private final JOptionPaneWrapper gui;

  public AppointmentMenu(BaseDomainRepository<Appointment, Long> repository, JOptionPaneWrapper gui) {
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
      Appointment appointment = repository.findAll()[Integer.parseInt(gui.doRequestInputData("Ingrese el índice mostrado por sistema:"))];
      sb.append(appointment);
      gui.doShowOutputData(sb.toString());
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }
}
