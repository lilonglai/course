package com.kevin.aeas.operation.db;

import java.util.List;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;


public class FirstCourseOperation {
	public FirstCourse get(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			return (FirstCourse)JpaOperationManager.getInstance().getFirstCourseOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getFirstCourseOperation().get(key);
		}
	}
	
	public List<FirstCourse> getByGrade(int grade){
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<FirstCourse>) JpaOperationManager.getInstance().getFirstCourseOperation().getByGrade(grade);
		}
		else{
			return DbOperationManager.getInstance().getFirstCourseOperation().getByGrade(grade);
		}
		
	}
	
	public List<FirstCourse> getAll(){
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<FirstCourse>) JpaOperationManager.getInstance().getFirstCourseOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getFirstCourseOperation().getAll();
		}
		
	}
	
	
	public void add(FirstCourse firstCourse){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getFirstCourseOperation().add(firstCourse);
		}
		else{
			DbOperationManager.getInstance().getFirstCourseOperation().add(firstCourse);
		}
		
	}
	
	public void update(FirstCourse firstCourse){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getFirstCourseOperation().update(firstCourse);
		}
		else{
			DbOperationManager.getInstance().getFirstCourseOperation().update(firstCourse);
		}
	}
	
	
	public void delete(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getFirstCourseOperation().delete(key);
		}
		else{
			DbOperationManager.getInstance().getFirstCourseOperation().delete(key);
		}
	}
	
	public static void main(String[] args) {
		FirstCourseOperation operation = new FirstCourseOperation();
		System.out.println(operation.getAll());		
	}

}
