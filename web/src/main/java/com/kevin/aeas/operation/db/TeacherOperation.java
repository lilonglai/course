package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.Teacher;
import com.kevin.aeas.operation.db.basic.JdbcTeacherOperation;
import com.kevin.aeas.operation.db.jpa.JpaTeacherOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisTeacherOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import java.util.List;

public class TeacherOperation {
    private ITeacherOperation teacherDao;
    public TeacherOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            teacherDao = new JpaTeacherOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            teacherDao = new MyBatisTeacherOperation();
        }
        else{
            teacherDao = new JdbcTeacherOperation();
        }
    }

	public Teacher get(int key){
        return teacherDao.get(key);
	}
	
	public Teacher getByName(String name){
        return teacherDao.getByName(name);
	}
	
	
	public Teacher getByShortName(String shortName){
        return teacherDao.getByShortName(shortName);
	}
	
	public List<Teacher> getAll(){
        return teacherDao.getAll();
	}
	
	public List<Teacher> getAlive(){
        return teacherDao.getAlive();
	}
	
	public List<Teacher> getNotAlive(){
        return teacherDao.getNotAlive();
	}
	
	public Teacher getByCondition(Teacher condition){
        return teacherDao.getByCondition(condition);
	}
	
	public void add(Teacher teacher){
        teacherDao.add(teacher);
	}
	
	public void update(Teacher teacher){
        teacherDao.update(teacher);
	}

	public void delete(int key){
        teacherDao.delete(key);
	}
	
	public void retire(int key){
        teacherDao.retire(key);
	}
}
