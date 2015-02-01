package com.kevin.aeas.test.db.basic.mysql;

import com.kevin.aeas.test.db.basic.FirstCourseOperationTest;
import com.kevin.aeas.utils.ConfigurationManager;

public class MySqlFirstCourseOperationTest extends FirstCourseOperationTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();		
	}
	
	public MySqlFirstCourseOperationTest(){
		ConfigurationManager.getInstance().setProperty("dbUrl",
				"jdbc:mysql://localhost:3306/aeas");
		ConfigurationManager.getInstance().setProperty("dbDriver",
				"com.mysql.jdbc.Driver");
		ConfigurationManager.getInstance().setProperty("dbUser", "root");
		ConfigurationManager.getInstance().setProperty("dbPassword", "root");
		ConfigurationManager.getInstance().setProperty("jpa", "false");
		ConfigurationManager.getInstance().setProperty("usePool", "false");
	}
}
