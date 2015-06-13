package com.kevin.course.test.db.mybatis;

import com.kevin.course.object.User;
import com.kevin.course.operation.db.mybatis.MyBatisUserOperation;
import junit.framework.TestCase;


public class UserOperationTest extends TestCase{
	public void  testGet(){
        MyBatisUserOperation operation = new MyBatisUserOperation();
		User user = operation.get("test", "test");
	}
	
	
	public void  testAdd(){
        MyBatisUserOperation operation = new MyBatisUserOperation();
		User user = new User();

        //* add grade 1 first course
        user.setName("test");
        user.setPassword("test");
        user.setEmail("longlai.li@gmail.com");
        user.setDescription("this is the test case for first course");
        operation.add(user);
	}
	
	public void testUpdate(){
        MyBatisUserOperation operation = new MyBatisUserOperation();
		User user = operation.get("test", "test");
        if(user == null){
            user = new User();
            user.setName("test");
            user.setPassword("test");
            user.setEmail("longlai.li@gmail.com");
            user.setDescription("this is the test case for first course");
            operation.add(user);
        }
        user.setEmail("409797885@gmail.com");
        operation.update(user);
	}

    public void testUpdatePassword(){
        MyBatisUserOperation operation = new MyBatisUserOperation();
        User user = new User();

        user.setName("test1");
        user.setPassword("test");
        user.setEmail("longlai.li@gmail.com");
        user.setDescription("this is the test case for first course");
        operation.add(user);
        operation.updatePassword("test1", "test1");

        user = operation.get("test1", "test1");
        operation.delete(user.getId());

    }
		
	public void testDelete(){
        MyBatisUserOperation operation = new MyBatisUserOperation();
        User user = operation.get("test", "test");
        operation.delete(user.getId());
	}

}
