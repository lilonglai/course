package com.kevin.aeas.object.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.kevin.aeas.object.FirstCourse;

/**
 * Created by loli on 2014/11/30.
 */

public class JpaFirstCourse extends FirstCourse{

    @Basic
    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }

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

}
