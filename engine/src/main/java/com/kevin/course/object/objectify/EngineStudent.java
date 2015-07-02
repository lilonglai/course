package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.Student;
import com.kevin.course.utils.TableName;

import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity(name = TableName.STUDENT)
public class EngineStudent extends Student{
    public int getId() {
        return id;
    }

	public String getName() {
	    return name;
	}

	public String getShortName() {
	    return shortName;
	}

	public int getGrade() {
	    return grade;
	}

	public String getTestScore() {
	    return testScore;
	}

	public String getTargetScore() {
	    return targetScore;
	}

	public Date getExamineDate() {
	    return examineDate;
	}

	public String getExaminePlace() {
	    return examinePlace;
	}

	public int getTeacherId() {
	    return teacherId;
	}

	public String getDescription() {
	    return description;
	}

	public Boolean getIsAlive() {
	    return isAlive;
	}

}
