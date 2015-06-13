package com.kevin.course.operation.db.mybatis;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.IFirstCourseOperation;

import java.util.List;

public class MyBatisFirstCourseOperation extends MyBatisBaseOperation<IFirstCourseOperation> implements IFirstCourseOperation{

    public MyBatisFirstCourseOperation(){
        super(IFirstCourseOperation.class);
    }

	public FirstCourse get(int key) {
        return proxy.get(key);
	}

	public List<FirstCourse> getByGrade(int grade) {
        return proxy.getByGrade(grade);
	}

	public List<FirstCourse> getAll() {
        return proxy.getAll();
	}

	public void add(FirstCourse firstCourse) {
        proxy.add(firstCourse);
	}

	public void update(FirstCourse firstCourse) {
        proxy.update(firstCourse);
	}

	public void delete(int key) {
        proxy.delete(key);
	}

}
