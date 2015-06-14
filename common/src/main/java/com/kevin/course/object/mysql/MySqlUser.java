package com.kevin.course.object.mysql;

import com.kevin.course.object.User;
import javax.persistence.*;
/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_user")
public class MySqlUser extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
