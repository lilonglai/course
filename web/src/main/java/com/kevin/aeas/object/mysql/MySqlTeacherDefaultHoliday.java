package com.kevin.aeas.object.mysql;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kevin.aeas.object.jpa.JpaTeacherDefaultHoliday;

/**
 * Created by loli on 2014/11/30.
 */
public class MySqlTeacherDefaultHoliday extends JpaTeacherDefaultHoliday{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }

}
