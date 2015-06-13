package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.ITeacherAbilityOperation;

import java.util.List;

public class MyBatisTeacherAbilityOperation extends MyBatisBaseOperation<ITeacherAbilityOperation> implements ITeacherAbilityOperation{
    public MyBatisTeacherAbilityOperation(){
        super(ITeacherAbilityOperation.class);
    }

	public TeacherAbility get(int key) {
        return proxy.get(key);
	}
	
	public List<TeacherAbility> getAll() {
        return proxy.getAll();
	}
	
	public List<TeacherAbility> getByTeacherId(int teacherId) {
        return proxy.getByTeacherId(teacherId);
	}
	
	public List<TeacherAbility> getByCourseId(int courseId) {
        return proxy.getByCourseId(courseId);
	}
	
	public void add(TeacherAbility teacherAbility) {
        proxy.add(teacherAbility);
    }

	
	public void update(TeacherAbility teacherAbility){
        proxy.add(teacherAbility);
	}
	
	
	public void delete(int key){
        proxy.delete(key);
	}
	
	public void deleteByTeacherId(int teacherId){
        proxy.deleteByTeacherId(teacherId);
	}
	
	
	public void deleteByTeacherAndGrade(int teacherId,int grade){
        proxy.deleteByTeacherAndGrade(teacherId, grade);
	}
	
}


