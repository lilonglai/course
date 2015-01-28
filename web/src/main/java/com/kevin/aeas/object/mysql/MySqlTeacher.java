package com.kevin.aeas.object.mysql;

import javax.persistence.*;

import com.kevin.aeas.object.jpa.JpaTeacher;

/**
 * Created by loli on 2014/11/30.
 */
public class MySqlTeacher extends JpaTeacher{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }

}
