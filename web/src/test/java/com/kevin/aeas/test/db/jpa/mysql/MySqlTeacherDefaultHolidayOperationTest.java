package com.kevin.aeas.test.db.jpa.mysql;

import com.kevin.aeas.test.db.jpa.TeacherDefaultHolidayOperationTest;
import com.kevin.aeas.utils.ConfigurationManager;

public class MySqlTeacherDefaultHolidayOperationTest extends TeacherDefaultHolidayOperationTest{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "MySqlPersistenceUnit");
	}
}
