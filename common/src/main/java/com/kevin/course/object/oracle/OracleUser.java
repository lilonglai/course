package com.kevin.course.object.oracle;

import com.kevin.course.object.User;
import com.kevin.course.utils.TableName;

import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = TableName.USER)
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
