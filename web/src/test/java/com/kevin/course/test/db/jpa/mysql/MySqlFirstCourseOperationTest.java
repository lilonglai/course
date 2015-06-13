package com.kevin.course.test.db.jpa.mysql;

import com.kevin.course.test.db.jpa.FirstCourseOperationTest;
import com.kevin.course.utils.ConfigurationManager;

public class MySqlFirstCourseOperationTest extends FirstCourseOperationTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "MySqlPersistenceUnit");
	}
	
}
