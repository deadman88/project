package sample.repairScene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.employeeScene.EmployeeScene;
import sample.machinScene.MachinScene;
import sample.repairScene.dialogRepairWindow.Repair;
import sample.repairScene.dialogRepairWindow.RepairEditDialogController;
import sample.repairScene.repairDB.RepairDB;

import java.io.IOException;
import java.time.LocalDate;


/**
 * Created by Макс on 29.08.2017.
 */
public class RepairSceneController {
    private final ObservableList<Repair> repairData = FXCollections.observableArrayList();
    private ObservableList<String> dayOr = FXCollections.observableArrayList("Вася","Петро","Додік");
    private LocalDate localDate;
    private Repair repair;
    RepairDB repository;

    public Repair getRepair(){return repair;}

    public void setRepair(Repair repair){
        this.repair = repair;
        repairTable.setItems(repository.getRepairRepositoryList());
    }

    @FXML
    private TableView<Repair> repairTable;
    @FXML
    private TableColumn<Repair, String> nameOfRepairColumn;
    @FXML
    private TableColumn<Repair, Integer> costOfRepairColumn;
    @FXML
    private TableColumn<Repair, String> timeOfRepairColumn;
    @FXML
    private ComboBox<String> comboBox; //через свічі
    @FXML
    private DatePicker   datePicker; //опрацювання івенту

    public RepairSceneController(){repository = new RepairDB();}

    @FXML
    public void handleOnFromDate() {
        this.localDate = datePicker.getValue();
        System.out.println(this.localDate);
    }

    @FXML
    private void handleDeleteRepair() {
        int selectedIndex = repairTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            repairTable.getItems().remove(selectedIndex);
            Repair repair = repairTable.getSelectionModel().getSelectedItem();
            String nameOfRepair = repair.getNameOfRepair();
            String timeOfRepair = repair.getTimeOfRepair();
            repository.remove(nameOfRepair, timeOfRepair);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Помилка");
            alert.setHeaderText("Не вибраний ремонт");
            alert.setContentText("Будь ласка виберіть ремон, для того щоб видалити.");
            alert.showAndWait();
        }
    }


    public boolean showRepairEditDialog(Repair repair) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RepairEditDialogController.class.getResource("EmployeeEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Редагування ремонту");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            RepairEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setRepair(repair);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void handleNewRepair() {
        Repair tempRepair = new Repair();
        boolean okClicked = showRepairEditDialog(tempRepair);
        if (okClicked) {
            repairData.add(tempRepair);
            repository.insertIntoDB(tempRepair);
        }
    }
    @FXML
    private void handleEditRepair() {
        Repair selectedRepair = repairTable.getSelectionModel().getSelectedItem();
        if (selectedRepair != null) {
            boolean okClicked = showRepairEditDialog(selectedRepair);
            if (okClicked) {
                int selectedIndex =
                        repairTable.getSelectionModel().getSelectedIndex();
                repairData.set(selectedIndex, selectedRepair);
                repository.updateIntoDB(
                        selectedRepair.getNameOfRepair(),
                        selectedRepair.getCostOfRepair(),
                        selectedRepair.getTimeOfRepair());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Помилка");
            alert.setHeaderText("Не вибрано ремонт");
            alert.setContentText("Будь ласка, виберіть ремонт з таблички");
            alert.showAndWait();
        }
    }

    @FXML
    public void goToMachinScene(ActionEvent event) {
        try {
            new MachinScene();
        }
        catch (Exception e) {
            e.printStackTrace();
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
    public void goToJobScene(ActionEvent event) {

        try {
            new Main();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void dayRepair(ActionEvent event){
//        if(comboBox.getItems()=dayOr.get(0){
//        }
//    }

    @FXML
    public void initialize() {
//        datePicker.setC
        comboBox.getItems().clear();
        comboBox.getItems().addAll(dayOr);
//        comboBox.setOnAction(ActionEvent
        nameOfRepairColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfRepairColumn"));
        costOfRepairColumn.setCellValueFactory(new PropertyValueFactory<>("costOfRepairColumn"));
        timeOfRepairColumn.setCellValueFactory(new PropertyValueFactory<>("timeOfRepair"));
        repairTable.setItems(repairData);
    }

}
