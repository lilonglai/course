package com.kevin.aeas.test.db.jpa.oracle;

import com.kevin.aeas.test.db.jpa.TeacherAbilityOperationTest;
import com.kevin.aeas.utils.ConfigurationManager;

public class OracleTeacherAbilityOperationTest extends TeacherAbilityOperationTest{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ConfigurationManager.getInstance().setProperty("jpa", "true");
		ConfigurationManager.getInstance().setProperty("jpaName", "OraclePersistenceUnit");
		
	}
}
