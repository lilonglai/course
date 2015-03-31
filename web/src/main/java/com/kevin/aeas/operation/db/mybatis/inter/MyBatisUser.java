package com.kevin.aeas.operation.db.mybatis.inter;

/**
 * Created by loli on 2015/3/30.
 */
public interface MyBatisUser {
    public boolean isExistUser(String userName, String userPassword);
}
