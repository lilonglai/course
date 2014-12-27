package com.kevin.aeas.object.v2;

import javax.persistence.*;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherability")
public class AeasTeacherAbility {
    private int id;
    private AeasFirstCourse aeasFirstCourse;
    private AeasTeacher aeasTeacher;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AeasTeacherAbility that = (AeasTeacherAbility) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "courseid", referencedColumnName = "id")
    public AeasFirstCourse getAeasFirstCourse() {
        return aeasFirstCourse;
    }

    public void setAeasFirstCourse(AeasFirstCourse aeasFirstCourse) {
        this.aeasFirstCourse = aeasFirstCourse;
    }

    @ManyToOne
    @JoinColumn(name = "teacherid", referencedColumnName = "id")
    public AeasTeacher getAeasTeacher() {
        return aeasTeacher;
    }

    public void setAeasTeacher(AeasTeacher aeasTeacher) {
        this.aeasTeacher = aeasTeacher;
    }
}
