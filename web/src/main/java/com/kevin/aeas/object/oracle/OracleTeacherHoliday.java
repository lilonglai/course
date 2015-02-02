package com.kevin.aeas.object.oracle;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.kevin.aeas.object.jpa.JpaTeacherHoliday;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleTeacherHoliday extends JpaTeacherHoliday{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherholiday_id")
    @SequenceGenerator(name="aeas_teacherholiday_id", sequenceName="aeas_teacherholiday_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
