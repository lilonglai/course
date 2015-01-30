package com.kevin.aeas.operation.db.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleSecondCourse;

public class JpaSecondCourseOperation extends JpaBasicOperation{
	public JpaSecondCourseOperation(){
		super(OracleSecondCourse.class);
	}
	
	public List getByFirstCourseId(int firstCourseId){
		Query q = EntityManangerUtil.getInstance().createQuery("select sc from AeasSecondCourse sc where sc.firstCourseId=:firstCourseId");
		q.setParameter("firstCourseId", firstCourseId);
		List scList = q.getResultList();
		return scList;		
	}
	
	public List getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select sc from AeasFirstCourse fc, AeasSecondCourse sc  where fc.grade=:grade and sc.firstCourseId=fc.id");
		q.setParameter("grade", grade);
		List<OracleFirstCourse> scList = q.getResultList();
		return scList;		
	}
	
	public static void main(String[] args) {
		JpaSecondCourseOperation operation = new JpaSecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));
		
		
		
		
	}

}