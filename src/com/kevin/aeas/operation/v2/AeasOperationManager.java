package com.kevin.aeas.operation.v2;

public class AeasOperationManager {
	private static AeasOperationManager instance = new AeasOperationManager();
	
	private AeasTeacherOperation aeasTeacherOperation;	
	private AeasStudentOperation aeasStudentOperation;
	
	private AeasOperationManager(){
		aeasTeacherOperation = new AeasTeacherOperation();
		aeasStudentOperation = new AeasStudentOperation();
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

}
