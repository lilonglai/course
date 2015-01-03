package com.kevin.aeas.object;

import java.sql.Date;

public class Schedule {
	private int id;
	private Date onDate;
	private int onTime;
	private int studentId;
	private int courseId;
	private int teacherId;
	private String addition;
	private String description;

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

}
