package com.kevin.aeas.object.oracle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AeasPersistenceUnit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		OracleTeacher aeaTeacher = entityManager.find(OracleTeacher.class, 2);
		entityManager.close();
		entityManagerFactory.close();

	}

}
