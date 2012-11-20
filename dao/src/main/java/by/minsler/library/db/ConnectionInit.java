package by.minsler.library.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInit implements ServletContextListener {

	private static Connection connection = null;
	private static ServletContext context = null;

	public void contextInitialized(ServletContextEvent event) {
		context = event.getServletContext();
		String jdbcDriverName = context.getInitParameter("jdbcDriverName");
		String jdbcUrl = context.getInitParameter("jdbcUrl");
		String jdbcUser = context.getInitParameter("jdbcUser");
		String jdbcPassword = context.getInitParameter("jdbcPassword");

		try {
			Class.forName(jdbcDriverName);
            //for mysql
			//connection = DriverManager.getConnection(jdbcUrl, jdbcUser,jdbcPassword);

            // for sqlite
            connection = DriverManager.getConnection("jdbc:sqlite:library.sqlite3");
			context.log("jdbc driver: connection created");
			context.setAttribute("connection", connection);
			System.out.println("connectin created");
		} catch (ClassNotFoundException e) {
			context.log("jdbc driver: Class not found: " + e);
		} catch (SQLException e) {
			context.log("sql exception: " + e);
		}

	}

	public void contextDestroyed(ServletContextEvent event) {
		if (connection != null) {
			try {
				connection.close();
				context.log("jdbc connection closed");
			} catch (SQLException e) {
				context.log("sql exception: " + e);
			}
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
