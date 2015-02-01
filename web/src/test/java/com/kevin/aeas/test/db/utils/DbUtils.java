package com.kevin.aeas.test.db.utils;

import java.lang.reflect.Field;

import com.kevin.aeas.utils.DatabaseHelp;

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
}
