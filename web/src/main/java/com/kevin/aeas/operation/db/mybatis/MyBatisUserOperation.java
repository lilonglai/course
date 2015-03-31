package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.User;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisUser;
import com.kevin.aeas.utils.DatabaseHelp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyBatisUserOperation extends MyBatisBaseOperation<MyBatisUser> {
    public MyBatisUserOperation(){
        super(MyBatisUser.class);
    }

	public boolean isExistUser(String userName, String userPassword) {
		return true;
	}
}
