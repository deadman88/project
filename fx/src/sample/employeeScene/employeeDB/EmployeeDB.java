package sample.employeeScene.employeeDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.db.Connector;
import sample.employeeScene.dialogEmployeeWindow.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Макс on 06.09.2017.
 */
public class EmployeeDB implements EmployeeRepository {
    private final static Logger LOGGER = Logger.getLogger("EmployeeDB.class");
    private ObservableList<Employee> employeeObservableList;
    private Connection connection;

    public static void main(String[] args) {
        initDB();
    }

    public static Connection getConnection() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        Connection connection = null;
        try {
            Class.forName(properties.getProperty("db.driver"));
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void remove(String firstNameOfEmployee, String secondNameOfEmployee) {
        String sql = "DELETE FROM employee WHERE FIRSTNAMEOFEMPLOYEE = ? AND SECONDNAMEOFEMPLOYEE = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstNameOfEmployee);
            statement.setString(2, secondNameOfEmployee);
            statement.execute();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    public void updateIntoDB(String firstNameOfEmployee, String secondNameOfEmployee, String dateOfBirthday,
                             String passport, long idNumber) {
        String sql = "UPDATE employee SET FIRSTNAMEOFEMPLOYEE=?, SECONDNAMEOFEMPLOYEE" +
                "=?, DATEOFBIRTHDAY=?, PASSPORT=?, IDNUMBER=? WHERE FIRSTNAMEOFEMPLOYEE = ? AND SECONDNAMEOFEMPLOYEE = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstNameOfEmployee);
            statement.setString(2, secondNameOfEmployee);
            statement.setString(3, dateOfBirthday);
            statement.setString(4, passport);
            statement.setLong(5, idNumber);

            int rs = statement.executeUpdate();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }


    public static void initDB() {
        String sql = "CREATE TABLE IF NOT EXISTS employee " +
                "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                "FIRSTNAMEOFEMPLOYEE VARCHAR(255) NOT NULL," +
                "SECONDNAMEOFEMPLOYEE VARCHAR(255) NOT NULL," +
                "DATEOFBIRTHDAY VARCHAR(255) NOT NULL," +
                "PASSPORT VARCHAR(255) NOT NULL," +
                "IDNUMBER LONG NOT NULL," +
                ")";
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoDB(Employee employee) {
        this.insertIntoDB(employee.getFirstNameOfEmployee(), employee.getSecondNameOfEmployee(),
                employee.getDateOfBirthday(), employee.getPassport(), employee.getIdNumber());
    }

    public void insertIntoDB(String firstNameOfEmployee, String secondNameOfEmployee, String dateOfBirthday,
                             String passport, long idNumber) {
        String sql = "INSERT INTO employee(FIRSTNAMEOFEMPLOYEE,SECONDNAMEOFEMPLOYEE," +
                "DATEOFBIRTHDAY, PASSPORT, IDNUMBER) VALUES(?,?,?,?,?)";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstNameOfEmployee);
            statement.setString(2, secondNameOfEmployee);
            statement.setString(3, dateOfBirthday);
            statement.setString(4, passport);
            statement.setLong(5, idNumber);
            statement.execute();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    public void fillDB() {
        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO employee(FIRSTNAMEOFEMPLOYEE,SECONDNAMEOFEMPLOYEE," +
                    "DATEOFBIRTHDAY,PASSPORT,IDNUMBER) " +
                    "VALUES(\'Петро\', \'Федів\',\'15.04.1985\',\'Згорів\'),25)");

        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    @Override
    public ObservableList<Employee> getEmployeeRepositoryList() {
        employeeObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM employee";
        try(Connection connection = this.getConnection();
            Statement statement = connection.createStatement();){

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String firstNameOfEmployee = resultSet.getString("FIRSTNAMEOFEMPLOYEE");
                String secondNameOfEmployee = resultSet.getString("SECONDNAMEOFEMPLOYEE");
                String dateOfBirthday = resultSet.getString("DATEOFBIRTHDAY");
                String passport = resultSet.getString("PASSPORT");
                int idNumber = resultSet.getInt("IDNUMBER");
                Employee e = new Employee( firstNameOfEmployee, secondNameOfEmployee, dateOfBirthday,
                        passport,idNumber );
                employeeObservableList.add(e);
            }

        }catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
        return employeeObservableList;
    }

}

