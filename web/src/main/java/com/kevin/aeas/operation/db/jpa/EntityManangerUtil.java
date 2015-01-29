package com.kevin.aeas.operation.db.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kevin.aeas.utils.ConfigurationManager;

public class EntityManangerUtil {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static EntityManager getInstance(){
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
