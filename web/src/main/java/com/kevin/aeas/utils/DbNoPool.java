package com.kevin.aeas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbNoPool  implements IGetConnection{
	
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	
	private Connection connection = null;
	
	public DbNoPool(){
		dbUser = ConfigurationManager.getInstance().getProperty("dbUser");
		dbPassword = ConfigurationManager.getInstance().getProperty(
				"dbPassword");
		dbUrl = ConfigurationManager.getInstance().getProperty("dbUrl");
		dbDriver = ConfigurationManager.getInstance().getProperty("dbDriver");

		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public   final   Connection   getConnection() throws SQLException{
		if (connection != null && !connection.isClosed())
			return connection;

		try {
			/*
			 * String url = dbUrl + "?user=" + dbUser + "&password=" +dbPassword
			 * + "&useUnicode=true&characterEncoding=utf-8"; connection =
			 * DriverManager.getConnection(url);
			 */
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			connection = null;
			System.out.println(e);
		}
		return connection;
	}
}
