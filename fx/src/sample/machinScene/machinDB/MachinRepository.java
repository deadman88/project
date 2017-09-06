package sample.machinScene.machinDB;

import javafx.collections.ObservableList;
import sample.machinScene.dialogMachinWindow.Machin;

/**
 * Created by Макс on 06.09.2017.
 */
public interface MachinRepository {
    ObservableList<Machin> getMachinRepositoryList();
}
