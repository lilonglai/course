package com.kevin.aeas.operation.v2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.object.v2.AeasTeacher;
import com.kevin.aeas.utils.DatabaseHelp;

public class AeasTeacherOperation extends AeasBasicOperation<AeasTeacher>{
	public AeasTeacherOperation(){
		super(AeasTeacher.class);
	}
	
	public AeasTeacher getByName(String name){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from AeasTeacher t where t.name=:name");
		q.setParameter("name", name);
		List<AeasTeacher> list = q.getResultList();
		AeasTeacher aeasTeacher = null;
		if(list.size() > 0 )
			aeasTeacher = list.get(0);
		return aeasTeacher;	
	}
	
	
	public AeasTeacher getByShortName(String shortName){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from AeasTeacher t where t.shortName=:shortName");
		q.setParameter("shortName", shortName);
		List<AeasTeacher> list = q.getResultList();
		AeasTeacher aeasTeacher = null;
		if(list.size() > 0 )
			aeasTeacher = list.get(0);
		return aeasTeacher;		
	}
	
	public List<AeasTeacher> getAlive(){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from AeasTeacher t where t.isAlive=:isAlive");
		q.setParameter("isAlive", true);
		List<AeasTeacher> list = q.getResultList();
		return list;		
	}
	
	public List<AeasTeacher> getNotAlive(){
		Query q = EntityManangerUtil.getInstance().createQuery("select t from AeasTeacher t where t.isAlive=:isAlive");
		q.setParameter("isAlive", false);
		List<AeasTeacher> list = q.getResultList();
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
	
	public void retire(int key){
		AeasTeacher aeasTeacher = EntityManangerUtil.getInstance().find(AeasTeacher.class, key);
		aeasTeacher.setIsAlive(false);
		EntityManangerUtil.getInstance().merge(aeasTeacher);
	}
	
	public static void main(String[] args) {
		AeasTeacherOperation operation = new AeasTeacherOperation();
		System.out.println(operation.getAll());		
	}

}
