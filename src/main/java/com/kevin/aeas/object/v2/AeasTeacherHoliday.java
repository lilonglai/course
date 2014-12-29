package com.kevin.aeas.object.v2;

import javax.persistence.*;

import java.sql.Date;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacherholiday")
public class AeasTeacherHoliday {
    private int id;
    private Date adjustDate;
    private Boolean isHoliday;
    private AeasTeacher aeasTeacher;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacherholiday_id")
    @SequenceGenerator(name="aeas_teacherholiday_id", sequenceName="aeas_teacherholiday_id")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "adjustdate")
    public Date getAdjustDate() {
        return adjustDate;
    }

    public void setAdjustDate(Date adjustDate) {
        this.adjustDate = adjustDate;
    }

    @Basic
    @Column(name = "isholiday")
    public Boolean getIsHoliday() {
        return isHoliday;
    }

    public void setIsHoliday(Boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AeasTeacherHoliday that = (AeasTeacherHoliday) o;

        if (id != that.id) return false;
        if (adjustDate != null ? !adjustDate.equals(that.adjustDate) : that.adjustDate != null) return false;
        if (isHoliday != null ? !isHoliday.equals(that.isHoliday) : that.isHoliday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (adjustDate != null ? adjustDate.hashCode() : 0);
        result = 31 * result + (isHoliday != null ? isHoliday.hashCode() : 0);
        return result;
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
