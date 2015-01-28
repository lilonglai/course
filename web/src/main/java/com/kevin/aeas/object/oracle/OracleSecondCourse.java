package com.kevin.aeas.object.oracle;

import javax.persistence.*;
import com.kevin.aeas.object.jpa.JpaSecondCourse;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleSecondCourse extends JpaSecondCourse{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_secondcourse_id")
    @SequenceGenerator(name="aeas_secondcourse_id", sequenceName="aeas_secondcourse_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

}
