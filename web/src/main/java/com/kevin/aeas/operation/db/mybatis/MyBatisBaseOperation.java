package com.kevin.aeas.operation.db.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public abstract class MyBatisBaseOperation<T> {
    protected static SqlSessionFactory sqlSessionFactory;
    static{
        try{
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected Class<T> mybatisMapper;
    public MyBatisBaseOperation(Class<T> mybatisMapper){
        this.mybatisMapper = mybatisMapper;
    }
}
