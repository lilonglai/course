package com.kevin.aeas.object.mysql;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kevin.aeas.object.SecondCourse;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_secondcourse")
public class MySqlSecondCourse extends SecondCourse{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
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
	@Column(name = "description")
	public String getDescription() {
	    return description;
	}

	@Basic
	@Column(name = "isalive")
	public Boolean getIsAlive() {
	    return isAlive;
	}

	@Basic
	@Column(name = "firstCourseId")
	public int getFirstCourseId() {
		return firstCourseId;
	}

}
