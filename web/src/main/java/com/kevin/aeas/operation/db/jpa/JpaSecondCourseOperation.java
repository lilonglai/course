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
        return q.getResultList();
	}
	
	public List<SecondCourse> getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select sc from "  + firstCourseClass.getSimpleName() + " fc, "  + getActualClass().getSimpleName() + " sc  where fc.grade=:grade and sc.firstCourseId=fc.id");
		q.setParameter("grade", grade);
		return q.getResultList();
	}
	
	protected  Object changeToJpa(Object t){
		SecondCourse newObject;
		if(ConfigurationManager.getInstance().isMySql()){
			newObject = new MySqlSecondCourse();
		}
		else{
			newObject = new OracleSecondCourse();
		}
		setValueByObject(t, newObject);
		return newObject;
	}
}
