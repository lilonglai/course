package com.kevin.aeas.object.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.kevin.aeas.object.Teacher;

/**
 * Created by loli on 2014/11/30.
 */

public class JpaTeacher extends Teacher{
	
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
