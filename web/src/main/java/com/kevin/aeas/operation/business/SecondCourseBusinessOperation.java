package com.kevin.aeas.operation.business;

import com.kevin.aeas.object.SecondCourse;
import com.kevin.aeas.operation.db.OperationManager;
import com.kevin.aeas.operation.db.SecondCourseOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class SecondCourseBusinessOperation {
    SecondCourseOperation secondCourseOperation = OperationManager.getInstance().getSecondCourseOperation();

    public void add(SecondCourse secondCourse){
        secondCourseOperation.add(secondCourse);
    }

    public void update(SecondCourse secondCourse){
        secondCourseOperation.update(secondCourse);
    }

	public SecondCourse get(int secondCourseId){
		return secondCourseOperation.get(secondCourseId);
	}

	public void delete(int secondCourseId){
		secondCourseOperation.delete(secondCourseId);
	}

    public List<SecondCourse> getAll(){
        return secondCourseOperation.getAll();
    }
	
}
