package com.kevin.aeas.test.db.basic;

import java.util.ArrayList;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.basic.DbTeacherOperation;
import com.kevin.aeas.test.db.utils.DbUtils;

import junit.framework.TestCase;

public abstract class TeacherOperationTest extends TestCase{
	public void testGet(){
		DbTeacherOperation operation = new DbTeacherOperation();
		Teacher teacher = operation.get(1);
	}

	
	public void testGetByName(){
		DbTeacherOperation operation = new DbTeacherOperation();
		Teacher teacher = operation.getByName("test");
	}
	
	
	public void testGetByShortName(){
		DbTeacherOperation operation = new DbTeacherOperation();
		Teacher teacher = operation.getByShortName("test");
	}
	
	public void testGetAll(){
		DbTeacherOperation operation = new DbTeacherOperation();
		ArrayList<Teacher> list = operation.getAll();
	}
	
	public void testGetAlive(){
		DbTeacherOperation operation = new DbTeacherOperation();
		ArrayList<Teacher> list = operation.getAlive();
	}
	
	public void testGetNotAlive(){
		DbTeacherOperation operation = new DbTeacherOperation();
		ArrayList<Teacher> list = operation.getNotAlive();
	}
	
	public void testGetIdByObject(){
		DbTeacherOperation operation = new DbTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
		int id = operation.getIdByObject(teacher);

		
		
	}
	
	public void testAdd(){
		DbTeacherOperation operation = new DbTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
		teacher.setShortName("test");
		teacher.setIsMaster(true);
		teacher.setPhone("15221002264");
		operation.add(teacher);
	}
	
	public void testUpdate(){
		DbTeacherOperation operation = new DbTeacherOperation();
		ArrayList<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				teacher.setShortName("test2");
				operation.update(teacher);
			}
		}
		
	}
	
	
	public void testDelete(){
		DbTeacherOperation operation = new DbTeacherOperation();
		ArrayList<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.delete(teacher.getId());;
			}
		}
	}
	
	public void testRetire(){
		DbTeacherOperation operation = new DbTeacherOperation();
		ArrayList<Teacher> list = operation.getAlive();
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
