package com.kevin.course.object.mysql;

import com.kevin.course.object.Teacher;
import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "teacher")
public class MySqlTeacher extends Teacher{
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
