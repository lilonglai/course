package com.kevin.aeas.object;

public class SecondCourse {
	private int id;
	private String name;
	private String shortName;
	private int firstCourseId;
	private String description;

	public SecondCourse() {
		super();
	}

	public SecondCourse(int id, String name, String shortName,
			int firstCourseId, String description) {
		super();
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.firstCourseId = firstCourseId;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getFirstCourseId() {
		return firstCourseId;
	}

	public void setFirstCourseId(int firstCourseId) {
		this.firstCourseId = firstCourseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [id=" + id  + ", name=" + name
				+ ", shortName=" + shortName + ", firstCourseId=" + firstCourseId
				+ ", description=" + description + "]";
	}
	
	

}
