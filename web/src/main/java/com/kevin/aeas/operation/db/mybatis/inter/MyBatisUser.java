package com.kevin.aeas.operation.db.mybatis.inter;

import com.kevin.aeas.object.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by loli on 2015/3/30.
 */
public interface MyBatisUser {
    public User get(@Param("name")String name, @Param("password")String password);

    public void add(User user);

    public void update(User user);

    public void updatePassword(@Param("name")String name, @Param("password")String password);

    public void delete(int key);
}
