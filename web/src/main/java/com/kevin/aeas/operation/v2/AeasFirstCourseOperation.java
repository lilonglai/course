package com.kevin.aeas.operation.v2;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleFirstCourse;


public class AeasFirstCourseOperation extends AeasBasicOperation<OracleFirstCourse> {
	public AeasFirstCourseOperation(){
		super(OracleFirstCourse.class);
	}
	
	public List<OracleFirstCourse> getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select c from AeasFirstCourse c where c.grade=:grade");
		q.setParameter("grade", grade);
		List<OracleFirstCourse> list = q.getResultList();		
		return list;		
	}		
	
	public static void main(String[] args) {
		AeasFirstCourseOperation operation = new AeasFirstCourseOperation();
		System.out.println(operation.getAll());		
	}

}
