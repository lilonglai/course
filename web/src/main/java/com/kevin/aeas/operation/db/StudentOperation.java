package com.kevin.aeas.operation.db;

import java.util.ArrayList;

import com.kevin.aeas.object.Student;
import com.kevin.aeas.operation.db.basic.DbOperationManager;
import com.kevin.aeas.operation.db.jpa.JpaOperationManager;
import com.kevin.aeas.utils.ConfigurationManager;

public class StudentOperation {
	public Student get(int key) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (Student)JpaOperationManager.getInstance().getStudentOperation().get(key);
		}
		else{
			return DbOperationManager.getInstance().getStudentOperation().get(key);
		}
	}
	
	public Student getByName(String name) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (Student)JpaOperationManager.getInstance().getStudentOperation().getByName(name);
		}
		else{
			return DbOperationManager.getInstance().getStudentOperation().getByName(name);
		}
	}
	

	public ArrayList<Student> getByGrade(int grade) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Student>)JpaOperationManager.getInstance().getStudentOperation().getByGrade(grade);
		}
		else{
			return DbOperationManager.getInstance().getStudentOperation().getByGrade(grade);
		}

	}

	public ArrayList<Student> getAll() {
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Student>)JpaOperationManager.getInstance().getStudentOperation().getAll();
		}
		else{
			return DbOperationManager.getInstance().getStudentOperation().getAll();
		}

	}
	
	public ArrayList<Student> getAlive() {
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Student>)JpaOperationManager.getInstance().getStudentOperation().getAlive();
		}
		else{
			return DbOperationManager.getInstance().getStudentOperation().getAlive();
		}
	}
	
	public ArrayList<Student> getNotAlive() {
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Student>)JpaOperationManager.getInstance().getStudentOperation().getNotAlive();
		}
		else{
			return DbOperationManager.getInstance().getStudentOperation().getNotAlive();
		}
	}

	public ArrayList<Student> getByTeacherId(int teacherId) {
		if(ConfigurationManager.getInstance().isJpa()){
			return (ArrayList<Student>)JpaOperationManager.getInstance().getStudentOperation().getByTeacherId(teacherId);
		}
		else{
			return DbOperationManager.getInstance().getStudentOperation().getByTeacherId(teacherId);
		}

	}

	public void add(Student student){
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getStudentOperation().add(student);
		}
		else{
			DbOperationManager.getInstance().getStudentOperation().add(student);
		}
		
	}

	public void update(Student student) {
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getStudentOperation().update(student);
		}
		else{
			DbOperationManager.getInstance().getStudentOperation().update(student);
		}
	}

	public void delete(int key) {
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getStudentOperation().delete(key);
		}
		else{
			DbOperationManager.getInstance().getStudentOperation().delete(key);
		}
	}
	
	public void retire(int key) {
		if(ConfigurationManager.getInstance().isJpa()){
			JpaOperationManager.getInstance().getStudentOperation().retire(key);
		}
		else{
			DbOperationManager.getInstance().getStudentOperation().retire(key);
		}
	}

	public static void main(String[] args) {
		StudentOperation studentOperation = new StudentOperation();
		System.out.println(studentOperation.getAll());
		
	}

}
