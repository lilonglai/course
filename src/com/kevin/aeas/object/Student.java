package com.kevin.aeas.object;

import java.sql.Date;

public class Student {
	private int id;
	private String name;
	private String shortName;
	private int grade;
	private String testScore;
	private String targetScore;
	private Date examineDate;
	private String examinePlace;
	private int teacherId;
	private String description;

	public Student() {
		super();
	}

	public Student(int id, String name, String shortName, int grade,
			String testScore, String targetScore, Date examineDate,
			String examinePlace, int teacherId, String description) {
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", shortName="
				+ shortName + ", grade=" + grade + ", testScore=" + testScore
				+ ", targetScore=" + targetScore + ", examineDate=" + examineDate
				+ ", examinePlace=" + examinePlace + ", teacherId=" + teacherId
				+ ", description=" + description + "]";
	}

}
