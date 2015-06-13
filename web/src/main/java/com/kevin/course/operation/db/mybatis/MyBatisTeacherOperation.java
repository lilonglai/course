package com.kevin.course.operation.db.mybatis;

import com.kevin.course.object.Teacher;
import com.kevin.course.operation.db.ITeacherOperation;

import java.util.List;

public class MyBatisTeacherOperation extends MyBatisBaseOperation<ITeacherOperation> implements ITeacherOperation{
    public MyBatisTeacherOperation(){
        super(ITeacherOperation.class);
    }

	public Teacher get(int key){
        return proxy.get(key);
	}

	
	public Teacher getByName(String name){
        return proxy.getByName(name);
	}
	
	
	public Teacher getByShortName(String shortName){
        return proxy.getByShortName(shortName);
	}
	
	public List<Teacher> getAll(){
        return proxy.getAll();
	}
	
	public List<Teacher> getAlive(){
        return proxy.getAlive();
	}

	public List<Teacher> getNotAlive(){
        return proxy.getNotAlive();
	}
	
	public Teacher getByCondition(Teacher condition){
		return proxy.getByCondition(condition);
	}
	
	public void add(Teacher teacher){
        proxy.add(teacher);
	}
	
	public void update(Teacher teacher){
        proxy.update(teacher);
	}
	
	
	public void delete(int key){
        proxy.delete(key);
	}
	
	public void retire(int key){
        proxy.retire(key);
	}
}
