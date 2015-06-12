package com.kevin.aeas.test.db.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by loli on 2015/6/12.
 */
public class ApplicationContextUtils {
    private static ApplicationContext jdbcApplicationContext= new ClassPathXmlApplicationContext("spring-basic.xml");
    private static ApplicationContext myBatisApplicationContext= new ClassPathXmlApplicationContext("spring-mybatis.xml");

    public static ApplicationContext getJdbcInstance(){
        return jdbcApplicationContext;
    }

    public static ApplicationContext getMybatisInstance(){
        return myBatisApplicationContext;
    }
}
