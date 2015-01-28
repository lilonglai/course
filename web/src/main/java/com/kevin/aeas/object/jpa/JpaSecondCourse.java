package com.kevin.aeas.object.jpa;

import javax.persistence.*;

import com.kevin.aeas.object.SecondCourse;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_secondcourse")
public class JpaSecondCourse extends SecondCourse{

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "shortname")
    public String getShortName() {
        return shortName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Basic
    @Column(name = "isalive")
    public Boolean getIsAlive() {
        return isAlive;
    }
    
    @Basic
    @Column(name = "firstCourseId")
	public int getFirstCourseId() {
		return firstCourseId;
	}

}
