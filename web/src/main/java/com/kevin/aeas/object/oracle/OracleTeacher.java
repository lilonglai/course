package com.kevin.aeas.object.oracle;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.kevin.aeas.object.jpa.JpaTeacher;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleTeacher extends JpaTeacher{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacher_id")
    @SequenceGenerator(name="aeas_teacher_id", sequenceName="aeas_teacher_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
