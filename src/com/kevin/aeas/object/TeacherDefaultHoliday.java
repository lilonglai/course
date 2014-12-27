package com.kevin.aeas.object;

public class TeacherDefaultHoliday {
	private int id;
	private int teacherId;
	private boolean week1;
	private boolean week2;
	private boolean week3;
	private boolean week4;
	private boolean week5;
	private boolean week6;
	private boolean week7;

	public TeacherDefaultHoliday() {
		super();
	}

	public TeacherDefaultHoliday(int id, int teacherId, boolean week1,
			boolean week2, boolean week3, boolean week4, boolean week5,
			boolean week6, boolean week7) {
		super();
		this.id = id;
		this.teacherId = teacherId;
		this.week1 = week1;
		this.week2 = week2;
		this.week3 = week3;
		this.week4 = week4;
		this.week5 = week5;
		this.week6 = week6;
		this.week7 = week7;
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

	public boolean isWeek1() {
		return week1;
	}

	public void setWeek1(boolean week1) {
		this.week1 = week1;
	}

	public boolean isWeek2() {
		return week2;
	}

	public void setWeek2(boolean week2) {
		this.week2 = week2;
	}

	public boolean isWeek3() {
		return week3;
	}

	public void setWeek3(boolean week3) {
		this.week3 = week3;
	}

	public boolean isWeek4() {
		return week4;
	}

	public void setWeek4(boolean week4) {
		this.week4 = week4;
	}

	public boolean isWeek5() {
		return week5;
	}

	public void setWeek5(boolean week5) {
		this.week5 = week5;
	}

	public boolean isWeek6() {
		return week6;
	}

	public void setWeek6(boolean week6) {
		this.week6 = week6;
	}

	public boolean isWeek7() {
		return week7;
	}

	public void setWeek7(boolean week7) {
		this.week7 = week7;
	}

	@Override
	public String toString() {
		return "TeacherDefaultHoliday [id=" + id + ", teacherId=" + teacherId
				+ ", week1=" + week1 + ", week2=" + week2 + ", week3=" + week3
				+ ", week4=" + week4 + ", week5=" + week5 + ", week6=" + week6
				+ ", week7=" + week7 + "]";
	}
	
	

}
