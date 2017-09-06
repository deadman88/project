package sample.repairScene.dialogRepairWindow;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * Created by Макс on 29.08.2017.
 */
public class Repair implements Serializable {
    private StringProperty nameOfRepair;
    private IntegerProperty costOfRepair;
    private StringProperty timeOfRepair;

    public Repair() {
        this(new SimpleStringProperty("Назва ремонту"), new SimpleIntegerProperty(0), new SimpleStringProperty("Час ремонту"));
    }

    public Repair(String nameOfRepair, int costOfRepair, String timeOfRepair) {
        this.nameOfRepair = new SimpleStringProperty(nameOfRepair);
        this.costOfRepair = new SimpleIntegerProperty(costOfRepair);
        this.timeOfRepair = new SimpleStringProperty(timeOfRepair);
    }

    public Repair(SimpleStringProperty nameOfRepair, SimpleIntegerProperty costOfRepair, SimpleStringProperty timeOfRepair) {
        this.nameOfRepair = nameOfRepair;
        this.costOfRepair = costOfRepair;
        this.timeOfRepair = timeOfRepair;
    }

    public String getNameOfRepair() {
        return nameOfRepair.get();
    }

    public StringProperty nameOfRepairProperty() {
        return nameOfRepair;
    }

    public void setNameOfRepair(String nameOfRepair) {
        this.nameOfRepair.set(nameOfRepair);
    }

    public int getCostOfRepair() {
        return costOfRepair.get();
    }

    public IntegerProperty costOfRepairProperty() {
        return costOfRepair;
    }

    public void setCostOfRepair(int costOfRepair) {
        this.costOfRepair.set(costOfRepair);
    }

    public String getTimeOfRepair() {
        return timeOfRepair.get();
    }

    public StringProperty timeOfRepairProperty() {
        return timeOfRepair;
    }

    public void setTimeOfRepair(String timeOfRepair) {
        this.timeOfRepair.set(timeOfRepair);
    }
}
