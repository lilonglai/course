package com.kevin.aeas.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseHelp {
	private static DatabaseHelp instance = new DatabaseHelp();

	private String dbDriver = "com.mysql.jdbc.Driver";

	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	private Connection connection = null;

	private DatabaseHelp() {

		InputStream is = DatabaseHelp.class.getClassLoader()
				.getResourceAsStream("database.props");
		Properties prop = new Properties();
		try {
			prop.load(is);
			dbUser = prop.getProperty("dbUser");
			dbPassword = prop.getProperty("dbPassword");
			dbUrl = prop.getProperty("dbUrl");
			dbDriver = prop.getProperty("dbDriver");
			
			try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		if(connection!=null)
			return connection;
		
		try {
			/*
			String url = dbUrl + "?user=" + dbUser + "&password=" +dbPassword + "&useUnicode=true&characterEncoding=utf-8";
			connection = DriverManager.getConnection(url);
			*/
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			connection = null;
			System.out.println(e);
		}
		return connection;
	}

	public static DatabaseHelp getInstance() {
		return instance;
	}

	public ResultSet executeSql(String sql) throws SQLException {
		Connection con = getConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
	
	public int executeUpdateSql(String sql) throws SQLException{
		Connection con = getConnection();
		Statement statement = con.createStatement();
		int count = statement.executeUpdate(sql);
		return count;
	}
	
	
	public static void main(String[] args) throws SQLException{
		DatabaseHelp instance = DatabaseHelp.getInstance();
		ResultSet result = instance.executeSql("select * from aeas_student");
	}


}
