package com.kevin.aeas.object.oracle;

import javax.persistence.*;
import com.kevin.aeas.object.jpa.JpaStudent;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_student")
public class OracleStudent extends JpaStudent{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_student_id")
    @SequenceGenerator(name="aeas_student_id", sequenceName="aeas_student_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
