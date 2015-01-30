package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleTeacher;

public class JpaBasicOperation {
	private Class actualClass;
	public JpaBasicOperation(Class c){
		actualClass = c;
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
	
	public void add(Object t){
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		EntityManangerUtil.getInstance().persist(t);
		transaction.commit();
	}

	public void update(Object t) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		EntityManangerUtil.getInstance().merge(t);
		transaction.commit();
	}

	public void delete(int key) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		Object t = EntityManangerUtil.getInstance().find(actualClass, key);
		EntityManangerUtil.getInstance().remove(t);
		transaction.commit();
	}
	
}