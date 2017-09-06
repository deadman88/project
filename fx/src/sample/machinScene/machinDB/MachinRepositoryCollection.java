package sample.machinScene.machinDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.machinScene.dialogMachinWindow.Machin;

/**
 * Created by Макс on 06.09.2017.
 */
public class MachinRepositoryCollection implements MachinRepository {
    private ObservableList<Machin> machinObservableList;

    public MachinRepositoryCollection() {
        this.machinObservableList = FXCollections.observableArrayList();
        this.machinObservableList.add(new Machin("JCB","1","15-00","BO0000BO", "2001"));
    }

    @Override
    public ObservableList<Machin> getMachinRepositoryList() {
        return machinObservableList;
    }
}
