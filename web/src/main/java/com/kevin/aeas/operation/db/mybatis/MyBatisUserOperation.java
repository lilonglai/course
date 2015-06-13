package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.User;
import com.kevin.aeas.operation.db.IUserOperation;

public class MyBatisUserOperation extends MyBatisBaseOperation<IUserOperation> implements IUserOperation{
    public MyBatisUserOperation(){
        super(IUserOperation.class);
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
