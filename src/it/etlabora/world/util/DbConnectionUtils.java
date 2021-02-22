package it.etlabora.world.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtils {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Class.forName(Constants.DB_DRIVER);
		//			Driver d = new Driver();
		//			DriverManager.registerDriver(new Driver());
		conn = DriverManager.getConnection(Constants.DB_NAME, Constants.DB_USERNAME, Constants.DB_PASSWORD);
		return conn;
	}
}
