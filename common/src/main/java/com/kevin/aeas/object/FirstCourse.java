package com.kevin.aeas.object;

public class FirstCourse {
    protected int id;
    protected int grade;
    protected String name;
    protected String shortName;
    protected String description;
    protected Boolean isAlive;

	public FirstCourse() {
		super();
	}

	public FirstCourse(int id, int grade, String name, String shortName,
			String description, Boolean isAlive) {
		super();
		this.id = id;
		this.grade = grade;
		this.name = name;
		this.shortName = shortName;
		this.description = description;
		this.isAlive = isAlive;
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

    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }
    
    
	
    @Override
	public String toString() {
		return "FirstCourse [id=" + id + ", grade=" + grade + ", name=" + name
				+ ", shortName=" + shortName + ", description=" + description
				+ ", isAlive=" + isAlive + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FirstCourse that = (FirstCourse) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (grade != that.grade) return false;
        if (isAlive != null ? !isAlive.equals(that.isAlive) : that.isAlive != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + grade;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isAlive != null ? isAlive.hashCode() : 0);
        return result;
    }

}
