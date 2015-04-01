package com.kevin.aeas.operation.db.jpa;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.object.mysql.MySqlFirstCourse;
import com.kevin.aeas.object.mysql.MySqlSecondCourse;
import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleSecondCourse;
import com.kevin.aeas.operation.db.ISecondCourseOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import javax.persistence.Query;
import java.util.List;

public class JpaSecondCourseOperation extends JpaBasicOperation<SecondCourse> implements ISecondCourseOperation{
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
	
	public List<SecondCourse> getByFirstCourseId(int firstCourseId){
		Query q = EntityManangerUtil.getInstance().createQuery("select sc from "  + getActualClass().getSimpleName() + " sc where sc.firstCourseId=:firstCourseId");
		q.setParameter("firstCourseId", firstCourseId);
        List<SecondCourse> scList = q.getResultList();
		return scList;		
	}
	
	public List<SecondCourse> getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select sc from "  + firstCourseClass.getSimpleName() + " fc, "  + getActualClass().getSimpleName() + " sc  where fc.grade=:grade and sc.firstCourseId=fc.id");
		q.setParameter("grade", grade);
		List<SecondCourse> scList = q.getResultList();
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
