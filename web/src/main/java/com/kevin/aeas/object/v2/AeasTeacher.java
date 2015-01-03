package com.kevin.aeas.object.v2;

import javax.persistence.*;

import java.util.Collection;

/**
 * Created by loli on 2014/11/30.
 */
@Entity
@Table(name = "aeas_teacher")
public class AeasTeacher {
    private int id;
    private String name;
    private String shortName;
    private String phone;
    private Boolean isMaster;
    private Boolean isAlive;
    private Collection<AeasSchedule> aeasSchedules;
    private Collection<AeasTeacherAbility> aeasTeacherAbilities;
    private AeasTeacherDefaultHoliday aeasTeacherDefaultHoliday;
    private Collection<AeasTeacherHoliday> aeasTeacherHolidays;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aeas_teacher_id")
    @SequenceGenerator(name="aeas_teacher_id", sequenceName="aeas_teacher_id")
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "ismaster")
    public Boolean getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(Boolean isMaster) {
        this.isMaster = isMaster;
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

        AeasTeacher that = (AeasTeacher) o;

        if (id != that.id) return false;
        if (isAlive != null ? !isAlive.equals(that.isAlive) : that.isAlive != null) return false;
        if (isMaster != null ? !isMaster.equals(that.isMaster) : that.isMaster != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (isMaster != null ? isMaster.hashCode() : 0);
        result = 31 * result + (isAlive != null ? isAlive.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "aeasTeacher")
    public Collection<AeasSchedule> getAeasSchedules() {
        return aeasSchedules;
    }

    public void setAeasSchedules(Collection<AeasSchedule> aeasSchedules) {
        this.aeasSchedules = aeasSchedules;
    }

    @OneToMany(mappedBy = "aeasTeacher")
    public Collection<AeasTeacherAbility> getAeasTeacherAbilities() {
        return aeasTeacherAbilities;
    }

    public void setAeasTeacherAbilities(Collection<AeasTeacherAbility> aeasTeacherAbilities) {
        this.aeasTeacherAbilities = aeasTeacherAbilities;
    }

    @OneToOne(mappedBy = "aeasTeacher", cascade=CascadeType.ALL)
    public AeasTeacherDefaultHoliday getAeasTeacherDefaultHoliday() {
        return aeasTeacherDefaultHoliday;
    }

    public void setAeasTeacherDefaultHoliday(AeasTeacherDefaultHoliday aeasTeacherDefaultHoliday) {
        this.aeasTeacherDefaultHoliday = aeasTeacherDefaultHoliday;
    }

    @OneToMany(mappedBy = "aeasTeacher")
    public Collection<AeasTeacherHoliday> getAeasTeacherHolidays() {
        return aeasTeacherHolidays;
    }

    public void setAeasTeacherHolidays(Collection<AeasTeacherHoliday> aeasTeacherHolidays) {
        this.aeasTeacherHolidays = aeasTeacherHolidays;
    }
}
