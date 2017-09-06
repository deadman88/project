package sample.jobScene.jobDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.jobScene.jobDB.JobRepository;
import sample.jobScene.dialogJobWindow.Job;

/**
 * Created by Макс on 06.09.2017.
 */
public class JobRepositoryCollection implements JobRepository {
    private ObservableList<Job> jobObservableList;

    public JobRepositoryCollection() {
        this.jobObservableList = FXCollections.observableArrayList();
        this.jobObservableList.add(new Job("JCB","Вася","15-00",2500, 500,"копання", "Нал", true));
    }

    @Override
    public ObservableList<Job> getJobRepositoryList() {
        return jobObservableList;
    }
}
