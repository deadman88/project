package sample.employeeScene.employeeDB;

import javafx.collections.ObservableList;
import sample.employeeScene.dialogEmployeeWindow.Employee;

/**
 * Created by Макс on 06.09.2017.
 */
public interface EmployeeRepository {
    ObservableList<Employee> getEmployeeRepositoryList();
}
