package com.kevin.aeas.operation.db;

public class OperationManager {
	private static OperationManager instance = new OperationManager();
	

	private FirstCourseOperation firstCourseOperation;
	private SecondCourseOperation secondCourseOperation;
	
	private StudentOperation studentOperation;
	private ScheduleOperation scheduleOperation;
	
	private TeacherOperation teacherOperation;	
	private TeacherAbilityOperation teacherAbilityOperation;
	private TeacherDefaultHolidayOperation teacherDefaultHolidayOperation;
	private TeacherHolidayOperation teacherHolidayOperation;
	
	private UserOperation userOperation;
	
	private OperationManager(){
		firstCourseOperation = new FirstCourseOperation();
		secondCourseOperation = new SecondCourseOperation();
		
		studentOperation = new StudentOperation();
		scheduleOperation = new ScheduleOperation();
		
		teacherOperation = new TeacherOperation();
		teacherAbilityOperation = new TeacherAbilityOperation();
		teacherDefaultHolidayOperation = new TeacherDefaultHolidayOperation();
		teacherHolidayOperation = new TeacherHolidayOperation();
		
		userOperation = new UserOperation();
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

	public TeacherAbilityOperation getTeacherAbilityOperation() {
		return teacherAbilityOperation;
	}

	public TeacherDefaultHolidayOperation getTeacherDefaultHolidayOperation() {
		return teacherDefaultHolidayOperation;
	}

	public TeacherHolidayOperation getTeacherHolidayOperation() {
		return teacherHolidayOperation;
	}
	


}
