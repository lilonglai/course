package com.kevin.aeas.object.oracle;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kevin.aeas.object.FirstCourse;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_firstcourse")
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
