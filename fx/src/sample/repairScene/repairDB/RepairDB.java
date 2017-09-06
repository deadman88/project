package sample.repairScene.repairDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.db.Connector;
import sample.repairScene.dialogRepairWindow.Repair;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Макс on 06.09.2017.
 */
public class RepairDB implements RepairRepository {
    private final static Logger LOGGER = Logger.getLogger("RepairDB.class");
    private ObservableList<Repair> repairObservableList;
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

    public void remove(String nameOfRepair, String timeOfRepair) {
        String sql = "DELETE FROM repair WHERE NAMEOFREPAIR = ? AND TIMEOFREPAIR = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nameOfRepair);
            statement.setString(3, timeOfRepair);
            statement.execute();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    public void updateIntoDB(String nameOfRepair,int costOfRepair,String timeOfRepair) {
        String sql = "UPDATE repair SET NAMEOFREPAIR=?, COSTOFREPAIR" +
                "=?, TIMEOFREPAIR=? WHERE NAMEOFREPAIR = ? AND TIMEOFREPAIR = ?";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nameOfRepair);
            statement.setInt(2, costOfRepair);
            statement.setString(3, timeOfRepair);

            int rs = statement.executeUpdate();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }


    public static void initDB() {
        String sql = "CREATE TABLE IF NOT EXISTS repair " +
                "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                "NAMEOFREPAIR VARCHAR(255) NOT NULL," +
                "COSTOFREPAIR INT NOT NULL," +
                "TIMEOFREPAIR VARCHAR(255) NOT NULL," +
                ")";
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoDB(Repair repair) {
        this.insertIntoDB(repair.getNameOfRepair(), repair.getCostOfRepair(), repair.getTimeOfRepair());
    }

    public void insertIntoDB(String nameOfRepair, int costOfRepair, String timeOfRepair) {
        String sql = "INSERT INTO repair(NAMEOFREPAIR,COSTOFREPAIR,TIMEOFREPAIR) VALUES(?,?,?)";
        try (Connection connection = this.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nameOfRepair);
            statement.setInt(2, costOfRepair);
            statement.setString(3, timeOfRepair);
            statement.execute();
        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    public void fillDB() {
        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO repair(NAMEOFREPAIR,COSTOFREPAIR,TIMEOFREPAIR) " +
                    "VALUES(\'Камаз\', 1500, \'5 днів\')");

        } catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
    }

    @Override
    public ObservableList<Repair> getRepairRepositoryList() {
        repairObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM repair";
        try(Connection connection = this.getConnection();
            Statement statement = connection.createStatement();){

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String nameOfMachin = resultSet.getString("NAMEOFREPAIR");
                int costOfCarriage = resultSet.getInt("COSTOFREPAIR");
                String nameOfJob = resultSet.getString("TIMEOFREPAIR");
                Repair r = new Repair( nameOfMachin, costOfCarriage, nameOfJob );
                repairObservableList.add(r);
            }

        }catch (SQLException sqlexception) {
            LOGGER.log(Level.WARNING, sqlexception.getMessage(), sqlexception);
        }
        return repairObservableList;
    }

}
