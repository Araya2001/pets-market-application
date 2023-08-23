package pets.market.service;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class JOptionPaneWrapperImpl implements JOptionPaneWrapper {
  private static final String TITLE = "PETS MARKET APPLICATION";

  @Override
  public String doRequestInputData(String message) {
    return JOptionPane.showInputDialog(null, message);
  }

  @Override
  public void doShowOutputData(String message) {
    JOptionPane.showMessageDialog(null, message, TITLE, JOptionPane.PLAIN_MESSAGE);
  }

  @Override
  public void doShowErrorData(String message) {
    Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
    JOptionPane.showMessageDialog(null, new StringBuffer().append("ERROR: ").append(message), TITLE, JOptionPane.ERROR_MESSAGE, errorIcon);
  }

  @Override
  public Boolean doRequestYesNoMenu(String message) {
    return Objects.equals(JOptionPane.showConfirmDialog(null, message, TITLE, JOptionPane.YES_NO_OPTION), JOptionPane.YES_OPTION);
  }

  @Override
  public Integer doShowInputMenu(String body, String title, String[] botones, int index) {
    return
        JOptionPane.showOptionDialog(
            null,
            body,
            title,
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null, botones, botones[index]);
  }

  @Override
  public LocalDateTime doRequestComboBoxSelectionWithDate(String message, String title, List<LocalDateTime> options) {
    JComboBox<LocalDateTime> comboBox = new JComboBox<>(options.toArray(new LocalDateTime[0]));
    int result = JOptionPane.showConfirmDialog(
        null,
        comboBox,
        message,
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
      return (LocalDateTime) comboBox.getSelectedItem();
    } else {
      return null;
    }
  }
}
