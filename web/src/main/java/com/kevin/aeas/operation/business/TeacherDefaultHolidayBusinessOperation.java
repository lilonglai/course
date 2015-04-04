package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.TeacherDefaultHoliday;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.TeacherDefaultHolidayOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class TeacherDefaultHolidayBusinessOperation {
    TeacherDefaultHolidayOperation teacherDefaultHolidayOperation = OperationManager.getInstance().getTeacherDefaultHolidayOperation();

    public void add(TeacherDefaultHoliday teacherDefaultHoliday){
        teacherDefaultHolidayOperation.add(teacherDefaultHoliday);
    }

    public void update(TeacherDefaultHoliday teacherDefaultHoliday){
        teacherDefaultHolidayOperation.update(teacherDefaultHoliday);
    }

	public TeacherDefaultHoliday get(@QueryParam("id") int id){
		return teacherDefaultHolidayOperation.get(id);
	}

	public void delete(@QueryParam("id") int id){
        teacherDefaultHolidayOperation.delete(id);
	}

    public List<TeacherDefaultHoliday> getAll(){
        return teacherDefaultHolidayOperation.getAll();
    }
}
