package com.kevin.aeas.object.mysql;

import javax.persistence.*;

import com.kevin.aeas.object.jpa.JpaSchedule;

/**
 * Created by loli on 2014/11/30.
 */
public class MySqlSchedule extends JpaSchedule{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
