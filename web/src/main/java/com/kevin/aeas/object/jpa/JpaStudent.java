package com.kevin.aeas.object.jpa;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kevin.aeas.object.Student;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_student")
public class JpaStudent extends Student{

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
    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }

    @Basic
    @Column(name = "testscore")
    public String getTestScore() {
        return testScore;
    }

    @Basic
    @Column(name = "targetscore")
    public String getTargetScore() {
        return targetScore;
    }

    @Basic
    @Column(name = "examinedate")
    public Date getExamineDate() {
        return examineDate;
    }

    @Basic
    @Column(name = "examineplace")
    public String getExaminePlace() {
        return examinePlace;
    }

    @Basic
    @Column(name = "teacherid")
    public int getTeacherId() {
        return teacherId;
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
