package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.TeacherAbility;
import com.kevin.course.utils.TableName;

/**
 * Created by loli on 2014/11/30.
 */
@Entity(name = TableName.TEACHERABILITY)
public class EngineTeacherAbility extends TeacherAbility {
    public int getId() {
        return id;
    }

	public int getTeacherId() {
		return teacherId;
	}

	public int getCourseId() {
		return courseId;
	}

}
