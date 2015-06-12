package com.kevin.aeas.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3Pool implements IGetConnection {
	private   ComboPooledDataSource   dataSource;
	
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	
	public C3Pool(){
		dataSource=new  ComboPooledDataSource ();
		
		dbUser = ConfigurationManager.getInstance().getProperty("dbUser");
		dbPassword = ConfigurationManager.getInstance().getProperty(
				"dbPassword");
		dbUrl = ConfigurationManager.getInstance().getProperty("dbUrl");
		dbDriver = ConfigurationManager.getInstance().getProperty("dbDriver");
		
	   dataSource.setUser(dbUser);
	   dataSource.setPassword(dbPassword);
	   dataSource.setJdbcUrl(dbUrl);
	   try {
		dataSource.setDriverClass(dbDriver);
	} catch (PropertyVetoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   dataSource.setInitialPoolSize(2); 
       dataSource.setMinPoolSize(1); 
       dataSource.setMaxPoolSize(10);
       dataSource.setMaxStatements(50); 
       dataSource.setMaxIdleTime(60);
	}
	
	/* (non-Javadoc)
	 * @see com.kevin.aeas.utils.IGetConnection#getConnection()
	 */
	@Override
	public   final   Connection   getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
