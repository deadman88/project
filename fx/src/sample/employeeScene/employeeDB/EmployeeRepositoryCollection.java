package sample.employeeScene.employeeDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.employeeScene.dialogEmployeeWindow.Employee;

/**
 * Created by Макс on 06.09.2017.
 */
public class EmployeeRepositoryCollection implements EmployeeRepository {
    private ObservableList<Employee> employeeObservableList;

    public EmployeeRepositoryCollection() {
        this.employeeObservableList = FXCollections.observableArrayList();
        this.employeeObservableList.add(new Employee("Василь","Пупкін", "01.10.1975","нема",25468451541L));
    }

    @Override
    public ObservableList<Employee> getEmployeeRepositoryList() {
        return employeeObservableList;
    }
}
