package com.kevin.aeas.operation.db.basic;

public class DbOperationManager {
	private static DbOperationManager instance = new DbOperationManager();
	
	private DbFirstCourseOperation firstCourseOperation;
	private DbSecondCourseOperation secondCourseOperation;
	
	
	private DbStudentOperation studentOperation;
	private DbScheduleOperation scheduleOperation;
	
	private DbTeacherOperation teacherOperation;
	private DbTeacherAbilityOperation teacherAbilityOperation;
	private DbTeacherDefaultHolidayOperation teacherDefaultHolidayOperation;
	private DbTeacherHolidayOperation teacherHolidayOperation;
	
	private DbUserOperation userOperation;
	
	private DbOperationManager(){
		firstCourseOperation = new DbFirstCourseOperation();
		secondCourseOperation = new DbSecondCourseOperation();	
		
		studentOperation = new DbStudentOperation();
		scheduleOperation = new DbScheduleOperation();
	
		teacherOperation = new DbTeacherOperation();
		teacherAbilityOperation = new DbTeacherAbilityOperation();
		teacherDefaultHolidayOperation = new DbTeacherDefaultHolidayOperation();
		teacherHolidayOperation = new DbTeacherHolidayOperation();
		
		userOperation = new DbUserOperation();
	}
	
	public static DbOperationManager getInstance(){
		return instance;
	}
		
	public DbFirstCourseOperation getFirstCourseOperation(){
		return firstCourseOperation;
	}
	
	public DbSecondCourseOperation getSecondCourseOperation(){
		return secondCourseOperation;
	}
	
	public DbStudentOperation getStudentOperation(){
		return studentOperation;
	}

	public DbScheduleOperation getScheduleOperation() {
		return scheduleOperation;
	}
	
	public DbTeacherOperation getTeacherOperation(){
		return teacherOperation;
	}
	
	public DbTeacherAbilityOperation getTeacherAbilityOperation() {
		return teacherAbilityOperation;
	}

	public DbTeacherDefaultHolidayOperation getTeacherDefaultHolidayOperation() {
		return teacherDefaultHolidayOperation;
	}

	public DbTeacherHolidayOperation getTeacherHolidayOperation() {
		return teacherHolidayOperation;
	}
	
	public DbUserOperation getUserOperation(){
		return userOperation;
	}

}
