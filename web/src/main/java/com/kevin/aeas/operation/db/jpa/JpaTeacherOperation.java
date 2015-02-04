package com.kevin.aeas.operation.db.jpa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.mysql.MySqlTeacher;
import com.kevin.aeas.object.oracle.OracleTeacher;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DatabaseHelp;

public class JpaTeacherOperation extends JpaBasicOperation{
	public JpaTeacherOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlTeacher.class);
		}
		else{
			setActualClass(OracleTeacher.class);
		}
	}
	
	public Object getByName(String name){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.name=:name");
		q.setParameter("name", name);
		List<Teacher> list = q.getResultList();
		Teacher aeasTeacher = null;
		if(list.size() > 0 )
			aeasTeacher = list.get(0);
		return aeasTeacher;	
	}
	
	
	public Object getByShortName(String shortName){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.shortName=:shortName");
		q.setParameter("shortName", shortName);
		List<Teacher> list = q.getResultList();
		Teacher aeasTeacher = null;
		if(list.size() > 0 )
			aeasTeacher = list.get(0);
		return aeasTeacher;		
	}
	
	public List getAlive(){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive");
		q.setParameter("isAlive", true);
		List<OracleTeacher> list = q.getResultList();
		return list;		
	}
	
	public List getNotAlive(){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from "  + getActualClass().getSimpleName() + " t where t.isAlive=:isAlive");
		q.setParameter("isAlive", false);
		List<OracleTeacher> list = q.getResultList();
		return list;	
		
	}
	
	public int getIdByObject(Teacher condition){
		String sql = "select * from aeas_teacher where";
		if(condition.getName() != null)
			sql += " name = '" + condition.getName() + "'";
		
		if(condition.getShortName() != null)			
			sql +=  " && shortname = '" + condition.getShortName() + "'";
		
		if(condition.getPhone() != null)
			sql +=  " && phone = '" + condition.getPhone() + "'";
		
		int id = 0;
		try {
			ResultSet rs = DatabaseHelp.getInstance().executeSql(sql);
			if(rs.next()){
				id = rs.getInt("id");			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
		
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
