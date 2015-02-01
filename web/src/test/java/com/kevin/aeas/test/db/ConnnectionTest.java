package com.kevin.aeas.test.db;

import java.lang.reflect.Field;
import java.sql.SQLException;

import com.kevin.aeas.test.db.utils.DbUtils;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DatabaseHelp;

import junit.framework.TestCase;

public class ConnnectionTest extends TestCase {
	public void testMySqlConnection() {
		ConfigurationManager.getInstance().setProperty("dbUrl",
				"jdbc:mysql://localhost:3306/aeas");
		ConfigurationManager.getInstance().setProperty("dbDriver",
				"com.mysql.jdbc.Driver");
		ConfigurationManager.getInstance().setProperty("dbUser", "root");
		ConfigurationManager.getInstance().setProperty("dbPassword", "root");
		ConfigurationManager.getInstance().setProperty("jpa", "false");
		ConfigurationManager.getInstance().setProperty("usePool", "false");
		
		try {
			DatabaseHelp.getInstance().executeSql("select * from aeas_student");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("can not connecte to db");
		}
	}

	public void testOracleConnection() {
		ConfigurationManager.getInstance().setProperty("dbUrl",
				"jdbc:oracle:thin:@10.182.251.230:1521:orcl");
		ConfigurationManager.getInstance().setProperty("dbDriver",
				"oracle.jdbc.driver.OracleDriver");
		ConfigurationManager.getInstance().setProperty("dbUser", "aeas");
		ConfigurationManager.getInstance().setProperty("dbPassword", "oracle");
		ConfigurationManager.getInstance().setProperty("jpa", "false");
		ConfigurationManager.getInstance().setProperty("usePool", "false");
		
		try {
			DatabaseHelp.getInstance().executeSql("select * from aeas_student");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("can not connecte to db");
		}
	}

	public void testCachedMySqlConnection() {
		ConfigurationManager.getInstance().setProperty("dbUrl",
				"jdbc:mysql://localhost:3306/aeas");
		ConfigurationManager.getInstance().setProperty("dbDriver",
				"com.mysql.jdbc.Driver");
		ConfigurationManager.getInstance().setProperty("dbUser", "root");
		ConfigurationManager.getInstance().setProperty("dbPassword", "root");
		ConfigurationManager.getInstance().setProperty("jpa", "false");
		ConfigurationManager.getInstance().setProperty("usePool", "true");
		
		try {
			DatabaseHelp.getInstance().executeSql("select * from aeas_student");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("can not connecte to db");
		}
	}

	public void testCachedOracleConnection() {
		ConfigurationManager.getInstance().setProperty("dbUrl",
				"jdbc:oracle:thin:@10.182.251.230:1521:orcl");
		ConfigurationManager.getInstance().setProperty("dbDriver",
				"oracle.jdbc.driver.OracleDriver");
		ConfigurationManager.getInstance().setProperty("dbUser", "aeas");
		ConfigurationManager.getInstance().setProperty("dbPassword", "oracle");
		ConfigurationManager.getInstance().setProperty("jpa", "false");
		ConfigurationManager.getInstance().setProperty("usePool", "true");
		
		try {
			DatabaseHelp.getInstance().executeSql("select * from aeas_student");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("can not connecte to db");
		}
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}

}
