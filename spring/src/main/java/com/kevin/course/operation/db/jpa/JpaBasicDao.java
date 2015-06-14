package com.kevin.course.operation.db.jpa;

import com.kevin.course.object.BasicException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Method;
import java.util.List;

public abstract class JpaBasicDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

	private Class actualClass;
	
	public JpaBasicDao(){
	}
	
	protected void setActualClass(Class c){
		this.actualClass = c;
	}
	
	protected Class getActualClass(){
		return actualClass;
	}

	@Transactional
	public List<T> getAll(){
		String hsql = "select t from " + actualClass.getSimpleName() +" t";
        try {
            Query q = entityManager.createQuery(hsql);
            List list = q.getResultList();
            return list;
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

	@Transactional
	public T get(int key){
		return (T) entityManager.find(actualClass, key);
	}

	@Transactional
	public void add(T t){
        try {
            entityManager.persist(changeToJpa(t));
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

	@Transactional
	public void update(T t) {
        try {
            entityManager.merge(changeToJpa(t));
        }catch(Exception e){
            throw new BasicException(e);
        }
	}

	@Transactional
	public void delete(int key) {
        try {
            Object t = entityManager.find(actualClass, key);
            entityManager.remove(t);
        }catch(Exception e){
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
	
}
