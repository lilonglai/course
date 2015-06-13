package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.ITeacherOperation;
import com.kevin.course.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

import java.util.List;

public  class TeacherOperationTest extends TestCase{
	ITeacherOperation
			operation;
	public TeacherOperationTest(){
		ApplicationContext context = ApplicationContextUtils.getMybatisInstance();
		operation = (ITeacherOperation)context.getBean("myBatisTeacherDao");
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
		List<? extends Teacher> list = operation.getAll();
	}
	
	public void testGetAlive(){
		List<? extends Teacher> list = operation.getAlive();
	}
	
	public void testGetNotAlive(){
		List<? extends Teacher> list = operation.getNotAlive();
	}
	
	public void testGetByCondition(){
		Teacher teacher = new Teacher();
		teacher.setName("test");
        teacher = operation.getByCondition(teacher);
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
		List<? extends Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				teacher.setShortName("test2");
				operation.update(teacher);
			}
		}
		
	}
	
	
	public void testDelete(){
		List<? extends Teacher> list = operation.getAll();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.delete(teacher.getId());;
			}
		}
	}
	
	public void testRetire(){
		List<? extends Teacher> list = operation.getAlive();
		for(Teacher teacher: list){
			if(teacher.getName().equals("test")){
				operation.retire(teacher.getId());;
			}
		}
	}

}
