package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.basic.JdbcStudentOperation;
import com.kevin.aeas.operation.db.jpa.JpaStudentOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisStudentOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import java.util.List;

public class StudentOperation {
    private IStudentOperation studentDao;
    public StudentOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            studentDao = new JpaStudentOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            studentDao = new MyBatisStudentOperation();
        }
        else{
            studentDao = new JdbcStudentOperation();
        }
    }

	public Student get(int key) {
        return studentDao.get(key);
	}
	
	public Student getByName(String name) {
        return studentDao.getByName(name);
	}
	

	public List<Student> getByGrade(int grade) {
        return studentDao.getByGrade(grade);
	}

	public List<Student> getAll() {
        return studentDao.getAll();
	}
	
	public List<Student> getAlive() {
        return studentDao.getAlive();
	}
	
	public List<Student> getNotAlive() {
        return studentDao.getNotAlive();
	}

	public List<Student> getByTeacherId(int teacherId) {
        return studentDao.getByTeacherId(teacherId);
	}

	public void add(Student student){
        studentDao.add(student);
	}

	public void update(Student student) {
        studentDao.update(student);
	}

	public void delete(int key) {
        studentDao.delete(key);
	}
	
	public void retire(int key) {
        studentDao.retire(key);
	}
}
