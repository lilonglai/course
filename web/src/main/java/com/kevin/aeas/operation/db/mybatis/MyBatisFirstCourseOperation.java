package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.IFirstCourseOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisFirstCourse;

import java.util.List;

public class MyBatisFirstCourseOperation extends MyBatisBaseOperation<MyBatisFirstCourse> implements IFirstCourseOperation{

    public MyBatisFirstCourseOperation(){
        super(MyBatisFirstCourse.class);
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
