package com.kevin.course.operation.business;

import com.kevin.course.object.User;

/**
 * Created by loli on 2015/6/22.
 */
public interface IUserBusinessOperation {
    public User get(String userName, String userPassword);

    public User getByEmail(String userName, String userEmail);

    public void add(User user);

    public void update(User user);

    public void updatePassword(final String userName, final String userPassword);

}
