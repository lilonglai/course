package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.User;

/**
 * Created by loli on 2015/3/30.
 */
public interface IUserOperation {
    public User get(String userName, String userPassword);
}
