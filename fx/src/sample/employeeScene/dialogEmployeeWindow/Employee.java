package sample.employeeScene.dialogEmployeeWindow;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Макс on 29.08.2017.
 */
public class Employee {
    private StringProperty firstNameOfEmployee;
    private StringProperty secondNameOfEmployee;
    private StringProperty dateOfBirthday;
    private StringProperty passport;
    private LongProperty idNumber;

    public Employee() {
        this(new SimpleStringProperty("Ім'я"), new SimpleStringProperty("Прізвище"),
                new SimpleStringProperty("День народження"),
                new SimpleStringProperty("Паспорт"), new SimpleLongProperty(25L));
    }

    public Employee(String firstNameOfEmployee, String secondNameOfEmployee,
                    String dateOfBirthday, String passport, long idNumber) {
        this.firstNameOfEmployee = new SimpleStringProperty(firstNameOfEmployee);
        this.secondNameOfEmployee = new SimpleStringProperty(secondNameOfEmployee);
        this.dateOfBirthday = new SimpleStringProperty(dateOfBirthday);
        this.passport = new SimpleStringProperty(passport);
        this.idNumber = new SimpleLongProperty(idNumber);
    }

    public Employee(SimpleStringProperty firstNameOfEmployee, SimpleStringProperty secondNameOfEmployee,
                    SimpleStringProperty dateOfBirthday, SimpleStringProperty passport, SimpleLongProperty idNumber) {
        this.firstNameOfEmployee = firstNameOfEmployee;
        this.secondNameOfEmployee = secondNameOfEmployee;
        this.dateOfBirthday = dateOfBirthday;
        this.passport = passport;
        this.idNumber = idNumber;
    }

    public String getFirstNameOfEmployee() {
        return firstNameOfEmployee.get();
    }

    public StringProperty firstNameOfEmployeeProperty() {
        return firstNameOfEmployee;
    }

    public void setFirstNameOfEmployee(String firstNameOfEmployee) {
        this.firstNameOfEmployee.set(firstNameOfEmployee);
    }

    public String getSecondNameOfEmployee() {
        return secondNameOfEmployee.get();
    }

    public StringProperty secondNameOfEmployeeProperty() {
        return secondNameOfEmployee;
    }

    public void setSecondNameOfEmployee(String secondNameOfEmployee) {
        this.secondNameOfEmployee.set(secondNameOfEmployee);
    }

    public String getDateOfBirthday() {
        return dateOfBirthday.get();
    }

    public StringProperty dateOfBirthdayProperty() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday.set(dateOfBirthday);
    }

    public String getPassport() {
        return passport.get();
    }

    public StringProperty passportProperty() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport.set(passport);
    }

    public long getIdNumber() {
        return idNumber.get();
    }

    public LongProperty idNumberProperty() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber.set(idNumber);
    }
}
