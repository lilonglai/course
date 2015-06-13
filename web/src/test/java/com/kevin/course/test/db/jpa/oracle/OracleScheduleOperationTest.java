package com.kevin.course.test.db.jpa.oracle;

import com.kevin.course.test.db.jpa.FirstCourseOperationTest;
import com.kevin.course.utils.ConfigurationManager;

public class OracleScheduleOperationTest extends FirstCourseOperationTest {

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "OraclePersistenceUnit");
		
	}
	

}
