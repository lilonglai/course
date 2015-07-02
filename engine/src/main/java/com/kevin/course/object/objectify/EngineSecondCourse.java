package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.SecondCourse;
import com.kevin.course.utils.TableName;

/**
 * Created by loli on 2014/11/30.
 */
@Entity(name = TableName.SECONDCOURSE)
public class EngineSecondCourse extends SecondCourse {
    public int getId() {
        return id;
    }

	public String getName() {
	    return name;
	}

	public String getShortName() {
	    return shortName;
	}

	public String getDescription() {
	    return description;
	}

	public Boolean getIsAlive() {
	    return isAlive;
	}

	public int getFirstCourseId() {
		return firstCourseId;
	}

}
