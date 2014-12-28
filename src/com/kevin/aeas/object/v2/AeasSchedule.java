package com.kevin.aeas.object.v2;

import javax.persistence.*;

import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_schedule")
public class AeasSchedule {
    private int id;
    private Date onDate;
    private Integer onTime;
    private String addition;
    private String description;
    private AeasSecondCourse aeasSecondCourse;
    private AeasTeacher aeasTeacher;
    private AeasStudent aeasStudent;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_schedule_id")
    @SequenceGenerator(name="aeas_schedule_id", sequenceName="aeas_schedule_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ondate")
    public Date getOnDate() {
        return onDate;
    }

    public void setOnDate(Date onDate) {
        this.onDate = onDate;
    }

    @Basic
    @Column(name = "ontime")
    public Integer getOnTime() {
        return onTime;
    }

    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    @Basic
    @Column(name = "addition")
    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AeasSchedule that = (AeasSchedule) o;

        if (id != that.id) return false;
        if (addition != null ? !addition.equals(that.addition) : that.addition != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (onDate != null ? !onDate.equals(that.onDate) : that.onDate != null) return false;
        if (onTime != null ? !onTime.equals(that.onTime) : that.onTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (onDate != null ? onDate.hashCode() : 0);
        result = 31 * result + (onTime != null ? onTime.hashCode() : 0);
        result = 31 * result + (addition != null ? addition.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "courseid", referencedColumnName = "id")
    public AeasSecondCourse getAeasSecondCourse() {
        return aeasSecondCourse;
    }

    public void setAeasSecondCourse(AeasSecondCourse aeasSecondCourse) {
        this.aeasSecondCourse = aeasSecondCourse;
    }

    @ManyToOne
    @JoinColumn(name = "teacherid", referencedColumnName = "id")
    public AeasTeacher getAeasTeacher() {
        return aeasTeacher;
    }

    public void setAeasTeacher(AeasTeacher aeasTeacher) {
        this.aeasTeacher = aeasTeacher;
    }

    @ManyToOne
    @JoinColumn(name = "studentid", referencedColumnName = "id")
    public AeasStudent getAeasStudent() {
        return aeasStudent;
    }

    public void setAeasStudent(AeasStudent aeasStudent) {
        this.aeasStudent = aeasStudent;
    }
}
