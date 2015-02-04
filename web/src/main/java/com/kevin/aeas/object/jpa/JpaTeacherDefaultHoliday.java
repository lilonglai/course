package com.kevin.aeas.object.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.kevin.aeas.object.TeacherDefaultHoliday;

/**
 * Created by loli on 2014/11/30.
 */

public class JpaTeacherDefaultHoliday extends TeacherDefaultHoliday{
    
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
