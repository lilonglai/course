package com.kevin.aeas.object.oracle;

import javax.persistence.*;

import com.kevin.aeas.object.jpa.JpaTeacherAbility;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleTeacherAbility extends JpaTeacherAbility{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherability_id")
    @SequenceGenerator(name="aeas_teacherability_id", sequenceName="aeas_teacherability_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
