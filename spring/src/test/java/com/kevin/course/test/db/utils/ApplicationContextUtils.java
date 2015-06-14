package com.kevin.course.test.db.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by loli on 2015/6/12.
 */
public class ApplicationContextUtils {
    private static ApplicationContext jdbcApplicationContext= null;
    private static ApplicationContext myBatisApplicationContext= null;
    private static ApplicationContext jpaApplicationContext= null;

    public static ApplicationContext getJdbcInstance(){
        if(jdbcApplicationContext == null){
            jdbcApplicationContext= new ClassPathXmlApplicationContext("spring-basic.xml");
        }
        return jdbcApplicationContext;
    }

    public static ApplicationContext getMybatisInstance(){
        if(myBatisApplicationContext == null){
            myBatisApplicationContext= new ClassPathXmlApplicationContext("spring-mybatis.xml");
        }
        return myBatisApplicationContext;
    }

    public static ApplicationContext getJpaInstance(){
        if(jpaApplicationContext == null){
            jpaApplicationContext= new ClassPathXmlApplicationContext("spring-jpa.xml");
        }
        return jpaApplicationContext;
    }
}
