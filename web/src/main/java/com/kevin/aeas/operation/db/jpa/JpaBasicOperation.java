package com.kevin.aeas.operation.db.jpa;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public abstract class JpaBasicOperation {
	private Class actualClass;
	public JpaBasicOperation(Class c){
		actualClass = c;
	}
	
	public JpaBasicOperation(){

	}
	
	protected void setActualClass(Class c){
		this.actualClass = c;
	}
	
	protected Class getActualClass(){
		return actualClass;
	}
	
	public List getAll(){
		String hsql = "select t from " + actualClass.getSimpleName() +" t";
		Query q = EntityManangerUtil.getInstance().createQuery(hsql);
		List list = q.getResultList();				
		return list;
	}
	
	public Object get(int key){
		return EntityManangerUtil.getInstance().find(actualClass, key);
	}
	
	protected abstract Object changeToJpa(Object t);
	
	public void add(Object t){
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		EntityManangerUtil.getInstance().persist(changeToJpa(t));
		transaction.commit();
	}

	public void update(Object t) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		EntityManangerUtil.getInstance().merge(changeToJpa(t));
		transaction.commit();
	}

	public void delete(int key) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		Object t = EntityManangerUtil.getInstance().find(actualClass, key);
		EntityManangerUtil.getInstance().remove(t);
		transaction.commit();
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
