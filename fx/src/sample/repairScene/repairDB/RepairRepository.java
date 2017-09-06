package sample.repairScene.repairDB;

import javafx.collections.ObservableList;
import sample.repairScene.dialogRepairWindow.Repair;

/**
 * Created by Макс on 06.09.2017.
 */
public interface RepairRepository {
    ObservableList<Repair> getRepairRepositoryList();
}
