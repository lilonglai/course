package com.kevin.course.object;

import java.sql.Date;

public class TeacherHoliday {
	protected int id;
	protected int teacherId;
	protected Date adjustDate;
	protected Boolean isHoliday;

	public TeacherHoliday() {
		super();
	}

	public TeacherHoliday(int id, int teacherId, Date adjustDate,
			boolean isHoliday) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.adjustDate = adjustDate;
		this.isHoliday = isHoliday;
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

	public Date getAdjustDate() {
		return adjustDate;
	}

	public void setAdjustDate(Date adjustDate) {
		this.adjustDate = adjustDate;
	}


	public Boolean getIsHoliday() {
		return isHoliday;
	}

	public void setIsHoliday(Boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	@Override
	public String toString() {
		return "TeacherHoliday [id=" + id + ", teacherId=" + teacherId
				+ ", adjustDate=" + adjustDate + ", isHoliday=" + isHoliday
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adjustDate == null) ? 0 : adjustDate.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((isHoliday == null) ? 0 : isHoliday.hashCode());
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
		TeacherHoliday other = (TeacherHoliday) obj;
		if (adjustDate == null) {
			if (other.adjustDate != null)
				return false;
		} else if (!adjustDate.equals(other.adjustDate))
			return false;
		if (id != other.id)
			return false;
		if (isHoliday == null) {
			if (other.isHoliday != null)
				return false;
		} else if (!isHoliday.equals(other.isHoliday))
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}
	
	

}
