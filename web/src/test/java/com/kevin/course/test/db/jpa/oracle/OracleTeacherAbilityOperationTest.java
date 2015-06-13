package com.kevin.course.test.db.jpa.oracle;

import com.kevin.course.test.db.jpa.TeacherAbilityOperationTest;
import com.kevin.course.utils.ConfigurationManager;

public class OracleTeacherAbilityOperationTest extends TeacherAbilityOperationTest{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "OraclePersistenceUnit");
		
	}
}
