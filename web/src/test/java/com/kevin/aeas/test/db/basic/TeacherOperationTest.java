package com.kevin.aeas.test.db.basic;

import java.util.List;

import com.kevin.aeas.operation.db.basic.JdbcTeacherOperation;
import junit.framework.TestCase;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.test.db.utils.DbUtils;

public abstract class TeacherOperationTest extends TestCase{
	public void testGet(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		Teacher teacher = operation.get(1);
	}

	
	public void testGetByName(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		Teacher teacher = operation.getByName("test");
	}
	
	
	public void testGetByShortName(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		Teacher teacher = operation.getByShortName("test");
	}
	
	public void testGetAll(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		List<? extends Teacher> list = operation.getAll();
	}
	
	public void testGetAlive(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		List<? extends Teacher> list = operation.getAlive();
	}
	
	public void testGetNotAlive(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		List<? extends Teacher> list = operation.getNotAlive();
	}
	
	public void testGetIdByObject(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
        operation.getByCondition(teacher);
	}
	
	public void testAdd(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
		teacher.setShortName("test");
		teacher.setIsMaster(true);
		teacher.setPhone("15221002264");
		operation.add(teacher);
	}
	
	public void testUpdate(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		List<? extends Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				teacher.setShortName("test2");
				operation.update(teacher);
			}
		}
		
	}
	
	
	public void testDelete(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		List<? extends Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.delete(teacher.getId());;
			}
		}
	}
	
	public void testRetire(){
		JdbcTeacherOperation operation = new JdbcTeacherOperation();
		List<? extends Teacher> list = operation.getAlive();
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
