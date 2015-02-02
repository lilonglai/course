package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.jpa.JpaFirstCourse;
import com.kevin.aeas.object.mysql.MySqlFirstCourse;
import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.utils.ConfigurationManager;


public class JpaFirstCourseOperation extends JpaBasicOperation {
	public JpaFirstCourseOperation(){		
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlFirstCourse.class);
		}
		else{
			setActualClass(OracleFirstCourse.class);
		}
	}
	
	public List getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select c from AeasFirstCourse c where c.grade=:grade");
		q.setParameter("grade", grade);
		List<OracleFirstCourse> list = q.getResultList();		
		return list;		
	}		
	
	protected  Object changeToJpa(Object t){
		JpaFirstCourse newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlFirstCourse();
		}
		else{
			newObject = new OracleFirstCourse();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	public static void main(String[] args) {
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		System.out.println(operation.getAll());		
	}

}
