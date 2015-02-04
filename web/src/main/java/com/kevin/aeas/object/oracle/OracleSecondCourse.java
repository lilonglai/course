package com.kevin.aeas.object.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kevin.aeas.object.jpa.JpaSecondCourse;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_secondcourse")
public class OracleSecondCourse extends JpaSecondCourse{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_secondcourse_id")
    @SequenceGenerator(name="aeas_secondcourse_id", sequenceName="aeas_secondcourse_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

}
