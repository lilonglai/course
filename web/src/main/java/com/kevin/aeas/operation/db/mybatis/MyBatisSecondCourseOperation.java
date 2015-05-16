package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.ISecondCourseOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisSecondCourse;

import java.util.List;

public class MyBatisSecondCourseOperation extends MyBatisBaseOperation<MyBatisSecondCourse> implements ISecondCourseOperation{
    public MyBatisSecondCourseOperation(){
        super(MyBatisSecondCourse.class);
    }

	public SecondCourse get(int key){
        return proxy.get(key);
	}

	
	public List<SecondCourse> getByFirstCourseId(int firstCourseId){
        return proxy.getByFirstCourseId(firstCourseId);
	}
	
	public List<SecondCourse> getByGrade(int grade){
        return proxy.getByGrade(grade);
	}
	
	public List<SecondCourse> getAll(){
        return proxy.getAll();
    }
	
	
	public void add(SecondCourse secondCourse){
        proxy.add(secondCourse);
	}
	
	public void update(SecondCourse secondCourse){
        proxy.update(secondCourse);
	}
	
	
	public void delete(int key){
        proxy.delete(key);
	}

}
