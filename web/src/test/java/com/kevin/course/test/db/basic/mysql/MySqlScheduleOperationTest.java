package com.kevin.course.test.db.basic.mysql;

import com.kevin.course.test.db.basic.ScheduleOperationTest;
import com.kevin.course.utils.ConfigurationManager;

public class MySqlScheduleOperationTest extends ScheduleOperationTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
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
