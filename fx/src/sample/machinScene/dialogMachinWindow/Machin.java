package sample.machinScene.dialogMachinWindow;

/**
 * Created by Макс on 29.08.2017.
 */
public class Machin {
    private String firstNameOfMachin;
    private String secondNameOfMachin;
    private String licensePlate;
    private String year;

    public String getFirstNameOfMachin() {
        return firstNameOfMachin;
    }

    public void setFirstNameOfMachin(String firstNameOfMachin) {
        this.firstNameOfMachin = firstNameOfMachin;
    }

    public String getSecondNameOfMachin() {
        return secondNameOfMachin;
    }

    public void setSecondNameOfMachin(String secondNameOfMachin) {
        this.secondNameOfMachin = secondNameOfMachin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Machin() {
        this.firstNameOfMachin = firstNameOfMachin;
        this.secondNameOfMachin = secondNameOfMachin;
        this.licensePlate = licensePlate;
        this.year = year;
    }

}
