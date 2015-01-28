package com.kevin.aeas.object;

import java.sql.Date;

public class Schedule {	
    protected int id;
    protected Date onDate;
    protected int onTime;
    protected String addition;
    protected String description;
    
    protected int studentId;
    protected int courseId;
    protected int teacherId;

	public Schedule() {
		super();
	}

	public Schedule(int id, Date onDate, int onTime, int studentId,
			int courseId, int teacherId, String addition, String description) {
		super();
		this.id = id;
		this.onDate = onDate;
		this.onTime = onTime;
		this.studentId = studentId;
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.addition = addition;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOnDate() {
		return onDate;
	}

	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}

	public int getOnTime() {
		return onTime;
	}

	public void setOnTime(int onTime) {
		this.onTime = onTime;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", onDate=" + onDate + ", onTime="
				+ onTime + ", studentId=" + studentId + ", courseId="
				+ courseId + ", teacherId=" + teacherId + ", addition="
				+ addition + ", description=" + description + "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule that = (Schedule) o;

        if (id != that.id) return false;
        if (addition != null ? !addition.equals(that.addition) : that.addition != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (onDate != null ? !onDate.equals(that.onDate) : that.onDate != null) return false;
        if (onTime != that.onTime) return false;
        if(studentId != that.studentId) return false;
        if(courseId != that.courseId) return false;
        if(teacherId != that.teacherId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (onDate != null ? onDate.hashCode() : 0);
        result = 31 * result + onTime;
        result = 31 * result + (addition != null ? addition.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + studentId;
        result = 31 * result + courseId;
        result = 31 * result + teacherId;
        return result;
    }

}
