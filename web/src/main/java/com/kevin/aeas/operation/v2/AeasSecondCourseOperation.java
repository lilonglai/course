package com.kevin.aeas.operation.v2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.v2.AeasFirstCourse;
import com.kevin.aeas.object.v2.AeasSecondCourse;

public class AeasSecondCourseOperation extends AeasBasicOperation<AeasSecondCourse>{
	public AeasSecondCourseOperation(){
		super(AeasSecondCourse.class);
	}
	
	public List<AeasSecondCourse> getByFirstCourseId(int firstCourseId){
		Query q = EntityManangerUtil.getInstance().createQuery("select fc from AeasFirstCourse fc where fc.id=:id");
		q.setParameter("id", firstCourseId);
		List<AeasFirstCourse> fcList = q.getResultList();
		ArrayList<AeasSecondCourse> scList = new ArrayList<AeasSecondCourse>();
		for(AeasFirstCourse fc: fcList)
		  scList.addAll(fc.getAeasSecondCourses());
		return scList;		
	}
	
	public List<AeasSecondCourse> getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select fc from AeasFirstCourse fc where fc.grade=:grade");
		q.setParameter("grade", grade);
		List<AeasFirstCourse> fcList = q.getResultList();
		ArrayList<AeasSecondCourse> scList = new ArrayList<AeasSecondCourse>();
		for(AeasFirstCourse fc: fcList)
		  scList.addAll(fc.getAeasSecondCourses());
		return scList;		
	}
	
	public static void main(String[] args) {
		AeasSecondCourseOperation operation = new AeasSecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));
		
		
		
		
	}

}
