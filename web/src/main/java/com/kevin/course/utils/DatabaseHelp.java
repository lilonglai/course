package com.kevin.course.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelp {
	private static DatabaseHelp instance = null;
    private boolean usePool = true;
    
    private IGetConnection getCon;
	
	private DatabaseHelp() {
		String usePoolString = ConfigurationManager.getInstance().getProperty("usePool");
		if(usePoolString != null){
			usePool = Boolean.valueOf(usePoolString);
		}
		
		if(usePool){
			getCon =  new C3Pool();
		}
		else{
			getCon =  new DbNoPool();
		}
	}

	public Connection getConnection() throws SQLException{
		return getCon.getConnection();
	}
	

	public static synchronized DatabaseHelp getInstance() {
		if(instance == null){
			instance = new DatabaseHelp();
		}
		return instance;
	}

	public ResultSet executeSql(String sql) throws SQLException {
		Connection con = getConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}

	public int executeUpdateSql(String sql) throws SQLException {
		Connection con = getConnection();
		Statement statement = con.createStatement();
		int count = statement.executeUpdate(sql);
		return count;
	}

	public static void main(String[] args) throws SQLException {
		DatabaseHelp instance = DatabaseHelp.getInstance();
		ResultSet result = instance.executeSql("select * from aeas_student");
	}

}
