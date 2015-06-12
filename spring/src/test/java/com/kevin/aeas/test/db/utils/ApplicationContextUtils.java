package com.kevin.aeas.test.db.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by loli on 2015/6/12.
 */
public class ApplicationContextUtils {
    private static ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring.xml");

    public static ApplicationContext getInstance(){
        return applicationContext;
    }
}
