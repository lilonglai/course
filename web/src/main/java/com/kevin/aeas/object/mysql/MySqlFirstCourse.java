package com.kevin.aeas.object.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kevin.aeas.object.jpa.JpaFirstCourse;

/**
 * Created by loli on 2014/11/30.
 */

@Entity
@Table(name = "aeas_firstcourse")
public class MySqlFirstCourse extends JpaFirstCourse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }

}
