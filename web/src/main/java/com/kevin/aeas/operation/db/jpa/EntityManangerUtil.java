package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManangerUtil {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static synchronized EntityManager getInstance(){
		if(entityManager != null)
			return entityManager;
		
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory(ConfigurationManager.getInstance().getJpaName());
		}
		
		if(entityManagerFactory != null){
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
	public static EntityManager createInstance(){
		if(entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory(ConfigurationManager.getInstance().getJpaName());
		}
		
		if(entityManagerFactory != null){
			return entityManagerFactory.createEntityManager();
		}
		return null;
	}

}
