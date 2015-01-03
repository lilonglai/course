package com.kevin.aeas.operation.v2;

public class AeasOperationManager {
	private static AeasOperationManager instance = new AeasOperationManager();
	
	private AeasTeacherOperation aeasTeacherOperation;	
	private AeasStudentOperation aeasStudentOperation;
	private AeasFirstCourseOperation aeasFirstCourseOperation;
	private AeasSecondCourseOperation aeasSecondCourseOperation;
	private AeasUserOperation aeasUserOperation;
	
	private AeasOperationManager(){
		aeasTeacherOperation = new AeasTeacherOperation();
		aeasStudentOperation = new AeasStudentOperation();
		aeasFirstCourseOperation = new AeasFirstCourseOperation();
		aeasSecondCourseOperation = new AeasSecondCourseOperation();		
		aeasUserOperation = new AeasUserOperation();
	}
	
	public static AeasOperationManager getInstance(){
		return instance;
	}
	
	public AeasTeacherOperation getTeacherOperation(){
		return aeasTeacherOperation;
	}
	
	public AeasStudentOperation getStudentOperation(){
		return aeasStudentOperation;
	}
	
	public AeasFirstCourseOperation getFirstCourseOperation(){
		return aeasFirstCourseOperation;
	}
	
	public AeasSecondCourseOperation getSecondCourseOperation(){
		return aeasSecondCourseOperation;
	}
	
	public AeasUserOperation getUserOperation(){
		return aeasUserOperation;
	}

}