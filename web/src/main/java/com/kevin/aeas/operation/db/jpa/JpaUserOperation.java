package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.User;
import com.kevin.aeas.object.mysql.MySqlUser;
import com.kevin.aeas.object.oracle.OracleUser;
import com.kevin.aeas.operation.db.IUserOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import java.sql.ResultSet;
import java.sql.SQLException;


public class JpaUserOperation extends JpaBasicOperation<User> implements IUserOperation {
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


}
