package com.kevin.aeas.object.jpa;

import javax.persistence.*;

import com.kevin.aeas.object.TeacherAbility;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherability")
public class JpaTeacherAbility extends TeacherAbility{
    
    @Basic
    @Column(name = "teacherId")
	public int getTeacherId() {
		return teacherId;
	}

    @Basic
    @Column(name = "courseId")
	public int getCourseId() {
		return courseId;
	}

}
