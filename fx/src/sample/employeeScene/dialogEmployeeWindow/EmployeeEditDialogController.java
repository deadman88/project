package sample.employeeScene.dialogEmployeeWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Макс on 29.08.2017.
 */
public class EmployeeEditDialogController {
    @FXML
    private TextField firstNameOfEmployeeField;
    @FXML
    private TextField secondNameOfEmployeeField;
    @FXML
    private TextField dateOfBirthdayField;
    @FXML
    private TextField passportField;
    @FXML
    private TextField idNumberField;

    private Stage dialogStage;
    private Employee employee;
    private boolean okClicked = false;


    @FXML
    private void initialize() {

    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        firstNameOfEmployeeField.setText(employee.getFirstNameOfEmployee());
        secondNameOfEmployeeField.setText(employee.getSecondNameOfEmployee());
        dateOfBirthdayField.setText(employee.getDateOfBirthday());
        passportField.setText(employee.getPassport());
        idNumberField.setText(Long.toString(employee.getIdNumber()));
        dateOfBirthdayField.setPromptText("11.11.2011");
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            employee.setFirstNameOfEmployee(firstNameOfEmployeeField.getText());
            employee.setSecondNameOfEmployee(secondNameOfEmployeeField.getText());
            employee.setDateOfBirthday(dateOfBirthdayField.getText());
            employee.setPassport(passportField.getText());
            employee.setIdNumber(Long.parseLong(idNumberField.getText()));
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
        if (firstNameOfEmployeeField.getText() == null || firstNameOfEmployeeField.getText().length() ==
                0) {
            errorMessage += "Не введено ім'я!\n";
        }
        if (secondNameOfEmployeeField.getText() == null || secondNameOfEmployeeField.getText().length() ==
                0) {
            errorMessage += "Не введено прізвище!\n";
        }
        if (dateOfBirthdayField.getText() == null || dateOfBirthdayField.getText().length() == 0) {
            errorMessage += "Не введена дата народження!\n";
        }
        if (passportField.getText() == null || passportField.getText().length()
                == 0) {
            errorMessage += "Не введено паспорт!\n";
        }
        if (idNumberField.getText() == null || idNumberField.getText().length()
                == 0) {
            errorMessage += "Не введено індфікаційний номер!\n";
        } else {
            try {
                Long.parseLong(idNumberField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Потрібно ввести цифри!\n";
            }
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