package com.kevin.aeas.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
	private static ConfigurationManager instance = new ConfigurationManager();
	private Properties prop;

	private ConfigurationManager() {
		InputStream is = DatabaseHelp.class.getClassLoader()
				.getResourceAsStream("database.props");
		Properties prop = new Properties();
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
	
	public boolean isJpa(){
		String jpa = prop.getProperty("jpa");
		if(jpa == null)
			return false;
		return Boolean.valueOf(jpa);
	}
	
	public String getJpaName(){
		return prop.getProperty("jpaName");
	}
}
