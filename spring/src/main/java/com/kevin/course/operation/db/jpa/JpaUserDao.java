package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.User;
import com.kevin.course.operation.db.IUserOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("jpaUserDao")
public class JpaUserDao extends JpaBasicDao<User> implements IUserOperation {
	public User get(String userName, String userPassword){
		return null;
	}

	public User getByEmail(String userName, String userPassword){
		return null;
	}


	@Transactional
	public void add(User user) {

	}

	@Transactional
	public void update(User user) {

	}

	@Transactional
	public void updatePassword(String userName, String userPassword) {

	}


}
