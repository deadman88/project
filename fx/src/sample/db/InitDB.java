package sample.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Макс on 30.08.2017.
 */
public class InitDB {
    public static void initDB() {
        String sql = "CREATE TABLE IF NOT EXISTS work( " +
                "ID INT AUTO_INCREMENT, " +
                "NAME VARCHAR(255) DEFAULT 'Maxym'," +
                "POS VARCHAR(255) DEFAULT 'Software engineer'," +
                "PRIMARY KEY(ID))";
            try (Connection connection = Connector.getConnection();
                 Statement statement = connection.createStatement();) {
                statement.execute(sql);
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initDB();
    }
}
