package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.FirstCourse;
import com.kevin.course.utils.TableName;

/**
 * Created by loli on 2014/11/30.
 */

@Entity(name = TableName.FIRSTCOURSE)
public class EngineFirstCourse extends FirstCourse {
    public int getId() {
        return id;
    }

	public int getGrade() {
	    return grade;
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

}
