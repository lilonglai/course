package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.utils.TableName;

/**
 * Created by loli on 2014/11/30.
 */
@Entity(name = TableName.TEACHERDEFAULTHOLIDAY)
public class EngineTeacherDefaultHoliday extends TeacherDefaultHoliday{
    public int getId() {
        return id;
    }

	public int getTeacherId() {
		return teacherId;
	}

	public Boolean getWeek1() {
	    return week1;
	}

	public Boolean getWeek2() {
	    return week2;
	}

	public Boolean getWeek3() {
	    return week3;
	}

	public Boolean getWeek4() {
	    return week4;
	}

	public Boolean getWeek5() {
	    return week5;
	}

	public Boolean getWeek6() {
	    return week6;
	}

	public Boolean getWeek7() {
	    return week7;
	}

}
