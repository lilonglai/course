package com.kevin.aeas.operation.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;
import com.kevin.aeas.utils.DatabaseHelp;

public class SecondCourseOperation {
	public SecondCourse get(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			return (SecondCourse)JpaOperationManager.getInstance().getSecondCourseOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getSecondCourseOperation().get(key);
		}
		
	}
	
	public ArrayList<SecondCourse> getByFirstCourseId(int firstCourseId){
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<SecondCourse>)JpaOperationManager.getInstance().getSecondCourseOperation().getByFirstCourseId(firstCourseId);
		}
		else{
			return DbOperationManager.getInstance().getSecondCourseOperation().getByFirstCourseId(firstCourseId);
		}
		
	}
	
	public ArrayList<SecondCourse> getByGrade(int grade){
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<SecondCourse>)JpaOperationManager.getInstance().getSecondCourseOperation().getByGrade(grade);
		}
		else{
			return DbOperationManager.getInstance().getSecondCourseOperation().getByGrade(grade);
		}
		
	}
	
	public ArrayList<SecondCourse> getAll(){
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<SecondCourse>)JpaOperationManager.getInstance().getSecondCourseOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getSecondCourseOperation().getAll();
		}
		
	}
	
	
	public void add(SecondCourse secondCourse){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getSecondCourseOperation().add(secondCourse);
		}
		else{
			DbOperationManager.getInstance().getSecondCourseOperation().add(secondCourse);
		}
		
	}
	
	public void update(SecondCourse secondCourse){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getSecondCourseOperation().update(secondCourse);
		}
		else{
			DbOperationManager.getInstance().getSecondCourseOperation().update(secondCourse);
		}
	}
	
	
	public void delete(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getSecondCourseOperation().delete(key);
		}
		else{
			DbOperationManager.getInstance().getSecondCourseOperation().delete(key);
		}
	}
	
	public static void main(String[] args) {
		SecondCourseOperation operation = new SecondCourseOperation();
		System.out.println(operation.getByFirstCourseId(1));
		
		
		
		
	}

}
