package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.ITeacherAbilityOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherAbilityBusinessOperation implements ITeacherAbilityBusinessOperation{
    @Autowired
    private ITeacherAbilityOperation teacherAbilityOperation;

    public void add(TeacherAbility teacherAbility){
        teacherAbilityOperation.add(teacherAbility);
    }

    public void update(TeacherAbility teacherAbility){
        teacherAbilityOperation.update(teacherAbility);
    }

	public TeacherAbility get( int id){
		return teacherAbilityOperation.get(id);
	}

	public void delete(int id){
        teacherAbilityOperation.delete(id);
	}

    public List<TeacherAbility> getAll(){
        return teacherAbilityOperation.getAll();
    }

    public List<TeacherAbility> getByTeacherId(int teacherId){
        return teacherAbilityOperation.getByTeacherId(teacherId);
    }

    public List<TeacherAbility> getByCourseId(int courseId){
        return teacherAbilityOperation.getByCourseId(courseId);
    }

    public void deleteByTeacherId(int teacherId){
        teacherAbilityOperation.deleteByTeacherId(teacherId);
    }

    public void deleteByTeacherAndGrade(int teacherId, int grade){
        teacherAbilityOperation.deleteByTeacherAndGrade(teacherId, grade);
    }
	
}
