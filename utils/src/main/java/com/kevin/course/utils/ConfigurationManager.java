package com.kevin.course.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
	private static ConfigurationManager instance = new ConfigurationManager();
	private Properties prop;

	private ConfigurationManager() {
		InputStream is = DatabaseHelp.class.getClassLoader()
				.getResourceAsStream("database.props");
		prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ConfigurationManager getInstance() {
		return instance;
	}

	public String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}
	
	public void setProperty(String propertyName, String propertyValue){
		prop.setProperty(propertyName, propertyValue);		
	}

    public boolean isJdbc(){
        String jpa = prop.getProperty("daoWay");
        if(jpa == null)
            return false;
        if(jpa.equals("jdbc")){
            return true;
        }
        return false;
    }

	public boolean isJpa(){
		String jpa = prop.getProperty("daoWay");
		if(jpa == null)
			return false;
        if(jpa.equals("jpa")){
            return true;
        }
		return false;
	}

    public boolean isMyBatis(){
        String jpa = prop.getProperty("daoWay");
        if(jpa == null)
            return false;
        if(jpa.equals("mybatis")){
            return true;
        }
        return false;
    }
	
	public String getJpaName(){
		return prop.getProperty("jpaName");
	}
	
	/* check the underlying database
	 *  true represent the underlying database is MySql
	 *  false for the Oracle
	 */
	public boolean isMySql(){
		String jpa = prop.getProperty("jpaName");
		if(jpa.startsWith("MySql"))
			return true;
		else return false;
		
	}
}
