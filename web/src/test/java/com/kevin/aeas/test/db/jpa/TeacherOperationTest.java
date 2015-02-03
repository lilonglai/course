package com.kevin.aeas.test.db.jpa;

import java.util.ArrayList;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.jpa.JpaTeacherOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;

public abstract class TeacherOperationTest extends TestCase{
	public void testGet(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = (Teacher) operation.get(1);
	}

	
	public void testGetByName(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = (Teacher) operation.getByName("test");
	}
	
	
	public void testGetByShortName(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = (Teacher) operation.getByShortName("test");
	}
	
	public void testGetAll(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		ArrayList<Teacher> list = (ArrayList<Teacher>) operation.getAll();
	}
	
	public void testGetAlive(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		ArrayList<Teacher> list = (ArrayList<Teacher>) operation.getAlive();
	}
	
	public void testGetNotAlive(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		ArrayList<Teacher> list = (ArrayList<Teacher>) operation.getNotAlive();
	}
	
	public void testGetIdByObject(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
		int id = operation.getIdByObject(teacher);

		
		
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
		ArrayList<Teacher> list = (ArrayList<Teacher>) operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				teacher.setShortName("test2");
				operation.update(teacher);
			}
		}
		
	}
	
	
	public void testDelete(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		ArrayList<Teacher> list = (ArrayList<Teacher>) operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.delete(teacher.getId());;
			}
		}
	}
	
	public void testRetire(){
		JpaTeacherOperation operation = new JpaTeacherOperation();
		ArrayList<Teacher> list = (ArrayList<Teacher>) operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.retire(teacher.getId());;
			}
		}
	}
	
	protected void setUp() throws Exception{
		DbUtils.resetDbInstance();
	}
}
