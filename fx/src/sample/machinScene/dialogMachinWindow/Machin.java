package sample.machinScene.dialogMachinWindow;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Макс on 29.08.2017.
 */
public class Machin {
    private StringProperty firstNameOfMachin;
    private StringProperty secondNameOfMachin;
    private StringProperty licensePlate;
    private StringProperty year;

    public Machin() {
        this(new SimpleStringProperty("Марка"), new SimpleStringProperty("Модель"),
                new SimpleStringProperty("Номерний знак"), new SimpleStringProperty("Рік випуску"));
    }

    public Machin(String firstNameOfMachin, String secondNameOfMachin,
                  String licensePlate, String year) {
        this.firstNameOfMachin = new SimpleStringProperty(firstNameOfMachin);
        this.secondNameOfMachin = new SimpleStringProperty(secondNameOfMachin);
        this.licensePlate = new SimpleStringProperty(licensePlate);
        this.year = new SimpleStringProperty(year);
    }
    public Machin(SimpleStringProperty firstNameOfMachin, SimpleStringProperty secondNameOfMachin,
                  SimpleStringProperty licensePlate, SimpleStringProperty year) {
        this.firstNameOfMachin = firstNameOfMachin;
        this.secondNameOfMachin = secondNameOfMachin;
        this.licensePlate = licensePlate;
        this.year = year;
    }

    public String getFirstNameOfMachin() {
        return firstNameOfMachin.get();
    }

    public StringProperty firstNameOfMachinProperty() {
        return firstNameOfMachin;
    }

    public void setFirstNameOfMachin(String firstNameOfMachin) {
        this.firstNameOfMachin.set(firstNameOfMachin);
    }

    public String getSecondNameOfMachin() {
        return secondNameOfMachin.get();
    }

    public StringProperty secondNameOfMachinProperty() {
        return secondNameOfMachin;
    }

    public void setSecondNameOfMachin(String secondNameOfMachin) {
        this.secondNameOfMachin.set(secondNameOfMachin);
    }

    public String getLicensePlate() {
        return licensePlate.get();
    }

    public StringProperty licensePlateProperty() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate.set(licensePlate);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }
}
