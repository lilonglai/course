package com.kevin.aeas.object.mysql;

import com.kevin.aeas.object.TeacherHoliday;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherholiday")
public class MySqlTeacherHoliday extends TeacherHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

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
