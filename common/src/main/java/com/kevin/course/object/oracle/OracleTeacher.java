package com.kevin.course.object.oracle;

import com.kevin.course.object.Teacher;
import com.kevin.course.utils.TableName;

import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = TableName.TEACHER)
public class OracleTeacher extends Teacher{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacher_id")
    @SequenceGenerator(name="aeas_teacher_id", sequenceName="aeas_teacher_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

	@Basic
	@Column(name = "name")
	public String getName() {
	    return name;
	}

	@Basic
	@Column(name = "shortname")
	public String getShortName() {
	    return shortName;
	}

	@Basic
	@Column(name = "phone")
	public String getPhone() {
	    return phone;
	}

	@Basic
	@Column(name = "ismaster")
	public Boolean getIsMaster() {
	    return isMaster;
	}

	@Basic
	@Column(name = "isalive")
	public Boolean getIsAlive() {
	    return isAlive;
	}
}
