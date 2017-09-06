package sample.machinScene.machinDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.db.Connector;
import sample.machinScene.dialogMachinWindow.Machin;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Макс on 06.09.2017.
 */
public class MachinDB implements MachinRepository {
    private final static Logger LOGGER = Logger.getLogger("MachinDB.class");
    private ObservableList<Machin> machinObservableList;
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

    public void remove(String firstNameOfMachin, String secondNameOfMachin) {
        String sql = "DELETE FROM machin WHERE FIRSTNAMEOFMACHIN = ? AND SECONDNAMEOFMACHIN = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstNameOfMachin);
            statement.setString(2, secondNameOfMachin);
            statement.execute();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    public void updateIntoDB(String firstNameOfMachin, String secondNameOfMachin,
                             String licensePlate, String year) {
        String sql = "UPDATE machin SET FIRSTNAMEOFMACHIN=?, SECONDNAMEOFMACHIN=?, " +
                "LICENSEPLATE=?, YEAR=? WHERE FIRSTNAMEOFMACHIN = ? AND SECONDNAMEOFMACHIN = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstNameOfMachin);
            statement.setString(2, secondNameOfMachin);
            statement.setString(3, licensePlate);
            statement.setString(4, year);

            int rs = statement.executeUpdate();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }


    public static void initDB() {
        String sql = "CREATE TABLE IF NOT EXISTS machin " +
                "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                "FIRSTNAMEOFMACHIN VARCHAR(255) NOT NULL," +
                "SECONDNAMEOFMACHIN VARCHAR(255) NOT NULL, " +
                "LICENSEPLATE VARCHAR(255) NOT NULL," +
                "YEAR VARCHAR(255) NOT NULL)";
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoDB(Machin machin) {
        this.insertIntoDB(machin.getFirstNameOfMachin(), machin.getSecondNameOfMachin(),
                machin.getLicensePlate(), machin.getYear());
    }

    public void insertIntoDB(String firstNameOfMachin, String secondNameOfMachin,
                             String licensePlate, String year) {
        String sql = "INSERT INTO machin(FIRSTNAMEOFMACHIN,SECONDNAMEOFMACHIN,LICENSEPLATE,YEAR)" +
                " VALUES(?,?,?,?)";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstNameOfMachin);
            statement.setString(2, secondNameOfMachin);
            statement.setString(3, licensePlate);
            statement.setString(4, year);
            statement.execute();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    public void fillDB() {
        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO machin(FIRSTNAMEOFMACHIN,SECONDNAMEOFMACHIN," +
                    "LICENSEPLATE,YEAR) " +
                    "VALUES(\'JCB\', \'C-2\', \'BO9999BO\',\'2009\')");

        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    @Override
    public ObservableList<Machin> getMachinRepositoryList() {
        machinObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM machin";
        try(Connection connection = this.getConnection();
            Statement statement = connection.createStatement();){

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String firstNameOfMachin = resultSet.getString("FIRSTNAMEOFMACHIN");
                String secondNameOfMachin = resultSet.getString("SECONDNAMEOFMACHIN");
                String licensePlate = resultSet.getString("LICENSEPLATE");
                String year = resultSet.getString("YEAR");
                Machin m = new Machin( firstNameOfMachin, secondNameOfMachin, licensePlate, year);
                machinObservableList.add(m);
            }

        }catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
        return machinObservableList;
    }


}
