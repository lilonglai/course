package com.kevin.aeas.operation.db;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.basic.JdbcSecondCourseOperation;
import com.kevin.aeas.operation.db.jpa.JpaSecondCourseOperation;
import com.kevin.aeas.operation.db.mybatis.MyBatisSecondCourseOperation;
import com.kevin.aeas.utils.ConfigurationManager;

import java.util.List;

public class SecondCourseOperation {
    private ISecondCourseOperation secondCourseDao;

    public SecondCourseOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            secondCourseDao = new JpaSecondCourseOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            secondCourseDao = new MyBatisSecondCourseOperation();
        }
        else{
            secondCourseDao = new JdbcSecondCourseOperation();
        }
    }

	public SecondCourse get(int key){
        return secondCourseDao.get(key);
	}
	
	public List<? extends SecondCourse> getByFirstCourseId(int firstCourseId){
        return secondCourseDao.getByFirstCourseId(firstCourseId);
	}
	
	public List<? extends SecondCourse> getByGrade(int grade){
        return secondCourseDao.getByGrade(grade);
	}
	
	public List<? extends SecondCourse> getAll(){
        return secondCourseDao.getAll();
	}
	
	
	public void add(SecondCourse secondCourse){
        secondCourseDao.add(secondCourse);
	}
	
	public void update(SecondCourse secondCourse){
        secondCourseDao.update(secondCourse);
	}
	
	
	public void delete(int key){
        secondCourseDao.delete(key);
	}

}
