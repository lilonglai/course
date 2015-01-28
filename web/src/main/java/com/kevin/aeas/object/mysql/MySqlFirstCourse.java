package com.kevin.aeas.object.mysql;

import javax.persistence.*;

import com.kevin.aeas.object.jpa.JpaFirstCourse;

/**
 * Created by loli on 2014/11/30.
 */

public class MySqlFirstCourse extends JpaFirstCourse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }

}
