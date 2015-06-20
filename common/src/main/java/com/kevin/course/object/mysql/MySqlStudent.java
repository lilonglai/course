package com.kevin.course.object.mysql;

import com.kevin.course.object.Student;
import com.kevin.course.utils.TableName;

import java.sql.Date;
import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = TableName.STUDENT)
public class MySqlStudent extends Student{

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
	@Column(name = "grade")
	public int getGrade() {
	    return grade;
	}

	@Basic
	@Column(name = "testscore")
	public String getTestScore() {
	    return testScore;
	}

	@Basic
	@Column(name = "targetscore")
	public String getTargetScore() {
	    return targetScore;
	}

	@Basic
	@Column(name = "examinedate")
	public Date getExamineDate() {
	    return examineDate;
	}

	@Basic
	@Column(name = "examineplace")
	public String getExaminePlace() {
	    return examinePlace;
	}

	@Basic
	@Column(name = "teacherid")
	public int getTeacherId() {
	    return teacherId;
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
