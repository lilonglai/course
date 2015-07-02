package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.TeacherHoliday;
import com.kevin.course.utils.TableName;

import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity(name = TableName.TEACHERHOLIDAY)
public class EngineTeacherHoliday extends TeacherHoliday {
    public int getId() {
        return id;
    }

	public Date getAdjustDate() {
	    return adjustDate;
	}

	public Boolean getIsHoliday() {
	    return isHoliday;
	}

	public int getTeacherId() {
		return teacherId;
	}
    
}
