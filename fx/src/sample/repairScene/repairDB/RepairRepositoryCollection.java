package sample.repairScene.repairDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.repairScene.dialogRepairWindow.Repair;

/**
 * Created by Макс on 06.09.2017.
 */
public class RepairRepositoryCollection implements RepairRepository {
    private ObservableList<Repair> repairObservableList;

    public RepairRepositoryCollection() {
        this.repairObservableList = FXCollections.observableArrayList();
        this.repairObservableList.add(new Repair("JCB",2500, "5 днів"));
    }

    @Override
    public ObservableList<Repair> getRepairRepositoryList() {
        return repairObservableList;
    }
}
