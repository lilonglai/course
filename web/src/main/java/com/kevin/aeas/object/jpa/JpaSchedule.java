package com.kevin.aeas.object.jpa;

import javax.persistence.*;

import com.kevin.aeas.object.Schedule;

import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_schedule")
public class JpaSchedule extends Schedule{

    @Basic
    @Column(name = "ondate")
    public Date getOnDate() {
        return onDate;
    }

    @Basic
    @Column(name = "ontime")
    public int getOnTime() {
        return onTime;
    }

    @Basic
    @Column(name = "addition")
    public String getAddition() {
        return addition;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
       
    @Basic
    @Column(name = "teacherId")
    public int getTeacherId() {
        return teacherId;
    }
    
    @Basic
    @Column(name = "studentId")
	public int getStudentId() {
		return studentId;
	}
    
    @Basic
    @Column(name = "courseId")
	public int getCourseId() {
		return courseId;
	}


}
