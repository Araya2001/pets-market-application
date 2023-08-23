/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pets.market.menu;

import pets.market.domain.Appointment;
import pets.market.domain.Customer;
import pets.market.repository.BaseDomainRepository;
import pets.market.service.JOptionPaneWrapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Valeria
 */
public class AppointmentMenu {
  private final BaseDomainRepository<Appointment, String> repository;
  private final BaseDomainRepository<Customer, String> customerRepository;
  private final JOptionPaneWrapper gui;

  public AppointmentMenu(BaseDomainRepository<Appointment, String> repository, JOptionPaneWrapper gui, BaseDomainRepository<Customer, String> customerRepository) {
    this.repository = repository;
    this.gui = gui;
    this.customerRepository = customerRepository;
  }

  public void createAppointmentReservation() {
    Appointment appointment;
    try {
      String customerId = gui.doRequestInputData("Ingresar cédula del cliente:");
      if (customerRepository.findById(customerId).isEmpty()) {
        gui.doShowErrorData("Por favor crear el cliente primero");
      } else {
        // TODO VVM: METER INTERFAZ DE CALENDARIO
        appointment = new Appointment();
        appointment.setDate(gui.doRequestComboBoxSelectionWithDate("Seleccione una fecha:", "RESERVA", localDateTimes()))
            .setCustomerId(customerId)
            .setId(gui.doRequestInputData("Ingresar un identificador de reserva"));
        if (repository.save(appointment) != null) {
          gui.doShowOutputData("Usuario guardado con éxito");
        } else {
          gui.doShowErrorData("Usuario no pudo ser guardado!!!");
        }
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void modifyAppointmentReservation() {
    Appointment appointment;
    try {
      String customerId = gui.doRequestInputData("Ingresar cédula del cliente:");
      if (customerRepository.findById(customerId).isEmpty()) {
        gui.doShowErrorData("Por favor crear el cliente primero");
      } else {
        appointment = repository.findById(gui.doRequestInputData("Ingrese identificador de reserva:")).orElse(null);
        if (appointment != null) {
          // TODO VVM: METER INTERFAZ DE CALENDARIO
          appointment.setDate(gui.doRequestComboBoxSelectionWithDate("Seleccione una fecha:", "RESERVA", localDateTimes()))
              .setCustomerId(customerId).setId(gui.doRequestInputData("Ingresar un identificador de reserva"));
        } else {
          gui.doShowErrorData("No se logró actualizar la reservación!!!");
        }
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
  }

  public void deleteAppointmentReservation() {
    try {
      Appointment appointment = repository.findById(gui.doRequestInputData("Ingrese identificador de reserva:")).orElse(null);
      if (repository.delete(appointment)) {
        gui.doShowOutputData("Se logró eliminar la reserva");
      } else {
        gui.doShowOutputData("No se logró eliminar la reserva");
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
          sb.append(i + 1).append(". ").append(repository.findAll()[i]).append("\n");
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

  private List<LocalDateTime> localDateTimes() {
    return Stream.iterate(0, x -> x + 1).limit(45).map(x -> LocalDateTime.now().plusDays(x).truncatedTo(ChronoUnit.DAYS))
        .filter(localDateTime -> Arrays.stream(repository.findAll()).noneMatch(appointment -> appointment.getDate().equals(localDateTime))).toList();
  }
}
