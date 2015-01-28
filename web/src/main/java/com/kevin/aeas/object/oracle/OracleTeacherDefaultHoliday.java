package com.kevin.aeas.object.oracle;

import javax.persistence.*;

import com.kevin.aeas.object.jpa.JpaTeacherDefaultHoliday;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleTeacherDefaultHoliday extends JpaTeacherDefaultHoliday{	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherdefaultholiday_id")
    @SequenceGenerator(name="aeas_teacherdefaultholiday_id", sequenceName="aeas_teacherdefaultholiday_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
