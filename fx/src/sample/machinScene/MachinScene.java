package sample.machinScene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by Макс on 29.08.2017.
 */
public class MachinScene {
    public MachinScene() throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MachinScene.fxml"));
        AnchorPane load = (AnchorPane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Діамант group   -   Техніка");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}
