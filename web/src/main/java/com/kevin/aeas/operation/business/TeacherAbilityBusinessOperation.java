package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.TeacherAbility;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherAbilityOperation;

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
