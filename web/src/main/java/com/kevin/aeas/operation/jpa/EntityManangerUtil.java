package com.kevin.aeas.operation.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManangerUtil {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AeasPersistenceUnit");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static EntityManager getInstance(){
		return entityManager;
	}
	
	public static EntityManager createInstance(){
		if(entityManagerFactory != null){
			return entityManagerFactory.createEntityManager();
		}
		return null;
	}

}
