package com.kevin.aeas.object.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kevin.aeas.object.jpa.JpaSchedule;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_schedule")
public class MySqlSchedule extends JpaSchedule{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
