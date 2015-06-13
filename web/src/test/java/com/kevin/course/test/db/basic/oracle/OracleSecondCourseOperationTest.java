package com.kevin.course.test.db.basic.oracle;

import com.kevin.course.test.db.basic.SecondCourseOperationTest;
import com.kevin.course.utils.ConfigurationManager;

public class OracleSecondCourseOperationTest extends SecondCourseOperationTest {
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		ConfigurationManager.getInstance().setProperty("dbUrl",
				"jdbc:oracle:thin:@10.182.251.230:1521:orcl");
		ConfigurationManager.getInstance().setProperty("dbDriver",
				"oracle.jdbc.driver.OracleDriver");
		ConfigurationManager.getInstance().setProperty("dbUser", "aeas");
		ConfigurationManager.getInstance().setProperty("dbPassword", "oracle");
		ConfigurationManager.getInstance().setProperty("jpa", "false");
		ConfigurationManager.getInstance().setProperty("usePool", "false");
		
	}
}
