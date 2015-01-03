package com.kevin.aeas.object;

import java.sql.Date;

public class TeacherHoliday {
	private int id;
	private int teacherId;
	private Date adjustDate;
	private boolean isHoliday;

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

	public boolean isHoliday() {
		return isHoliday;
	}

	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	@Override
	public String toString() {
		return "TeacherHoliday [id=" + id + ", teacherId=" + teacherId
				+ ", adjustDate=" + adjustDate + ", isHoliday=" + isHoliday
				+ "]";
	}

}
