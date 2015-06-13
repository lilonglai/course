package com.kevin.course.test.db.jpa;

import com.kevin.course.object.TeacherAbility;
import com.kevin.course.operation.db.jpa.JpaTeacherAbilityOperation;
import junit.framework.TestCase;

import java.util.List;

public abstract class TeacherAbilityOperationTest extends TestCase {
	public void testGet() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		TeacherAbility teacher =  operation.get(1);
	}

	public void testGetAll() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		List<TeacherAbility> list= operation.getAll();
	}

	public void testGetByTeacherId() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		List<TeacherAbility> list =  operation.getByTeacherId(1);
	}

	public void testGetByCourseId() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		List<TeacherAbility> list =  operation.getByCourseId(1);
	}

	public void testAdd() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		TeacherAbility teacherAbility = new TeacherAbility();
		teacherAbility.setTeacherId(25);
		teacherAbility.setCourseId(25);
		operation.add(teacherAbility);
	}

	public void testUpdate() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.update(teacherAbility);
			}
		}
	}

	public void testDelete() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		List<TeacherAbility> list=operation.getAll();
		for(TeacherAbility teacherAbility: list){
			if(teacherAbility.getTeacherId() == 25){
				teacherAbility.setCourseId(26);
				operation.delete(teacherAbility.getId());
			}
		}
	}

	public void testDeleteByTeacherId() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		operation.deleteByTeacherId(1);
	}

	public void testDeleteByTeacherAndGrade() {
		JpaTeacherAbilityOperation operation = new JpaTeacherAbilityOperation();
		operation.deleteByTeacherAndGrade(1, 1);;
	}

}
