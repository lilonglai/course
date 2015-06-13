package com.kevin.course.test.db.utils;

import com.kevin.course.operation.db.jpa.JpaBasicOperation;
import com.kevin.course.utils.DatabaseHelp;

import java.lang.reflect.Field;

public class DbUtils {
	public static void resetDbInstance(){
	    try {
			Field instanceField = DatabaseHelp.class.getDeclaredField("instance");
			instanceField.setAccessible(true);
			instanceField.set(null, null);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	public static void resetJpaManager(){
	    try {
			Field entityManagerFactoryField = JpaBasicOperation.class.getDeclaredField("entityManagerFactory");
			entityManagerFactoryField.setAccessible(true);
			entityManagerFactoryField.set(null, null);

			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
