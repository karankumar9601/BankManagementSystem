package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/bankApp";
		String password = "root";
		String username = "root";
		String driver_class = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver_class);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
                e.printStackTrace();
		}
		return connection;
	}

}
