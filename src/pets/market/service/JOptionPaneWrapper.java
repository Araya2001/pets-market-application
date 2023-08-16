package pets.market.service;

public interface JOptionPaneWrapper {

    String doRequestInputData(String message);

    void doShowOutputData(String message);

    void doShowErrorData(String message);


    Boolean doRequestYesNoMenu(String message);

    Integer doShowInputMenu(String body,String title,String[]botones,int index);   
    
}
