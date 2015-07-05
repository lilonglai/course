package com.kevin.course.operation.db.engine;

import com.google.appengine.api.datastore.*;

import com.google.appengine.api.datastore.Entity;
import com.kevin.course.object.User;
import com.kevin.course.operation.db.IUserOperation;
import com.kevin.course.utils.TableName;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EngineUserDao extends EngineBaseDao<User> implements IUserOperation {

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

    protected User generateObject(Entity entity){
        return null;
    }

    @Override
    protected String getTableName() {
        return TableName.USER;
    }
}
