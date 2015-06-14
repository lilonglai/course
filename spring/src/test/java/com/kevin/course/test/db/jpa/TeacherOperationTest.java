package com.kevin.course.test.db.jpa;

import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.ITeacherOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.util.List;

public  class TeacherOperationTest extends TestCase{
	ITeacherOperation operation;
	public TeacherOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getJpaInstance();
		operation = (ITeacherOperation)context.getBean("jpaTeacherDao");
	}
	public void testGet(){
		Teacher teacher = operation.get(1);
	}

	
	public void testGetByName(){
		Teacher teacher = operation.getByName("test");
	}
	
	
	public void testGetByShortName(){
		Teacher teacher = operation.getByShortName("test");
	}
	
	public void testGetAll(){
		List<Teacher> list =  operation.getAll();
	}
	
	public void testGetAlive(){
		List<Teacher> list =  operation.getAlive();
	}
	
	public void testGetNotAlive(){
		List<Teacher> list =  operation.getNotAlive();
	}
	
	public void testGetByCondition(){
		Teacher teacher = new Teacher();
		teacher.setName("test");
		operation.getByCondition(teacher);
	}
	
	public void testAdd(){
		Teacher teacher = new Teacher();
		teacher.setName("test");
		teacher.setShortName("test");
		teacher.setIsMaster(true);
		teacher.setPhone("15221002264");
		operation.add(teacher);
	}
	
	public void testUpdate(){
		List<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				teacher.setShortName("test2");
				operation.update(teacher);
			}
		}
		
	}
	
	
	public void testDelete(){
		List<Teacher> list = operation.getAll();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.delete(teacher.getId());;
			}
		}
	}
	
	public void testRetire(){
		List<Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.retire(teacher.getId());;
			}
		}
	}

}
