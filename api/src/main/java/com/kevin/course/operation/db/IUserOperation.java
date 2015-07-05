package com.kevin.course.operation.db;

import com.kevin.course.object.User;

/**
 * Created by loli on 2015/3/30.
 */
public interface IUserOperation {
    public User get(String userName, String userPassword);

    public User getByEmail(String userName, String userEmail);

    public void add(User user);

    public void update(User user);

    public void delete(int key);

    public void updatePassword(String userName, String userPassword);
}
