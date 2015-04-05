package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.User;
import com.kevin.aeas.object.mysql.MySqlUser;
import com.kevin.aeas.object.oracle.OracleUser;
import com.kevin.aeas.operation.db.IUserOperation;
import com.kevin.aeas.utils.ConfigurationManager;


public class JpaUserOperation extends JpaBasicOperation<User> implements IUserOperation {
	public JpaUserOperation() {
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlUser.class);
		}
		else{
			setActualClass(OracleUser.class);
		}
	}

    public User get(String userName, String userPassword){
        return null;
    }

}
