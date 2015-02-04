package com.kevin.aeas.object.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;

import com.kevin.aeas.object.User;

/**
 * Created by loli on 2014/11/30.
 */

public class JpaUser extends User{

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

}
