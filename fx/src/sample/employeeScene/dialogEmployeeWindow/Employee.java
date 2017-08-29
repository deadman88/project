package sample.employeeScene.dialogEmployeeWindow;

/**
 * Created by Макс on 29.08.2017.
 */
public class Employee {
    private String firstNameOfEmployee;
    private String secondNameOfEmployee;
    private String dateOfBirthday;
    private String passport;
    private long idNumber;

    public Employee() {
        this.firstNameOfEmployee = firstNameOfEmployee;
        this.secondNameOfEmployee = secondNameOfEmployee;
        this.dateOfBirthday = dateOfBirthday;
        this.passport = passport;
        this.idNumber = idNumber;
    }

    public String getFirstNameOfEmployee() {

        return firstNameOfEmployee;
    }

    public void setFirstNameOfEmployee(String firstNameOfEmployee) {
        this.firstNameOfEmployee = firstNameOfEmployee;
    }

    public String getSecondNameOfEmployee() {
        return secondNameOfEmployee;
    }

    public void setSecondNameOfEmployee(String secondNameOfEmployee) {
        this.secondNameOfEmployee = secondNameOfEmployee;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }
}
