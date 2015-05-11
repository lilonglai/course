package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.*;
import java.lang.reflect.Method;
import java.util.List;

public abstract class JpaBasicOperation<T> {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(ConfigurationManager.getInstance().getJpaName());

	private Class actualClass;
	
	public JpaBasicOperation(){
	}
	
	protected void setActualClass(Class c){
		this.actualClass = c;
	}
	
	protected Class getActualClass(){
		return actualClass;
	}
	
	public List<T> getAll(){
		String hsql = "select t from " + actualClass.getSimpleName() +" t";
        try {
            Query q = getEntityManager().createQuery(hsql);
            List list = q.getResultList();
            return list;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}
	
	public T get(int key){
		return (T) getEntityManager().find(actualClass, key);
	}
	
	public void add(T t){
        EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(changeToJpa(t));
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new BasicException(e);
        }

	}

	public void update(T t) {
        EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.merge(changeToJpa(t));
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new BasicException(e);
        }
	}

	public void delete(int key) {
        EntityManager entityManager = getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            Object t = entityManager.find(actualClass, key);
            entityManager.remove(t);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
            throw new BasicException(e);
        }
	}
	
	protected Object changeToJpa(Object from) throws Exception {
        Object to = getActualClass().newInstance();
		Class fromClass = from.getClass();
		Class toClass = to.getClass();
		Method[] toMethods = toClass.getMethods();
		for (Method toMethod : toMethods) {
			if (toMethod.getName().startsWith("set")) {
				String fromMethodName = "get" + toMethod.getName().substring(3);
				Method fromMethod = null;
                fromMethod = fromClass.getMethod(fromMethodName);
                Object value = fromMethod.invoke(from);
                toMethod.invoke(to, value);
			}
		}
        return to;
	}

    protected EntityManager getEntityManager(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(ConfigurationManager.getInstance().getJpaName());
        }

        if(entityManagerFactory != null){
            return entityManagerFactory.createEntityManager();
        }
        return null;
    }
	
}
