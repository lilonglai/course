package com.kevin.aeas.object;

public class TeacherAbility {
	private int id;
	private int teacherId;
	private int courseId;

	public TeacherAbility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherAbility(int id, int teacherId, int courseId) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.courseId = courseId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "TeacherAbility [id=" + id + ", teacherId=" + teacherId
				+ ", courseId=" + courseId + "]";
	}

}
