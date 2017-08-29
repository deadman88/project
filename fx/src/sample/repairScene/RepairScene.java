package sample.repairScene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Макс on 29.08.2017.
 */
public class RepairScene {

    public RepairScene() throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RepairScene.fxml"));
        AnchorPane load = (AnchorPane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Діамант group   -   Ремонт");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
