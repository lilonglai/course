package com.kevin.aeas.operation.v2;

import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.v2.AeasFirstCourse;


public class AeasFirstCourseOperation extends AeasBasicOperation<AeasFirstCourse> {
	public AeasFirstCourseOperation(){
		super(AeasFirstCourse.class);
	}
	
	public List<AeasFirstCourse> getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select c from AeasFirstCourse c where c.grade=:grade");
		q.setParameter("grade", grade);
		List<AeasFirstCourse> list = q.getResultList();		
		return list;		
	}		
	
	public static void main(String[] args) {
		AeasFirstCourseOperation operation = new AeasFirstCourseOperation();
		System.out.println(operation.getAll());		
	}

}
