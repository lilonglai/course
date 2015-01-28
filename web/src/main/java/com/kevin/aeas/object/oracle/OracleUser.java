package com.kevin.aeas.object.oracle;

import javax.persistence.*;
import com.kevin.aeas.object.jpa.JpaUser;

/**
 * Created by loli on 2014/11/30.
 */
public class OracleUser extends JpaUser{	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_user_id")
    @SequenceGenerator(name="aeas_user_id", sequenceName="aeas_user_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
