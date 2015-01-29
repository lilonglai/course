package com.kevin.aeas.operation.db.jpa;

public class JpaOperationManager {
	private static JpaOperationManager instance = new JpaOperationManager();
	
	private JpaTeacherOperation aeasTeacherOperation;	
	private JpaStudentOperation aeasStudentOperation;
	private JpaFirstCourseOperation aeasFirstCourseOperation;
	private JpaSecondCourseOperation aeasSecondCourseOperation;
	private JpaUserOperation aeasUserOperation;
	
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

}
