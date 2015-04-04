package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.FirstCourseOperation;
import com.kevin.aeas.operation.db.OperationManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class FirstCourseBusinessOperation {
    FirstCourseOperation firstCourseService = OperationManager.getInstance().getFirstCourseOperation();

    public void add(FirstCourse firstCourse){
        firstCourseService.add(firstCourse);
    }

    public void update(FirstCourse firstCourse){
        firstCourseService.update(firstCourse);
    }

	public FirstCourse get(@QueryParam("id") int firstCourseId){
		return firstCourseService.get(firstCourseId);
	}

	public void delete(@QueryParam("id") int firstCourseId){
		firstCourseService.delete(firstCourseId);
	}

    public List<FirstCourse> getAll(){
        return firstCourseService.getAll();
    }

}
