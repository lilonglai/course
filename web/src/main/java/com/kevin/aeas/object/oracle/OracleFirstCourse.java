package com.kevin.aeas.object.oracle;

import javax.persistence.*;

import com.kevin.aeas.object.jpa.JpaFirstCourse;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleFirstCourse extends JpaFirstCourse {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_firstcourse_id")
    @SequenceGenerator(name="aeas_firstcourse_id", sequenceName="aeas_firstcourse_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
