package com.kevin.course.object;

public class SecondCourse {
	protected int id;
	protected String name;
	protected String shortName;
	protected int firstCourseId;
	protected String description;
	protected Boolean isAlive;

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

    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

	@Override
	public String toString() {
		return "Course [id=" + id  + ", name=" + name
				+ ", shortName=" + shortName + ", firstCourseId=" + firstCourseId
				+ ", description=" + description + "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecondCourse that = (SecondCourse) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (isAlive != null ? !isAlive.equals(that.isAlive) : that.isAlive != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isAlive != null ? isAlive.hashCode() : 0);
        result = 31 * result + firstCourseId;
        return result;
    }

}
