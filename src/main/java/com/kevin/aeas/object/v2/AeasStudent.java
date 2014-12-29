package com.kevin.aeas.object.v2;

import javax.persistence.*;

import java.sql.Date;
import java.util.Collection;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_student")
public class AeasStudent {
    private int id;
    private String name;
    private String shortName;
    private Integer grade;
    private String testScore;
    private String targetScore;
    private Date examineDate;
    private String examinePlace;
    private Integer teacherId;
    private String description;
    private Boolean isAlive;
    private Collection<AeasSchedule> aeasSchedules;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_student_id")
    @SequenceGenerator(name="aeas_student_id", sequenceName="aeas_student_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "testscore")
    public String getTestScore() {
        return testScore;
    }

    public void setTestScore(String testScore) {
        this.testScore = testScore;
    }

    @Basic
    @Column(name = "targetscore")
    public String getTargetScore() {
        return targetScore;
    }

    public void setTargetScore(String targetScore) {
        this.targetScore = targetScore;
    }

    @Basic
    @Column(name = "examinedate")
    public Date getExamineDate() {
        return examineDate;
    }

    public void setExamineDate(Date examineDate) {
        this.examineDate = examineDate;
    }

    @Basic
    @Column(name = "examineplace")
    public String getExaminePlace() {
        return examinePlace;
    }

    public void setExaminePlace(String examinePlace) {
        this.examinePlace = examinePlace;
    }

    @Basic
    @Column(name = "teacherid")
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

        AeasStudent that = (AeasStudent) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (examineDate != null ? !examineDate.equals(that.examineDate) : that.examineDate != null) return false;
        if (examinePlace != null ? !examinePlace.equals(that.examinePlace) : that.examinePlace != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (isAlive != null ? !isAlive.equals(that.isAlive) : that.isAlive != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (targetScore != null ? !targetScore.equals(that.targetScore) : that.targetScore != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (testScore != null ? !testScore.equals(that.testScore) : that.testScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (testScore != null ? testScore.hashCode() : 0);
        result = 31 * result + (targetScore != null ? targetScore.hashCode() : 0);
        result = 31 * result + (examineDate != null ? examineDate.hashCode() : 0);
        result = 31 * result + (examinePlace != null ? examinePlace.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isAlive != null ? isAlive.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "aeasStudent", cascade=CascadeType.REMOVE)
    public Collection<AeasSchedule> getAeasSchedules() {
        return aeasSchedules;
    }

    public void setAeasSchedules(Collection<AeasSchedule> aeasSchedules) {
        this.aeasSchedules = aeasSchedules;
    }
}
