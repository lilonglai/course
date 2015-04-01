package com.kevin.aeas.object.oracle;

import com.kevin.aeas.object.User;

import javax.persistence.*;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_user")
public class OracleUser extends User{	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_user_id")
    @SequenceGenerator(name="aeas_user_id", sequenceName="aeas_user_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

	@Basic
	@Column(name = "name")
	public String getName() {
	    return name;
	}

	@Basic
	@Column(name = "password")
	public String getPassword() {
	    return password;
	}

	@Basic
	@Column(name = "description")
	public String getDescription() {
	    return description;
	}
}
