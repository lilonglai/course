package com.kevin.aeas.operation.db.jpa;

public class JpaOperationManager {
	private static JpaOperationManager instance = new JpaOperationManager();
	
	private JpaTeacherOperation aeasTeacherOperation;	
	private JpaStudentOperation aeasStudentOperation;
	private JpaFirstCourseOperation aeasFirstCourseOperation;
	private JpaSecondCourseOperation aeasSecondCourseOperation;
	private JpaUserOperation aeasUserOperation;
	private JpaScheduleOperation aeasScheduleOperation;
	private JpaTeacherAbilityOperation aeasTeacherAbilityOperation;
	private JpaTeacherDefaultHolidayOperation aeasTeacherDefaultHolidayOperation;
	private JpaTeacherHolidayOperation aeasTeacherHolidayOperation;
	
	private JpaOperationManager(){
		aeasTeacherOperation = new JpaTeacherOperation();
		aeasStudentOperation = new JpaStudentOperation();
		aeasFirstCourseOperation = new JpaFirstCourseOperation();
		aeasSecondCourseOperation = new JpaSecondCourseOperation();		
		aeasUserOperation = new JpaUserOperation();
	}
	
	public static JpaOperationManager getInstance(){
		return instance;
	}
	
	public JpaTeacherOperation getTeacherOperation(){
		return aeasTeacherOperation;
	}
	
	public JpaStudentOperation getStudentOperation(){
		return aeasStudentOperation;
	}
	
	public JpaFirstCourseOperation getFirstCourseOperation(){
		return aeasFirstCourseOperation;
	}
	
	public JpaSecondCourseOperation getSecondCourseOperation(){
		return aeasSecondCourseOperation;
	}
	
	public JpaUserOperation getUserOperation(){
		return aeasUserOperation;
	}

	public JpaScheduleOperation getScheduleOperation() {
		return aeasScheduleOperation;
	}

	public JpaTeacherAbilityOperation getTeacherAbilityOperation() {
		return aeasTeacherAbilityOperation;
	}

	public JpaTeacherDefaultHolidayOperation getTeacherDefaultHolidayOperation() {
		return aeasTeacherDefaultHolidayOperation;
	}

	public JpaTeacherHolidayOperation getTeacherHolidayOperation() {
		return aeasTeacherHolidayOperation;
	}
	
}
