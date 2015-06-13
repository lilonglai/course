package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.User;
import com.kevin.course.operation.db.IUserOperation;


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
