package com.kevin.aeas.operation.db.basic;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kevin.aeas.utils.DatabaseHelp;

public class DbUserOperation extends DbBaseOperation{
	public boolean isExistUser(String userName, String userPassword) {
		String sql = "select * from User from name='" + userName + "' and u.password='" + userPassword + "'";
		ResultSet rs = null;
		try {
			rs = DatabaseHelp.getInstance().executeSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	protected Object generateObject(ResultSet rs) throws SQLException{
		Object obj = null;
		return obj;
	}
}
