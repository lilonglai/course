package com.kevin.course.object.oracle;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.utils.TableName;

import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = TableName.TEACHERABILITY)
public class OracleTeacherAbility extends TeacherAbility {
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
