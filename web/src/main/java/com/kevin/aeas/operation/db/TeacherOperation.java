package com.kevin.aeas.operation.db;

import java.util.List;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;

public class TeacherOperation {
	public Teacher get(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			return (Teacher)JpaOperationManager.getInstance().getTeacherOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getTeacherOperation().get(key);
		}	
	}
	
	public Teacher getByName(String name){
		if(ConfigurationManager.getInstance().isJpa()){
			return (Teacher)JpaOperationManager.getInstance().getTeacherOperation().getByName(name);
		}
		else{
			return DbOperationManager.getInstance().getTeacherOperation().getByName(name);
		}		
	}
	
	
	public Teacher getByShortName(String shortName){
		if(ConfigurationManager.getInstance().isJpa()){
			return (Teacher)JpaOperationManager.getInstance().getTeacherOperation().getByShortName(shortName);
		}
		else{
			return DbOperationManager.getInstance().getTeacherOperation().getByShortName(shortName);
		}		
	}
	
	public List<Teacher> getAll(){
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<Teacher>)JpaOperationManager.getInstance().getTeacherOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getTeacherOperation().getAll();
		}	
		
	}
	
	public List<Teacher> getAlive(){
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<Teacher>)JpaOperationManager.getInstance().getTeacherOperation().getAlive();
		}
		else{
			return DbOperationManager.getInstance().getTeacherOperation().getAlive();
		}	
		
	}
	
	public List<Teacher> getNotAlive(){
		if(ConfigurationManager.getInstance().isJpa()){
			return (List<Teacher>)JpaOperationManager.getInstance().getTeacherOperation().getNotAlive();
		}
		else{
			return DbOperationManager.getInstance().getTeacherOperation().getNotAlive();
		}
		
	}
	
	public int getIdByObject(Teacher condition){
		if(ConfigurationManager.getInstance().isJpa()){
			return JpaOperationManager.getInstance().getTeacherOperation().getIdByObject(condition);
		}
		else{
			return DbOperationManager.getInstance().getTeacherOperation().getIdByObject(condition);
		}
		
	}
	
	public void add(Teacher teacher){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherOperation().add(teacher);
		}
		else{
			 DbOperationManager.getInstance().getTeacherOperation().add(teacher);
		}
		
		
	}
	
	public void update(Teacher teacher){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherOperation().update(teacher);
		}
		else{
			 DbOperationManager.getInstance().getTeacherOperation().update(teacher);
		}
		
	}
	
	
	public void delete(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherOperation().delete(key);
		}
		else{
			 DbOperationManager.getInstance().getTeacherOperation().delete(key);
		}
		
	}
	
	public void retire(int key){
		if(ConfigurationManager.getInstance().isJpa()){
			 JpaOperationManager.getInstance().getTeacherOperation().retire(key);
		}
		else{
			 DbOperationManager.getInstance().getTeacherOperation().retire(key);
		}
	}
	
	public static void main(String[] args) {
		TeacherOperation operation = new TeacherOperation();
		System.out.println(operation.getAll());		
	}

}
