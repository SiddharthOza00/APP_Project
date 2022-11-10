package ca.concordia.webapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ca.concordia.webapp.util.Constants;

public class DbConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER_NAME, Constants.DB_PASSWORD);
		return conn;
	}
}
