package sample.jobScene.dialogJobWindow;

/**
 * Created by DM-UA on 25.08.2017.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class JobEditDialogController {
    @FXML
    private TextField nameOfMachinField;
    @FXML
    private TextField nameOfEmployeeField;
    @FXML
    private TextField timeField;
    @FXML
    private TextField costField;
    @FXML
    private TextField costOfCarriageField;
    @FXML
    private TextField nameOfJobField;
    @FXML
    private TextField paymentField;
    @FXML
    private TextField noOrYesPaymentField;

    private Stage dialogStage;
    private Job job;
    private boolean okClicked = false;


    @FXML
    private void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setJob(Job job) {
        this.job = job;
        nameOfMachinField.setText(job.getNameOfMachin());
        nameOfEmployeeField.setText(job.getNameOfEmployee());
        timeField.setText(job.getTime());
        costField.setText(Integer.toString(job.getCost()));
        costOfCarriageField.setText(Integer.toString(job.getCostOfCarriage()));
        nameOfJobField.setText(job.getNameOfJob());
        paymentField.setText(job.getPayment());
        noOrYesPaymentField.setCache(job.isNoOrYesPayment());
        timeField.setPromptText("00-00");
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            job.setNameOfMachin(nameOfMachinField.getText());
            job.setNameOfEmployee(nameOfEmployeeField.getText());
            job.setTime(timeField.getText());
            job.setCost(Integer.parseInt(costField.getText()));
            job.setCostOfCarriage(Integer.parseInt(costOfCarriageField.getText()));
            job.setNameOfJob(nameOfJobField.getText());
            job.setPayment(paymentField.getText());
            job.setNoOrYesPayment(Boolean.parseBoolean(noOrYesPaymentField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (nameOfMachinField.getText() == null || nameOfMachinField.getText().length() ==
                0) {
            errorMessage += "Не введена назва техніки!\n";
        }
        if (nameOfEmployeeField.getText() == null || nameOfEmployeeField.getText().length() ==
                0) {
            errorMessage += "Не введено працівника!\n";
        }
        if (timeField.getText() == null || timeField.getText().length() == 0) {
            errorMessage += "Не введений час!\n";
        }
        if (costField.getText() == null || costField.getText().length()
                == 0) {
            errorMessage += "Не введено вартість!\n";
        } else {
            try {
                Integer.parseInt(costField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Потрібно ввести цифри!\n";
            }
        }
        if (costOfCarriageField.getText() == null || costOfCarriageField.getText().length()
                == 0) {
            errorMessage += "Не введено доїзд!\n";
        } else {
            try {
                Integer.parseInt(costOfCarriageField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Потрібно ввести цифри!\n";
            }
        }
        if (nameOfJobField.getText() == null || nameOfJobField.getText().length()
                == 0) {
            errorMessage += "Не введено вид роботи!\n";
        }
        if (paymentField.getText() == null || paymentField.getText().length()
                    == 0) {
                errorMessage += "Не введено вид оплати!\n";
        }
        if (noOrYesPaymentField.getText() == null || noOrYesPaymentField.getText().length()
                    == 0) {
                    errorMessage += "Не введено оплата!\n";
        } else {
            try {
                Boolean.parseBoolean(noOrYesPaymentField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Потрібно написати true або false!\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Помилка в заповненні полів");
                alert.setHeaderText("Будь ласка перевірте правильність заповнення полів");
                alert.setContentText(errorMessage);
                alert.showAndWait();

                return false;
            }
    }
}