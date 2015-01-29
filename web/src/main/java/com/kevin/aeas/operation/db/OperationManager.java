package com.kevin.aeas.operation.db;

public class OperationManager {
	private static OperationManager instance = new OperationManager();
	
	private TeacherOperation teacherOperation;	
	private StudentOperation studentOperation;
	private FirstCourseOperation firstCourseOperation;
	private SecondCourseOperation secondCourseOperation;
	private UserOperation userOperation;
	private ScheduleOperation scheduleOperation;
	
	private TeacherAbilityOperation ateacherAbilityOperation;
	private TeacherDefaultHolidayOperation teacherDefaultHolidayOperation;
	private TeacherHolidayOperation teacherHolidayOperation;
	
	private OperationManager(){
		
	}
	
	public static OperationManager getInstance(){
		return instance;
	}

	public TeacherOperation getTeacherOperation() {
		return teacherOperation;
	}

	public StudentOperation getStudentOperation() {
		return studentOperation;
	}

	public FirstCourseOperation getFirstCourseOperation() {
		return firstCourseOperation;
	}

	public SecondCourseOperation getSecondCourseOperation() {
		return secondCourseOperation;
	}

	public UserOperation getUserOperation() {
		return userOperation;
	}

	public ScheduleOperation getScheduleOperation() {
		return scheduleOperation;
	}

	public TeacherAbilityOperation getAteacherAbilityOperation() {
		return ateacherAbilityOperation;
	}

	public TeacherDefaultHolidayOperation getTeacherDefaultHolidayOperation() {
		return teacherDefaultHolidayOperation;
	}

	public TeacherHolidayOperation getTeacherHolidayOperation() {
		return teacherHolidayOperation;
	}
	


}
