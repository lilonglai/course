package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.User;
import com.kevin.aeas.operation.db.IUserOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisUser;

public class MyBatisUserOperation extends MyBatisBaseOperation<MyBatisUser> implements IUserOperation{
    public MyBatisUserOperation(){
        super(MyBatisUser.class);
    }

    public User get(String name, String password) {
        return proxy.get(name, password);
    }

    public void add(User user) {
        proxy.add(user);
    }

    public void update(User user) {
        proxy.update(user);
    }

    public void updatePassword(String name, String password) {
        proxy.updatePassword(name, password);
    }

    public void delete(int key) {
        proxy.delete(key);
    }
}
