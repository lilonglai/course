package com.kevin.aeas.object.jpa;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.kevin.aeas.object.TeacherHoliday;

/**
 * Created by loli on 2014/11/30.
 */

public class JpaTeacherHoliday extends TeacherHoliday {

    @Basic
    @Column(name = "adjustdate")
    public Date getAdjustDate() {
        return adjustDate;
    }

    @Basic
    @Column(name = "isholiday")
    public Boolean getIsHoliday() {
        return isHoliday;
    }

    @Basic
    @Column(name = "teacherId")
	public int getTeacherId() {
		return teacherId;
	}
    
}
