package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.IStudentOperation;

import java.util.List;

public class MyBatisStudentOperation extends MyBatisBaseOperation<IStudentOperation> implements IStudentOperation{
    public MyBatisStudentOperation(){
        super(IStudentOperation.class);
    }

	public Student get(int key) {
        return proxy.get(key);
	}
	
	public Student getByName(String name) {
        return proxy.getByName(name);
	}
	

	public List<Student> getByGrade(int grade) {
        return proxy.getByGrade(grade);
	}

	public List<Student> getAll() {
        return proxy.getAll();
	}
	
	public List<Student> getAlive() {
        return proxy.getAlive();
	}
	
	public List<Student> getNotAlive() {
        return proxy.getNotAlive();
	}

	public List<Student> getByTeacherId(int teacherId) {
        return proxy.getByTeacherId(teacherId);
	}

	public void add(Student student){
        proxy.add(student);
	}

	public void update(Student student) {
        proxy.add(student);
	}

	public void delete(int key) {
        proxy.delete(key);
	}
	
	public void retire(int key) {
        proxy.retire(key);
	}
}
