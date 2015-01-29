package com.kevin.aeas.operation.db.basic;

public class DbOperationManager {
	private static DbOperationManager instance = new DbOperationManager();
	
	private DbTeacherOperation aeasTeacherOperation;	
	private DbStudentOperation aeasStudentOperation;
	private DbFirstCourseOperation aeasFirstCourseOperation;
	private DbSecondCourseOperation aeasSecondCourseOperation;
	private DbUserOperation aeasUserOperation;
	private DbScheduleOperation aeasScheduleOperation;
	
	private DbTeacherAbilityOperation aeasTeacherAbilityOperation;
	private DbTeacherDefaultHolidayOperation aeasTeacherDefaultHolidayOperation;
	private DbTeacherHolidayOperation aeasTeacherHolidayOperation;
	
	private DbOperationManager(){
		aeasTeacherOperation = new DbTeacherOperation();
		aeasStudentOperation = new DbStudentOperation();
		aeasFirstCourseOperation = new DbFirstCourseOperation();
		aeasSecondCourseOperation = new DbSecondCourseOperation();		
		aeasUserOperation = new DbUserOperation();
	}
	
	public static DbOperationManager getInstance(){
		return instance;
	}
	
	public DbTeacherOperation getTeacherOperation(){
		return aeasTeacherOperation;
	}
	
	public DbStudentOperation getStudentOperation(){
		return aeasStudentOperation;
	}
	
	public DbFirstCourseOperation getFirstCourseOperation(){
		return aeasFirstCourseOperation;
	}
	
	public DbSecondCourseOperation getSecondCourseOperation(){
		return aeasSecondCourseOperation;
	}
	
	public DbUserOperation getUserOperation(){
		return aeasUserOperation;
	}

	public DbScheduleOperation getScheduleOperation() {
		return aeasScheduleOperation;
	}

	public DbTeacherAbilityOperation getTeacherAbilityOperation() {
		return aeasTeacherAbilityOperation;
	}

	public DbTeacherDefaultHolidayOperation getTeacherDefaultHolidayOperation() {
		return aeasTeacherDefaultHolidayOperation;
	}

	public DbTeacherHolidayOperation getTeacherHolidayOperation() {
		return aeasTeacherHolidayOperation;
	}


}
