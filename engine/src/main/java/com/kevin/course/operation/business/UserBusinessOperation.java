package com.kevin.course.operation.business;

import com.kevin.course.object.User;
import com.kevin.course.operation.db.IUserOperation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by loli on 2015/6/22.
 */
public class UserBusinessOperation implements IUserBusinessOperation{
    @Autowired
    private IUserOperation userOperation;
    public void add(User user){
        userOperation.add(user);
    }

    public void update(User user){
        userOperation.update(user);
    }

}
