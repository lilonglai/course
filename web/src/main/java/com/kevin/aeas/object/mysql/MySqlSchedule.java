package com.kevin.aeas.object.mysql;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kevin.aeas.object.Schedule;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_schedule")
public class MySqlSchedule extends Schedule{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }

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
