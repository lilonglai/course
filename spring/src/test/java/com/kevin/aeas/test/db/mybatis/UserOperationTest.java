package com.kevin.aeas.test.db.mybatis;

import com.kevin.aeas.object.User;
import com.kevin.aeas.operation.db.IUserOperation;
import com.kevin.aeas.test.db.utils.ApplicationContextUtils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;


public class UserOperationTest extends TestCase{
    IUserOperation operation;
    public UserOperationTest(){
        ApplicationContext context = ApplicationContextUtils.getMybatisInstance();
        operation = (IUserOperation)context.getBean("myBatisUserDao");
    }
	public void  testGet(){
		User user = operation.get("test", "test");
	}
	
	
	public void  testAdd(){
		User user = new User();

        //* add grade 1 first course
        user.setName("test");
        user.setPassword("test");
        user.setEmail("longlai.li@gmail.com");
        user.setDescription("this is the test case for first course");
        operation.add(user);
	}
	
	public void testUpdate(){
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
        User user = operation.get("test", "test");
        operation.delete(user.getId());
	}

}
