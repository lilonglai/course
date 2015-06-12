package com.kevin.aeas.object;

public class TeacherAbility {
	protected int id;
	protected int teacherId;
	protected int courseId;

	public TeacherAbility() {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + id;
		result = prime * result + teacherId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherAbility other = (TeacherAbility) obj;
		if (courseId != other.courseId)
			return false;
		if (id != other.id)
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}
	
	

}
