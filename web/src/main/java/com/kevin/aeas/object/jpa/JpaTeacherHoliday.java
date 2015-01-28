package com.kevin.aeas.object.jpa;

import javax.persistence.*;

import com.kevin.aeas.object.TeacherHoliday;

import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherholiday")
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
