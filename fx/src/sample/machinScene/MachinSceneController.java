package sample.machinScene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.employeeScene.EmployeeScene;
import sample.machinScene.dialogMachinWindow.Machin;
import sample.machinScene.dialogMachinWindow.MachinEditDialogController;
import sample.machinScene.machinDB.MachinDB;
import sample.repairScene.RepairScene;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by Макс on 29.08.2017.
 */
public class MachinSceneController {
    private final ObservableList<Machin> machinData = FXCollections.observableArrayList();
    private LocalDate localDate;
    private Machin machin;
    MachinDB repository;

    public MachinSceneController(){ repository = new MachinDB();}

    public Machin getMachin(){return machin;}

    public void setMachin(Machin machin){
        this.machin = machin;
        machinTable.setItems(repository.getMachinRepositoryList());
    }


    @FXML
    private TableView<Machin> machinTable;
    @FXML
    private TableColumn<Machin, String> firstNameOfMachinColumn;
    @FXML
    private TableColumn<Machin, String> secondNameOfMachinColumn;
    @FXML
    private TableColumn<Machin, String> licensePlateColumn;
    @FXML
    private TableColumn<Machin, String> yearColumn;
    @FXML
    private DatePicker datePicker;



    @FXML
    public void handleOnFromDate() {
        this.localDate = datePicker.getValue();
        System.out.println(this.localDate);
    }

    @FXML
    private void handleDeleteMachin() {
        int selectedIndex = machinTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            machinTable.getItems().remove(selectedIndex);
            Machin machin = machinTable.getSelectionModel().getSelectedItem();
            String firstNameOfMachinColumn = machin.getFirstNameOfMachin();
            String secondNameOfMachinColumn = machin.getSecondNameOfMachin();
            repository.remove(firstNameOfMachinColumn, secondNameOfMachinColumn);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Помилка");
            alert.setHeaderText("Не вибрана техніка");
            alert.setContentText("Будь ласка виберіть техніку, для того щоб видалити.");
            alert.showAndWait();
        }
    }
    public boolean showMachinEditDialog(Machin machin) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MachinEditDialogController.class.getResource("MachinEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Редагування техніки");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            MachinEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMachin(machin);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @FXML
    private void handleNewMachin() {
        Machin tempMachin = new Machin();
        boolean okClicked = showMachinEditDialog(tempMachin);
        if (okClicked) {
            machinData.add(tempMachin);
            repository.insertIntoDB(tempMachin);
        }
    }

    @FXML
    private void handleEditMachin() {
        Machin selectedMachin = machinTable.getSelectionModel().getSelectedItem();
        if (selectedMachin != null) {
            boolean okClicked =showMachinEditDialog(selectedMachin);
            if (okClicked) {
                int selectedIndex =
                        machinTable.getSelectionModel().getSelectedIndex();
                machinData.set(selectedIndex, selectedMachin);
                repository.updateIntoDB(
                        selectedMachin.getFirstNameOfMachin(),
                        selectedMachin.getSecondNameOfMachin(),
                        selectedMachin.getLicensePlate(),
                        selectedMachin.getYear());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Помилка");
            alert.setHeaderText("Не вибрано роботи");
            alert.setContentText("Будь ласка, виберіть роботу з таблички");
            alert.showAndWait();
        }
    }

    @FXML
    public void goToEmployeeScene(ActionEvent event) {
        try {
            new EmployeeScene();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void goToRepairScene(ActionEvent event) {
        try {
            new RepairScene();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void goToJobScene(ActionEvent event) {
        try {
            new Main();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        firstNameOfMachinColumn.setCellValueFactory(new PropertyValueFactory<>("firstNameOfMachin"));
        secondNameOfMachinColumn.setCellValueFactory(new PropertyValueFactory<>("secondNameOfMachin"));
        licensePlateColumn.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        machinTable.setItems(machinData);
    }

}
