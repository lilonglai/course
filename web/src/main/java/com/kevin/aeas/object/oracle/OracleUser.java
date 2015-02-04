package com.kevin.aeas.object.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kevin.aeas.object.jpa.JpaUser;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_user")
public class OracleUser extends JpaUser{	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_user_id")
    @SequenceGenerator(name="aeas_user_id", sequenceName="aeas_user_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }
}
