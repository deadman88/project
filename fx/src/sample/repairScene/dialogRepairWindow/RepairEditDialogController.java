package sample.repairScene.dialogRepairWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Макс on 29.08.2017.
 */
public class RepairEditDialogController {
    @FXML
    private TextField nameOfRepairField;
    @FXML
    private TextField costOfRepairField;
    @FXML
    private TextField timeOfRepairField;

    private Stage dialogStage;
    private Repair repair;
    private boolean okClicked = false;


    @FXML
    private void initialize() {

    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
        nameOfRepairField.setText(repair.getNameOfRepair());
        costOfRepairField.setText(Integer.toString(repair.getCostOfRepair()));
        timeOfRepairField.setText(repair.getTimeOfRepair());
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            repair.setNameOfRepair(nameOfRepairField.getText());
            repair.setCostOfRepair(Integer.parseInt(costOfRepairField.getText()));
            repair.setTimeOfRepair(timeOfRepairField.getText());
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
        if (nameOfRepairField.getText() == null || nameOfRepairField.getText().length() ==
                0) {
            errorMessage += "Не введено вид ремонту!\n";
        }
        if (costOfRepairField.getText() == null || costOfRepairField.getText().length() ==
                0) {
            errorMessage += "Не введено вартість!\n";
        } else {
            try {
                Integer.parseInt(costOfRepairField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Потрібно ввести цифри!\n";
            }
        }
        if (timeOfRepairField.getText() == null || timeOfRepairField.getText().length() == 0) {
            errorMessage += "Не введено час!\n";
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
