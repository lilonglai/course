package com.kevin.aeas.object.oracle;

import com.kevin.aeas.object.TeacherHoliday;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherholiday")
public class OracleTeacherHoliday extends TeacherHoliday{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherholiday_id")
    @SequenceGenerator(name="aeas_teacherholiday_id", sequenceName="aeas_teacherholiday_id")
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
