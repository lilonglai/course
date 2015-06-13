package com.kevin.course.object.mysql;

import com.kevin.course.object.FirstCourse;

import javax.persistence.*;

/**
 * Created by loli on 2014/11/30.
 */

@Entity
@Table(name = "aeas_firstcourse")
public class MySqlFirstCourse extends FirstCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
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
