package com.kevin.course.operation.db;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.operation.db.basic.JdbcFirstCourseOperation;
import com.kevin.course.operation.db.jpa.JpaFirstCourseOperation;
import com.kevin.course.operation.db.mybatis.MyBatisFirstCourseOperation;
import com.kevin.course.utils.ConfigurationManager;

import java.util.List;


public class FirstCourseOperation {
    private IFirstCourseOperation firstCourseDao;
    public FirstCourseOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            firstCourseDao = new JpaFirstCourseOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            firstCourseDao = new MyBatisFirstCourseOperation();
        }
        else{
            firstCourseDao = new JdbcFirstCourseOperation();
        }
    }

	public FirstCourse get(int key){
        return firstCourseDao.get(key);
	}
	
	public List<FirstCourse> getByGrade(int grade){
        return firstCourseDao.getByGrade(grade);
	}
	
	public List<FirstCourse> getAll(){
        return firstCourseDao.getAll();
	}
	
	
	public void add(FirstCourse firstCourse){
        firstCourseDao.add(firstCourse);
	}
	
	public void update(FirstCourse firstCourse){
        firstCourseDao.update(firstCourse);
	}
	
	
	public void delete(int key){
        firstCourseDao.delete(key);
	}

}
