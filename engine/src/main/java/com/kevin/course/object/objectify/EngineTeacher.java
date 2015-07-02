package com.kevin.course.object.objectify;

import com.googlecode.objectify.annotation.Entity;
import com.kevin.course.object.Teacher;
import com.kevin.course.utils.TableName;

/**
 * Created by loli on 2014/11/30.
 */
@Entity(name = TableName.TEACHER)
public class EngineTeacher extends Teacher{
    public int getId() {
        return id;
    }

	public String getName() {
	    return name;
	}

	public String getShortName() {
	    return shortName;
	}

	public String getPhone() {
	    return phone;
	}

	public Boolean getIsMaster() {
	    return isMaster;
	}

	public Boolean getIsAlive() {
	    return isAlive;
	}

}
