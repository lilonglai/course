package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.object.mysql.MySqlFirstCourse;
import com.kevin.aeas.object.mysql.MySqlSecondCourse;
import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleSecondCourse;
import com.kevin.aeas.utils.ConfigurationManager;

public class JpaSecondCourseOperation extends JpaBasicOperation{
	private Class firstCourseClass;
	
	public JpaSecondCourseOperation(){
		if(ConfigurationManager.getInstance().isMySql()){
			setActualClass(MySqlSecondCourse.class);
			firstCourseClass = MySqlFirstCourse.class;
		}
		else{
			setActualClass(OracleSecondCourse.class);
			firstCourseClass = OracleFirstCourse.class;
		}
	}
	
	public List getByFirstCourseId(int firstCourseId){
		Query q = EntityManangerUtil.getInstance().createQuery("select sc from "  + getActualClass().getSimpleName() + " sc where sc.firstCourseId=:firstCourseId");
		q.setParameter("firstCourseId", firstCourseId);
		List scList = q.getResultList();
		return scList;		
	}
	
	public List getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select sc from "  + firstCourseClass.getSimpleName() + " fc, "  + getActualClass().getSimpleName() + " sc  where fc.grade=:grade and sc.firstCourseId=fc.id");
		q.setParameter("grade", grade);
		List<OracleFirstCourse> scList = q.getResultList();
		return scList;		
	}
	
	protected  Object changeToJpa(Object t){
		SecondCourse newObject = null;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlSecondCourse();
		}
		else{
			newObject = new OracleSecondCourse();
		}
		
		setValueByObject(t, newObject);
		
		return newObject;
	}
	
	public static void main(String[] args) {
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));		
	}

}
