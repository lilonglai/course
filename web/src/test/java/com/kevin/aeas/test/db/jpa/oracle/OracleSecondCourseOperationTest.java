package com.kevin.aeas.test.db.jpa.oracle;

import com.kevin.aeas.test.db.jpa.SecondCourseOperationTest;
import com.kevin.aeas.utils.ConfigurationManager;

public class OracleSecondCourseOperationTest extends SecondCourseOperationTest{
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "OraclePersistenceUnit");
		
	}
}
