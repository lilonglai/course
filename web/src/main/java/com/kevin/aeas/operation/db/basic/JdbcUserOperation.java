package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.User;
import com.kevin.aeas.operation.db.IUserOperation;
import com.kevin.aeas.utils.DatabaseHelp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserOperation extends JdbcBaseOperation<User> implements IUserOperation{
	public boolean isExistUser(String userName, String userPassword) {
		String sql = "select * from " + getTableName() + " from name='" + userName + "' and u.password='" + userPassword + "'";
		ResultSet rs = null;
		try {
			rs = DatabaseHelp.getInstance().executeSql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	protected User generateObject(ResultSet rs) throws SQLException{
		User user = null;
		return user;
	}

	@Override
	protected String getTableName() {
		return "aeas_user";
	}
}