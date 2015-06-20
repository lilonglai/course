package com.kevin.course.object.oracle;

import com.kevin.course.object.TeacherDefaultHoliday;
import com.kevin.course.utils.TableName;

import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = TableName.TEACHERDEFAULTHOLIDAY)
public class OracleTeacherDefaultHoliday extends TeacherDefaultHoliday{	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherdefaultholiday_id")
    @SequenceGenerator(name="aeas_teacherdefaultholiday_id", sequenceName="aeas_teacherdefaultholiday_id")
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
