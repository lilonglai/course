package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleTeacher;

public class JpaBasicOperation<T> {
	private Class<T> actualClass;
	public JpaBasicOperation(Class<T> c){
		actualClass = c;
	}
	
	public List<T> getAll(){
		String hsql = "select t from " + actualClass.getSimpleName() +" t";
		Query q = EntityManangerUtil.getInstance().createQuery(hsql);
		List<T> list = q.getResultList();				
		return list;
	}
	
	public T get(int key){
		return EntityManangerUtil.getInstance().find(actualClass, key);
	}
	
	public void add(T t){
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		EntityManangerUtil.getInstance().persist(t);
		transaction.commit();
	}

	public void update(T t) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		EntityManangerUtil.getInstance().merge(t);
		transaction.commit();
	}

	public void delete(int key) {
		EntityTransaction transaction = EntityManangerUtil.getInstance().getTransaction();
		transaction.begin();
		T t = EntityManangerUtil.getInstance().find(actualClass, key);
		EntityManangerUtil.getInstance().remove(t);
		transaction.commit();
	}
	
	
	public static void main(String[] args){
		JpaBasicOperation<OracleTeacher> operation = new JpaBasicOperation<OracleTeacher>(OracleTeacher.class);
		operation.getAll();
	}
	
}
