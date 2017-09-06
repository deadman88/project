package sample.jobScene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.jobScene.jobDB.JobDB;
import sample.jobScene.dialogJobWindow.Job;
import sample.jobScene.dialogJobWindow.JobEditDialogController;
import sample.employeeScene.EmployeeScene;
import sample.machinScene.MachinScene;
import sample.repairScene.RepairScene;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Created by Макс on 25.08.2017.
 */
public class JobController {
    private final ObservableList<Job> jobData = FXCollections.observableArrayList();
    private Main main;
    private LocalDate localDate;
    JobDB repository;

    public Main getMain(){return main;}

    public void setMain(Main main) {
        this.main = main;
        jobTable.setItems(repository.getJobRepositoryList());
    }

    @FXML
    private TableView<Job> jobTable;

    public TableView<Job> getJobTable() {
        return jobTable;
    }

    public void setJobTable(TableView<Job> jobTable) {
        this.jobTable = jobTable;
    }

    @FXML
    private TableColumn<Job, String> nameOfMachinColumn;
    @FXML
    private TableColumn<Job, String> nameOfEmployeeColumn;
    @FXML
    private TableColumn<Job, LocalDateTime> timeColumn;
    @FXML
    private TableColumn<Job, Integer> costColumn;
    @FXML
    private TableColumn<Job, Integer> costOfCarriageColumn;
    @FXML
    private TableColumn<Job, String> nameOfJobColumn;
    @FXML
    private TableColumn<Job, String> paymentColumn;
    @FXML
    private TableColumn<Job, Boolean> noOrYesPaymentColumn;
    @FXML
    private DatePicker   datePicker;


    public JobController() {
        repository = new JobDB();
    }

    @FXML
    public void handleOnFromDate() {
        this.localDate = datePicker.getValue();
        System.out.println(this.localDate);
    }
    @FXML
    private void handleDeleteJob() {
        int selectedIndex = jobTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            jobTable.getItems().remove(selectedIndex);
            Job job = jobTable.getSelectionModel().getSelectedItem();
            String nameOfMachinColumn = job.getNameOfMachin();
            String nameOfEmployeeColumn = job.getNameOfEmployee();
            repository.remove(nameOfMachinColumn, nameOfEmployeeColumn);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Помилка");
            alert.setHeaderText("Не вибрана робота");
            alert.setContentText("Будь ласка виберіть роботу, для того щоб видалити.");
            alert.showAndWait();
        }
    }

    public boolean showJobEditDialog(Job job) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JobEditDialogController.class.getResource("JobEditDialog.fxml"));
                    AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Редагування роботи");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            JobEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setJob(job);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void handleNewjob() {
        Job tempJob = new Job();
        boolean okClicked = showJobEditDialog(tempJob);
        if (okClicked) {
            jobData.add(tempJob);
            repository.insertIntoDB(tempJob);
        }
    }
    @FXML
    private void handleEditJob() {
        Job selectedJob = jobTable.getSelectionModel().getSelectedItem();
        if (selectedJob != null) {
            boolean okClicked =showJobEditDialog(selectedJob);
            if (okClicked) {
                int selectedIndex =
                        jobTable.getSelectionModel().getSelectedIndex();
                jobData.set(selectedIndex, selectedJob);
                showJobEditDialog(selectedJob);
                repository.updateIntoDB(
                        selectedJob.getNameOfMachin(),
                        selectedJob.getNameOfEmployee(),
                        selectedJob.getTime(),
                        selectedJob.getCost(),
                        selectedJob.getCostOfCarriage(),
                        selectedJob.getNameOfJob(),
                        selectedJob.getPayment(),
                        selectedJob.isNoOrYesPayment());
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
    public void goToMachinScene(ActionEvent event) {
        try {
            new MachinScene();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize() {
        nameOfMachinColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfMachin"));
        nameOfEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfEmployee"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        costOfCarriageColumn.setCellValueFactory(new PropertyValueFactory<>("costOfCarriage"));
        nameOfJobColumn.setCellValueFactory(new PropertyValueFactory<>("nameOfJob"));
        paymentColumn.setCellValueFactory(new PropertyValueFactory<>("payment"));
        noOrYesPaymentColumn.setCellValueFactory(new PropertyValueFactory<>("noOrYesPayment"));
        jobTable.setItems(jobData);
    }
}
