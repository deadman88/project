package sample.jobScene.jobDB;

import javafx.collections.ObservableList;
import sample.jobScene.dialogJobWindow.Job;

/**
 * Created by Макс on 06.09.2017.
 */
public interface JobRepository {
    ObservableList<Job> getJobRepositoryList();

}

