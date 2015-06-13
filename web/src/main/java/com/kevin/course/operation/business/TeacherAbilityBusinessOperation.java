package com.kevin.course.operation.business;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.OperationManager;
import com.kevin.course.operation.db.TeacherAbilityOperation;

import javax.ws.rs.QueryParam;
import java.util.List;

public class TeacherAbilityBusinessOperation {
    TeacherAbilityOperation teacherAbilityOperation = OperationManager.getInstance().getTeacherAbilityOperation();

    public void add(TeacherAbility teacherAbility){
        teacherAbilityOperation.add(teacherAbility);
    }

    public void update(TeacherAbility teacherAbility){
        teacherAbilityOperation.update(teacherAbility);
    }

	public TeacherAbility get(@QueryParam("id") int id){
		return teacherAbilityOperation.get(id);
	}

	public void delete(@QueryParam("id") int id){
        teacherAbilityOperation.delete(id);
	}

    public List<TeacherAbility> getAll(){
        return teacherAbilityOperation.getAll();
    }
	
}
