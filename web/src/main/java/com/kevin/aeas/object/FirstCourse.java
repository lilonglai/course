package com.kevin.aeas.object;

public class FirstCourse {
	private int id;
	private int grade;
	private String name;
	private String shortName;
	private String description;

	public FirstCourse() {
		super();
	}

	public FirstCourse(int id, int grade, String name, String shortName,
			String description) {
		super();
		this.id = id;
		this.grade = grade;
		this.name = name;
		this.shortName = shortName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", grade=" + grade + ", name=" + name
				+ ", shortName=" + shortName + ", description=" + description
				+ "]";
	}

}
