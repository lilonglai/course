package com.kevin.aeas.object.mysql;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kevin.aeas.object.jpa.JpaTeacherHoliday;

/**
 * Created by loli on 2014/11/30.
 */
public class MySqlTeacherHoliday extends JpaTeacherHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    
}
