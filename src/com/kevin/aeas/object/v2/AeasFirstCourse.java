package com.kevin.aeas.object.v2;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_firstcourse")
public class AeasFirstCourse {
    private int id;
    private Integer grade;
    private String name;
    private String shortName;
    private String description;
    private Boolean isAlive;
    private Collection<AeasSecondCourse> aeasSecondCourses;
    private Collection<AeasTeacherAbility> aeasTeacherAbilities;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_firstcourse_id")
    @SequenceGenerator(name="aeas_firstcourse_id", sequenceName="aeas_firstcourse_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "shortname")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isalive")
    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AeasFirstCourse that = (AeasFirstCourse) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (isAlive != null ? !isAlive.equals(that.isAlive) : that.isAlive != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isAlive != null ? isAlive.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "aeasFirstCourse")
    public Collection<AeasSecondCourse> getAeasSecondCourses() {
        return aeasSecondCourses;
    }

    public void setAeasSecondCourses(Collection<AeasSecondCourse> aeasSecondCourses) {
        this.aeasSecondCourses = aeasSecondCourses;
    }
    
    @OneToMany(mappedBy = "aeasFirstCourse")
    public Collection<AeasTeacherAbility> getAeasTeacherAbilities() {
        return aeasTeacherAbilities;
    }

    public void setAeasTeacherAbilities(Collection<AeasTeacherAbility> aeasTeacherAbilities) {
        this.aeasTeacherAbilities = aeasTeacherAbilities;
    }
}
