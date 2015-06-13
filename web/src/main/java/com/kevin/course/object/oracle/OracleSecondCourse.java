package com.kevin.course.object.oracle;

import com.kevin.course.object.SecondCourse;

import javax.persistence.*;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_secondcourse")
public class OracleSecondCourse extends SecondCourse {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_secondcourse_id")
    @SequenceGenerator(name="aeas_secondcourse_id", sequenceName="aeas_secondcourse_id")
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
