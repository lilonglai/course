package com.kevin.aeas.object.oracle;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.kevin.aeas.object.jpa.JpaSchedule;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleSchedule extends JpaSchedule{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_schedule_id")
    @SequenceGenerator(name="aeas_schedule_id", sequenceName="aeas_schedule_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
