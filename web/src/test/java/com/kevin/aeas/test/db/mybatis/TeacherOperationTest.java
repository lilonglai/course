package com.kevin.aeas.test.db.mybatis;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.mybatis.MyBatisTeacherOperation;
import junit.framework.TestCase;

import java.util.List;

public  class TeacherOperationTest extends TestCase{
	public void testGet(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		Teacher teacher = operation.get(1);
	}

	
	public void testGetByName(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		Teacher teacher = operation.getByName("test");
	}
	
	
	public void testGetByShortName(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		Teacher teacher = operation.getByShortName("test");
	}
	
	public void testGetAll(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		List<Teacher> list = operation.getAll();
	}
	
	public void testGetAlive(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		List<Teacher> list = operation.getAlive();
	}
	
	public void testGetNotAlive(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		List<Teacher> list = operation.getNotAlive();
	}
	
	public void testGetByCondition(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
        teacher = operation.getByCondition(teacher);
	}
	
	public void testAdd(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		Teacher teacher = new Teacher();
		teacher.setName("test");
		teacher.setShortName("test");
		teacher.setIsMaster(true);
		teacher.setPhone("15221002264");
		operation.add(teacher);
	}
	
	public void testUpdate(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		List<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				teacher.setShortName("test2");
				operation.update(teacher);
			}
		}
		
	}
	
	
	public void testDelete(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		List<Teacher> list = operation.getAll();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.delete(teacher.getId());;
			}
		}
	}
	
	public void testRetire(){
        MyBatisTeacherOperation operation = new MyBatisTeacherOperation();
		List<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.retire(teacher.getId());;
			}
		}
	}

}
