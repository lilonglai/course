package com.kevin.aeas.object;

import java.sql.Date;

public class Student {
	protected int id;
	public String name;
	public String shortName;
	public int grade;
	public String testScore;
	public String targetScore;
	public Date examineDate;
	public String examinePlace;
	public int teacherId;
	public String description;
	public Boolean isAlive;

	public Student() {
		super();
	}


	public Student(int id, String name, String shortName, int grade,
			String testScore, String targetScore, Date examineDate,
			String examinePlace, int teacherId, String description,
			Boolean isAlive) {
		super();
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.grade = grade;
		this.testScore = testScore;
		this.targetScore = targetScore;
		this.examineDate = examineDate;
		this.examinePlace = examinePlace;
		this.teacherId = teacherId;
		this.description = description;
		this.isAlive = isAlive;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getTestScore() {
		return testScore;
	}

	public void setTestScore(String testScore) {
		this.testScore = testScore;
	}

	public String getTargetScore() {
		return targetScore;
	}

	public void setTargetScore(String targetScore) {
		this.targetScore = targetScore;
	}

	public Date getExamineDate() {
		return examineDate;
	}

	public void setExamineDate(Date examineDate) {
		this.examineDate = examineDate;
	}

	public String getExaminePlace() {
		return examinePlace;
	}

	public void setExaminePlace(String examinePlace) {
		this.examinePlace = examinePlace;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
		return "Student [id=" + id + ", name=" + name + ", shortName="
				+ shortName + ", grade=" + grade + ", testScore=" + testScore
				+ ", targetScore=" + targetScore + ", examineDate="
				+ examineDate + ", examinePlace=" + examinePlace
				+ ", teacherId=" + teacherId + ", description=" + description
				+ ", isAlive=" + isAlive + "]";
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student that = (Student) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (examineDate != null ? !examineDate.equals(that.examineDate) : that.examineDate != null) return false;
        if (examinePlace != null ? !examinePlace.equals(that.examinePlace) : that.examinePlace != null) return false;
        if (grade != that.grade) return false;
        if (isAlive != null ? !isAlive.equals(that.isAlive) : that.isAlive != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (shortName != null ? !shortName.equals(that.shortName) : that.shortName != null) return false;
        if (targetScore != null ? !targetScore.equals(that.targetScore) : that.targetScore != null) return false;
        if (teacherId != that.teacherId) return false;
        if (testScore != null ? !testScore.equals(that.testScore) : that.testScore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + grade;
        result = 31 * result + (testScore != null ? testScore.hashCode() : 0);
        result = 31 * result + (targetScore != null ? targetScore.hashCode() : 0);
        result = 31 * result + (examineDate != null ? examineDate.hashCode() : 0);
        result = 31 * result + (examinePlace != null ? examinePlace.hashCode() : 0);
        result = 31 * result + teacherId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isAlive != null ? isAlive.hashCode() : 0);
        return result;
    }

}
