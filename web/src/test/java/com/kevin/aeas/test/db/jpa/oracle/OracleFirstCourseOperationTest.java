package com.kevin.aeas.test.db.jpa.oracle;

import com.kevin.aeas.test.db.jpa.FirstCourseOperationTest;
import com.kevin.aeas.utils.ConfigurationManager;

public class OracleFirstCourseOperationTest extends FirstCourseOperationTest{

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "OraclePersistenceUnit");
		
	}
	

}
