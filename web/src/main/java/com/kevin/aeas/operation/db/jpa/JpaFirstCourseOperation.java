package com.kevin.aeas.operation.db.jpa;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.object.oracle.OracleFirstCourse;


public class JpaFirstCourseOperation extends JpaBasicOperation {
	public JpaFirstCourseOperation(){
		super(OracleFirstCourse.class);
	}
	
	public List getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select c from AeasFirstCourse c where c.grade=:grade");
		q.setParameter("grade", grade);
		List<OracleFirstCourse> list = q.getResultList();		
		return list;		
	}		
	
	public static void main(String[] args) {
		JpaFirstCourseOperation operation = new JpaFirstCourseOperation();
		System.out.println(operation.getAll());		
	}

}
