package com.kevin.aeas.test.db.basic.mysql;

import com.kevin.aeas.test.db.basic.TeacherAbilityOperationTest;
import com.kevin.aeas.utils.ConfigurationManager;

public class MySqlTeacherAbilityOperationTest extends TeacherAbilityOperationTest{
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
