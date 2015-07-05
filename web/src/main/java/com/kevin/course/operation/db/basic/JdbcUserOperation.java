package com.kevin.course.operation.db.basic;

import com.kevin.course.object.User;
import com.kevin.course.operation.db.IUserOperation;
import com.kevin.course.utils.TableName;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserOperation extends JdbcBaseOperation<User> implements IUserOperation {
	public User get(String userName, String userPassword){
		return null;
	}

	@Override
	public User getByEmail(String userName, String userEmail) {
		return null;
	}

	@Override
	public void add(User user) {

	}

	@Override
	public void update(User user) {

	}

	@Override
	public void updatePassword(String userName, String userPassword) {

	}

	protected User generateObject(ResultSet rs) throws SQLException{
		User user = null;
		return user;
	}

	@Override
	protected String getTableName() {
		return TableName.USER;
	}
}
