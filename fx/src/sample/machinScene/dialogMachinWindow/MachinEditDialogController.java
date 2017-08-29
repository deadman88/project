package sample.machinScene.dialogMachinWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Макс on 29.08.2017.
 */
public class MachinEditDialogController {
    @FXML
    private TextField firstNameOfMachinField;
    @FXML
    private TextField secondNameOfMachinField;
    @FXML
    private TextField licensePlateField;
    @FXML
    private TextField yearField;

    private Stage dialogStage;
    private Machin machin;
    private boolean okClicked = false;


    @FXML
    private void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMachin(Machin machin) {
        this.machin = machin;
        firstNameOfMachinField.setText(machin.getFirstNameOfMachin());
        secondNameOfMachinField.setText(machin.getSecondNameOfMachin());
        licensePlateField.setText(machin.getLicensePlate());
        yearField.setText(machin.getYear());
        yearField.setPromptText("2017");
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            machin.setFirstNameOfMachin(firstNameOfMachinField.getText());
            machin.setSecondNameOfMachin(secondNameOfMachinField.getText());
            machin.setLicensePlate(licensePlateField.getText());
            machin.setYear(yearField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "Помилка";
        if (firstNameOfMachinField.getText() == null || firstNameOfMachinField.getText().length() ==
                0) {
            errorMessage += "Не введена марка техніки!\n";
        }
        if (secondNameOfMachinField.getText() == null || secondNameOfMachinField.getText().length() ==
                0) {
            errorMessage += "Не введено модель!\n";
        }
        if (licensePlateField.getText() == null || licensePlateField.getText().length() == 0) {
            errorMessage += "Не введений номерний знак!\n";
        }
        if (yearField.getText() == null || yearField.getText().length()
                == 0) {
            errorMessage += "Не введено рік виготовлення!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Помилка в заповненні полів");
            alert.setHeaderText("Будь ласка перевірте правильність заповнення полів");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }
}
