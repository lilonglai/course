package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.mysql.MySqlTeacher;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.operation.db.ITeacherOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.Query;
import java.util.List;

public class JpaTeacherOperation extends JpaBasicOperation<Teacher> implements ITeacherOperation{
	public JpaTeacherOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacher.class);
		}
		else{
			setActualClass(OracleTeacher.class);
		}
	}
	
	public Teacher getByName(String name){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.name=:name");
		q.setParameter("name", name);
		List<? extends Teacher> list = q.getResultList();
		Teacher teacher = null;
		if(list.size() > 0 )
            teacher = list.get(0);
		return teacher;
	}
	
	
	public Teacher getByShortName(String shortName){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.shortName=:shortName");
		q.setParameter("shortName", shortName);
		List<? extends Teacher> list = q.getResultList();
		Teacher teacher = null;
		if(list.size() > 0 )
            teacher = list.get(0);
		return teacher;
	}
	
	public List<? extends Teacher> getAlive(){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive");
		q.setParameter("isAlive", true);
        List<? extends Teacher> list = q.getResultList();
		return list;		
	}
	
	public List<? extends Teacher> getNotAlive(){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive");
		q.setParameter("isAlive", false);
        List<? extends Teacher> list = q.getResultList();
		return list;	
		
	}
	
	public Teacher getByCondition(Teacher condition){
		return null;
	}
	
	protected  Object changeToJpa(Object t){
		Teacher newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlTeacher();
		}
		else{
			newObject = new OracleTeacher();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	
	
	public void retire(int key){
		OracleTeacher aeasTeacher = EntityManangerUtil.getInstance().find(OracleTeacher.class, key);
		aeasTeacher.setIsAlive(false);
		EntityManangerUtil.getInstance().merge(aeasTeacher);
	}
	
	public static void main(String[] args) {
		JpaTeacherOperation operation = new JpaTeacherOperation();
		System.out.println(operation.getAll());		
	}

}
