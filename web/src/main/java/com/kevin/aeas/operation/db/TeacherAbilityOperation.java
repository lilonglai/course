package com.kevin.aeas.operation.db;

import java.util.ArrayList;
import java.util.List;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;

public class TeacherAbilityOperation {
	public TeacherAbility get(int key) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (TeacherAbility)JpaOperationManager.getInstance().getTeacherAbilityOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getTeacherAbilityOperation().get(key);
		}

	}

	public List<TeacherAbility> getAll() {
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<TeacherAbility>)JpaOperationManager.getInstance().getTeacherAbilityOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getTeacherAbilityOperation().getAll();
		}
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<TeacherAbility>)JpaOperationManager.getInstance().getTeacherAbilityOperation().getByTeacherId(teacherId);
		}
		else{
			return DbOperationManager.getInstance().getTeacherAbilityOperation().getByTeacherId(teacherId);
		}
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<TeacherAbility>)JpaOperationManager.getInstance().getTeacherAbilityOperation().getByCourseId(courseId);
		}
		else{
			return DbOperationManager.getInstance().getTeacherAbilityOperation().getByCourseId(courseId);
		}
	}
	
	public void add(TeacherAbility teacherAbility){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherAbilityOperation().add(teacherAbility);
		}
		else{
			DbOperationManager.getInstance().getTeacherAbilityOperation().add(teacherAbility);
		}
		
	}
	
	public void update(TeacherAbility teacherAbility){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherAbilityOperation().update(teacherAbility);
		}
		else{
			DbOperationManager.getInstance().getTeacherAbilityOperation().update(teacherAbility);
		}
	}
	
	
	public void delete(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherAbilityOperation().delete(key);
		}
		else{
			DbOperationManager.getInstance().getTeacherAbilityOperation().delete(key);
		}
	}
	
	public void deleteByTeacherId(int teacherId){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherAbilityOperation().deleteByTeacherId(teacherId);
		}
		else{
			DbOperationManager.getInstance().getTeacherAbilityOperation().deleteByTeacherId(teacherId);
		}
	}
	
	
	public void deleteByTeacherAndGrade(int teacherId,int grade){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getTeacherAbilityOperation().deleteByTeacherAndGrade(teacherId,grade);
		}
		else{
			DbOperationManager.getInstance().getTeacherAbilityOperation().deleteByTeacherAndGrade(teacherId,grade);
		}
	}
	
	public static void main(String[] args) {
		TeacherAbilityOperation teacherAbilityOperation = new TeacherAbilityOperation();
		
		
		
		
	}
}


