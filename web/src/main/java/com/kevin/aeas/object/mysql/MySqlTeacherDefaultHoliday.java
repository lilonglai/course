package com.kevin.aeas.object.mysql;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kevin.aeas.object.TeacherDefaultHoliday;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherdefaultholiday")
public class MySqlTeacherDefaultHoliday extends TeacherDefaultHoliday{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }

	@Basic
	@Column(name = "teacherId")
	public int getTeacherId() {
		return teacherId;
	}

	@Basic
	@Column(name = "week1")
	public Boolean getWeek1() {
	    return week1;
	}

	@Basic
	@Column(name = "week2")
	public Boolean getWeek2() {
	    return week2;
	}

	@Basic
	@Column(name = "week3")
	public Boolean getWeek3() {
	    return week3;
	}

	@Basic
	@Column(name = "week4")
	public Boolean getWeek4() {
	    return week4;
	}

	@Basic
	@Column(name = "week5")
	public Boolean getWeek5() {
	    return week5;
	}

	@Basic
	@Column(name = "week6")
	public Boolean getWeek6() {
	    return week6;
	}

	@Basic
	@Column(name = "week7")
	public Boolean getWeek7() {
	    return week7;
	}

}
