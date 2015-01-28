package com.kevin.aeas.object;

public class TeacherDefaultHoliday {
	protected int id;
	protected int teacherId;
	protected Boolean week1;
	protected Boolean week2;
	protected Boolean week3;
	protected Boolean week4;
	protected Boolean week5;
	protected Boolean week6;
	protected Boolean week7;

	public TeacherDefaultHoliday() {
		super();
	}

	public TeacherDefaultHoliday(int id, int teacherId, Boolean week1,
			Boolean week2, Boolean week3, Boolean week4, Boolean week5,
			Boolean week6, Boolean week7) {
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

	
	public Boolean getWeek1() {
		return week1;
	}

	public void setWeek1(Boolean week1) {
		this.week1 = week1;
	}

	public Boolean getWeek2() {
		return week2;
	}

	public void setWeek2(Boolean week2) {
		this.week2 = week2;
	}

	public Boolean getWeek3() {
		return week3;
	}

	public void setWeek3(Boolean week3) {
		this.week3 = week3;
	}

	public Boolean getWeek4() {
		return week4;
	}

	public void setWeek4(Boolean week4) {
		this.week4 = week4;
	}

	public Boolean getWeek5() {
		return week5;
	}

	public void setWeek5(Boolean week5) {
		this.week5 = week5;
	}

	public Boolean getWeek6() {
		return week6;
	}

	public void setWeek6(Boolean week6) {
		this.week6 = week6;
	}

	public Boolean getWeek7() {
		return week7;
	}

	public void setWeek7(Boolean week7) {
		this.week7 = week7;
	}

	@Override
	public String toString() {
		return "TeacherDefaultHoliday [id=" + id + ", teacherId=" + teacherId
				+ ", week1=" + week1 + ", week2=" + week2 + ", week3=" + week3
				+ ", week4=" + week4 + ", week5=" + week5 + ", week6=" + week6
				+ ", week7=" + week7 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + teacherId;
		result = prime * result + ((week1 == null) ? 0 : week1.hashCode());
		result = prime * result + ((week2 == null) ? 0 : week2.hashCode());
		result = prime * result + ((week3 == null) ? 0 : week3.hashCode());
		result = prime * result + ((week4 == null) ? 0 : week4.hashCode());
		result = prime * result + ((week5 == null) ? 0 : week5.hashCode());
		result = prime * result + ((week6 == null) ? 0 : week6.hashCode());
		result = prime * result + ((week7 == null) ? 0 : week7.hashCode());
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
		TeacherDefaultHoliday other = (TeacherDefaultHoliday) obj;
		if (id != other.id)
			return false;
		if (teacherId != other.teacherId)
			return false;
		if (week1 == null) {
			if (other.week1 != null)
				return false;
		} else if (!week1.equals(other.week1))
			return false;
		if (week2 == null) {
			if (other.week2 != null)
				return false;
		} else if (!week2.equals(other.week2))
			return false;
		if (week3 == null) {
			if (other.week3 != null)
				return false;
		} else if (!week3.equals(other.week3))
			return false;
		if (week4 == null) {
			if (other.week4 != null)
				return false;
		} else if (!week4.equals(other.week4))
			return false;
		if (week5 == null) {
			if (other.week5 != null)
				return false;
		} else if (!week5.equals(other.week5))
			return false;
		if (week6 == null) {
			if (other.week6 != null)
				return false;
		} else if (!week6.equals(other.week6))
			return false;
		if (week7 == null) {
			if (other.week7 != null)
				return false;
		} else if (!week7.equals(other.week7))
			return false;
		return true;
	}

}
