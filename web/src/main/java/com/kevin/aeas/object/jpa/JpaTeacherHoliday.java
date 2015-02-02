package com.kevin.aeas.object.jpa;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kevin.aeas.object.TeacherHoliday;

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
