package com.kevin.course.test.db.jpa;

import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.jpa.JpaTeacherOperation;
import junit.framework.TestCase;

import java.util.List;

public abstract class TeacherOperationTest extends TestCase{
	public void testGet(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = operation.get(1);
	}

	
	public void testGetByName(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = operation.getByName("test");
	}
	
	
	public void testGetByShortName(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = operation.getByShortName("test");
	}
	
	public void testGetAll(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		List<Teacher> list =  operation.getAll();
	}
	
	public void testGetAlive(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		List<Teacher> list =  operation.getAlive();
	}
	
	public void testGetNotAlive(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		List<Teacher> list =  operation.getNotAlive();
	}
	
	public void testGetByCondition(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
		operation.getByCondition(teacher);
	}
	
	public void testAdd(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
		teacher.setShortName("test");
		teacher.setIsMaster(true);
		teacher.setPhone("15221002264");
		operation.add(teacher);
	}
	
	public void testUpdate(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		List<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				teacher.setShortName("test2");
				operation.update(teacher);
			}
		}
		
	}
	
	
	public void testDelete(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		List<Teacher> list = operation.getAll();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.delete(teacher.getId());;
			}
		}
	}
	
	public void testRetire(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		List<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.retire(teacher.getId());;
			}
		}
	}

}
