package com.kevin.aeas.operation.db.basic;

import com.kevin.aeas.object.User;
import com.kevin.aeas.operation.db.IUserOperation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao extends JdbcBaseDao<User> implements IUserOperation{
    public User get(String userName, String userPassword){
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
		return "aeas_user";
	}
}
