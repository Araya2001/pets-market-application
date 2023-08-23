package pets.market.service;

import java.time.LocalDateTime;
import java.util.List;

public interface JOptionPaneWrapper {
  String doRequestInputData(String message);

  void doShowOutputData(String message);

  void doShowErrorData(String message);

  Boolean doRequestYesNoMenu(String message);

  Integer doShowInputMenu(String body, String title, String[] botones, int index);

  LocalDateTime doRequestComboBoxSelectionWithDate(String message, String title, List<LocalDateTime> options);
}
