package com.kevin.course.object.oracle;

import com.kevin.course.object.FirstCourse;
import com.kevin.course.utils.TableName;

import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = TableName.FIRSTCOURSE)
public class OracleFirstCourse extends FirstCourse {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_firstcourse_id")
    @SequenceGenerator(name="aeas_firstcourse_id", sequenceName="aeas_firstcourse_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

	@Basic
	@Column(name = "grade")
	public int getGrade() {
	    return grade;
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
	@Column(name = "description")
	public String getDescription() {
	    return description;
	}

	@Basic
	@Column(name = "isalive")
	public Boolean getIsAlive() {
	    return isAlive;
	}
}
