package com.kevin.aeas.operation.db.jpa;

public class JpaOperationManager {
	private static JpaOperationManager instance = new JpaOperationManager();
	
	private JpaFirstCourseOperation firstCourseOperation;
	private JpaSecondCourseOperation secondCourseOperation;
	
	private JpaStudentOperation studentOperation;
	private JpaScheduleOperation scheduleOperation;
	
	private JpaTeacherOperation teacherOperation;
	private JpaTeacherAbilityOperation teacherAbilityOperation;
	private JpaTeacherDefaultHolidayOperation teacherDefaultHolidayOperation;
	private JpaTeacherHolidayOperation teacherHolidayOperation;
	
	private JpaUserOperation userOperation;
	
	private JpaOperationManager(){
		firstCourseOperation = new JpaFirstCourseOperation();
		secondCourseOperation = new JpaSecondCourseOperation();
		
		studentOperation = new JpaStudentOperation();
		scheduleOperation = new JpaScheduleOperation();
		
		teacherOperation = new JpaTeacherOperation();
		teacherAbilityOperation = new JpaTeacherAbilityOperation();
		teacherDefaultHolidayOperation = new JpaTeacherDefaultHolidayOperation();
		teacherHolidayOperation = new JpaTeacherHolidayOperation();
		
		userOperation = new JpaUserOperation();
	}
	
	public static JpaOperationManager getInstance(){
		return instance;
	}
	
	public JpaFirstCourseOperation getFirstCourseOperation(){
		return firstCourseOperation;
	}
	
	public JpaSecondCourseOperation getSecondCourseOperation(){
		return secondCourseOperation;
	}

	public JpaStudentOperation getStudentOperation(){
		return studentOperation;
	}
	
	public JpaScheduleOperation getScheduleOperation() {
		return scheduleOperation;
	}
	
	public JpaTeacherOperation getTeacherOperation(){
		return teacherOperation;
	}
	
	public JpaTeacherAbilityOperation getTeacherAbilityOperation() {
		return teacherAbilityOperation;
	}

	public JpaTeacherDefaultHolidayOperation getTeacherDefaultHolidayOperation() {
		return teacherDefaultHolidayOperation;
	}

	public JpaTeacherHolidayOperation getTeacherHolidayOperation() {
		return teacherHolidayOperation;
	}
	
	public JpaUserOperation getUserOperation(){
		return userOperation;
	}
	
}
