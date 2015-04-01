package com.kevin.aeas.operation.db.jpa;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.lang.reflect.Method;
import java.util.List;

public abstract class JpaBasicOperation<T> {
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
		Query q = EntityManangerUtil.getInstance().createQuery(hsql);
		List list = q.getResultList();				
		return list;
	}
	
	public T get(int key){
		return (T)EntityManangerUtil.getInstance().find(actualClass, key);
	}
	
	protected abstract Object changeToJpa(Object t);
	
	public void add(T t){
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
        transaction.begin();
        try {
            EntityManangerUtil.getInstance().persist(changeToJpa(t));
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }

	}

	public void update(T t) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
        transaction.begin();
        try {
            EntityManangerUtil.getInstance().merge(changeToJpa(t));
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
	}

	public void delete(int key) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
        transaction.begin();
        try {
            Object t = EntityManangerUtil.getInstance().find(actualClass, key);
            EntityManangerUtil.getInstance().remove(t);
            transaction.commit();
        }catch(Exception e){
            transaction.rollback();
        }
	}
	
	protected void setValueByObject(Object from, Object to) {
		Class fromClass = from.getClass();
		Class toClass = to.getClass();
		Method[] toMethods = toClass.getMethods();
		for (Method toMethod : toMethods) {
			if (toMethod.getName().startsWith("set")) {
				String fromMethodName = "get" + toMethod.getName().substring(3);
				Method fromMethod = null;
				try {
					fromMethod = fromClass.getMethod(fromMethodName);
					Object value = fromMethod.invoke(from);
					toMethod.invoke(to, value);
				} catch (Exception e) {
					fromMethod = null;
					e.printStackTrace();
				}
			}
		}

	}
	
}
