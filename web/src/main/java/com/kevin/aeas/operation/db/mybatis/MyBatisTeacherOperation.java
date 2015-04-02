package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.ITeacherOperation;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisTeacher;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisTeacherOperation extends MyBatisBaseOperation<MyBatisTeacher> implements ITeacherOperation{
    public MyBatisTeacherOperation(){
        super(MyBatisTeacher.class);
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
