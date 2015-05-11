package com.kevin.aeas.test.db.utils;

import com.kevin.aeas.operation.db.jpa.EntityManagerUtil;
import com.kevin.aeas.utils.DatabaseHelp;

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
			Field entityManagerFactoryField = EntityManagerUtil.class.getDeclaredField("entityManagerFactory");
			entityManagerFactoryField.setAccessible(true);
			entityManagerFactoryField.set(null, null);
			
			Field entityManagerField = EntityManagerUtil.class.getDeclaredField("entityManager");
			entityManagerField.setAccessible(true);
			entityManagerField.set(null, null);
			
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
