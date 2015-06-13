package com.kevin.course.test.db.jpa.mysql;

import com.kevin.course.test.db.jpa.SecondCourseOperationTest;
import com.kevin.course.utils.ConfigurationManager;

public class MySqlSecondCourseOperationTest extends SecondCourseOperationTest{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "MySqlPersistenceUnit");
	}
}
