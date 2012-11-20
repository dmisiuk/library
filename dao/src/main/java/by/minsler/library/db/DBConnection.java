package by.minsler.library.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * User: dzmitry.misiuk
 * Date: 11/20/12
 * Time: 3:42 PM
 */
public class DBConnection {

    private Connection connection;

    private static DBConnection ourInstance = new DBConnection();

    public static DBConnection getInstance() {
        return ourInstance;
    }

    private DBConnection() {
        String jdbcDriverName = null;
        String url = null;
        try {
            Properties prop = new Properties();
            prop.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
            jdbcDriverName = prop.getProperty("jdbcDriverName");
            url = prop.getProperty("url");
            System.out.println(jdbcDriverName + " " + url );
            Class.forName(jdbcDriverName);
            connection = DriverManager.getConnection(url);
            System.out.println(connection);
        } catch (IOException ex) {
            System.out.println("error load properties to db. please add config db.properties");
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class " + jdbcDriverName + " not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("sql exception: for url " + url);
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
