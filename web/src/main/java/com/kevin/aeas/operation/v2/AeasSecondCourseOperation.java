package com.kevin.aeas.operation.v2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.kevin.aeas.object.oracle.OracleFirstCourse;
import com.kevin.aeas.object.oracle.OracleSecondCourse;

public class AeasSecondCourseOperation extends AeasBasicOperation<OracleSecondCourse>{
	public AeasSecondCourseOperation(){
		super(OracleSecondCourse.class);
	}
	
	public List<OracleSecondCourse> getByFirstCourseId(int firstCourseId){
		Query q = EntityManangerUtil.getInstance().createQuery("select fc from AeasFirstCourse fc where fc.id=:id");
		q.setParameter("id", firstCourseId);
		List<OracleFirstCourse> fcList = q.getResultList();
		ArrayList<OracleSecondCourse> scList = new ArrayList<OracleSecondCourse>();
		for(OracleFirstCourse fc: fcList)
		  scList.addAll(fc.getAeasSecondCourses());
		return scList;		
	}
	
	public List<OracleSecondCourse> getByGrade(int grade){
		Query q = EntityManangerUtil.getInstance().createQuery("select fc from AeasFirstCourse fc where fc.grade=:grade");
		q.setParameter("grade", grade);
		List<OracleFirstCourse> fcList = q.getResultList();
		ArrayList<OracleSecondCourse> scList = new ArrayList<OracleSecondCourse>();
		for(OracleFirstCourse fc: fcList)
		  scList.addAll(fc.getAeasSecondCourses());
		return scList;		
	}
	
	public static void main(String[] args) {
		AeasSecondCourseOperation operation = new AeasSecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));
		
		
		
		
	}

}
