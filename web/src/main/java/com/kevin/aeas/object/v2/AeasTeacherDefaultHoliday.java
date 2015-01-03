package com.kevin.aeas.object.v2;

import javax.persistence.*;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherdefaultholiday")
public class AeasTeacherDefaultHoliday {
    private int id;
    private Boolean weak1;
    private Boolean weak2;
    private Boolean weak3;
    private Boolean weak4;
    private Boolean weak5;
    private Boolean weak6;
    private Boolean weak7;
    private AeasTeacher aeasTeacher;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherdefaultholiday_id")
    @SequenceGenerator(name="aeas_teacherdefaultholiday_id", sequenceName="aeas_teacherdefaultholiday_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "weak1")
    public Boolean getWeak1() {
        return weak1;
    }

    public void setWeak1(Boolean weak1) {
        this.weak1 = weak1;
    }

    @Basic
    @Column(name = "weak2")
    public Boolean getWeak2() {
        return weak2;
    }

    public void setWeak2(Boolean weak2) {
        this.weak2 = weak2;
    }

    @Basic
    @Column(name = "weak3")
    public Boolean getWeak3() {
        return weak3;
    }

    public void setWeak3(Boolean weak3) {
        this.weak3 = weak3;
    }

    @Basic
    @Column(name = "weak4")
    public Boolean getWeak4() {
        return weak4;
    }

    public void setWeak4(Boolean weak4) {
        this.weak4 = weak4;
    }

    @Basic
    @Column(name = "weak5")
    public Boolean getWeak5() {
        return weak5;
    }

    public void setWeak5(Boolean weak5) {
        this.weak5 = weak5;
    }

    @Basic
    @Column(name = "weak6")
    public Boolean getWeak6() {
        return weak6;
    }

    public void setWeak6(Boolean weak6) {
        this.weak6 = weak6;
    }

    @Basic
    @Column(name = "weak7")
    public Boolean getWeak7() {
        return weak7;
    }

    public void setWeak7(Boolean weak7) {
        this.weak7 = weak7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AeasTeacherDefaultHoliday that = (AeasTeacherDefaultHoliday) o;

        if (id != that.id) return false;
        if (weak1 != null ? !weak1.equals(that.weak1) : that.weak1 != null) return false;
        if (weak2 != null ? !weak2.equals(that.weak2) : that.weak2 != null) return false;
        if (weak3 != null ? !weak3.equals(that.weak3) : that.weak3 != null) return false;
        if (weak4 != null ? !weak4.equals(that.weak4) : that.weak4 != null) return false;
        if (weak5 != null ? !weak5.equals(that.weak5) : that.weak5 != null) return false;
        if (weak6 != null ? !weak6.equals(that.weak6) : that.weak6 != null) return false;
        if (weak7 != null ? !weak7.equals(that.weak7) : that.weak7 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (weak1 != null ? weak1.hashCode() : 0);
        result = 31 * result + (weak2 != null ? weak2.hashCode() : 0);
        result = 31 * result + (weak3 != null ? weak3.hashCode() : 0);
        result = 31 * result + (weak4 != null ? weak4.hashCode() : 0);
        result = 31 * result + (weak5 != null ? weak5.hashCode() : 0);
        result = 31 * result + (weak6 != null ? weak6.hashCode() : 0);
        result = 31 * result + (weak7 != null ? weak7.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "teacherid", referencedColumnName = "id")
    public AeasTeacher getAeasTeacher() {
        return aeasTeacher;
    }

    public void setAeasTeacher(AeasTeacher aeasTeacher) {
        this.aeasTeacher = aeasTeacher;
    }
}
