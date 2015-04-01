package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.operation.db.IUserOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisUser;

public class MyBatisUserOperation extends MyBatisBaseOperation<MyBatisUser> implements IUserOperation{
    public MyBatisUserOperation(){
        super(MyBatisUser.class);
    }

	public boolean isExistUser(String userName, String userPassword) {
		return true;
	}
}
