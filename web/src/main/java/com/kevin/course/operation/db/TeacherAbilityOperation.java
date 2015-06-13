package com.kevin.course.operation.db;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.basic.JdbcTeacherAbilityOperation;
import com.kevin.course.operation.db.jpa.JpaTeacherAbilityOperation;
import com.kevin.course.operation.db.mybatis.MyBatisTeacherAbilityOperation;
import com.kevin.course.utils.ConfigurationManager;

import java.util.List;

public class TeacherAbilityOperation {
    private ITeacherAbilityOperation teacherAbilityDao;
    public TeacherAbilityOperation(){
        if(ConfigurationManager.getInstance().isJpa()){
            teacherAbilityDao = new JpaTeacherAbilityOperation();
        }
        else if(ConfigurationManager.getInstance().isMyBatis()){
            teacherAbilityDao = new MyBatisTeacherAbilityOperation();
        }
        else{
            teacherAbilityDao = new JdbcTeacherAbilityOperation();
        }
    }

	public TeacherAbility get(int key) {
        return teacherAbilityDao.get(key);
	}

	public List<TeacherAbility> getAll() {
        return teacherAbilityDao.getAll();
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
        return teacherAbilityDao.getByTeacherId(teacherId);
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
        return teacherAbilityDao.getByCourseId(courseId);
	}
	
	public void add(TeacherAbility teacherAbility){
        teacherAbilityDao.add(teacherAbility);
	}
	
	public void update(TeacherAbility teacherAbility){
        teacherAbilityDao.update(teacherAbility);
	}

	public void delete(int key){
        teacherAbilityDao.delete(key);
	}
	
	public void deleteByTeacherId(int teacherId){
        teacherAbilityDao.deleteByTeacherId(teacherId);
	}

	public void deleteByTeacherAndGrade(int teacherId,int grade){
        teacherAbilityDao.deleteByTeacherAndGrade(teacherId, grade);
	}
}


