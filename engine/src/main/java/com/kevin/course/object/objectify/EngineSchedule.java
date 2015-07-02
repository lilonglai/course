package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.Schedule;
import com.kevin.course.utils.TableName;

import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity(name = TableName.SCHEDULE)
public class EngineSchedule extends Schedule{
    public int getId() {
        return id;
    }

	public Date getOnDate() {
	    return onDate;
	}

	public int getOnTime() {
	    return onTime;
	}

	public String getAddition() {
	    return addition;
	}

	public String getDescription() {
	    return description;
	}

	public int getTeacherId() {
	    return teacherId;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return courseId;
	}
}
