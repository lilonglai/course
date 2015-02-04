package com.kevin.aeas.object.oracle;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kevin.aeas.object.TeacherAbility;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherability")
public class OracleTeacherAbility extends TeacherAbility{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherability_id")
    @SequenceGenerator(name="aeas_teacherability_id", sequenceName="aeas_teacherability_id")
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
	@Column(name = "courseId")
	public int getCourseId() {
		return courseId;
	}
}
